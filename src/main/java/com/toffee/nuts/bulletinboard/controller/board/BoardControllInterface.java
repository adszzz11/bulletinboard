package com.toffee.nuts.bulletinboard.controller.board;

import com.toffee.nuts.bulletinboard.dto.BoardCreateDto;
import com.toffee.nuts.bulletinboard.dto.BoardDescDto;
import com.toffee.nuts.bulletinboard.dto.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//@RestController
@RequestMapping("/board")
public interface BoardControllInterface {

    @GetMapping("/")
    Page<BoardDescDto> getBoardListDesc(@PageableDefault(size = 10, sort = "id") Pageable pageable);

    @GetMapping("/view/{id}")
    BoardDto viewBoard(@PathVariable Long id);

    @PostMapping("/modify/{id}")
    ResponseEntity<String> modifyBoard(@RequestBody @Validated BoardDto boardDto);

    @PostMapping("/create")
    ResponseEntity<String> createBoard(@RequestBody @Validated BoardCreateDto boardCreateDto);

    @PostMapping("/remove")
    ResponseEntity<String> removeBoard(@RequestBody @Validated BoardDto boardDto);

    @GetMapping("/test")
    String testBoardInit();

}
