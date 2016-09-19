package com.ganglia_java.core.mapper;

import com.ganglia_java.core.model.Host;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostMapper {
    @Select("select * from HOST where CLUSTER_NAME = #{clusterName}")
    @Results(value = {@Result(property = "hostName", column = "HOST_NAME"),
            @Result(property = "clusterName", column = "CLUSTER_NAME"),
            @Result(property = "hostIP", column = "IP"),
            @Result(property = "location", column = "LOCATION"),
            @Result(property = "tags",column = "TAGS")
    })
    public List<Host> selectByCluster(String clusterName);

    @Select("select * from HOST where HOST_NAME = #{hostName}")
    @Results(value = {@Result(property = "hostName", column = "HOST_NAME"),
            @Result(property = "clusterName", column = "CLUSTER_NAME"),
            @Result(property = "hostIP", column = "IP"),
            @Result(property = "location", column = "LOCATION"),
            @Result(property = "tags",column = "TAGS")
    })
    public Host selectByName(String hostName);

    @Insert("insert into host(HOST_NAME,CLUSTER_NAME,IP,LOCATION,TAGS) " +
            "values(#{hostName},#{clusterName},#{hostIP},#{location},#{tags})")
    public void insertHost(Host host);

    @Update("update host set HOST_NAME = #{newHost.hostName}," +
            "CLUSTER_NAME = #{newHost.clusterName}," +
            "IP = #{newHost.hostIP},LOCATION = #{newHost.location}," +
            "TAGS = #{newHost.tags} " +
            "where HOST_NAME = #{oldHostName}")
    public void updateHost(@Param("newHost") Host newHost,@Param("oldHostName")String oldHostName);

    @Delete("delete from host where HOST_NAME = #{hostName}")
    public void deleteHost(Host host);

}
