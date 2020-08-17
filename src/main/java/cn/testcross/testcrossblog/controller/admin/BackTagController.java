package cn.testcross.testcrossblog.controller.admin;

import cn.testcross.testcrossblog.bean.Tag;
import cn.testcross.testcrossblog.service.TagService;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Tag测试")
@RequestMapping("/Tag")
public class BackTagController {

    @Autowired
    TagService tagService;


    @GetMapping("/{id}")
    public ResponseEntity getTagById(@PathVariable("id") Integer id){
        return new ResponseEntity(tagService.queryTagById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createNewTag(@RequestBody Tag tag){
        tagService.addTag(tag);
        return new ResponseEntity( HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTagById(@RequestBody Tag tag,@PathVariable("id") Integer id){
        tagService.updateTagById(tag,id);
        return new ResponseEntity( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTagById(@PathVariable("id") Integer id){
        tagService.deleteTagById(id);
        return new ResponseEntity( HttpStatus.OK);
    }

    @GetMapping("/tags")
    public ResponseEntity tagList(){
        return  new ResponseEntity(tagService.queryAllTag(),HttpStatus.OK);
    }


}
