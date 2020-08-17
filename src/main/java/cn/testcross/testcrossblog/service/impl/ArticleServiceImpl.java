package cn.testcross.testcrossblog.service.impl;

import cn.testcross.testcrossblog.bean.Article;
import cn.testcross.testcrossblog.bean.ArticleCategoryRefExample;
import cn.testcross.testcrossblog.bean.ArticleTagRefExample;
import cn.testcross.testcrossblog.mapper.ArticleCategoryRefMapper;
import cn.testcross.testcrossblog.mapper.ArticleMapper;
import cn.testcross.testcrossblog.mapper.ArticleTagRefMapper;
import cn.testcross.testcrossblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleCategoryRefMapper articleCategoryRefMapper;

    @Autowired
    ArticleTagRefMapper articleTagRefMapper;

    @Override
    public void updateArticleById(Integer id, Article article) {
        if(id!=null)
            article.setArticleId(id);
        else return;
        articleMapper.updateByPrimaryKey(article);
    }

    @Override
    public void addNewArticle(Article article) {
        if(articleMapper.selectByPrimaryKey(article.getArticleId())!=null)
            article.setArticleId(null);
        articleMapper.insert(article);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteArticleById(Integer id) {
        articleMapper.deleteByPrimaryKey(id);
        ArticleCategoryRefExample articleCategoryRefExample=new ArticleCategoryRefExample();
        articleCategoryRefExample.createCriteria().andArticleIdEqualTo(id);
        ArticleTagRefExample articleTagRefExample=new ArticleTagRefExample();
        articleTagRefExample.createCriteria().andArticleIdEqualTo(id);
        articleCategoryRefMapper.deleteByExample(articleCategoryRefExample);
        articleTagRefMapper.deleteByExample(articleTagRefExample);
    }

    @Override
    public Article queryArticleById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> queryAllArticles() {
        return articleMapper.selectByExample(null);
    }

    @Override
    public List<Article> queryAllSimpleArticles() {
        return articleMapper.selectSimpleArticles();
    }
}
