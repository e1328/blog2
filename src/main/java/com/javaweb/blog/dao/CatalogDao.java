package com.javaweb.blog.dao;

import com.javaweb.blog.pojo.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogDao extends JpaRepository<Catalog, Integer> {
}
