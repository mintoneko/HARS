package com.main.data.serviceimpl;

import com.main.data.dao.mapper.DictMapper;
import com.main.data.entity.Dict;
import com.main.data.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 数据字典 服务层实现
 * @author mobai
 */
@Service
public class IDictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

}
