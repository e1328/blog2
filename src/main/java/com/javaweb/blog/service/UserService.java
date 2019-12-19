package com.javaweb.blog.service;

import com.javaweb.blog.dao.UserDao;
import com.javaweb.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void add(User user) {
        userDao.save(user);
    }

    public User login(User user) {
        User u = null;
        u = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return u;
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

}
