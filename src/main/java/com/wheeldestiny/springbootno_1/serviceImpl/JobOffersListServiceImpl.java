package com.wheeldestiny.springbootno_1.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wheeldestiny.springbootno_1.bean.JobOffersList;
import com.wheeldestiny.springbootno_1.bean.People;
import com.wheeldestiny.springbootno_1.dao.JobOffersListDao;
import com.wheeldestiny.springbootno_1.service.JobOffersListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JobOffersListServiceImpl implements JobOffersListService {
    @Resource
    private JobOffersListDao JobOffersListDao;
    @Override
    public PageInfo<JobOffersList> queryJobOffersList(int pageNo, int pageSize, String orderBy, String recruitmentPositionName,String enterpriseName,String location,String industry,String salary,String experience,String educationalBackground) {
        if ("".equals(experience)){
            experience="-1";
        }
        if ("".equals(educationalBackground)){
            educationalBackground="-1";
        }
        PageHelper.startPage(pageNo,pageSize,orderBy);
        List<JobOffersList> JobOffersLists = JobOffersListDao.queryAll(enterpriseName,recruitmentPositionName,location,industry,salary,Integer.parseInt(experience),Integer.parseInt(educationalBackground));

        PageInfo<JobOffersList> page = new PageInfo<JobOffersList>(JobOffersLists);

        return page;
    }
}
