package com.main.data.serviceimpl;

import com.main.data.dao.mapper.RolePermissionMapper;
import com.main.data.entity.RolePermission;
import com.main.data.service.IRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色-菜单关系 服务层实现
 * @author mobai
 */
@Service
public class IRolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

}
