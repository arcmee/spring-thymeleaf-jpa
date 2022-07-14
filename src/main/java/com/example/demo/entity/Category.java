package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(schema = "SCOTT", name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ")
    @SequenceGenerator(sequenceName = "category_seq", allocationSize = 1, name="CATEGORY_SEQ")
    @Column(name="ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "root_Category_id")
    private Category rootCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_Category_id")
    private Category parentCategory;

    @Column(unique = true, nullable = false)
    private String value;

    @Column(nullable = false)
    private Long leftNode = 1L;

    @Column(nullable = false)
    private Long rightNode = 2L;

    @Column(nullable = false)
    private Long depth = 1L;

}
