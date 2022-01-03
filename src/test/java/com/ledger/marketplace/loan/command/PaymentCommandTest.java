package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentCommandTest {

    @Test
    public void executePaymentForShelly() {
        MarketPlace marketPlace = new MarketPlace();
        marketPlace.createLoan("UON", "Shelly", 15000, 2, 9);

        Command loanCommand = new PaymentCommand(marketPlace, "UON", "Shelly", "7000 12");
        loanCommand.execute();

        assertEquals("UON Shelly 15856 3", marketPlace.getBalance("UON", "Shelly", 12));
    }

    @Test
    public void executePaymentForHarry() {
        MarketPlace marketPlace = new MarketPlace();
        marketPlace.createLoan("MBI", "Harry", 10000, 3, 7);

        Command loanCommand = new PaymentCommand(marketPlace, "MBI", "Harry", "5000 10");
        loanCommand.execute();

        assertEquals("MBI Harry 9044 10", marketPlace.getBalance("MBI", "Harry", 12));
    }
}
