package cn.testcross.testcrossblog.service.impl;

import cn.testcross.testcrossblog.bean.*;
import cn.testcross.testcrossblog.mapper.ArticleMapper;
import cn.testcross.testcrossblog.mapper.ArticleTagRefMapper;
import cn.testcross.testcrossblog.mapper.TagMapper;
import cn.testcross.testcrossblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleTagRefMapper articleTagRefMapper;

    @Override
    public void addTag(Tag tag) {
        if(tagMapper.selectByPrimaryKey(tag.getTagId())!=null)
        tag.setTagId(null);
        tagMapper.insert(tag);
    }

    @Override
    public void deleteTagById(Integer id) {
        if(id==null)return;
        TagExample tagExample=new TagExample();
        tagExample.createCriteria().andTagIdEqualTo(id);
        tagMapper.deleteByExample(tagExample);
    }

    @Override
    public void updateTagById(Tag tag, Integer id) {
        if(id==null)return;
        tagMapper.updateByPrimaryKey(tag);
    }

    @Override
    public Tag queryTagById(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }

//    @Override
//    public List<Tag> queryByFiled(Tag tag) {
//        return null;
//    }

    @Override
    public List<Article> queryArticleById(Integer id) {
        ArticleTagRefExample articleTagRefExample=new ArticleTagRefExample();
        articleTagRefExample.createCriteria().andTagIdEqualTo(id);
        List<ArticleTagRef> articleTagRefs= articleTagRefMapper.selectByExample(articleTagRefExample);
        List<Article> articleList=new ArrayList<Article>();
        for (ArticleTagRef articleTagRef:
             articleTagRefs) {
            articleList.add(articleMapper.selectByPrimaryKey(articleTagRef.getArticleId()));
        }
        return articleList;
    }

    @Override
    public List<Tag> queryAllTag() {
        return tagMapper.selectByExample(null);
    }
}
