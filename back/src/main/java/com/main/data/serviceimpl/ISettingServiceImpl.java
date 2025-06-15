package com.main.data.serviceimpl;

import com.main.data.dao.mapper.SettingMapper;
import com.main.data.entity.Setting;
import com.main.data.service.ISettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 设置 服务层实现
 * @author mobai
 */
@Service
public class ISettingServiceImpl extends ServiceImpl<SettingMapper, Setting> implements ISettingService {

}
