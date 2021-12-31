package com.ledger.marketplace.loan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarketPlaceTest {

    @Test
    public void testCreateLoan(){
        MarketPlace marketPlace = new MarketPlace();
        marketPlace.createLoan("IDIDI", "Dale", 10000, 5, 4);

        String balance = marketPlace.getBalance("IDIDI", "Dale", 5);

        assertEquals("IDIDI Dale 1000 55", balance);
    }
}
