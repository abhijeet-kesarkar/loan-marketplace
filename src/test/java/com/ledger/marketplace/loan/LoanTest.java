package com.ledger.marketplace.loan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanTest {
    @Test
    public void testBalanceForDaleAfter5EMIs(){
        Loan loan = new Loan("IDIDI", "Dale", 10000, 5, 4);
        Balance balance = loan.balance(5);
        assertEquals(1000, balance.getAmountPaid());
        assertEquals(55, balance.getNoOfEMIsRemaining());
    }

    @Test
    public void testBalanceForDaleAfter40EMIs(){
        Loan loan = new Loan("IDIDI", "Dale", 10000, 5, 4);
        Balance balance = loan.balance(40);
        assertEquals(8000, balance.getAmountPaid());
        assertEquals(20, balance.getNoOfEMIsRemaining());
    }

    @Test
    public void testBalanceForHarryAfter12EMIs(){
        Loan loan = new Loan("MBI", "Harry", 2000, 2, 2);
        Balance balance = loan.balance(12);
        assertEquals(1044, balance.getAmountPaid());
        assertEquals(12, balance.getNoOfEMIsRemaining());
    }

    @Test
    public void testBalanceForHarryAfter0EMIs(){
        Loan loan = new Loan("MBI", "Harry", 2000, 2, 2);
        Balance balance = loan.balance(0);
        assertEquals(0, balance.getAmountPaid());
        assertEquals(24, balance.getNoOfEMIsRemaining());
    }

    @Test
    public void testBalanceForHarryAfter24EMIs(){
        Loan loan = new Loan("MBI", "Harry", 2000, 2, 2);
        Balance balance = loan.balance(24);
        assertEquals(2080, balance.getAmountPaid());
        assertEquals(0, balance.getNoOfEMIsRemaining());
    }
}
