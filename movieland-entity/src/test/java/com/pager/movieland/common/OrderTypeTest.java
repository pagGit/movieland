package com.pager.movieland.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTypeTest {
    @Test
    public void testForName() {
        String correctOrderTypeAsc = "asc";
        String correctOrderTypeDesc = "desc";
        String correctUpperOrderType = "DESC";

        assertEquals(OrderType.ASC, OrderType.forName((correctOrderTypeAsc)));
        assertEquals(OrderType.DESC, OrderType.forName((correctOrderTypeDesc)));
        assertEquals(OrderType.DESC, OrderType.forName((correctUpperOrderType)));
    }

    @Test
    public void testisOrderType() {
        String incorrectOrderType = "another";
        String correctOrderTypeAsc = "asc";
        String correctOrderTypeDesc = "desc";
        String correctUpperOrderTypeDesc = "DESC";

        assertEquals(false, OrderType.isOrderType((incorrectOrderType)));
        assertEquals(true, OrderType.isOrderType((correctOrderTypeAsc)));
        assertEquals(true, OrderType.isOrderType((correctOrderTypeDesc)));
        assertEquals(true, OrderType.isOrderType((correctUpperOrderTypeDesc)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        String incorrectOrderType = "another";
        OrderType.forName(incorrectOrderType);
    }
}
