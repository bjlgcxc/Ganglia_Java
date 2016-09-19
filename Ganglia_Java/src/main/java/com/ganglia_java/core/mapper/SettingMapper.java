package com.ganglia_java.core.mapper;

import com.ganglia_java.core.model.Setting;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingMapper {

    @Select("select * from setting")
    @Results(value = {@Result(property = "line_count", column = "LINE_COUNT"),
            @Result(property = "update_interval", column = "UPDATE_INTERVAL"),
            @Result(property = "email", column = "EMAIL")
    })
    public List<Setting> selectSetting();

    @Insert("insert into Setting(LINE_COUNT,UPDATE_INTERVAL,EMAIL) values(#{line_count},#{update_interval},#{email})")
    public void interSetting(Setting setting);

    @Update("update Setting set LINE_COUNT = #{line_count}, " +
            "UPDATE_INTERVAL = #{update_interval} " +
            "EMAIL = #{email}")
    public void updateSetting(Setting setting);

    @Delete("delete from setting")
    public void deleteSetting();
}
