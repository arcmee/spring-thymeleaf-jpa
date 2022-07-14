package com.example.demo.repository.Category;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryCustomRepositoryImpl implements CategoryCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    public CategoryCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;


    }

}
