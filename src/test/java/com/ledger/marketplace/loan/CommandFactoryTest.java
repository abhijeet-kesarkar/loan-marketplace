package com.ledger.marketplace.loan;

import com.ledger.marketplace.loan.command.Command;
import com.ledger.marketplace.loan.command.CommandFactory;
import com.ledger.marketplace.loan.command.LoanCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandFactoryTest {

    @Test
    public void testCreateLoanCommand() {

        MarketPlace marketPlace = new MarketPlace();
        CommandFactory commandFactory = new CommandFactory(marketPlace);
        Command command = commandFactory.create("LOAN bank borrower 100 1 1");
        assertEquals(command.getClass(), LoanCommand.class);
    }
}
