package com.main.data.serviceimpl;

import com.main.data.dao.mapper.LogMapper;
import com.main.data.entity.Log;
import com.main.data.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 系统日志 服务层实现
 * @author mobai
 */
@Service
public class ILogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
