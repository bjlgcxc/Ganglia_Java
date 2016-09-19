package com.ganglia_java.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ganglia_java.core.mapper.UserMapper;
import com.ganglia_java.core.model.User;

@Service
public class UserService {
	
	@Autowired
    private UserMapper userMapper;
	
	public User getMatchUser(User user){
		return userMapper.getMatchUser(user);
	}
	
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
    
    public void insertUser(User user){
        userMapper.insertUser(user);
    }
    
    public void updateUser(User user){
        userMapper.updateUser(user);
    }
    
    public void deleteUser(User user){
        userMapper.deleteUser(user);
    }
    
}
