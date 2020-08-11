package com.wheeldestiny.springbootno_1.dao;


import com.wheeldestiny.springbootno_1.bean.JobOffersList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobOffersListDao {
    //v_jobofferslist视图数据
    List<JobOffersList> queryAll(
            @Param("enterpriseName") String enterpriseName,//企业名称
            @Param("recruitmentPositionName") String recruitmentPositionName,//招聘岗位名称
            @Param("location") String location,//所在地
            @Param("industry") String industry,//所在行业
            @Param("salary") String salary,//薪资水平
            @Param("experience") int experience,//工作经验要求
            @Param("educationalBackground") int educationalBackground//教育背景要求
    );
}
