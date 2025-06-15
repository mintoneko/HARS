package com.main.data.serviceimpl;

import com.main.data.dao.mapper.DepartmentHeaderMapper;
import com.main.data.entity.DepartmentHeader;
import com.main.data.service.IDepartmentHeaderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 部门领导 服务层实现
 * @author mobai
 */
@Service
public class IDepartmentHeaderServiceImpl extends ServiceImpl<DepartmentHeaderMapper, DepartmentHeader> implements IDepartmentHeaderService {

}
