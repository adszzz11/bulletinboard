package com.toffee.nuts.bulletinboard.service.board;

import com.toffee.nuts.bulletinboard.domain.Board;
import com.toffee.nuts.bulletinboard.dto.BoardDescDto;
import com.toffee.nuts.bulletinboard.dto.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


//@Service
public interface BoardService{
    Board saveBoard(Board board);
    Page<BoardDescDto> getBoardDescList(Pageable pageable);
    BoardDto getBoardDetail(Long id) throws Exception;
    Board updateBoard(BoardDto boardDto);
    void deleteBoard(BoardDto boardDto);

}
