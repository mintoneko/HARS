package com.main.doctor.controller;

import com.main.basics.baseVo.PageVo;
import com.main.basics.baseVo.Result;
import com.main.basics.utils.PageUtil;
import com.main.basics.utils.ResultUtil;
import com.main.basics.utils.SecurityUtil;
import com.main.data.entity.User;
import com.main.data.utils.ZwzNullUtils;
import com.main.doctor.entity.Doctor;
import com.main.doctor.entity.DoctorScheduling;
import com.main.doctor.entity.HospitalOrder;
import com.main.doctor.service.IDoctorSchedulingService;
import com.main.doctor.service.IDoctorService;
import com.main.doctor.service.IHospitalOrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mobai
 */
@RestController
@Api(tags = "挂号管理接口")
@RequestMapping("/zwz/hospitalOrder")
@Transactional
public class HospitalOrderController {

    @Autowired
    private IHospitalOrderService iHospitalOrderService;

    @Autowired
    private SecurityUtil securityUtil;

    @Autowired
    private IDoctorService iDoctorService;

    @Autowired
    private IDoctorSchedulingService iDoctorSchedulingService;

    @RequestMapping(value = "/getMyOrderList", method = RequestMethod.POST)
    @ApiOperation(value = "查询我的挂号")
    public Result<IPage<HospitalOrder>> getMyOrderList(@ModelAttribute HospitalOrder order,@ModelAttribute PageVo page){
        User currUser = securityUtil.getCurrUser();
        QueryWrapper<HospitalOrder> qw = new QueryWrapper<>();
        qw.eq("user_id",currUser.getId());
        qw.orderByDesc("create_time");
        if(!ZwzNullUtils.isNull(order.getDateTime())) {
            qw.eq("date_time",order.getDateTime());
        }
        if(!ZwzNullUtils.isNull(order.getDoctorName())) {
            qw.like("doctor_name",order.getDoctorName());
        }
        return new ResultUtil<IPage<HospitalOrder>>().setData(iHospitalOrderService.page(PageUtil.initMpPage(page),qw));
    }
    @RequestMapping(value = "/payMoney", method = RequestMethod.POST)
    @ApiOperation(value = "挂号付款")
    public Result<Object> payMoney(@RequestParam String orderId){
        HospitalOrder ho = iHospitalOrderService.getById(orderId);
        if(ho == null) {
            return ResultUtil.error("挂号单不存在");
        }
        ho.setMoneyFlag(1);
        iHospitalOrderService.saveOrUpdate(ho);
        return ResultUtil.success("付款成功");
    }

    @RequestMapping(value = "/noneOrder", method = RequestMethod.POST)
    @ApiOperation(value = "取消挂号")
    public Result<Object> noneOrder(@RequestParam String orderId){
        HospitalOrder ho = iHospitalOrderService.getById(orderId);
        if(ho == null) {
            return new ResultUtil<Object>().setErrorMsg("挂号单不存在");
        }
        ho.setStatus(1);
        iHospitalOrderService.saveOrUpdate(ho);
        return ResultUtil.success("取消成功");
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    @ApiOperation(value = "新增挂号")
    public Result<Object> addOrder(@RequestParam String orderId){
        User currUser = securityUtil.getCurrUser();
        DoctorScheduling ds = iDoctorSchedulingService.getById(orderId);
        if(ds == null) {
            return ResultUtil.error("号源不存在");
        }
        if(ds.getOrderFlag() > 0) {
            return ResultUtil.error("您手慢拉,该号已被别人预约!");
        }
        Doctor doctor = iDoctorService.getById(ds.getDoctorId());
        if(doctor == null) {
            return ResultUtil.error("医生不存在");
        }
        ds.setOrderFlag(1);
        iDoctorSchedulingService.saveOrUpdate(ds);
        HospitalOrder ho = new HospitalOrder();
        ho.setUserId(currUser.getId());
        ho.setUserName(currUser.getNickname());
        ho.setOrderId(ds.getId());
        ho.setNumber(ds.getNumber());
        ho.setStep(ds.getStep());
        ho.setDateTime(ds.getDate());
        ho.setDoctorId(ds.getDoctorId());
        ho.setDoctorName(ds.getDoctorName());
        ho.setMoneyData(doctor.getOrderMoney());
        iHospitalOrderService.saveOrUpdate(ho);
        return ResultUtil.success("预约成功!");
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有挂号信息")
    public Result<List<HospitalOrder>> getAll(){
        return new ResultUtil<List<HospitalOrder>>().setData(iHospitalOrderService.list());
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询挂号信息")
    public Result<IPage<HospitalOrder>> getByPage(PageVo page){
        return new ResultUtil<IPage<HospitalOrder>>().setData(iHospitalOrderService.page(PageUtil.initMpPage(page)));
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改挂号信息")
    public Result<HospitalOrder> saveOrUpdate(HospitalOrder hospitalOrder){
        if(iHospitalOrderService.saveOrUpdate(hospitalOrder)){
            return new ResultUtil<HospitalOrder>().setData(hospitalOrder);
        }
        return ResultUtil.error();
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除挂号信息")
    public Result<Object> delAllByIds(@RequestParam String[] ids){
        for(String id : ids){
            iHospitalOrderService.removeById(id);
        }
        return ResultUtil.success();
    }
}
