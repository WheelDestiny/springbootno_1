package com.wheeldestiny.springbootno_1.controller;

import com.github.pagehelper.PageInfo;
import com.wheeldestiny.springbootno_1.bean.People;
import com.wheeldestiny.springbootno_1.interceptor.loginTest;
import com.wheeldestiny.springbootno_1.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;

@Controller
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    //获取列表属性
    //@param pageNo 要显示第几页内容
    //@param pageSize 一页显示多少条
    @loginTest
    @ResponseBody
    @RequestMapping(value = "/getPeopleList", method = RequestMethod.POST)
    public PageInfo<People> getPeopleList(
            @RequestParam(required = false, name = "length",defaultValue="10") Integer length,
            @RequestParam(required = false, name = "start",defaultValue="1")Integer start,
            @RequestParam(required = false, name = "order[0][column]",defaultValue="-1")Integer column,
            @RequestParam(required = false, name = "order[0][dir]",defaultValue="asc")String dir,
            @RequestParam(required = false, name = "name",defaultValue="")String name,
            Model model){
        //获取people属性的名称列表
        Field[] field = People.class.getDeclaredFields();
        String orderBy=field[column+1].getName()+" "+dir;
        PageInfo<People> pageInfo = peopleService.queryPeople((start/length)+1,length,orderBy,name);
        model.addAttribute("pageInfo", pageInfo);
        return pageInfo;
    }
    //跳转到人物列表页
    @loginTest
    @RequestMapping(value = "/toPeopleTable", method = RequestMethod.GET)
    public String toPeopleTable(){
        return "/production/tables_dynamic2";
    }
    //添加人物页弹窗
    @loginTest
    @RequestMapping(value = "/addOrUpdatePeople")
    public String addOrUpdatePeople(){
        return "/production/addOrUpdatePeople";
    }
    //添加人物
    //传回成功/失败标记
    @ResponseBody
    @RequestMapping(value = "/addPeople", method = RequestMethod.POST)
    public boolean addPeople(@RequestBody People people) {
        Long res = peopleService.addPeople(people.getName(),people.getIntelligence(),people.getStrength(),people.getSpeed(),(people.getIntelligence()+people.getStrength()+people.getSpeed()));
        Boolean result = false;
        if (res>0){
            result = true;
        }
        return result;
    }
    //修改人物/updatePeople
    //传回成功/失败标记
    @ResponseBody
    @RequestMapping(value = "/updatePeople", method = RequestMethod.POST)
    public boolean updatePeople(@RequestBody People people) {
        Long res = peopleService.updatePeople(
                people.getId(),
                people.getName(),
                people.getIntelligence(),
                people.getStrength(),
                people.getSpeed(),
                (people.getIntelligence()+people.getStrength()+people.getSpeed()));
        Boolean result = false;
        if (res>0){
            result = true;
        }
        return result;
    }
    //删除人物
    //传回成功/失败标记
    @ResponseBody
    @RequestMapping(value = "/deletePeople", method = RequestMethod.POST)
    public boolean deletePeople(@RequestBody People people) {
        Long res = peopleService.deletePeople(people.getId());
        Boolean result = false;
        if (res>0){
            result = true;
        }
        return result;
    }
}
