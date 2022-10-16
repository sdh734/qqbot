package com.sdh.qqbot.main.controller.database;

import cn.hutool.core.date.DateTime;
import com.sdh.qqbot.main.entity.database.Message;
import com.sdh.qqbot.main.entity.message.MessageEntity;
import com.sdh.qqbot.main.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author SDH
 * @since 2022-10-16
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    private static IMessageService messageService;
    @Autowired
    private        IMessageService messageService1;

    /**
     * 保存消息
     *
     * @param message 消息实体类
     */
    public static boolean saveMessage(MessageEntity message) {
        Message message1 = Message.builder().isgroup("group".equals(message.getMessageType()))
                                  .message(message.getMessage()).senderUserid(message.getUserId())
                                  .messageId(message.getMessageId()).senderNickname(message.getSender().getNickname())
                                  .messageType(message.getMessageType()).time(new DateTime().toLocalDateTime()).build();
        if ("group".equals(message.getMessageType())) {
            message1.setGroupId(Integer.valueOf(message.getGroupId()));
        }
        return messageService.save(message1);
    }

    @PostConstruct
    public void init() {
        messageService = messageService1;
    }
}
