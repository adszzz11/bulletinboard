package com.toffee.nuts.bulletinboard.service.board;

import com.toffee.nuts.bulletinboard.domain.Board;
import com.toffee.nuts.bulletinboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public void getBoardList() {

    }

    public void getBoardDetail() {

    }

    public void saveBoard() {

    }

    public void updateBoard() {

    }

    public void deleteBoard() {

    }

}
