package com.ganglia_java.core.mapper;

import com.ganglia_java.core.model.Metric;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetricMapper {
    @Select("select * from metric")
    @Results(value = {@Result(property = "metricName", column = "METRIC_NAME"),
            @Result(property = "type", column = "TYPE"),
            @Result(property = "unit", column = "UNIT"),
            @Result(property = "warning", column = "WARNING")
    })
    public List<Metric> selectAll();

    @Select("select DISTINCT metric.METRIC_NAME,TYPE,UNIT,WARNING " +
            "from data,metric " +
            "where data.METRIC_NAME = metric.METRIC_NAME " +
            "AND HOST_NAME= #{hostName}")
    @Results(value = {@Result(property = "metricName", column = "METRIC_NAME"),
            @Result(property = "type", column = "TYPE"),
            @Result(property = "unit", column = "UNIT"),
            @Result(property = "warning",column = "WARNING")
    })
    public List<Metric> selectByHost(String hostName);

    @Insert("insert into metric(METRIC_NAME,TYPE,UNIT,WARNING) values(#{metricName},#{type},#{unit},#{warning})")
    public void insertMetric(Metric metric);

    @Update("update metric set METRIC_NAME = #{newMetric.metricName} TYPE = #{newMetric.type} UNIT = #{newMetric.unit} where METRIC_NAME = #{oldMetricName}")
    public void updateMetric(@Param("newMetric") Metric newMetric,@Param("oldMetricName") String oldMetricName);

    @Delete("delete from metric where METRIC_NAME = #{metricName}")
    public void deleteMetric(Metric metric);

}
