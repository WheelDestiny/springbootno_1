package com.wheeldestiny.springbootno_1.service;

import com.github.pagehelper.PageInfo;
import com.wheeldestiny.springbootno_1.bean.People;

import java.util.List;

public interface PeopleService {
    //列表查询
    PageInfo<People> queryPeople(int pageNo, int pageSize,String orderBy,String name);
    //添加人物
    Long addPeople(String name,double intelligence,double strength,double speed ,double power);
    //修改人物
    Long updatePeople(Long id,String name,double intelligence,double strength,double speed ,double power);
    //删除人物
    Long deletePeople(Long id);
}
