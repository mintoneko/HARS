package com.main.doctor.serviceimpl;

import com.main.doctor.mapper.HospitalOrderMapper;
import com.main.doctor.entity.HospitalOrder;
import com.main.doctor.service.IHospitalOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 挂号接口实现
 * @author mobai
 */
@Service
@Transactional
public class IHospitalOrderServiceImpl extends ServiceImpl<HospitalOrderMapper, HospitalOrder> implements IHospitalOrderService {

}