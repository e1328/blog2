package com.javaweb.blog.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="article_label")
public class ArticleLabel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "article_id")
    private int articleId;

    @Column(name = "label_id")
    private int labelId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toString() {
        return "ArticleLabel{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", labelId=" + labelId +
                '}';
    }

}
