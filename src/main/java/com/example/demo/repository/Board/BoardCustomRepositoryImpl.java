package com.example.demo.repository.Board;
import com.example.demo.entity.Board;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
//import com.querydsl.core.util.StringUtils;

import java.util.List;

import static com.example.demo.entity.QBoard.board;

@Repository
public class BoardCustomRepositoryImpl implements BoardCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory)    {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Board> customFindAll() {

        return jpaQueryFactory.selectFrom(board).fetch();
    }

    @Override
    public Page<Board> boardSearchByConditions(String searchKeyword, Integer category_id, Pageable pageable) {

        List<Board> result = jpaQueryFactory.selectFrom(board).where(
                searchKeywordContaining(searchKeyword),
                categoryIdEq(category_id)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = jpaQueryFactory.select(board.count())
                .from(board)
                .where(
                        searchKeywordContaining(searchKeyword),
                        categoryIdEq(category_id)
                ).fetchOne();

        return new PageImpl<>(result, pageable, count);
    }

    private BooleanExpression searchKeywordContaining(String searchKeyword) {
        return StringUtils.hasText(searchKeyword) ? board.title.contains(searchKeyword) : null;
    }
    private BooleanExpression categoryIdEq(Integer category_id){
        return category_id != null ? board.category_id.eq(category_id) : null;
    }

}
