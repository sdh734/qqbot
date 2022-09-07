package com.sdh.qqbot.main.message;

import com.gitee.starblues.spring.extract.ExtractFactory;
import com.sdh.qqbot.main.entity.message.EchoMessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
public class RecallMessageManager {

    @Autowired
    private ExtractFactory extractFactory1;
    private static ExtractFactory extractFactory;

    @PostConstruct
    public void init() {
        extractFactory = extractFactory1;
    }

    private static List<RecallMessage> receiverMessages;

    public static void load() {
        receiverMessages = extractFactory.getExtractByInterClass(RecallMessage.class);
    }

    public static void manager(EchoMessageEntity message) {
        log.info("收到消息：" + message.toString());
        for (RecallMessage receiverMessage : receiverMessages) {
            receiverMessage.RecallMessageManager(message);
        }
    }
}
