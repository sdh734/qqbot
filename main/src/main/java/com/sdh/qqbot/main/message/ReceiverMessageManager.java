package com.sdh.qqbot.main.message;

import com.gitee.starblues.spring.extract.ExtractFactory;
import com.sdh.qqbot.main.controller.database.MessageController;
import com.sdh.qqbot.main.controller.database.UserController;
import com.sdh.qqbot.main.entity.message.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 接收方消息管理器
 *
 * @author SDH
 * @date 2022/10/16
 */
@Component
@Slf4j
public class ReceiverMessageManager {
    private static ExtractFactory        extractFactory;
    private static List<ReceiverMessage> receiverMessages;

    @Autowired
    private ExtractFactory extractFactory1;

    /**
     * 加载所有实现ReceiverMessage接口的类
     */
    public static void load() {
        receiverMessages = extractFactory.getExtractByInterClass(ReceiverMessage.class);
    }

    public static void manager(MessageEntity message) {
        log.info(message.toString());
        log.info("收到消息：" + message.getMessage());
        boolean saveMessage = MessageController.saveMessage(message);
        boolean saveUser    = UserController.saveUser(message);
        if (saveMessage && saveUser) {
            log.info("OK");
        } else {
            log.info("ERROR");
        }
        for (ReceiverMessage receiverMessage : receiverMessages) {
            receiverMessage.MessageManager(message);
        }
    }


    /**
     * 初始化注入
     */
    @PostConstruct
    public void init() {
        extractFactory = extractFactory1;
    }
}
