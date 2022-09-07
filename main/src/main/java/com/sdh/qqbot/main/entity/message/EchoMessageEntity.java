package com.sdh.qqbot.main.entity.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 调用Api返回数据实体
 */
@NoArgsConstructor
@Data
public class EchoMessageEntity {

    @JsonProperty("data")
    private DataDTO data;//返回数据，具体查看 OneBot-11 文档，这里只写了发送消息的返回数据
    @JsonProperty("echo")
    private String echo;//自定义返回值
    @JsonProperty("retcode")
    private Integer retcode;//状态码
    @JsonProperty("status")
    private String status;//状态

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("message_id")
        private Integer messageId;
    }
}
