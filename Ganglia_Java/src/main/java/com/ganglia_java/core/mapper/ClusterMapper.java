package com.ganglia_java.core.mapper;

import com.ganglia_java.core.model.Cluster;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClusterMapper {
    
	@Select("select * from CLUSTER where GRID_NAME = #{gridName}")
    @Results(value = {@Result(property = "clusterName", column = "CLUSTER_NAME"),
            @Result(property = "gridName", column = "GRID_NAME"),
            @Result(property = "owner",column = "OWNER"),
            @Result(property = "latlong",column = "LATLONG"),
            @Result(property = "url",column = "URL")
    })
    public List<Cluster> selectByGrid(String gridName);

    @Select("select * from CLUSTER where CLUSTER_NAME = #{clusterName}")
    @Results(value = {@Result(property = "clusterName", column = "CLUSTER_NAME"),
            @Result(property = "gridName", column = "GRID_NAME"),
            @Result(property = "owner",column = "OWNER"),
            @Result(property = "latlong",column = "LATLONG"),
            @Result(property = "url",column = "URL")
    })
    public Cluster selectByName(String clusterName);

    @Insert("insert into CLUSTER(CLUSTER_NAME,GRID_NAME,OWNER,LATLONG,URL) " +
            "values(#{clusterName},#{gridName},#{owner},#{latlong},#{url})")
    public void insertCluster(Cluster cluster);

    @Update("update cluter set CLUSTER_NAME = #{newCluster.clusterName} " +
            "GRID_NAME = #{newCluster.gridName}," +
            "OWNER= #{newCluster.owner},LATLONG= #{newCluster.latlong}," +
            "URL= #{newCluster.url} " +
            "where CLUSTER_NAME = #{oldClusterName}")
    public void updateCluster(@Param("newCluster") Cluster newCluster,@Param("oldClusterName")String oldClusterName);

    @Delete("delete from CLUSTER where CLUSTER_NAME = #{clusterName}")
    public void deleteCluster(Cluster cluster);

}
