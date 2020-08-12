package com.wheeldestiny.springbootno_1.dao;

import com.wheeldestiny.springbootno_1.bean.People;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleDao {
    //people表数据
    List<People> queryAll(String name);
    //添加人物信息
    Long addPeople(@Param("name") String name,
                 @Param("intelligence") double intelligence,
                 @Param("strength") double strength,
                 @Param("speed") double speed,
                 @Param("power") double power);
    //修改人物信息
    Long updatePeople(@Param("id") Long id,
                      @Param("name") String name,
                      @Param("intelligence") double intelligence,
                      @Param("strength") double strength,
                      @Param("speed") double speed,
                      @Param("power") double power);
    //删除人物信息
    Long deletePeople(@Param("id") Long id);
}
