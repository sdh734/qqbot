package com.sdh.qqbot.main.message;

/**
 * 插件实现该接口，实现对消息的拦截、处理、返回
 */
public interface ReceiveMessage {
    /**
     * 消息管理器，接收消息并处理
     *
     * @param message 消息字符串
     */
    void MessageManager(String message);

    /**
     * 插件帮助信息
     *
     * @return 帮助信息
     */
    String help();
}
