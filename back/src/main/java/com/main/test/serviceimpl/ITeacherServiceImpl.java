package com.main.test.serviceimpl;

import com.main.test.mapper.TeacherMapper;
import com.main.test.entity.Teacher;
import com.main.test.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 教师 服务层接口实现
 * @author mobai
 */
@Slf4j
@Service
@Transactional
public class ITeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
}