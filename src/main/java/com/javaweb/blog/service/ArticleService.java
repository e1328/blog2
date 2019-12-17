package com.javaweb.blog.service;

import com.javaweb.blog.dao.ArticleDao;
import com.javaweb.blog.dao.ArticleLabelDao;
import com.javaweb.blog.dao.CatalogDao;
import com.javaweb.blog.dao.LabelDao;
import com.javaweb.blog.pojo.Article;
import com.javaweb.blog.pojo.ArticleLabel;
import com.javaweb.blog.pojo.Catalog;
import com.javaweb.blog.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CatalogDao catalogDao;

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private ArticleLabelDao articleLabelDao;

    public List<Article> findAll() {
        List<Article> list = articleDao.findAll();
        for(int i = 0; i < list.size(); i++) {
            int catalogId = list.get(i).getCatalogId();
            int articleId = list.get(i).getArticleId();
            Catalog catalog = catalogDao.findById(catalogId).get();
            //设置catalog
            list.get(i).setCatalog(catalog);
            //设置labelList
            List<ArticleLabel> articleLabelList = articleLabelDao.findAllByArticleId(articleId);
            List<Label> labelList = new ArrayList<>();
            for(int j = 0; j < articleLabelList.size(); j++){
                int labelId = articleLabelList.get(j).getLabelId();
                Label label = labelDao.findById(labelId).get();
                labelList.add(label);
            }
            list.get(i).setLabelList(labelList);
        }
        return list;
    }

    public Article findById(int id) {
        Article article = articleDao.findById(id).get();
        int catalogId = article.getCatalogId();
        int articleId = article.getArticleId();
        Catalog catalog = catalogDao.findById(catalogId).get();
        //设置catalog
        article.setCatalog(catalog);
        //设置labelList
        List<ArticleLabel> articleLabelList = articleLabelDao.findAllByArticleId(articleId);
        List<Label> labelList = new ArrayList<>();
        for(int i = 0; i < articleLabelList.size(); i++){
            int labelId = articleLabelList.get(i).getLabelId();
            Label label = labelDao.findById(labelId).get();
            labelList.add(label);
        }
        article.setLabelList(labelList);
        return article;
    }

    public Map<String, Object> findSearch(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Article> pageList = articleDao.findAll(pageRequest);
        List<Article> list = pageList.getContent();
        for(int i = 0; i < list.size(); i++) {
            int catalogId = list.get(i).getCatalogId();
            int articleId = list.get(i).getArticleId();
            Catalog catalog = catalogDao.findById(catalogId).get();
            //设置catalog
            list.get(i).setCatalog(catalog);
            //设置labelList
            List<ArticleLabel> articleLabelList = articleLabelDao.findAllByArticleId(articleId);
            List<Label> labelList = new ArrayList<>();
            for(int j = 0; j < articleLabelList.size(); j++){
                int labelId = articleLabelList.get(j).getLabelId();
                Label label = labelDao.findById(labelId).get();
                labelList.add(label);
            }
            list.get(i).setLabelList(labelList);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageList.getTotalElements());
        map.put("rows", list);
        return map;
    }

    public void add(Article article, String[] labelArr) {
        System.out.println(article);
        List<String> list = Arrays.asList(labelArr);
        System.out.println(list);
        int articleId = articleDao.save(article).getArticleId();
        for(int i = 0; i < list.size(); i++) {
            ArticleLabel articleLabel = new ArticleLabel();
            Label label = new Label();
            label.setLabelName(list.get(i));
            int labelId = labelDao.save(label).getLabelId();
            articleLabel.setArticleId(articleId);
            articleLabel.setLabelId(labelId);
            articleLabelDao.save(articleLabel);
        }
    }

    public void modifyById(Article article, String[] labelArr) {
        //删除之前的标签
        List<ArticleLabel> articleLabelList = articleLabelDao.findAllByArticleId(article.getArticleId());
        for(int i = 0; i < articleLabelList.size(); i++) {
            int id = articleLabelList.get(i).getId();
            articleLabelDao.deleteById(id);
        }

        System.out.println(article);
        List<String> list = Arrays.asList(labelArr);
        System.out.println(list);
        int articleId = articleDao.save(article).getArticleId();
        for(int i = 0; i < list.size(); i++) {
            ArticleLabel articleLabel = new ArticleLabel();
            Label label = new Label();
            label.setLabelName(list.get(i));
            int labelId = labelDao.save(label).getLabelId();
            articleLabel.setArticleId(articleId);
            articleLabel.setLabelId(labelId);
            articleLabelDao.save(articleLabel);
        }
    }

    public void deleteById(int id) {
        articleDao.deleteById(id);
    }

}
