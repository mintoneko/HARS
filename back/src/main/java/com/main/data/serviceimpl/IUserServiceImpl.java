package com.main.data.serviceimpl;

import com.main.data.dao.mapper.UserMapper;
import com.main.data.entity.User;
import com.main.data.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户 服务层实现
 * @author mobai
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
