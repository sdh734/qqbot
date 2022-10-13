package com.sdh.qqbot.main.entity.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 回显消息实体
 * 调用Api返回数据实体
 *
 * @author SDH
 * @date  2022/10/13
 */

@Data
@Builder
public class EchoMessageEntity {

    /**
     * 返回数据，具体查看 OneBot-11 文档，这里只写了发送消息的返回数据
     */
    @JsonProperty("data")
    private DataDTO data;
    /**
     * 回调参数
     */
    @JsonProperty("echo")
    private String echo;
    /**
     * 返回值
     */
    @JsonProperty("retcode")
    private Integer retcode;
    /**
     * 状态
     */
    @JsonProperty("status")
    private String status;

    @Data
    public static class DataDTO {
        @JsonProperty("message_id")
        private Integer messageId;
    }
}
