package cn.testcross.testcrossblog.controller.admin;

import cn.testcross.testcrossblog.bean.User;
import cn.testcross.testcrossblog.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "User测试")
@RequestMapping("/user")
public class BackUserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public  ResponseEntity getUserById(@PathVariable("id") Integer id){
        return  new ResponseEntity(userService.queryUserById(id), HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public  ResponseEntity createNewUser(@RequestBody User user){
        userService.addUser(user);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUserById(@RequestBody User user,@PathVariable("id") Integer id){
        userService.updateUserById(user,id);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Integer id){
        userService.deleteUserById(id);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity userList(){
        return  new ResponseEntity(userService.queryAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity test(){
        return new ResponseEntity(HttpStatus.OK);
    }


}
