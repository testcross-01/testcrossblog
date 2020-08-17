package cn.testcross.testcrossblog.service;

import cn.testcross.testcrossblog.bean.Article;

import java.util.List;

public interface ArticleService {
//    Integer countArticle();
//    Integer countArticleComment();
//    Integer countArticleByCategoryId(Integer id);
//    Integer countArticleByTagId(Integer id);

    void updateArticleById(Integer id,Article article);
    void addNewArticle(Article article);
    void deleteArticleById(Integer id);
    Article queryArticleById(Integer id);
    List<Article> queryAllArticles();
    List<Article> queryAllSimpleArticles();

}
