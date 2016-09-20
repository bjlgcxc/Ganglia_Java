package com.ganglia_java.core.controller;

import com.ganglia_java.core.model.User;
import com.ganglia_java.core.model.NewUser;
import com.ganglia_java.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
@RequestMapping(value = "/userProfile")
public class userProfileController {

    @Autowired
    private UserService userService;

    private String mainFrag = "templates/navigation";
    private String contentPage = "contentPage";
    private String profilePage = "userProfilePage";

    /*
     * 跳转到"查询用户"
     */
    @RequestMapping(value = "/selectUser")
    public String selectUser(ModelMap modelMap) {
        List<User> allUsers = userService.selectAll();
        modelMap.addAttribute("users",allUsers);
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        modelMap.addAttribute(profilePage,"queryResult.jsp");
        return mainFrag;
    }
    
    /*
     * 跳转到"插入用户"
     */
    @RequestMapping(value = "/insertUser",method = RequestMethod.GET)
    public String insertUserInit(ModelMap modelMap) {
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        modelMap.addAttribute(profilePage,"insertForm.jsp");
        modelMap.addAttribute("insertForm",new User());
        return mainFrag;
    }

    /*
     * 插入用户
     */
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public String insertUser(@ModelAttribute(value = "insertForm")User user, ModelMap modelMap) {
        User matcheUser = userService.getMatchUser(user);
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        if (user.getUserName().equals("")){
            modelMap.addAttribute(profilePage,"errorMsg.jsp");
            modelMap.addAttribute("errorMsg","用户名不能为空");
        }else{
            if (matcheUser.getUserName().equals(user.getUserName())){
                modelMap.addAttribute(profilePage,"errorMsg.jsp");
                modelMap.addAttribute("errorMsg","该用户已存在");
            }
        	else{
        		userService.insertUser(user);
        		modelMap.addAttribute(profilePage,"successMsg.jsp");
        		modelMap.addAttribute("successMsg","新用户创建成功");
        	}
        }  
        return mainFrag;
    }

    /*
     * 跳转到"更新用户"
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public String updateUserInit(ModelMap modelMap) {
        List<User> users = userService.selectAll();
        modelMap.addAttribute("listUsers",users);
        modelMap.addAttribute(profilePage,"updateForm.jsp");
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        modelMap.addAttribute("updateForm",new NewUser());
        modelMap.addAttribute("newPassword", "");
        return mainFrag;
    }

    /*
     * 更新用户
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(@ModelAttribute(value = "updateForm") NewUser nUser , ModelMap modelMap) {
        User matchUser = userService.getMatchUser(nUser);
        if (matchUser.getUserPassword().equals(nUser.getUserPassword())){
        	User newuser = new User(nUser.getUserName(),nUser.getNewPassword());
            userService.updateUser(newuser);
            modelMap.addAttribute(profilePage,"successMsg.jsp");
            modelMap.addAttribute("successMsg","密码更新成功!");
        }else{
            modelMap.addAttribute(profilePage,"errorMsg.jsp");
            modelMap.addAttribute("errorMsg","输入的原密码有误,更新失败");
        }
    
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        return mainFrag;
    }
    
    /*
     * 跳转到"删除用户"
     */
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public String deleteUserInit(ModelMap modelMap) {
        List<User> users = userService.selectAll();
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        modelMap.addAttribute(profilePage,"deleteForm.jsp");
        modelMap.addAttribute("listUsers",users);
        modelMap.addAttribute("deleteForm",new User());
        return mainFrag;
    }

    /*
     * 删除用户
     */
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute(value = "deleteForm")User user,ModelMap modelMap) {
    	User matchUser = userService.getMatchUser(user);
        if (matchUser.getUserPassword().equals(user.getUserPassword())){
            userService.deleteUser(user);
            modelMap.addAttribute(profilePage,"successMsg.jsp");
            modelMap.addAttribute("successMsg","删除成功!");
        }else{
            modelMap.addAttribute(profilePage,"errorMsg.jsp");
            modelMap.addAttribute("errorMsg","输入的密码有误,删除失败");
        }
      
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        return mainFrag;
    }
    
}
