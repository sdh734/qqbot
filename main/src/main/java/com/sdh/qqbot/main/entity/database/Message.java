package com.sdh.qqbot.main.entity.database;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author SDH
 * @since 2022-10-16
 */
@Getter
@Setter
@Builder
@TableName("t_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 消息类型 private group
     */
    @TableField("message_type")
    private String messageType;

    /**
     * 消息ID
     */
    @TableField("message_id")
    private String messageId;

    /**
     * 发送时间戳
     */
    @TableField("time")
    private LocalDateTime time;

    /**
     * 消息真实ID
     */
    @TableField("real_id")
    private Long realId;

    /**
     * 消息内容
     */
    @TableField("message")
    private String message;

    /**
     * 发送人昵称
     */
    @TableField("sender_nickname")
    private String senderNickname;

    /**
     * 发送人QQ号
     */
    @TableField("sender_userid")
    private String senderUserid;

    /**
     * 是否群消息
     */
    @TableField("isgroup")
    private Boolean isgroup;

    /**
     * 群ID
     */
    @TableField("group_id")
    private Integer groupId;
}
