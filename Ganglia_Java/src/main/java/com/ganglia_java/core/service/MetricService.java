package com.ganglia_java.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ganglia_java.core.mapper.MetricMapper;
import com.ganglia_java.core.model.Metric;

@Service
public class MetricService {
	
	@Autowired
    private MetricMapper metricMapper;

    public List<Metric> selectAll() {
        return metricMapper.selectAll();
    }
    
    public List<Metric> selectByHost(String hostName){ 
    	return metricMapper.selectByHost(hostName);
    }
    
    public void insertMetric(Metric metric){
        metricMapper.insertMetric(metric);
    }
    
    public void updateMetric(Metric newMetric,String oldMetricName){
        metricMapper.updateMetric(newMetric,oldMetricName);
    }
    
    public void deleteMetric(Metric metric){
        metricMapper.deleteMetric(metric);
    }
    
}
