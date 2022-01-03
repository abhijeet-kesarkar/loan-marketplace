package com.ledger.marketplace.loan;

import java.util.HashMap;

public class Loan {
    private final String bankName;
    private final String borrowerName;
    private final int principal;
    private final int noOfYears;
    private final double rateOfInterest;
    private final HashMap<Integer, Integer> payments = new HashMap<>();

    public Loan(String bankName, String borrowerName, int principal, int noOfYears, double rateOfInterest) {

        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.noOfYears = noOfYears;
        this.rateOfInterest = rateOfInterest;
    }

    public Balance balance(int emiNo) {
        double interest = principal * noOfYears * rateOfInterest / 100;
        double amount = principal + interest;
        int emi = (int) Math.ceil(amount / (noOfYears * 12));

        int amountPaid = 0;
        double balanceAmount = amount;
        for (int i = 1; i <= emiNo; i++) {
            amountPaid += balanceAmount < emi ? balanceAmount : emi;
            amountPaid += payments.getOrDefault(i, 0);
            balanceAmount = amount - amountPaid;
        }
        int noOfEMIsRemaining = (int) Math.ceil(balanceAmount / emi);
        return new Balance(bankName, borrowerName, amountPaid, noOfEMIsRemaining);
    }

    public void payment(int lumpSumAmount, int emiNo) {
        payments.put(emiNo, lumpSumAmount);
    }
}
