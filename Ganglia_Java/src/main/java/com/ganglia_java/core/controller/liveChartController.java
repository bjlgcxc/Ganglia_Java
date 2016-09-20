package com.ganglia_java.core.controller;

import com.ganglia_java.core.model.Cluster;
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
public class liveChartController {

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
    private String liveChartPage = "liveChartPage";
    
    /*
     * 实时监控信息 网格详情
     */
    @RequestMapping(value = "/grids/{gridName}")
    public String findGrid(@PathVariable String gridName,ModelMap modelMap){
        List<Cluster> clusters = clusterService.selectByGrid(gridName);
        modelMap.addAttribute(contentPage,"liveCharts.jsp");
        modelMap.addAttribute(liveChartPage,"gridView.jsp");
        modelMap.addAttribute("allClusters",clusters);
        return mainFrag;
    }

    /*
     * 实时监控信息 集群详情
     */
    @RequestMapping(value = "/clusters/{clusterName}")
    public String findCluster(@PathVariable String clusterName,ModelMap modelMap){
        List<Host> hosts = hostService.selectByCluster(clusterName);
        modelMap.addAttribute(contentPage,"liveCharts.jsp");
        modelMap.addAttribute(liveChartPage,"clusterView.jsp");
        modelMap.addAttribute("allHosts",hosts);
        return mainFrag;
    }

    /*
     * 实时监控信息 主机详情
     */
    @RequestMapping(value = "/hosts/{hostName}")
    public String findHost(@PathVariable String hostName,ModelMap modelMap){
        List<Metric> metrics = metricService.selectByHost(hostName);
        modelMap.addAttribute(contentPage,"liveCharts.jsp");
        modelMap.addAttribute(liveChartPage,"hostView.jsp");
        modelMap.addAttribute("allMetrics",metrics);
        return mainFrag;
    }
}
