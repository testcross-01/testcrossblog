package cn.testcross.testcrossblog.controller.admin;

import cn.testcross.testcrossblog.bean.Article;
import cn.testcross.testcrossblog.service.ArticleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Article测试")
public class BackArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/{id}")
    public ResponseEntity getArticleById(@PathVariable("id")Integer id){
        return new ResponseEntity(articleService.queryArticleById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createNewArticle(@RequestBody Article article){
        articleService.addNewArticle(article);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateArticleById(@PathVariable("id")Integer id,@RequestBody Article article){
        articleService.updateArticleById(id,article);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteArticleById(@PathVariable("id")Integer id){
        articleService.deleteArticleById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("articles")
    public ResponseEntity articleList(){
        return new ResponseEntity(articleService.queryAllArticles(),HttpStatus.OK);
    }

    @GetMapping("sarticles")
    public ResponseEntity simpleArticleList(){
        return new ResponseEntity(articleService.queryAllSimpleArticles(),HttpStatus.OK);
    }



}
