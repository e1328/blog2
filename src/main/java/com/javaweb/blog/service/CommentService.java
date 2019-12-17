package com.javaweb.blog.service;

import com.javaweb.blog.dao.CommentDao;
import com.javaweb.blog.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public List<Comment> findAll() {
        return commentDao.findAll();
    }

}
