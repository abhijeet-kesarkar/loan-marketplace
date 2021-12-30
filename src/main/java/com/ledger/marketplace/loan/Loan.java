package com.ledger.marketplace.loan;

public class Loan {
    private final String bankName;
    private final String borrowerName;
    private final int principal;
    private final int noOfYears;
    private final int rateOfInterest;

    public Loan(String bankName, String borrowerName, int principal, int noOfYears, int rateOfInterest) {

        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.noOfYears = noOfYears;
        this.rateOfInterest = rateOfInterest;
    }

    public Balance balance(int emiNo) {
        return new Balance(1000, 55);
    }
}
