package com.sdh.qqbot.main.controller.database;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sdh.qqbot.main.entity.database.User;
import com.sdh.qqbot.main.entity.message.MessageEntity;
import com.sdh.qqbot.main.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author SDH
 * @since 2022-10-16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static IUserService userService;

    @Autowired
    private IUserService userService1;

    public static boolean saveUser(MessageEntity message) {
        MessageEntity.SenderDTO senderDTO = message.getSender();
        User user = User.builder().nickname(senderDTO.getNickname()).age(senderDTO.getAge())
                        .userId(senderDTO.getUserId()).area(senderDTO.getArea()).level(senderDTO.getLevel())
                        .sex(senderDTO.getSex()).card(senderDTO.getCard()).card(senderDTO.getCard())
                        .title(senderDTO.getTitle()).role(senderDTO.getRole()).build();
        if ("group".equals(message.getMessageType())) {
            user.setGroupId(message.getGroupId());
        }
        return userService.saveOrUpdate(user, new UpdateWrapper<User>().eq("user_id", user.getUserId()));
    }

    @PostConstruct
    public void init() {
        userService = userService1;
    }
}
