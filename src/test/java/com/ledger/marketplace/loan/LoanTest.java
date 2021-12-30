package com.ledger.marketplace.loan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanTest {
    @Test
    public void testBalance(){
        Loan loan = new Loan("IDIDI", "Dale", 10000, 5, 4);
        Balance balance = loan.balance(5);
        assertEquals(1000, balance.getAmountPaid());
        assertEquals(55, balance.getRemainingEMIs());
    }
}
