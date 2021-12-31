package com.ledger.marketplace.loan;

public class Loan {
    private final String bankName;
    private final String borrowerName;
    private final int principal;
    private final int noOfYears;
    private final double rateOfInterest;

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
        for( int i=0; i<emiNo; i++)
        {
            amountPaid += balanceAmount < emi ? balanceAmount : emi;
            balanceAmount = amount - amountPaid;
        }
        int noOfEMIsRemaining = (int) Math.ceil(balanceAmount / emi);
        return new Balance(amountPaid, noOfEMIsRemaining);
    }
}
