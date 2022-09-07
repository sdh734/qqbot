package com.sdh.qqbot.main.message;

import com.sdh.qqbot.main.entity.message.EchoMessageEntity;

/**
 * 接口调用后回调接口，调用接口时使用自定义echo值，并在插件实现此接口，以进行撤回等操作。
 */
public interface RecallMessage {
    /**
     * 调用接口回调函数
     * @param echoMessage 返回的数据实体
     */
    void RecallMessageManager(EchoMessageEntity echoMessage);
}
