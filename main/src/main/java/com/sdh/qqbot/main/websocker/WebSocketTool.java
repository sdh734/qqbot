package com.sdh.qqbot.main.websocker;

import com.sdh.qqbot.main.entity.message.SendMessageEntity;
import io.javalin.websocket.WsConnectContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WebSocketTool {
    private static WsConnectContext ctx = null;

    public static void setCtx(WsConnectContext ctx1) {
        ctx = ctx1;
    }

    private static void init() {
        WebSocketInstance.init("/ws/api", 8091);
    }
    private static void sendPrivateMessage(){

    }
    private static void sendGroupMessage(){

    }
    /**
     * 发送消息
     *
     * @param message JSON格式化的消息字符串
     */
    public static void send(String message) {
        if (ctx == null) {
            init();
        } else {
            ctx.send(message);
        }
    }

    /**
     * 发送消息
     *
     * @param message 发送消息实体对象
     */
    public static void send(SendMessageEntity message) {
        if (ctx == null) {
            init();
        } else {
            try {
                ctx.send(message.toString());
            } catch (Exception e) {
                log.info("出现异常：" + e.getMessage());
            }

        }
    }
}
