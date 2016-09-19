package com.ganglia_java.core.model;

public class newUser extends User{

    private String newPassword;

    public newUser(){}

    public newUser(String userName,String userPassword,String newPassword){
        super(userName,userPassword);
        newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
