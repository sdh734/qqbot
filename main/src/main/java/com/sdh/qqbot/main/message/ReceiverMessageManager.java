package com.sdh.qqbot.main.message;

import com.gitee.starblues.spring.extract.ExtractFactory;
import com.sdh.qqbot.main.entity.message.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Slf4j
public class ReceiverMessageManager {
    @Autowired
    private ExtractFactory extractFactory1;
    private static ExtractFactory extractFactory;

    @PostConstruct
    public void init() {
        extractFactory = extractFactory1;
    }

    private static List<ReceiverMessage> receiverMessages;

    /**
     * 加载所有实现ReceiverMessage接口的类
     */
    public static void load() {
        receiverMessages = extractFactory.getExtractByInterClass(ReceiverMessage.class);
    }

    public static void manager(MessageEntity message) {
        log.info("收到消息：" + message.getMessage());
        for (ReceiverMessage receiverMessage : receiverMessages) {
            receiverMessage.MessageManager(message);
        }
    }
}
