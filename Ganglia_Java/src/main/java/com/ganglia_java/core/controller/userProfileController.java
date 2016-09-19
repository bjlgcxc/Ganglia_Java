package com.ganglia_java.core.controller;

import com.ganglia_java.core.model.User;
import com.ganglia_java.core.model.newUser;
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

    @RequestMapping(value = "/selectUser")
    public String selectUser(ModelMap modelMap) {
        List<User> allUsers = userService.selectAll();
        modelMap.addAttribute("users",allUsers);
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        modelMap.addAttribute(profilePage,"queryResult.jsp");
        return mainFrag;
    }

    @RequestMapping(value = "/insertUser",method = RequestMethod.GET)
    public String insertUserInit(ModelMap modelMap) {
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        modelMap.addAttribute(profilePage,"insertForm.jsp");
        modelMap.addAttribute("insertForm",new User());
        return mainFrag;
    }

    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public String insertUser(@ModelAttribute(value = "insertForm")User user, ModelMap modelMap) {
        List<User> allUsers = userService.selectAll();
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        if (user.getUserName().equals("")){
            modelMap.addAttribute(profilePage,"errorMsg.jsp");
            modelMap.addAttribute("errorMsg","用户名不能为空");
        }else{
            for (User cur_user : allUsers){
                if (cur_user.getUserName().equals(user.getUserName())){
                    modelMap.addAttribute(profilePage,"errorMsg.jsp");
                    modelMap.addAttribute("errorMsg","该用户已存在");
                    return mainFrag;
                }
            }
            userService.insertUser(user);
            modelMap.addAttribute(profilePage,"successMsg.jsp");
            modelMap.addAttribute("successMsg","新用户创建成功");
        }
        return mainFrag;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public String updateUserInit(ModelMap modelMap) {
        List<User> users = userService.selectAll();
        modelMap.addAttribute("listUsers",users);
        modelMap.addAttribute(profilePage,"updateForm.jsp");
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        modelMap.addAttribute("updateForm",new newUser());
        modelMap.addAttribute("newPassword", "");
        return mainFrag;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(@ModelAttribute(value = "updateForm") newUser nUser , ModelMap modelMap) {
        List<User> users = userService.selectAll();
        for (User cur_user : users){
            if (cur_user.getUserName().equals(nUser.getUserName()) && cur_user.getUserPassword().equals(nUser.getUserPassword())){
                User newuser = new User(nUser.getUserName(),nUser.getNewPassword());
                userService.updateUser(newuser);
                modelMap.addAttribute(profilePage,"successMsg.jsp");
                modelMap.addAttribute("successMsg","密码更新成功!");
            }else{
                modelMap.addAttribute(profilePage,"errorMsg.jsp");
                modelMap.addAttribute("errorMsg","输入的原密码有误,更新失败");
            }
        }
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        return mainFrag;
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public String deleteUserInit(ModelMap modelMap) {
        List<User> users = userService.selectAll();
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        modelMap.addAttribute(profilePage,"deleteForm.jsp");
        modelMap.addAttribute("listUsers",users);
        modelMap.addAttribute("deleteForm",new User());
        return mainFrag;
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute(value = "deleteForm")User user,ModelMap modelMap) {
        List<User> users = userService.selectAll();
        for (User cur_user : users){
            if (cur_user.getUserName().equals(user.getUserName()) && cur_user.getUserPassword().equals(user.getUserPassword())){
                userService.deleteUser(user);
                modelMap.addAttribute(profilePage,"successMsg.jsp");
                modelMap.addAttribute("successMsg","删除成功!");
            }else{
                modelMap.addAttribute(profilePage,"errorMsg.jsp");
                modelMap.addAttribute("errorMsg","输入的密码有误,删除失败");
            }
        }
        modelMap.addAttribute(contentPage,"userProfile.jsp");
        return mainFrag;
    }
}
