package com.ganglia_java.core.model;

public class NewUser extends User{

    private String newPassword;

    public NewUser(){}

    public NewUser(String userName,String userPassword,String newPassword){
        super(userName,userPassword);
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
