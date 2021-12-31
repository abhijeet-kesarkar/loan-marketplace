package com.ledger.marketplace.loan;

public class Balance {
    private final String bankName;
    private final String borrowerName;
    private final int amountPaid;
    private final int noOfEMIsRemaining;

    public Balance(String bankName, String borrowerName, int amountPaid, int noOfEMIsRemaining) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.amountPaid = amountPaid;
        this.noOfEMIsRemaining = noOfEMIsRemaining;
    }

    public int getNoOfEMIsRemaining() {
        return noOfEMIsRemaining;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    @Override
    public String toString() {
        return bankName + " " + borrowerName + " " + amountPaid +
                " " + noOfEMIsRemaining;
    }
}
