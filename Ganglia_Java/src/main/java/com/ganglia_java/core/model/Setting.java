package com.ganglia_java.core.model;

import com.ganglia_java.core.service.MetricService;
import javax.annotation.Resource;
import java.util.List;

public class Setting {

    @Resource(name = "MetricService")
    private MetricService metricService;

    private List<Metric> metrics;
    private int update_interval;
    private int line_count;
    private String Email;

    public Setting() {}

    public MetricService getMetricService() {
        return metricService;
    }

    public void setMetricService(MetricService metricService) {
        this.metricService = metricService;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

    public int getUpdate_interval() {
        return update_interval;
    }

    public void setUpdate_interval(int update_interval) {
        this.update_interval = update_interval;
    }

    public int getLine_count() {
        return line_count;
    }

    public void setLine_count(int line_count) {
        this.line_count = line_count;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
