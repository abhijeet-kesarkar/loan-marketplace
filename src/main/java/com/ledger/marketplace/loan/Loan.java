package com.ledger.marketplace.loan;

import java.util.HashMap;

public class Loan {
    private final String bankName;
    private final String borrowerName;
    private final HashMap<Integer, Integer> payments = new HashMap<>();
    private final double amount;
    private final int emi;

    public Loan(String bankName, String borrowerName, int principal, int noOfYears, double rateOfInterest) {

        this.bankName = bankName;
        this.borrowerName = borrowerName;
        double interest = principal * noOfYears * rateOfInterest / 100;
        amount = principal + interest;
        emi = (int) Math.ceil(amount / (noOfYears * 12));
    }

    public Balance balance(int emiNo) {

        int amountPaid = paymentDoneAtEMI(0);
        for (int i = 1; i <= emiNo; i++) {
            amountPaid += emiAmount(amount - amountPaid);
            amountPaid += paymentDoneAtEMI(i);
        }
        int noOfEMIsRemaining = (int) Math.ceil((amount - amountPaid) / emi);
        return new Balance(bankName, borrowerName, amountPaid, noOfEMIsRemaining);
    }

    private double emiAmount(double balanceAmount) {
        return balanceAmount < emi ? balanceAmount : emi;
    }

    private Integer paymentDoneAtEMI(int i) {
        return payments.getOrDefault(i, 0);
    }

    public void payment(int lumpSumAmount, int emiNo) {
        payments.put(emiNo, lumpSumAmount);
    }
}
