package com.sdh.qqbot.main.service.impl;

import com.sdh.qqbot.main.entity.database.Message;
import com.sdh.qqbot.main.mapper.MessageMapper;
import com.sdh.qqbot.main.service.IMessageService;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
