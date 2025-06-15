package com.main.test.controller;

import com.main.basics.log.LogType;
import com.main.basics.log.SystemLog;
import com.main.basics.utils.PageUtil;
import com.main.basics.utils.ResultUtil;
import com.main.basics.baseVo.PageVo;
import com.main.basics.baseVo.Result;
import com.main.data.utils.ZwzNullUtils;
import com.main.data.vo.AntvVo;
import com.main.test.entity.Teacher;
import com.main.test.service.ITeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author mobai
 */
@Slf4j
@RestController
@Api(tags = "教师管理接口")
@RequestMapping("/zwz/teacher")
@Transactional
public class TeacherController {

    @Autowired
    private ITeacherService iTeacherService;

    @SystemLog(about = "查询单条教师", type = LogType.MORE_MOUDLE,doType = "TEACHER-01")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条教师")
    public Result<Teacher> get(@RequestParam String id){
        return new ResultUtil<Teacher>().setData(iTeacherService.getById(id));
    }

    @SystemLog(about = "查询全部教师个数", type = LogType.MORE_MOUDLE,doType = "TEACHER-02")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部教师个数")
    public Result<Long> getCount(){
        return new ResultUtil<Long>().setData(iTeacherService.count());
    }

    @SystemLog(about = "查询全部教师", type = LogType.MORE_MOUDLE,doType = "TEACHER-03")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部教师")
    public Result<List<Teacher>> getAll(){
        return new ResultUtil<List<Teacher>>().setData(iTeacherService.list());
    }

    @SystemLog(about = "查询教师", type = LogType.MORE_MOUDLE,doType = "TEACHER-04")
    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询教师")
    public Result<IPage<Teacher>> getByPage(@ModelAttribute Teacher teacher ,@ModelAttribute PageVo page){
        QueryWrapper<Teacher> qw = new QueryWrapper<>();
        if(!ZwzNullUtils.isNull(teacher.getName())) {
            qw.like("name",teacher.getName());
        }
        if(!ZwzNullUtils.isNull(teacher.getEducation())) {
            qw.eq("education",teacher.getEducation());
        }
        if(!ZwzNullUtils.isNull(teacher.getGraduated())) {
            qw.like("graduated",teacher.getGraduated());
        }
        IPage<Teacher> data = iTeacherService.page(PageUtil.initMpPage(page),qw);
        return new ResultUtil<IPage<Teacher>>().setData(data);
    }

    @SystemLog(about = "增改教师", type = LogType.MORE_MOUDLE,doType = "TEACHER-05")
    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改教师")
    public Result<Teacher> saveOrUpdate(Teacher teacher){
        if(iTeacherService.saveOrUpdate(teacher)){
            return new ResultUtil<Teacher>().setData(teacher);
        }
        return ResultUtil.error();
    }

    @SystemLog(about = "新增教师", type = LogType.MORE_MOUDLE,doType = "TEACHER-06")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增教师")
    public Result<Teacher> insert(Teacher teacher){
        iTeacherService.saveOrUpdate(teacher);
        return new ResultUtil<Teacher>().setData(teacher);
    }

    @SystemLog(about = "编辑教师", type = LogType.MORE_MOUDLE,doType = "TEACHER-07")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑教师")
    public Result<Teacher> update(Teacher teacher){
        iTeacherService.saveOrUpdate(teacher);
        return new ResultUtil<Teacher>().setData(teacher);
    }

    @SystemLog(about = "删除教师", type = LogType.MORE_MOUDLE,doType = "TEACHER-08")
    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除教师")
    public Result<Object> delByIds(@RequestParam String[] ids){
        for(String id : ids){
            iTeacherService.removeById(id);
        }
        return ResultUtil.success();
    }

    @SystemLog(about = "查询图表数据", type = LogType.CHART,doType = "CHART-01")
    @RequestMapping(value = "/getAntvVoList", method = RequestMethod.GET)
    @ApiOperation(value = "查询图表数据")
    public Result<List<AntvVo>> getAntvVoList(){
        List<AntvVo> ansList = new ArrayList<>();
        List<Teacher> teacherList = iTeacherService.list();
        for (Teacher o : teacherList) {
            boolean flag = false;
            for (AntvVo vo : ansList) {
                if(Objects.equals(vo.getTitle(),o.getName())) {
                    flag = true;
                    vo.setValue(vo.getValue().add(o.getWages()));
                    break;
                }
            }
            if(!flag) {
                AntvVo vo = new AntvVo();
                vo.setTitle(o.getName());
                vo.setType("工资金额");
                vo.setValue(o.getWages());
                ansList.add(vo);
            }
        }
        return new ResultUtil<List<AntvVo>>().setData(ansList);
    }
}
