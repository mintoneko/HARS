package com.main.data.serviceimpl;

import com.main.data.dao.mapper.RoleMapper;
import com.main.data.entity.Role;
import com.main.data.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色 服务层实现
 * @author mobai
 */
@Service
public class IRoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
