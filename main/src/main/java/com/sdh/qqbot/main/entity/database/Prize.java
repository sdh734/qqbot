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
@TableName("t_prize")
public class Prize implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 奖品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 奖品名称
     */
    private String prizeName;

    /**
     * 奖品数量,默认1
     */
    private Integer prizeQuantity;

    /**
     * 抽取时间,默认不设置,不设置则为手动抽取
     */
    private LocalDateTime prizeDrawtime;

    /**
     * 奖品添加时间
     */
    private LocalDateTime prizeAddtime;

    /**
     * 奖品是否抽取,默认0(未抽取)
     */
    private Integer prizeIsdraw;

    /**
     * 奖品提供者,默认为添加奖品的用户
     */
    private String prizeFrom;
}
