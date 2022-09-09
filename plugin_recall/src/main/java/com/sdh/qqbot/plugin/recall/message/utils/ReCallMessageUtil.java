package com.sdh.qqbot.plugin.recall.message.utils;

import cn.hutool.core.thread.ThreadUtil;
import com.sdh.qqbot.main.entity.message.SendMessageEntity;
import com.sdh.qqbot.main.websocker.WebSocketTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 实现消息撤回功能。
 * 在发送需要撤回的消息时，echo字段传"recall"即可。
 * 15秒后自动撤回。
 */
@Slf4j
@Component
public class ReCallMessageUtil {
    private static final Queue<String> messageQueue = new LinkedList<>();

    /**
     * 添加要撤回的消息Id到队列中
     *
     * @param messageId 消息Id
     */
    public static void add(String messageId) {
        log.info(messageId);
        messageQueue.add(messageId);
        ThreadUtil.execAsync(() -> {
            ThreadUtil.sleep(15 * 1000);
            reCallMessage();
        });
    }

    /**
     * 撤回消息方法。
     * 队列poll最前的元素，进行撤回操作
     */
    public static void reCallMessage() {
        if (messageQueue.size() != 0) {
            String messageId = messageQueue.poll();
            SendMessageEntity entity = new SendMessageEntity();
            entity.setAction("delete_msg");
            Map<String, String> params = new HashMap<>();
            params.put("message_id", messageId);
            entity.setParams(params);
            WebSocketTool.send(entity);
        }
    }
}
