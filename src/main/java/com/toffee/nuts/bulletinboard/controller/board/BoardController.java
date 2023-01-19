package com.toffee.nuts.bulletinboard.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String board() {
        System.out.println("board init");
        return "index.html";
    }

}
