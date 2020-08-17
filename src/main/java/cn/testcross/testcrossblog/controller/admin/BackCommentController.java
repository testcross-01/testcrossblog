package cn.testcross.testcrossblog.controller.admin;

import cn.testcross.testcrossblog.bean.Comment;
import cn.testcross.testcrossblog.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Comment测试")
@RequestMapping("/comment")
@RestController
public class BackCommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity getCommentById(@PathVariable("id") Integer id){
        return new ResponseEntity(commentService.queryCommentById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createNewComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCommentById(@RequestBody Comment comment,@PathVariable("id") Integer id){
        commentService.updateCommentById(id,comment);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCommentById(@PathVariable("id") Integer id){
        commentService.deleteCommentById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/comments")
    public ResponseEntity commentList(){
        return new ResponseEntity(commentService.queryAllComments(),HttpStatus.OK);
    }

//    @GetMapping("")
//    public ResponseEntity queryCommentsByArticleId(){
//
//    }
}
