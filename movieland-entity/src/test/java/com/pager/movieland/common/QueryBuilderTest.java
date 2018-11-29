package com.pager.movieland.common;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class QueryBuilderTest {
    @Test
    public void testBuild(){
        assertEquals("sql", QueryBuilder.build("sql"));
    }

    @Test
    public void testBuildWithParam(){
        QueryParams queryParams = new QueryParams();
        QueryOrder queryOrderPrice = new QueryOrder(OrderColumnName.forName("price"),OrderType.forName("asc"));
        QueryOrder queryOrderRating = new QueryOrder(OrderColumnName.forName("rating"),OrderType.forName("desc"));
        ArrayList<QueryOrder> queryOrders = new ArrayList<>();
        queryOrders.add(queryOrderPrice);
        queryOrders.add(queryOrderRating);
        queryParams.setQueryOrders(queryOrders);
        assertEquals("sql order by PRICE ASC, RATING DESC", QueryBuilder.build("sql", queryParams));
    }
}
