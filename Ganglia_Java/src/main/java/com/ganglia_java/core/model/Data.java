package com.ganglia_java.core.model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Data {
	
    private String metricName;
    private String hostName;
    private String val;

    @Temporal(TemporalType.TIMESTAMP)
    private Date reportedTime;

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getReportedTime() {
        return reportedTime;
    }

    public void setReportedTime(Date reportedTime) {
        this.reportedTime = reportedTime;
    }
}
