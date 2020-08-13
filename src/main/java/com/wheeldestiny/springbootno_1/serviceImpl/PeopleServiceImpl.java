package com.wheeldestiny.springbootno_1.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wheeldestiny.springbootno_1.bean.People;
import com.wheeldestiny.springbootno_1.dao.PeopleDao;
import com.wheeldestiny.springbootno_1.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Resource
    private PeopleDao peopleDao;

    @Override
    public PageInfo<People> queryPeople(int pageNo, int pageSize,String orderBy,String name) {
        PageHelper.startPage(pageNo,pageSize,orderBy);
        List<People> peopleList = peopleDao.queryAll(name);

        PageInfo<People> page = new PageInfo<People>(peopleList);

        return page;
    }

    @Override
    public Long addPeople(String name, double intelligence, double strength, double speed, double power) {
        return peopleDao.addPeople(name,intelligence,strength,speed,power);
    }

    @Override
    public Long updatePeople(Long id, String name, double intelligence, double strength, double speed, double power) {
        return peopleDao.updatePeople(id,name,intelligence,strength,speed,power);
    }

    @Override
    public Long deletePeople(Long id) {
        return peopleDao.deletePeople(id);
    }
}
