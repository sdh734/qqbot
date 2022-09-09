package com.sdh.qqbot.plugin.recall.message;

import com.gitee.starblues.annotation.Extract;
import com.sdh.qqbot.main.entity.message.EchoMessageEntity;
import com.sdh.qqbot.plugin.recall.message.utils.ReCallMessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Extract(bus = "plugin", scene = "recall", order = 1)
public class RecallMessage implements com.sdh.qqbot.main.message.RecallMessage {
    /**
     * 调用接口回调函数
     *
     * @param echoMessage 返回的数据实体
     */
    @Override
    public void RecallMessageManager(EchoMessageEntity echoMessage) {
        String echo = echoMessage.getEcho();
        if ("recall".equals(echo)) {
            log.info("执行撤回任务");
            ReCallMessageUtil.add(echoMessage.getData().getMessageId().toString());
        }
    }
}
