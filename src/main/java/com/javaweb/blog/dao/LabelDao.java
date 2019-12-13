package com.javaweb.blog.dao;

import com.javaweb.blog.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelDao extends JpaRepository<Label, Integer> {
}
