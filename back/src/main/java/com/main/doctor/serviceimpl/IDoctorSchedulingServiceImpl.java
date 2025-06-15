package com.main.doctor.serviceimpl;

import com.main.doctor.mapper.DoctorSchedulingMapper;
import com.main.doctor.entity.DoctorScheduling;
import com.main.doctor.service.IDoctorSchedulingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 医生排班接口实现
 * @author mobai
 */
@Service
@Transactional
public class IDoctorSchedulingServiceImpl extends ServiceImpl<DoctorSchedulingMapper, DoctorScheduling> implements IDoctorSchedulingService {

}