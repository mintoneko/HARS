package com.main.data.serviceimpl;

import com.main.data.dao.mapper.UserRoleMapper;
import com.main.data.entity.UserRole;
import com.main.data.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户-角色关系 服务层实现
 * @author mobai
 */
@Service
public class IUserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
