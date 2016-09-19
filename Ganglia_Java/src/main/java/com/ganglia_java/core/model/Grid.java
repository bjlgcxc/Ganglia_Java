package com.ganglia_java.core.model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Grid {
    private String gridName;
    private String authority;

    public Grid(){}

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
