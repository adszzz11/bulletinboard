package com.toffee.nuts.bulletinboard.domain;

import com.toffee.nuts.bulletinboard.repository.BoardRepository;
import com.toffee.nuts.bulletinboard.service.board.BoardService;
import com.toffee.nuts.bulletinboard.service.board.BoardServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    @Transactional
    public void testBoardinit() throws Exception{
        for (int i = 0; i < 100; i++) {
            Board board = new Board(
                    "username",
                    "pwd",
                    "author",
                    "title" + i,
                    "context" + i);
            boardRepository.save(board);
        }

//        List<Board> all = boardRepository.findAll();
//        Assertions.assertThat(all.size()).isEqualTo(100);
    }

    @Test
    public void getBoardListDescTest() throws Exception {
        List<Board> boards = boardRepository.findAll();

        Assertions.assertThat(boards.size()).isEqualTo(100);
    }

    @Test
    public void boardRepositoryFlowTest() {
        Board board = new Board(
                "boardFlowTest",
                "pwd",
                "author",
                "boardFlowTest",
                "boardFlowTest");
        Board savedBoard = boardRepository.save(board);
        boardRepository.findById(savedBoard.getId())
                .ifPresent(value -> Assertions.assertThat(value.getContext()).isEqualTo(savedBoard.getContext()));

        Board toBeChangedBoard = new Board(
                "boardFlowTest2",
                "pwd",
                "author",
                "boardFlowTest",
                "changedBoardFlowTest");

        savedBoard.updateBoard(toBeChangedBoard);

        boardRepository.save(savedBoard);

        boardRepository.findById(savedBoard.getId())
                .ifPresent(value -> Assertions.assertThat(value.getContext()).isEqualTo(toBeChangedBoard.getContext()));

        boardRepository.delete(savedBoard);

        Assertions.assertThat(boardRepository.findById(savedBoard.getId()).isPresent()).isFalse();
    }


}