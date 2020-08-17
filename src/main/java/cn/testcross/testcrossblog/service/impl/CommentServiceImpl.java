package cn.testcross.testcrossblog.service.impl;

import cn.testcross.testcrossblog.bean.Comment;
import cn.testcross.testcrossblog.bean.CommentExample;
import cn.testcross.testcrossblog.mapper.CommentMapper;
import cn.testcross.testcrossblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public Comment queryCommentById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addComment(Comment comment) {
        if(commentMapper.selectByPrimaryKey(comment.getCommentId())!=null)
            comment.setCommentId(null);
        commentMapper.insert(comment);
    }

    @Override
    public void updateCommentById(Integer id,Comment comment) {
        if(comment.getCommentId()!=id)
            comment.setCommentId(id);
        commentMapper.updateByPrimaryKey(comment);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCommentById(Integer id) {
        commentMapper.deleteByPrimaryKey(id);
        CommentExample commentExample=new CommentExample();
        List<Comment> childComments=  queryChildCommentById(id);
        List<Integer> ids=new ArrayList<>();
        for (Comment comment:childComments
             ) {
            ids.add(comment.getCommentId());
        }
        commentExample.createCriteria().andCommentIdIn(ids);
        commentMapper.deleteByExample(commentExample);
    }

    @Override
    public List<Comment> queryCommentsByArtcileId(Integer id) {
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria().andCommentArticleIdEqualTo(id);
        List<Comment> comments= commentMapper.selectByExample(commentExample);
        return comments;
    }

    @Override
    public List<Comment> queryAllComments() {
        return commentMapper.selectByExample(null);
    }

    @Override
    public List<Comment> queryChildCommentById(Integer id) {
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria().andCommentPidEqualTo(id);
        return commentMapper.selectByExample(commentExample);
    }
}
