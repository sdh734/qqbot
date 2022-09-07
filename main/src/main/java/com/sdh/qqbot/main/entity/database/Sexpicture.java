package com.sdh.qqbot.main.entity.database;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("t_sexpicture")
public class Sexpicture implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 色图本地数据库ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 色图p站id
     */
    private String pictureId;

    /**
     * 色图url
     */
    private String pictureUrl;

    /**
     * 色图图像大小（original，regular，small，thumb，mini）
     */
    private String pictureSize;

    /**
     * 色图缓存图像绝对地址
     */
    private String pictureCache;
}
