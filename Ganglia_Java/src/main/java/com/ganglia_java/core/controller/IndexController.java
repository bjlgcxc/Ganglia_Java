package com.ganglia_java.core.controller;

import com.ganglia_java.core.model.Grid;
import com.ganglia_java.core.service.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class IndexController {

    private String mainFrag = "templates/navigation";
    private String contentPage = "contentPage";

    @Autowired
    GridService gridService;

    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap){
        List<Grid> grids = gridService.selectAll();
        modelMap.addAttribute(contentPage,"liveCharts.jsp");
        modelMap.addAttribute("liveChartPage","defaultView.jsp");
        modelMap.addAttribute("allGrids",grids);
        return mainFrag;
    }

    @RequestMapping(value = "/userProfile")
    public String userProfile(ModelMap modelMap){
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        modelMap.addAttribute("userProfilePage","successMsg.jsp");
        modelMap.addAttribute("successMsg","请选择下方功能");
        return mainFrag;
    }

    @RequestMapping(value = "/notification")
    public String notification(ModelMap modelMap){
        modelMap.addAttribute(contentPage,"notification.jsp");
        return mainFrag;
    }
}
