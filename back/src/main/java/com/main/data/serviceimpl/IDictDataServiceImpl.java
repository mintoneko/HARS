package com.main.data.serviceimpl;

import com.main.data.dao.mapper.DictDataMapper;
import com.main.data.entity.DictData;
import com.main.data.service.IDictDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 数据字典值 服务层实现
 * @author mobai
 */
@Service
public class IDictDataServiceImpl extends ServiceImpl<DictDataMapper, DictData> implements IDictDataService {

}
