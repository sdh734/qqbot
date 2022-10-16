package com.sdh.qqbot.main.websocker;

import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.fastjson2.JSON;
import com.sdh.qqbot.main.entity.message.EchoMessageEntity;
import com.sdh.qqbot.main.entity.message.MessageEntity;
import com.sdh.qqbot.main.message.RecallMessageManager;
import com.sdh.qqbot.main.message.ReceiverMessageManager;
import com.sdh.qqbot.main.utils.push.PushUtils;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author SDH
 */
@Slf4j
public class WebSocketInstance {
    private static Javalin instance      = null;
    /**
     * 出错次数
     */
    private static int     errorCount    = 0;
    private static int     errorCountMax = 5;

    /**
     * 初始化WS服务器
     * 端点为 host:8091/ws/receiver
     * todo WebSocketConfig后期改为配置文件读取
     */
    public static void init(String path, int port) {
        Javalin.create().get("/", ctx -> ctx.result("OK")).ws(path, ws -> {
            //连接成功
            ws.onConnect(ctx -> {
                log.info("WS连接成功");
                errorCount = 0;
                WebSocketTool.setCtx(ctx);
                ReceiverMessageManager.load();
                RecallMessageManager.load();
            });
            ws.onClose(ctx -> {
                log.info("WS连接关闭");
                errorCount = 0;
                ctx.closeSession();
                WebSocketTool.setCtx(null);
            });
            ws.onMessage(ctx -> {
                //获取消息类型
                String postType = JSON.parseObject(ctx.message()).getString("post_type");
                if ("message".equals(postType)) {
                    ReceiverMessageManager.manager(ctx.messageAsClass(MessageEntity.class));
                } else {
                    String echo = JSON.parseObject(ctx.message()).getString("echo");
                    if (echo != null) {
                        RecallMessageManager.manager(ctx.messageAsClass(EchoMessageEntity.class));
                    }
                }

            });
            ws.onBinaryMessage(ctx -> log.info(Arrays.toString(ctx.data())));
            ws.onError(ctx -> {
                log.info("WS连接出错");
                log.info(Objects.requireNonNull(ctx.error()).toString());
                ThreadUtil.sleep(5000);
                errorCount++;
                ctx.closeSession();
                WebSocketTool.setCtx(null);
                if (errorCount < errorCountMax) {
                    init("/ws/api", 8091);
                } else {
                    PushUtils.push("WS连接超时，请检查服务器网络连接!");
                }

            });
        }).start(port);
        if (instance != null) {
            log.info("WS服务器启动成功，等待客户端接入中。。。");
        }
    }
}
