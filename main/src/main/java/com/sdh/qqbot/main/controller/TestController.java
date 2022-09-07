package com.sdh.qqbot.main.controller;

import com.sdh.qqbot.main.websocker.WebSocketTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public void test() {
       WebSocketTool.send("测试测试");
    }
}
