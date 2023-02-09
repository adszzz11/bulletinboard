package com.toffee.nuts.bulletinboard.service.board;

import com.toffee.nuts.bulletinboard.domain.Board;
import com.toffee.nuts.bulletinboard.dto.BoardDescDto;
import com.toffee.nuts.bulletinboard.dto.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface BoardService{
    void saveBoard(Board board);
    Page<BoardDescDto> getBoardDescList(Pageable pageable);
    BoardDto getBoardDetail(Integer id) throws Exception;
    void updateBoard();
    void deleteBoard(Board board);

}
