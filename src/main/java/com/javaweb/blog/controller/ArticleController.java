package com.javaweb.blog.controller;

import com.javaweb.blog.entity.PageResult;
import com.javaweb.blog.entity.Result;
import com.javaweb.blog.entity.StatusCode;
import com.javaweb.blog.pojo.Article;
import com.javaweb.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", articleService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable int id) {
        return new Result(true, StatusCode.OK, "查询成功", articleService.findById(id));
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.GET)
    public Result findSearch(@PathVariable int page, @PathVariable int size) {
        Map<String, Object> map = articleService.findSearch(page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Article>((long) map.get("total"), (List<Article>) map.get("rows")));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Article article) {
        articleService.add(article);
        return new Result(true, StatusCode.OK, "增加成功");
    }

}
