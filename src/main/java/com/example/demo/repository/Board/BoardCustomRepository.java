package com.example.demo.repository.Board;

import com.example.demo.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardCustomRepository {
    List<Board> customFindAll();

    Page<Board> boardSearchByConditions(String searchKeyword, Integer category_id, Pageable pageable);
}
