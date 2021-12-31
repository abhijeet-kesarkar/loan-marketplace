package com.ledger.marketplace.loan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarketPlaceTest {

    @Test
    public void testCreateLoanForDale() {
        MarketPlace marketPlace = new MarketPlace();
        marketPlace.createLoan("IDIDI", "Dale", 10000, 5, 4);

        String balance = marketPlace.getBalance("IDIDI", "Dale", 5);

        assertEquals("IDIDI Dale 1000 55", balance);
    }

    @Test
    public void testCreateLoanForHarry() {
        MarketPlace marketPlace = new MarketPlace();
        marketPlace.createLoan("MBI", "Harry", 2000, 2, 2);

        String balance = marketPlace.getBalance("MBI", "Harry", 12);

        assertEquals("MBI Harry 1044 12", balance);
    }

    @Test
    public void testCreateLoanForHarryCaseInsensitive() {
        MarketPlace marketPlace = new MarketPlace();
        marketPlace.createLoan("MBI", "Harry", 2000, 2, 2);

        String balance = marketPlace.getBalance("mbi", "harry", 12);

        assertEquals("MBI Harry 1044 12", balance);
    }

    @Test
    public void testPaymentForShellyAfter12thEMI() {
        MarketPlace marketPlace = new MarketPlace();
        marketPlace.createLoan("UON", "Shelly", 15000, 2, 9);
        marketPlace.makePayment("UON", "Shelly", 7000, 12);
        String balance = marketPlace.getBalance("UON", "Shelly", 12);
        assertEquals("UON Shelly 15856 3", balance);

    }
}
