package com.javaweb.blog.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="catalog")
public class Catalog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private int catalogId;

    @Column(name = "catalog_name")
    private String catalogName;

    @Column(name = "is_top")
    private int isTop;

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                ", isTop=" + isTop +
                '}';
    }

}
