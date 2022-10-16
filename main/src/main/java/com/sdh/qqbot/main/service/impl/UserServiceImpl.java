package com.sdh.qqbot.main.service.impl;

import com.sdh.qqbot.main.entity.database.User;
import com.sdh.qqbot.main.mapper.UserMapper;
import com.sdh.qqbot.main.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SDH
 * @since 2022-10-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
