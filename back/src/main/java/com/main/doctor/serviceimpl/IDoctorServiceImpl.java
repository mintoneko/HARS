package com.main.doctor.serviceimpl;

import com.main.doctor.mapper.DoctorMapper;
import com.main.doctor.entity.Doctor;
import com.main.doctor.service.IDoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 医生接口实现
 * @author mobai
 */
@Service
@Transactional
public class IDoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {

}