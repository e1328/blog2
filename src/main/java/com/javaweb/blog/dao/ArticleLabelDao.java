package com.javaweb.blog.dao;

import com.javaweb.blog.pojo.ArticleLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleLabelDao extends JpaRepository<ArticleLabel, Integer> {

    public List<ArticleLabel> findAllByArticleId(int articleId);

}
