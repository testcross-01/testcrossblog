package cn.testcross.testcrossblog.controller.admin;

import cn.testcross.testcrossblog.bean.Category;
import cn.testcross.testcrossblog.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@Api(tags = "Category测试")
public class BackCategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable("id") Integer id){
        return  new ResponseEntity(categoryService.queryCategoryById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createNewCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity updateCategoryById(@RequestBody Category category,@PathVariable("id")Integer id){
        categoryService.updateCategoryById(id,category);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoryById(@PathVariable("id")Integer id){
        categoryService.deleteCategoryById(id);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/categorys")
    public ResponseEntity categoryList(){
        return  new ResponseEntity(categoryService.queryAllCategory(),HttpStatus.OK);
    }


}
