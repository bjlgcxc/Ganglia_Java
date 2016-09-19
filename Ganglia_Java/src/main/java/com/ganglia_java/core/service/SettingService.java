package com.ganglia_java.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ganglia_java.core.mapper.SettingMapper;
import com.ganglia_java.core.model.Setting;

@Service
public class SettingService {
	
	@Autowired
    private SettingMapper settingMapper;

    public List<Setting> selectSetting(){
        return settingMapper.selectSetting();
    }
    
    public void interSetting(Setting setting){
        settingMapper.interSetting(setting);
    }
    
    public void updateSetting(Setting setting){
        settingMapper.updateSetting(setting);
    }
    
    public void deleteSetting(){
        settingMapper.deleteSetting();
    }
    
}
