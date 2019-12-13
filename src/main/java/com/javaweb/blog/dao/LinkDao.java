package com.javaweb.blog.dao;

import com.javaweb.blog.pojo.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkDao extends JpaRepository<Link, Integer> {
}
