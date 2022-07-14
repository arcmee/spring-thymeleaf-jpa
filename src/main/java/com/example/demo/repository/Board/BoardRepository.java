package com.example.demo.repository.Board;

import com.example.demo.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>, BoardCustomRepository {
    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
}
