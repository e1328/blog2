package com.javaweb.blog.service;

import com.javaweb.blog.dao.LabelDao;
import com.javaweb.blog.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findById(int id) {
        return labelDao.findById(id).get();
    }

    public void add(Label label) {
        labelDao.save(label);
    }

    public void deleteById(int id) {
        labelDao.deleteById(id);
    }

    public void modifyById(int id, Label label) {
        label.setLabelId(id);
        labelDao.save(label);
    }

    public Page<Label> findSearch(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return labelDao.findAll(pageRequest);
    }

}
