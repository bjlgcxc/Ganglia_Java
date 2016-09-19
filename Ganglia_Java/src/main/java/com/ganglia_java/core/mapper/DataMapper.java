package com.ganglia_java.core.mapper;

import com.ganglia_java.core.model.Data;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataMapper {
    
	@Select("select * from DATA where HOST_NAME = #{hostName}")
    @Results(value = {@Result(property = "metricName", column = "METRIC_NAME"),
            @Result(property = "hostName", column = "HOST_NAME"),
            @Result(property = "reportedTime", column = "REPORTED"),
            @Result(property = "val", column = "VAL")
    })
    public List<Data> selectByHost(String hostName);

    @Insert("insert into DATA(METRIC_NAME,HOST_NAME,REPORTED,VAL) " +
            "values(#{metricName},#{hostName},#{reportedTime},#{val})")
    public void insertData(Data data);

    @Update("update DATA set METRIC_NAME = #{newData.}" +
            "HOST_NAME = #{newData.hostName}" +
            "REPORTED = #{newData.reportedTime}" +
            "VAL = #{newData.val}" +
            "where METRIC_NAME = #{oldData.metricName} " +
            "HOST_NAME = #{oldData.hostName}," +
            "REPORTED = #{oldData.reportedTime}")
    public void updateData(@Param("newData") Data newData,@Param("oldData") Data oldData);

    @Delete("delete from DATA where METRIC_NAME = #{metricName} " +
            "AND HOST_NAME = #{hostName} AND " +
            "REPORTED = #{reportedTime}")
    public void deleteData(Data data);
}
