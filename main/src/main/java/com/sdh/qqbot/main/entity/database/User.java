package com.sdh.qqbot.main.entity.database;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户QQ号
     */
    @TableField("user_id")
    private String userId;

    /**
     * 用户昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 用户权限等级
     */
    @TableField("user_level")
    private Integer userLevel;

    /**
     * 用户年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 用户地区
     */
    @TableField("area")
    private String area;

    /**
     * 用户群名片
     */
    @TableField("card")
    private String card;

    /**
     * 是否允许修改群名片
     */
    @TableField("card_changeable")
    private Boolean cardChangeable;

    /**
     * 群号
     */
    @TableField("group_id")
    private String groupId;

    /**
     * 性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 加群时间戳
     */
    @TableField("join_time")
    private Long joinTime;

    /**
     * 最后发言时间戳
     */
    @TableField("last_sent_time")
    private Long lastSentTime;

    /**
     * 成员等级
     */
    @TableField("level")
    private String level;

    /**
     * 角色，群员owner，管理员admin，群主member
     */
    @TableField("role")
    private String role;

    /**
     * 是否不良记录成员
     */
    @TableField("unfriendly")
    private Boolean unfriendly;

    /**
     * 专属头衔
     */
    @TableField("title")
    private String title;

    /**
     * 专属头衔过期时间戳
     */
    @TableField("title_expire_time")
    private String titleExpireTime;

    /**
     * 禁言到期时间
     */
    @TableField("shut_up_timestamp")
    private String shutUpTimestamp;
}
