package com.main.data.serviceimpl;

import com.main.data.dao.mapper.DepartmentMapper;
import com.main.data.entity.Department;
import com.main.data.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 部门 服务层实现
 * @author mobai
 */
@Service
public class IDepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
