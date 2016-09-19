package com.ganglia_java.core.mapper;

import com.ganglia_java.core.model.Grid;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GridMapper {
    @Select("select * from GRID")
    @Results(value = {@Result(property = "gridName", column = "GRID_NAME"),
            @Result(property = "authority",column = "AUTHORITY")
    })
    public List<Grid> selectAll();

    @Select("select * from GRID where GRID_NAME = #{gridName}")
    @Results(value = {@Result(property = "gridName", column = "GRID_NAME"),
            @Result(property = "authority",column = "AUTHORITY")
    })
    public Grid selectByName(String gridName);


    @Insert("insert into GRID(GRID_NAME,AUTHORITY) values(#{gridName},#{authority})")
    public void insertGrid(Grid grid);

    @Update("update GRID set GRID_NAME = #{newGrid.gridName}, " +
            "AUTHORITY = #{newGrid.authority} " +
            "where GRID_NAME = #{oldGridName}")
    public void updateGrid(@Param("newGrid") Grid newGrid,@Param("oldGridName") String oldGridName);

    @Delete("delete from GRID where GRID)NAME = #{gridName}")
    public void deleteGrid(Grid grid);

}
