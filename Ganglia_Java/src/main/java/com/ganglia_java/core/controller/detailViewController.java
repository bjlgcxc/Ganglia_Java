package com.ganglia_java.core.controller;

import com.ganglia_java.core.model.Cluster;
import com.ganglia_java.core.model.Grid;
import com.ganglia_java.core.model.Host;
import com.ganglia_java.core.model.Metric;
import com.ganglia_java.core.service.ClusterService;
import com.ganglia_java.core.service.GridService;
import com.ganglia_java.core.service.HostService;
import com.ganglia_java.core.service.MetricService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class detailViewController {

    @Autowired
    GridService gridService;
    @Autowired
    ClusterService clusterService;
    @Autowired
    HostService hostService;
    @Autowired
    MetricService metricService;

    private String mainFrag = "templates/navigation";
    private String contentPage = "contentPage";
    private String detailPage = "detailPage";

    @RequestMapping(value = "/gridsDetail/{gridName}")
    public String findGrid(@PathVariable String gridName, ModelMap modelMap){
        List<Cluster> clusters = clusterService.selectByGrid(gridName);
        modelMap.addAttribute(contentPage,"detailView.jsp");
        modelMap.addAttribute(detailPage,"gridView.jsp");
        modelMap.addAttribute("allClusters",clusters);
        return mainFrag;
    }

    @RequestMapping(value = "/clustersDetail/{clusterName}")
    public String findCluster(@PathVariable String clusterName,ModelMap modelMap){
        List<Host> hosts = hostService.selectByCluster(clusterName);
        modelMap.addAttribute(contentPage,"detailView.jsp");
        modelMap.addAttribute(detailPage,"clusterView.jsp");
        modelMap.addAttribute("allHosts",hosts);
        return mainFrag;
    }

    @RequestMapping(value = "/hostsDetail/{hostName}")
    public String findHost(@PathVariable String hostName,ModelMap modelMap){
        List<Metric> metrics = metricService.selectByHost(hostName);
        modelMap.addAttribute(contentPage,"detailView.jsp");
        modelMap.addAttribute(detailPage,"hostView.jsp");
        modelMap.addAttribute("allMetrics",metrics);
        return mainFrag;
    }
    
    @RequestMapping(value = "/detailView")
    public String physicalView(ModelMap modelMap){
        List<Grid> grids = gridService.selectAll();
        modelMap.addAttribute(contentPage,"detailView.jsp");
        modelMap.addAttribute("detailPage","defaultView.jsp");
        modelMap.addAttribute("allGrids",grids);
        return mainFrag;
    }
    
}
