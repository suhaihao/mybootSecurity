package com.mytt.boot.Controller;

import com.mytt.boot.Moudel.User;
import com.mytt.boot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 测试控制类
 */
@RestController
@RequestMapping("/us")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/all")
    public List<User> getAlluser(){
        List<User> allmyuser = userService.getAllmyuser();
        return allmyuser;
    }
}
