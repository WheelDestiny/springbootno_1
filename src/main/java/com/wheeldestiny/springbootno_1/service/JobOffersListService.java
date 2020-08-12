package com.wheeldestiny.springbootno_1.service;

import com.github.pagehelper.PageInfo;
import com.wheeldestiny.springbootno_1.bean.JobOffersList;

public interface JobOffersListService {
    //列表查询
    PageInfo<JobOffersList> queryJobOffersList(int pageNo, int pageSize, String orderBy,
                                               String recruitmentPositionName,String enterpriseName,
                                               String location,String industry,String salary,String experience,
                                               String educationalBackground);
}
