package com.main.doctor.serviceimpl;

import com.main.doctor.mapper.HospitalSubjectMapper;
import com.main.doctor.entity.HospitalSubject;
import com.main.doctor.service.IHospitalSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 科室接口实现
 * @author mobai
 */
@Service
@Transactional
public class IHospitalSubjectServiceImpl extends ServiceImpl<HospitalSubjectMapper, HospitalSubject> implements IHospitalSubjectService {

}