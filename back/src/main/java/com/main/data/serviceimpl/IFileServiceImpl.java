package com.main.data.serviceimpl;

import com.main.data.dao.mapper.FileMapper;
import com.main.data.entity.File;
import com.main.data.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 系统文件 服务层实现
 * @author mobai
 */
@Service
public class IFileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

}
