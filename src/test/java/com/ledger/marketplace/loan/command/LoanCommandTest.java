package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoanCommandTest {

    @Test
    public void testExecuteLoanCommand(){
        String command = "LOAN bank borrower 100 1 1";
        MarketPlace marketPlace = new MarketPlace();
        Command loanCommand = new LoanCommand(marketPlace, command);
        loanCommand.execute();

        assertEquals("bank borrower 0 12", marketPlace.getBalance("bank","borrower",0));
    }
}
