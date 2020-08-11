package com.wheeldestiny.springbootno_1.controller;

import com.github.pagehelper.PageInfo;
import com.wheeldestiny.springbootno_1.bean.JobOffersList;
import com.wheeldestiny.springbootno_1.bean.People;
import com.wheeldestiny.springbootno_1.interceptor.loginTest;
import com.wheeldestiny.springbootno_1.service.JobOffersListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;

@Controller
public class JobOffersController {
    @Autowired
    private JobOffersListService JobOffersListService;

    //获取列表属性
    //@param pageNo 要显示第几页内容
    //@param pageSize 一页显示多少条
    @loginTest
    @ResponseBody
    @RequestMapping(value = "/getJobOffersList", method = RequestMethod.POST)
    public PageInfo<JobOffersList> getJobOffersList(
            @RequestParam(required = false, name = "length",defaultValue="10") Integer length,
            @RequestParam(required = false, name = "start",defaultValue="1")Integer start,
            @RequestParam(required = false, name = "order[0][column]",defaultValue="-1")Integer column,
            @RequestParam(required = false, name = "order[0][dir]",defaultValue="asc")String dir,
            @RequestParam(required = false, name = "recruitmentPositionName",defaultValue="")String recruitmentPositionName,
            @RequestParam(required = false, name = "enterpriseName",defaultValue="")String enterpriseName,
            @RequestParam(required = false, name = "location",defaultValue="")String location,
            @RequestParam(required = false, name = "industry",defaultValue="")String industry,
            @RequestParam(required = false, name = "salary",defaultValue="")String salary,
            @RequestParam(required = false, name = "experience",defaultValue="")String experience,
            @RequestParam(required = false, name = "educationalBackground",defaultValue="")String educationalBackground,
            Model model){
//        System.out.println(recruitmentPositionName+"@@"+enterpriseName+"@@"+location+"@@"+industry+"@@"+salary+"@@"+experience+"@@"+educationalBackground+"@@");
        //排序的话只有薪资字段能够排序，所以排序字段固定，有改动的只是升序和降序
        String orderBy="salary"+" "+dir;
        PageInfo<JobOffersList> pageInfo = JobOffersListService.queryJobOffersList((start/length)+1,length,orderBy,
                recruitmentPositionName,enterpriseName,location,industry,salary,experience,educationalBackground);
        model.addAttribute("pageInfo", pageInfo);
        return pageInfo;
    }

    //跳转到招聘信息列表页
    @loginTest
    @RequestMapping(value = "/toJobOffersListTable", method = RequestMethod.GET)
    public String toJobOffersListTable(){
        return "/production/tables_dynamic3";
    }
}
