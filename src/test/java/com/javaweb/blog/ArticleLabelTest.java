package com.javaweb.blog;

import com.javaweb.blog.dao.ArticleLabelDao;
import com.javaweb.blog.dao.LabelDao;
import com.javaweb.blog.pojo.ArticleLabel;
import com.javaweb.blog.pojo.Label;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleLabelTest {

    @Autowired
    private ArticleLabelDao articleLabelDao;

    @Autowired
    private LabelDao labelDao;

    @Test
    public void test() {
        List<ArticleLabel> list = articleLabelDao.findAllByArticleId(1);
        System.err.println(list);
    }

}
