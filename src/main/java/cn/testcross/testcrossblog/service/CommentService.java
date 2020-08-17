package cn.testcross.testcrossblog.service;

import cn.testcross.testcrossblog.bean.Comment;
import cn.testcross.testcrossblog.mapper.CommentMapper;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {
    /**
     基础的增删改查
     */
    Comment queryCommentById(Integer id);
    void addComment(Comment comment);
    void updateCommentById(Integer id,Comment comment);
    void deleteCommentById(Integer id);

    /**
     * 根据文章id查询评论
     * @param id
     * @return
     */
    public List<Comment> queryCommentsByArtcileId(Integer id);

    /**
     * 查询所有文章
     * @return
     */
    public List<Comment> queryAllComments();

    /**
     * 查询子评论
     */
    public List<Comment> queryChildCommentById(Integer id);
}
