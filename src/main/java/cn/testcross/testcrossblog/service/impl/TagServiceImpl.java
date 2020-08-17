package cn.testcross.testcrossblog.service.impl;

import cn.testcross.testcrossblog.bean.*;
import cn.testcross.testcrossblog.mapper.ArticleTagRefMapper;
import cn.testcross.testcrossblog.mapper.TagMapper;
import cn.testcross.testcrossblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Autowired
    ArticleTagRefMapper articleTagRefMapper;

    @Override
    public void addTag(Tag tag) {
        if(tagMapper.selectByPrimaryKey(tag.getTagId())!=null)
        tag.setTagId(null);
        tagMapper.insert(tag);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTagById(Integer id) {
        if(id==null)return;
        tagMapper.deleteByPrimaryKey(id);
        ArticleTagRefExample articleTagRefExample=new ArticleTagRefExample();
        articleTagRefExample.createCriteria().andTagIdEqualTo(id);
        articleTagRefMapper.deleteByExample(articleTagRefExample);

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
    public List<Tag> queryTagByArticleId(Integer id) {
        ArticleTagRefExample articleTagRefExample=new ArticleTagRefExample();
        articleTagRefExample.createCriteria().andArticleIdEqualTo(id);
        List<ArticleTagRef> articleTagRefs= articleTagRefMapper.selectByExample(articleTagRefExample);
        List<Tag> articleList=new ArrayList<Tag>();
        for (ArticleTagRef articleTagRef:
             articleTagRefs) {
            articleList.add(tagMapper.selectByPrimaryKey(articleTagRef.getTagId()));
        }
        return articleList;
    }

    @Override
    public List<Tag> queryAllTag() {
        return tagMapper.selectByExample(null);
    }
}
