package com.javaweb.blog.dao;

import com.javaweb.blog.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {

    public List<Comment> findAllByArticleId(int id);

}
