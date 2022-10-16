package com.sdh.qqbot.main;

import com.gitee.starblues.loader.launcher.SpringBootstrap;
import com.gitee.starblues.loader.launcher.SpringMainBootstrap;
import com.sdh.qqbot.main.websocker.WebSocketInstance;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author SDH
 */
@SpringBootApplication
@MapperScan("com.sdh.qqbot.main.mapper")
public class Application implements SpringBootstrap {
    public static void main(String[] args) {
        SpringMainBootstrap.launch(Application.class, args);
        WebSocketInstance.init("/ws/api", 8091);
    }

    @Override
    public void run(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
