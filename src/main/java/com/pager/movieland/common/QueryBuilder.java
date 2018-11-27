package com.pager.movieland.common;

import java.util.stream.Collectors;

public class QueryBuilder {
    private static final String SEPARATOR = ", ";

    public static String build(String query) {
        return query;
    }

    public static String build(String query, QueryParams queryParams) {

        if (queryParams.getQueryOrders() == null || queryParams.getQueryOrders().isEmpty()) {
            return query;
        }
        return addOrdering(query, queryParams);
    }

    private static String addOrdering(String query, QueryParams queryParams) {

        String newQuery;
        newQuery = query + " order by " + queryParams.getQueryOrders().stream()
                .map(QueryOrder::getOrderParam)
                .collect(Collectors.joining(SEPARATOR));

        return newQuery;
    }

}
