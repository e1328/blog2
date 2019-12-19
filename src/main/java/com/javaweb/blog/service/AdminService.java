package com.javaweb.blog.service;

import com.javaweb.blog.dao.AdminDao;
import com.javaweb.blog.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    public Admin login(Admin admin) {
        Admin a = null;
        a = adminDao.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());
        return a;
    }

}
