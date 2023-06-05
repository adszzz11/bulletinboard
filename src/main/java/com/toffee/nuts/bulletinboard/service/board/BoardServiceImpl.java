package com.toffee.nuts.bulletinboard.service.board;

import com.toffee.nuts.bulletinboard.domain.Board;
import com.toffee.nuts.bulletinboard.dto.BoardCreateDto;
import com.toffee.nuts.bulletinboard.dto.BoardDescDto;
import com.toffee.nuts.bulletinboard.dto.BoardDto;
import com.toffee.nuts.bulletinboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public Page<BoardDescDto> getBoardDescList(Pageable pageable) {
        return boardRepository.findAll(pageable)
                .map(BoardDescDto::getBoardDescDto);
    }

    public BoardDto getBoardDetail(Long id) {
        try {
            Optional<Board> board = boardRepository.findById(id);

            if (board.isPresent()) {
                return BoardDto.getBoardDto(board.get());
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

    public void saveBoard(BoardCreateDto boardCreateDto) {
        Board board = new Board(
                boardCreateDto.username(),
                boardCreateDto.pwd(),
                boardCreateDto.author(),
                boardCreateDto.title(),
                boardCreateDto.context()
        );
        boardRepository.save(board);
    }

    public Board updateBoard(BoardDto boardDto) {
        Optional<Board> findResult = boardRepository.findById(boardDto.id());

        try {
            if (findResult.isPresent()) {
                findResult.get().updateBoard(boardDto);
                boardRepository.save(findResult.get());
                return findResult.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteBoard(BoardDto boardDto) {

        Optional<Board> findResult = boardRepository.findById(boardDto.id());

        findResult.ifPresent(boardRepository::delete);

    }

}

