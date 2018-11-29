package com.pager.movieland.common;

import java.util.ArrayList;

public class QueryParams {
    private ArrayList<QueryOrder> queryOrders;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QueryParams otherQueryParams = (QueryParams) obj;
        if (getQueryOrders().equals(otherQueryParams.getQueryOrders())) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<QueryOrder> getQueryOrders() {
        return queryOrders;
    }

    public void setQueryOrders(ArrayList<QueryOrder> queryOrders) {
        this.queryOrders = queryOrders;
    }

    @Override
    public String toString() {
        return "QueryParams{" +
                "queryOrders=" + queryOrders +
                '}';
    }
}
