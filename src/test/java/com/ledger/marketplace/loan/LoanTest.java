package com.ledger.marketplace.loan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanTest {
    @Test
    public void testBalanceForDaleAfter5EMIs() {
        Loan loan = new Loan("IDIDI", "Dale", 10000, 5, 4);
        Balance balance = loan.balance(5);
        assertEquals(1000, balance.getAmountPaid());
        assertEquals(55, balance.getNoOfEMIsRemaining());
    }

    @Test
    public void testBalanceForDaleAfter40EMIs() {
        Loan loan = new Loan("IDIDI", "Dale", 10000, 5, 4);
        Balance balance = loan.balance(40);
        assertEquals(8000, balance.getAmountPaid());
        assertEquals(20, balance.getNoOfEMIsRemaining());
    }

    @Test
    public void testBalanceForHarryAfter12EMIs() {
        Loan loan = new Loan("MBI", "Harry", 2000, 2, 2);
        Balance balance = loan.balance(12);
        assertEquals(1044, balance.getAmountPaid());
        assertEquals(12, balance.getNoOfEMIsRemaining());
    }

    @Test
    public void testBalanceForHarryAfter0EMIs() {
        Loan loan = new Loan("MBI", "Harry", 2000, 2, 2);
        Balance balance = loan.balance(0);
        assertEquals(0, balance.getAmountPaid());
        assertEquals(24, balance.getNoOfEMIsRemaining());
    }

    @Test
    public void testBalanceForHarryAfter24EMIs() {
        Loan loan = new Loan("MBI", "Harry", 2000, 2, 2);
        Balance balance = loan.balance(24);
        assertEquals(2080, balance.getAmountPaid());
        assertEquals(0, balance.getNoOfEMIsRemaining());
    }

    @Test
    public void testPaymentForDaleAfter5thEMI() {
        Loan loan = new Loan("IDIDI", "Dale", 5000, 1, 6);
        loan.payment(1000, 5);
        Balance balanceAfter3EMIs = loan.balance(3);
        assertEquals(1326, balanceAfter3EMIs.getAmountPaid());
        assertEquals(9, balanceAfter3EMIs.getNoOfEMIsRemaining());

        Balance balanceAfter6EMIs = loan.balance(6);
        assertEquals(3652, balanceAfter6EMIs.getAmountPaid());
        assertEquals(4, balanceAfter6EMIs.getNoOfEMIsRemaining());
    }

    @Test
    public void testPaymentForHarryAfter10thEMI() {
        Loan loan = new Loan("MBI", "Harry", 10000, 3, 7);
        loan.payment(5000, 10);
        Balance balance = loan.balance(12);
        assertEquals(9044, balance.getAmountPaid());
        assertEquals(10, balance.getNoOfEMIsRemaining());
    }

    @Test
    public void testPaymentForShellyAfter12thEMI() {
        Loan loan = new Loan("UON", "Shelly", 15000, 2, 9);
        loan.payment(7000, 12);
        Balance balance = loan.balance(12);
        assertEquals(15856, balance.getAmountPaid());
        assertEquals(3, balance.getNoOfEMIsRemaining());
    }
}
