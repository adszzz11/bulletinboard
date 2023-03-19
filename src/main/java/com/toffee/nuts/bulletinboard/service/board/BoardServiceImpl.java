package com.toffee.nuts.bulletinboard.service.board;

import com.toffee.nuts.bulletinboard.domain.Board;
import com.toffee.nuts.bulletinboard.dto.BoardDescDto;
import com.toffee.nuts.bulletinboard.dto.BoardDto;
import com.toffee.nuts.bulletinboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public Page<BoardDescDto> getBoardDescList(Pageable pageable) {
        return boardRepository.findAll(pageable)
                .map(BoardDescDto::new);

    }

    public BoardDto getBoardDetail(Long id) {
        try {
            Optional<Board> board = boardRepository.findById(id);

            if (board.isPresent()) {
                return new BoardDto(board.get());
            } else {
                throw new Exception("no board");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board updateBoard(Board board) {
        Optional<Board> findResult = boardRepository.findById(board.getId());
        if (findResult.isPresent()) {
            try {
                findResult.ifPresent(value -> value.updateBoard(board));
                boardRepository.save(findResult.get());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return findResult.get();
        }

        return null;
    }

    public void deleteBoard(Board board) {

        Optional<Board> findResult = boardRepository.findById(board.getId());

        findResult.ifPresent(boardRepository::delete);

    }

}

