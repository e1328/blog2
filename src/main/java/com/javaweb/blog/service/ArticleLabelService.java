package com.javaweb.blog.service;

import com.javaweb.blog.dao.ArticleLabelDao;
import com.javaweb.blog.pojo.ArticleLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleLabelService {

    @Autowired
    private ArticleLabelDao articleLabelDao;

    public List<ArticleLabel> findAll() {
        return articleLabelDao.findAll();
    }

}
