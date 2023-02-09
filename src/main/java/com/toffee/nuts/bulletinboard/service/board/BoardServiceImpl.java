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

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public Page<BoardDescDto> getBoardDescList(Pageable pageable) {
        return boardRepository.findAll(pageable)
                .map(BoardDescDto::new);
    }

    public BoardDto getBoardDetail(Integer id) throws Exception {
        Optional<Board> board = boardRepository.findById(id);

        if (board.isPresent()) {
            return new BoardDto(board.get());
        }
        else {
            throw new Exception("no board");
        }

    }

    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    public void updateBoard() {

    }

    public void deleteBoard(Board board) {
        boardRepository.delete(board);
    }

}
