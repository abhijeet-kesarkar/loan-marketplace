package com.ledger.marketplace.loan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanTest {
    @Test
    public void testBalanceForBorrowerDale(){
        Loan loan = new Loan("IDIDI", "Dale", 10000, 5, 4);
        Balance balance = loan.balance(5);
        assertEquals(1000, balance.getAmountPaid());
        assertEquals(55, balance.getNoOfEMIsRemaining());
    }

    @Test
    public void testBalanceForBorrowerHarry(){
        Loan loan = new Loan("MBI", "Harry", 2000, 2, 2);
        Balance balance = loan.balance(12);
        assertEquals(1044, balance.getAmountPaid());
        assertEquals(12, balance.getNoOfEMIsRemaining());
    }
}
