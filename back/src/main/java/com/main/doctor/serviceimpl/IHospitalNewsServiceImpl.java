package com.main.doctor.serviceimpl;

import com.main.doctor.mapper.HospitalNewsMapper;
import com.main.doctor.entity.HospitalNews;
import com.main.doctor.service.IHospitalNewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 医院新闻接口实现
 * @author mobai
 */
@Service
@Transactional
public class IHospitalNewsServiceImpl extends ServiceImpl<HospitalNewsMapper, HospitalNews> implements IHospitalNewsService {

}