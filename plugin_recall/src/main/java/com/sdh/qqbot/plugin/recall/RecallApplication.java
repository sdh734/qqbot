package com.sdh.qqbot.plugin.recall;

import com.gitee.starblues.bootstrap.SpringPluginBootstrap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RecallApplication extends SpringPluginBootstrap {
    public static void main(String[] args) {
        new RecallApplication().run(args);
    }
}
