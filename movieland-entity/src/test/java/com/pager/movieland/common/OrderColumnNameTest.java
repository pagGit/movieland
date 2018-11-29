package com.pager.movieland.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderColumnNameTest {

    @Test
    public void testForName() {
        String correctOrderColumnName = "price";
        String correctUpperOrderColumnName = "RATING";

        assertEquals(OrderColumnName.PRICE, OrderColumnName.forName((correctOrderColumnName)));
        assertEquals(OrderColumnName.RATING, OrderColumnName.forName((correctUpperOrderColumnName)));
    }

    @Test
    public void testisOrderColumnName() {
        String incorrectOrderColumnName = "another";
        String correctOrderColumnName = "price";
        String correctUpperOrderColumnName = "RATING";

        assertEquals(false, OrderColumnName.isOrderColumnName((incorrectOrderColumnName)));
        assertEquals(true, OrderColumnName.isOrderColumnName((correctOrderColumnName)));
        assertEquals(true, OrderColumnName.isOrderColumnName((correctUpperOrderColumnName)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        String incorrectOrderColumnName = "another";
        OrderColumnName.forName(incorrectOrderColumnName);
    }

}
