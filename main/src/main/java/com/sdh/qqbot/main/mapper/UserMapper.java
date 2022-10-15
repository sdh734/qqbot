package com.sdh.qqbot.main.mapper;

import com.sdh.qqbot.main.entity.database.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SDH
 * @since 2022-10-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
