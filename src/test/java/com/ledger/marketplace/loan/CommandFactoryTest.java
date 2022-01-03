package com.ledger.marketplace.loan;

import com.ledger.marketplace.loan.command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandFactoryTest {
    MarketPlace marketPlace;
    CommandFactory commandFactory;

    @BeforeEach
    public void setup() {
        marketPlace = new MarketPlace();
        commandFactory = new CommandFactory(marketPlace);
    }

    @Test
    public void testCreateLoanCommand() throws Exception {
        Command command = commandFactory.create("LOAN bank borrower 100 1 1").get();
        assertEquals(LoanCommand.class, command.getClass());
    }

    @Test
    public void testCreatePaymentCommand() throws Exception {
        Command command = commandFactory.create("PAYMENT bank borrower 100 1").get();
        assertEquals(PaymentCommand.class, command.getClass());
    }

    @Test
    public void testCreateBalanceCommand() throws Exception {
        Command command = commandFactory.create("BALANCE bank borrower 100 1").get();
        assertEquals(BalanceCommand.class, command.getClass());
    }

    @Test
    public void testCaseInsensitiveCreateLoanCommand() throws Exception {
        Command command = commandFactory.create("loAn bank borrower 100 1 1").get();
        assertEquals(LoanCommand.class, command.getClass());
    }

    @Test
    public void testCaseInsensitiveCreatePaymentCommand() throws Exception {
        Command command = commandFactory.create("payment bank borrower 100 1").get();
        assertEquals(PaymentCommand.class, command.getClass());
    }

    @Test
    public void testCaseInsensitiveCreateBalanceCommand() throws Exception {
        Command command = commandFactory.create("Balance bank borrower 100 1").get();
        assertEquals(BalanceCommand.class, command.getClass());
    }

    @Test
    public void testInvalidCommand() {
        assertFalse(commandFactory.create("some bank borrower 100 1").isPresent());
    }
}
