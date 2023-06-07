package com.toffee.nuts.bulletinboard.controller.board;


import com.toffee.nuts.bulletinboard.domain.Board;
import com.toffee.nuts.bulletinboard.dto.BoardCreateDto;
import com.toffee.nuts.bulletinboard.dto.BoardDescDto;
import com.toffee.nuts.bulletinboard.dto.BoardDto;
import com.toffee.nuts.bulletinboard.service.board.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class BoardRestController implements BoardControllInterface {


    @Autowired
    private final BoardServiceImpl boardService;


    @Override
    public String testBoardInit() {
        System.out.println("test created");
        for (int i = 0; i < 100; i++) {
            Board board = new Board(
                    "username",
                    "pwd",
                    "author",
                    "title" + i,
                    "context" + i);
            boardService.saveBoard(board);

        }

//        List<Board> all = boardRepository.findAll();
//        Assertions.assertThat(all.size()).isEqualTo(100);
        return "true";
    }


    @Override
    public Page<BoardDescDto> getBoardListDesc(@PageableDefault(size = 10, sort = "id") Pageable pageable) {
        System.out.println("board init");
        return boardService.getBoardDescList(pageable);
    }

    @Override
    public BoardDto viewBoard(@PathVariable Long id) {

        BoardDto boardDetail = null;
        try {
            boardDetail = boardService.getBoardDetail(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return boardDetail;
    }

    @Override
    public ResponseEntity<String> modifyBoard(@RequestBody BoardDto boardDto) {

        try {
            boardService.updateBoard(boardDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createBoard(@RequestBody @Validated BoardCreateDto boardCreateDto) {
        boardService.saveBoard(boardCreateDto);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> removeBoard(@RequestBody @Validated BoardDto boardDto) {
        boardService.deleteBoard(boardDto);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

}
