package com.javaweb.blog.controller;

import com.javaweb.blog.entity.PageResult;
import com.javaweb.blog.entity.Result;
import com.javaweb.blog.entity.StatusCode;
import com.javaweb.blog.pojo.Label;
import com.javaweb.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable int id) {
        return new Result(true, StatusCode.OK, "查询成功", labelService.findById(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable int id) {
        labelService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.GET)
    public Result findSearch(@PathVariable int page, @PathVariable int size) {
        Page<Label> pageList = labelService.findSearch(page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Label>((int) pageList.getTotalElements(), pageList.getContent()));
    }

}