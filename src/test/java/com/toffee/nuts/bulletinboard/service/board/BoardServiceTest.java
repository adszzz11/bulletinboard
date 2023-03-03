package com.toffee.nuts.bulletinboard.service.board;

import com.toffee.nuts.bulletinboard.domain.Board;
import com.toffee.nuts.bulletinboard.dto.BoardDescDto;
import com.toffee.nuts.bulletinboard.dto.BoardDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardServiceImpl boardService;


    @BeforeEach
    @Transactional
    public void testBoardinit() throws Exception {
        for (int i = 0; i < 100; i++) {
            Board board = new Board(
                    "username",
                    "pwd",
                    "author",
                    "title" + i,
                    "context" + i);
            boardService.saveBoard(board);
        }

    }

    @Test
    public void beforeEachTest() {
        Page<BoardDescDto> boardDescList = boardService.getBoardDescList(Pageable.unpaged());
        assertThat(boardDescList.getSize()).isEqualTo(100);
    }

    @Test
    public void boardServiceFlowTest() {
        Board board = new Board(
                "boardServiceFlowTest",
                "pwd",
                "author",
                "boardServiceFlowTest",
                "boardServiceFlowTest");

        Board savedBoard = boardService.saveBoard(board);
        BoardDto boardDetail = boardService.getBoardDetail(savedBoard.getId());
        assertThat(boardDetail.getId()).isEqualTo(savedBoard.getId());
        assertThat(boardDetail.getContext()).isEqualTo(savedBoard.getContext());

        Board toBeUpdatedBoard = new Board(
                "toBeUpdatedBoard",
                "pwd",
                "author",
                "boardServiceFlowTest",
                "toBeUpdatedBoard");

        savedBoard.updateBoard(toBeUpdatedBoard);

        boardService.updateBoard(savedBoard);

        BoardDto updatedBoardDetail = boardService.getBoardDetail(savedBoard.getId());

        assertThat(updatedBoardDetail.getId()).isEqualTo(savedBoard.getId());
        assertThat(updatedBoardDetail.getContext()).isEqualTo(savedBoard.getContext());

        boardService.deleteBoard(savedBoard);

        assertThat(boardService.getBoardDetail(savedBoard.getId())).isNull();

    }


}