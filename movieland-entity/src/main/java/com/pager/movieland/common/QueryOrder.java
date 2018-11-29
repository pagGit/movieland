package com.pager.movieland.common;

public class QueryOrder {
    private OrderColumnName orderColumnName;
    private OrderType orderType;

    public QueryOrder(OrderColumnName orderColumnName, OrderType orderType) {
        this.orderColumnName = orderColumnName;
        this.orderType = orderType;
    }

    public String getOrderParam(){
        return orderColumnName + " " + orderType;
    }

    public OrderColumnName getOrderColumnName() {
        return orderColumnName;
    }

    public void setOrderColumnName(OrderColumnName orderColumnName) {
        this.orderColumnName = orderColumnName;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QueryOrder otherQueryOrder = (QueryOrder) obj;
        if (getOrderParam().equals(otherQueryOrder.getOrderParam())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "QueryOrder{" +
                "orderColumnName=" + orderColumnName +
                ", orderType=" + orderType +
                '}';
    }
}
