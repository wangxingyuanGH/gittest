package com.example.demo.server;

import com.example.demo.entity.User;

import java.util.List;

/**
 * 简单用户链接Mysql数据库微服务（通过@Service注解标注该类为持久化操作对象）。
 *
 * @author hmilyylimh
 *
 * @version 0.0.1
 *
 * @date 17/10/18
 *
 */
public interface IUserService {

    User findUserById(Long id);

    List<User> findAllUsers();

    int insertUser(User user);
}
