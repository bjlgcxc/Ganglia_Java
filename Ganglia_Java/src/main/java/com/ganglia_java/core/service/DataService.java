package com.ganglia_java.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ganglia_java.core.mapper.DataMapper;
import com.ganglia_java.core.model.Data;

@Service
public class DataService {
	
	 @Autowired
	 private DataMapper dataMapper;

     public List<Data> selectByHost(String hostName) {
        return dataMapper.selectByHost(hostName);
     }
     
     public void insertData(Data data){
        dataMapper.insertData(data);
     }
     
     public void updateData(Data newData,Data oldData){
        dataMapper.updateData(newData,oldData);
     }
     
     public void deleteData(Data data){
        dataMapper.deleteData(data);
     }
}
