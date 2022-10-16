package com.sdh.qqbot.main.utils.push;

import com.alibaba.fastjson2.JSONObject;
import com.sdh.qqbot.main.config.ApiKeyConfig;
import com.sdh.qqbot.main.config.ApiUrlConfig;
import com.sdh.qqbot.main.utils.okhttp.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * 推送实用程序
 * 消息推送工具
 *
 * @author SDH
 * @date 2022/10/16
 */
@Slf4j
public class PushUtils {
    public static boolean push(String message) {
        if (!Objects.equals(ApiKeyConfig.SERVERCHAN_TOKEN, "")) {
            log.info("开始使用Server酱推送微信消息。");
            String url = ApiUrlConfig.SERVERCHAN_URL + "?title=" + URLEncoder.encode(message, StandardCharsets.UTF_8);
            OkHttpUtil.get(url);
            log.info("微信消息发送成功。");
        } else if (!Objects.equals(ApiKeyConfig.PUSHPLUS_TOKEN, "")) {
            log.info("开始使用PushPlus推送微信消息。");
            JSONObject request = new JSONObject();
            request.put("token", ApiKeyConfig.PUSHPLUS_TOKEN);
            request.put("title", "Notify");
            request.put("content", message);
            request.put("template", "txt");
            OkHttpUtil.post(ApiUrlConfig.PUSHPLUS_URL, request.toString(), null);
            log.info("微信消息发送成功。");
            return true;
        } else {
            log.info("微信消息发送失败，未配置推送平台Token。");
            return false;
        }
        return false;
    }
}
