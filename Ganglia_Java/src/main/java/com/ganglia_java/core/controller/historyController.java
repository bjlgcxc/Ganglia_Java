package com.ganglia_java.core.controller;

import com.ganglia_java.core.model.History;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class historyController {

    private String mainFrag = "templates/navigation";
    private String contentPage = "contentPage";
    
    /*
     * 获取历史数据(未完成)
     */
    @RequestMapping(value = "/history",method = RequestMethod.GET)
    public String getHistory(ModelMap modelMap){
        modelMap.addAttribute(contentPage,"history.jsp");
        modelMap.addAttribute("result",false);
        modelMap.addAttribute("history",new History());
        return mainFrag;
    }

    /*
     * 保存历史数据(未完成)
     */
    @RequestMapping(value = "/history",method = RequestMethod.POST)
    public String saveHistory(@ModelAttribute(value = "history")History history, ModelMap modelMap){
        modelMap.addAttribute(contentPage,"history.jsp");
        modelMap.addAttribute("msg","Selected Time Range: " + history.getBeginTime() + " " + history.getStopTime());
        modelMap.addAttribute("result",true);
        return mainFrag;
    }
    
}
