package com.sdh.qqbot.main.entity.database;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author SDH
 * @since 2022-09-03
 */
@Getter
@Setter
@TableName("t_winners")
public class Winners implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 奖品ID
     */
    private Integer prizeId;

    /**
     * 中奖者ID
     */
    private Integer userId;

    /**
     * 中奖时间
     */
    private LocalDateTime drawTime;
}