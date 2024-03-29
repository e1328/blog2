package com.javaweb.blog.dao;

import com.javaweb.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    public User findByUsernameAndPassword(String username, String password);

    public User findByUsername(String username);

}
