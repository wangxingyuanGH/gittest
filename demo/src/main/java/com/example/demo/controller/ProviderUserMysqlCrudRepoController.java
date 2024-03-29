package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.server.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户微服务Controller。
 *
 * @author hmilyylimh
 *
 * @version 0.0.1
 *
 * @date 17/10/18
 *
 */
@RestController
class ProviderUserMysqlJdbcController {

    @Autowired
    private IUserService userService;

    @GetMapping("/simplejdbc/{id}")
    public User findUserById(@PathVariable Long id) {
        return this.userService.findUserById(id);
    }

    @GetMapping("/simplejdbc/list")
    public List<User> findAllUsers() {
        return this.userService.findAllUsers();
    }

    /**
     * 添加一个student,使用postMapping接收post请求
     *
     * http://localhost:8315/simple/addUser?username=user11&age=11&balance=11
     *
     * @return
     */
    @PostMapping("/simplejdbc/addUser")
    public User insertUser(@RequestParam(value = "username", required=false) String username, @RequestParam(value = "age", required=false) Integer age, @RequestParam(value = "balance", required=false) String balance){
        User user=new User();

        user.setUsername(username);
        user.setName(username);
        user.setAge(age);
        user.setBalance(balance);

        int result = userService.insertUser(user);
        if(result > 0){
            return user;
        }

        user.setId(0L);
        user.setName(null);
        user.setUsername(null);
        user.setBalance(null);
        return user;
    }
}
