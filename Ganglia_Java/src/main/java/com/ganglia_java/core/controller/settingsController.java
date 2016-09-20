package com.ganglia_java.core.controller;

import com.ganglia_java.core.model.Metric;
import com.ganglia_java.core.model.Setting;
import com.ganglia_java.core.service.MetricService;
import com.ganglia_java.core.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class settingsController {

    @Autowired
    MetricService metricService;
    @Autowired
    SettingService settingService;

    private String mainFrag = "templates/navigation";
    private String contentPage = "contentPage";
    
    /*
     * 获取系统设置
     */
    @RequestMapping(value = "/settings",method = RequestMethod.GET)
    public String settingsGET(ModelMap modelMap){
        List<Metric> metrics = metricService.selectAll();
        List<Setting> settings = settingService.selectSetting();
        if (settings.isEmpty()){
            settings.add(new Setting());
        }
        modelMap.addAttribute(contentPage,"settings.jsp");
        modelMap.addAttribute("save",false);
        modelMap.addAttribute("metrics",metrics);
        modelMap.addAttribute("setting",settings.get(0));
        return mainFrag;
    }

    /*
     * 保存系统设置
     */
    @RequestMapping(value = "/settings",method = RequestMethod.POST)
    public String settingsPOST(@ModelAttribute(value = "setting")List<Setting> settings, ModelMap modelMap){
        modelMap.addAttribute(contentPage,"settings.jsp");
        modelMap.addAttribute("save",true);
        return mainFrag;
    }
    
}
