package com.javaweb.blog.service;

import com.javaweb.blog.dao.CatalogDao;
import com.javaweb.blog.pojo.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CatalogService {

    @Autowired
    private CatalogDao catalogDao;

    public List<Catalog> findAll() {
        return catalogDao.findAll();
    }

    public void add(Catalog catalog) {
        catalogDao.save(catalog);
    }

}
