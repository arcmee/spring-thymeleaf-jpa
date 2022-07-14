package com.example.demo.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(schema = "SCOTT", name = "BOARD")
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ")
    @SequenceGenerator(sequenceName = "board_seq", allocationSize = 1, name="BOARD_SEQ")
    @Column(name="ID")
    private Integer id;

    @Column(name="TITLE")
    private String title;

    @Column(name="CONTENT")
    private String content;

    @Column(name="FILENAME")
    private String filename;

    @Column(name="FILEPATH")
    private String filepath;

    @Column(name="CATEGORY_ID")
    private Integer category_id;

}
