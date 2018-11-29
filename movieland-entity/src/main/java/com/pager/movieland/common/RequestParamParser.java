package com.pager.movieland.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestParamParser {

    public static boolean containOrderParam(Map<String, String> requestParams) {
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            if (OrderColumnName.isOrderColumnName(entry.getKey()) && OrderType.isOrderType(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public static QueryParams getQueryParams(LinkedHashMap<String, String> requestParams) {
        QueryParams queryParams = new QueryParams();
        ArrayList<QueryOrder> queryOrders = new ArrayList<>();

        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (OrderColumnName.isOrderColumnName(key) && OrderType.isOrderType(value)) {
                QueryOrder queryOrder = new QueryOrder(OrderColumnName.forName(key), OrderType.forName(value));
                queryOrders.add(queryOrder);
            }
        }

        queryParams.setQueryOrders(queryOrders);

        return queryParams;

    }
}
