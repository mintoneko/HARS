package com.main.test.serviceimpl;

import com.main.test.mapper.StudentMapper;
import com.main.test.entity.Student;
import com.main.test.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 学生 服务层接口实现
 * @author mobai
 */
@Slf4j
@Service
@Transactional
public class IStudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;
}