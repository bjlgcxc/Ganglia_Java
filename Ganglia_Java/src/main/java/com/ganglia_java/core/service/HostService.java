package com.ganglia_java.core.service;

import com.ganglia_java.core.mapper.HostMapper;
import com.ganglia_java.core.model.Host;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostService {
	
	@Autowired
    private HostMapper hostMapper;

    public List<Host> selectByCluster(String clusterName) {
        return hostMapper.selectByCluster(clusterName);
    }
 
    public Host selectByName(String hostName){ 
    	return hostMapper.selectByName(hostName);
    }
    
    public void insertHost(Host host){
        hostMapper.insertHost(host);
    }
    
    public void updateHost(Host newHost,String oldHostName){
        hostMapper.updateHost(newHost,oldHostName);
    }
    
    public void deleteHost(Host host){
        hostMapper.deleteHost(host);
    }   
	
}
