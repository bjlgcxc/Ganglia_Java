package com.ganglia_java.core.controller;

import com.ganglia_java.core.model.Grid;
import com.ganglia_java.core.model.User;
import com.ganglia_java.core.service.GridService;
import com.ganglia_java.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private GridService gridService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String addForm(Model model){
        User user = new User();
        model.addAttribute("userForm",user);
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginCheck(@ModelAttribute User user, ModelMap modelMap){
 
        User matchUser = userService.getMatchUser(user);
    	List<Grid> grids = gridService.selectAll();
    	
    	//用户存在
        if (matchUser!=null){
        	//密码正确
        	if(matchUser.getUserPassword().equals(user.getUserPassword())){
	            modelMap.addAttribute("message","登录成功!");
	            modelMap.addAttribute("contentPage","liveCharts.jsp");
	            modelMap.addAttribute("liveChartPage","defaultView.jsp");
	            modelMap.addAttribute("allGrids",grids);
	            return "/templates/navigation";
        	}
        	//密码错误
        	else{
        		modelMap.addAttribute("message","密码错误");
            	modelMap.addAttribute("userForm",new User());
            	return "login";
        	}
        }
        //用户不存在
        else{
        	modelMap.addAttribute("message","用户不存在");
        	modelMap.addAttribute("userForm",new User());
        	return "login";
        }
        
    }

}