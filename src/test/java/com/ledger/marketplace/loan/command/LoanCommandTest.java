package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanCommandTest {

    @Test
    public void testExecuteLoanCommand() {
        String command = "LOAN bank borrower 100 1 1";
        MarketPlace marketPlace = new MarketPlace();
        Command loanCommand = new LoanCommand(marketPlace, "bank", "borrower", "100 1 1");
        loanCommand.execute();

        assertEquals("bank borrower 0 12", marketPlace.getBalance("bank", "borrower", 0));
    }

    @Test
    public void testExecuteLoanCommandForBank2() {
        String command = "LOAN bank2 borrower2 200 2 2";
        MarketPlace marketPlace = new MarketPlace();
        Command loanCommand = new LoanCommand(marketPlace, "bank2", "borrower2", "200 2 2");
        loanCommand.execute();

        assertEquals("bank2 borrower2 0 24", marketPlace.getBalance("bank2", "borrower2", 0));
    }
}
