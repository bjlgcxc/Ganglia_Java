package com.ganglia_java.core.service;

import com.ganglia_java.core.mapper.ClusterMapper;
import com.ganglia_java.core.model.Cluster;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClusterService {
	
	@Autowired
    private ClusterMapper clusterMapper;

    public List<Cluster> selectByGrid(String gridName) {
        return clusterMapper.selectByGrid(gridName);
    }
    
    public Cluster selectByName(String clusterName){
    	return clusterMapper.selectByName(clusterName);
    }
    
    public void insertCluster(Cluster cluster){
        clusterMapper.insertCluster(cluster);
    }
    
    public void updateCluster(Cluster newCluster,String oldClusterName){
        clusterMapper.updateCluster(newCluster,oldClusterName);
    }
    
    public void deleteCluster(Cluster cluster){
        clusterMapper.deleteCluster(cluster);
    }
    
}
