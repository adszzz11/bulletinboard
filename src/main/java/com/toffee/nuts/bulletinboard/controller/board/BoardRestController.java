package com.toffee.nuts.bulletinboard.controller.board;


import com.toffee.nuts.bulletinboard.domain.Board;
import com.toffee.nuts.bulletinboard.domain.Member;
import com.toffee.nuts.bulletinboard.dto.BoardDescDto;
import com.toffee.nuts.bulletinboard.dto.BoardDto;
import com.toffee.nuts.bulletinboard.service.board.BoardService;
import com.toffee.nuts.bulletinboard.service.board.BoardServiceImpl;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class BoardRestController {


    BoardServiceImpl boardService;

    @GetMapping("/boards")
    public Page<BoardDescDto> getBoardListDesc(@PageableDefault(size = 10, sort = "id") Pageable pageable) {
        System.out.println("board init");
        return boardService.getBoardDescList(pageable);
    }

    @PostMapping("/boards/{id}")
    public String board(@PathVariable Integer id) {

        BoardDto boardDetail = boardService.getBoardDetail(id);

        return boardDetail.toString();
    }

    @PostMapping("/boards/create-board")
    public String board(@RequestBody @Validated Board board) {
        boardService.saveBoard(board);
        return "true";
    }

    @Data
    static class SaveBoardResponse {
        private Integer id;

        public SaveBoardResponse(Integer id) {
            this.id = id;
        }
    }
}
