package com.toffee.nuts.bulletinboard.controller.board;


import com.toffee.nuts.bulletinboard.domain.Board;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BoardRestController {

    @PostMapping("/board")
    public String board() {
        System.out.println("board init");

        return "ㅁㄴㅇㄹ";
    }
}
