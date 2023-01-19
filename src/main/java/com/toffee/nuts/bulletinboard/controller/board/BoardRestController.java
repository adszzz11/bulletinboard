package com.toffee.nuts.bulletinboard.controller.board;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardRestController {

    @PostMapping("/board")
    public String board() {
        System.out.println("board init");
        return "index.html";
    }
}
