package com.sdh.qqbot.main.service.impl;

import com.sdh.qqbot.main.entity.database.Infectcount;
import com.sdh.qqbot.main.mapper.InfectcountMapper;
import com.sdh.qqbot.main.service.IInfectcountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 中国疫情每日数据总和汇总 服务实现类
 * </p>
 *
 * @author SDH
 * @since 2022-09-03
 */
@Service
public class InfectcountServiceImpl extends ServiceImpl<InfectcountMapper, Infectcount> implements IInfectcountService {

}
