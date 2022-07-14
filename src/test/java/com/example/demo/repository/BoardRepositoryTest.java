package com.example.demo.repository;

import com.example.demo.entity.Board;
import com.example.demo.repository.Board.BoardCustomRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@Import(QuerydslConfig.class)
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class BoardRepositoryTest {

    @Autowired
    BoardCustomRepository boardCustomRepository;

    @DisplayName("QueryDsl을 통해 board조회")
    @Test
    void queryDslFindAllTest(){

        List<Board> boards = boardCustomRepository.customFindAll();

        assertThat(boards).hasSize(20);

    }

}