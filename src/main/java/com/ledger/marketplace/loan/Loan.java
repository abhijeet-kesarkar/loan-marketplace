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
        int interest = principal * noOfYears * rateOfInterest / 100;
        double amount = principal + interest;
        int emi = (int) Math.ceil(amount / (noOfYears * 12));
        int amountPaid = emiNo * emi;
        int noOfEMIsRemaining = (int) Math.ceil((amount - amountPaid) / emi);
        return new Balance(amountPaid, noOfEMIsRemaining);
    }
}
