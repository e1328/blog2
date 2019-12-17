package com.javaweb.blog.controller;

import com.javaweb.blog.entity.Result;
import com.javaweb.blog.entity.StatusCode;
import com.javaweb.blog.pojo.Catalog;
import com.javaweb.blog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", catalogService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Catalog catalog) {
        catalogService.add(catalog);
        return new Result(true, StatusCode.OK, "增加成功");
    }

}
