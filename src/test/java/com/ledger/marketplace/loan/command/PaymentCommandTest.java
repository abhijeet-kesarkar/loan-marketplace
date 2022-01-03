package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentCommandTest {

    @Test
    public void execute() {
        MarketPlace marketPlace = new MarketPlace();
        marketPlace.createLoan("UON", "Shelly", 15000, 2, 9);

        Command loanCommand = new PaymentCommand(marketPlace, "UON", "Shelly", "7000 12");
        loanCommand.execute();

        assertEquals("UON Shelly 15856 3", marketPlace.getBalance("UON", "Shelly", 12));
    }
}
