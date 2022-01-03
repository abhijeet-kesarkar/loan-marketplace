package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalanceCommandTest {

    @Test
    void executeBalanceCommandForDale() {
        MarketPlace marketPlace = new MarketPlace();
        marketPlace.createLoan("IDIDI", "Dale", 10000, 5, 4);

        Command command = new BalanceCommand(marketPlace, "IDIDI", "Dale", "5");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        command.execute(new PrintStream(outputStream));

        assertEquals("IDIDI Dale 1000 55\n", outputStream.toString());

    }

    @Test
    void executeBalanceCommandForDale2() {
        MarketPlace marketPlace = new MarketPlace();
        marketPlace.createLoan("IDIDI", "Dale", 10000, 5, 4);

        Command command = new BalanceCommand(marketPlace, "IDIDI", "Dale", "40");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        command.execute(new PrintStream(outputStream));

        assertEquals("IDIDI Dale 8000 20\n", outputStream.toString());

    }
}
