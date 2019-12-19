package com.javaweb.blog.service;

import com.javaweb.blog.dao.ArticleDao;
import com.javaweb.blog.dao.CommentDao;
import com.javaweb.blog.dao.UserDao;
import com.javaweb.blog.pojo.Article;
import com.javaweb.blog.pojo.Comment;
import com.javaweb.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ArticleDao articleDao;

    public List<Comment> findAll() {
        List<Comment> list = commentDao.findAll();
        for(int i = 0; i < list.size(); i++) {
            Comment comment = list.get(i);
            int userId = comment.getUserId();
            User user = userDao.findById(userId).get();
            list.get(i).setUser(user);
            int articleId = comment.getArticleId();
            Article article = articleDao.findById(articleId).get();
            list.get(i).setArticle(article);
        }
        return list;
    }

    public List<Comment> findByArticleId(int id) {
        List<Comment> list = commentDao.findAllByArticleId(id);
        for(int i = 0; i < list.size(); i++) {
            Comment comment = list.get(i);
            int userId = comment.getUserId();
            User user = userDao.findById(userId).get();
            list.get(i).setUser(user);
            int articleId = comment.getArticleId();
            Article article = articleDao.findById(articleId).get();
            list.get(i).setArticle(article);
        }
        return list;
    }

    public void add(Comment comment) {
        commentDao.save(comment);
    }

}
