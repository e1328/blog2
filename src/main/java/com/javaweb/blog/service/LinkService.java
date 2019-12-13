package com.javaweb.blog.service;

import com.javaweb.blog.dao.LinkDao;
import com.javaweb.blog.pojo.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LinkService {

    @Autowired
    private LinkDao linkDao;

    public List<Link> findAll() {
        return linkDao.findAll();
    }

}
