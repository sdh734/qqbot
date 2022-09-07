package com.sdh.qqbot.plugin.basic.tool;

import com.gitee.starblues.annotation.Extract;
import com.sdh.qqbot.main.entity.message.MessageEntity;
import com.sdh.qqbot.main.entity.message.SendMessageEntity;
import com.sdh.qqbot.main.message.ReceiverMessage;
import com.sdh.qqbot.main.websocker.WebSocketTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@Extract(bus = "plugin", scene = "basic", order = 1)
public class BasicTool implements ReceiverMessage {
    /**
     * 消息管理器，接收消息并处理
     *
     * @param message 消息实体
     */
    public void MessageManager(MessageEntity message) {
        if (message.getMessage().equals("recall")) {
            SendMessageEntity msg = new SendMessageEntity();
            msg.setAction("send_msg");
            Map<String, String> params = new HashMap<>();
            params.put("user_id", "1247769958");
            params.put("message", message.getMessage());
            msg.setParams(params);
            msg.setEcho("recall");
            WebSocketTool.send(msg);
        } else {
            log.info(String.valueOf(message));
        }
    }

    /**
     * 插件帮助信息
     *
     * @return 帮助信息
     */
    @Override
    public String help() {
        return "helpMessage";
    }
}
