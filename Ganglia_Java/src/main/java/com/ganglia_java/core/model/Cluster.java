package com.ganglia_java.core.model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Cluster {
    private String clusterName;
    private String owner;
    private String latlong;
    private String url;
    private String gridName;

    public Cluster() {}

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLatlong() {
        return latlong;
    }

    public void setLatlong(String latlong) {
        this.latlong = latlong;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }
}
