package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repository.Category.CategoryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    public void beforeInsert(Category category){

    }

    public void insertCategory(Category category){

    }

    public void deleteCategory(Category category){

    }

    public void getCategoryAll(){
        categoryRepository.findAll();
    }

    public void getNestedCategory(Category category){

    }

    public void insertChildCategory(Category category){

    }
}
