package com.ledger.marketplace.loan;

import com.ledger.marketplace.loan.command.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandFactoryTest {

    @Test
    public void testCreateLoanCommand() throws Exception {

        MarketPlace marketPlace = new MarketPlace();
        CommandFactory commandFactory = new CommandFactory(marketPlace);
        Command command = commandFactory.create("LOAN bank borrower 100 1 1");
        assertEquals(LoanCommand.class, command.getClass());
    }

    @Test
    public void testCreatePaymentCommand() throws Exception {

        MarketPlace marketPlace = new MarketPlace();
        CommandFactory commandFactory = new CommandFactory(marketPlace);
        Command command = commandFactory.create("PAYMENT bank borrower 100 1");
        assertEquals(PaymentCommand.class, command.getClass());
    }

    @Test
    public void testCreateBalanceCommand() throws Exception {

        MarketPlace marketPlace = new MarketPlace();
        CommandFactory commandFactory = new CommandFactory(marketPlace);
        Command command = commandFactory.create("BALANCE bank borrower 100 1");
        assertEquals(BalanceCommand.class, command.getClass());
    }

    @Test
    public void testInvalidCommand() {

        MarketPlace marketPlace = new MarketPlace();
        CommandFactory commandFactory = new CommandFactory(marketPlace);
        assertThrows(Exception.class, () -> commandFactory.create("some bank borrower 100 1"));
    }
}
