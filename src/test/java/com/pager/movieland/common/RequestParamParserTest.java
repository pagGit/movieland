package com.pager.movieland.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RequestParamParserTest {
    @Test
    public void containOrderParam() {
        Map<String, String> requestParams = new LinkedHashMap<>();
        requestParams.put("price", "asc");
        Map<String, String> requestParamsWithoutOrderParam = new LinkedHashMap<>();
        requestParams.put("another", "asc");

        assertEquals(true, RequestParamParser.containOrderParam(requestParams));
        assertEquals(false, RequestParamParser.containOrderParam(requestParamsWithoutOrderParam));

    }

    @Test
    public void testGetQueryParams() {
        LinkedHashMap<String, String> requestParamsPriceRating = new LinkedHashMap<>();
        requestParamsPriceRating.put("price", "asc");
        requestParamsPriceRating.put("RATING", "DESC");

        LinkedHashMap<String, String> requestParamsRatingPrice = new LinkedHashMap<>();
        requestParamsRatingPrice.put("RATING", "DESC");
        requestParamsRatingPrice.put("price", "asc");

        QueryOrder queryOrderPrice = new QueryOrder(OrderColumnName.PRICE, OrderType.ASC);
        QueryOrder queryOrderRating = new QueryOrder(OrderColumnName.RATING, OrderType.DESC);

        ArrayList<QueryOrder> queryOrdersPriceRating = new ArrayList<>();
        queryOrdersPriceRating.add(queryOrderPrice);
        queryOrdersPriceRating.add(queryOrderRating);

        QueryParams queryParamsPriceRating = new QueryParams();
        queryParamsPriceRating.setQueryOrders(queryOrdersPriceRating);

        ArrayList<QueryOrder> queryOrdersRatingPrice = new ArrayList<>();
        queryOrdersRatingPrice.add(queryOrderRating);
        queryOrdersRatingPrice.add(queryOrderPrice);
        QueryParams queryParamsRatingPrice = new QueryParams();
        queryParamsRatingPrice.setQueryOrders(queryOrdersRatingPrice);

        assertEquals(queryParamsPriceRating, RequestParamParser.getQueryParams(requestParamsPriceRating));
        assertEquals(queryParamsRatingPrice, RequestParamParser.getQueryParams(requestParamsRatingPrice));
    }
}
