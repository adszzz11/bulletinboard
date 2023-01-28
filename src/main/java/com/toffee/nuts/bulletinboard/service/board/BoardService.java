package com.toffee.nuts.bulletinboard.service.board;

import org.springframework.stereotype.Service;


public interface BoardService {
    void saveBoard();
    void getBoardList();
    void getBoardDetail();
    void updateBoard();
    void deleteBoard();

}
