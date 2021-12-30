package com.ledger.marketplace.loan;

public class Balance {
    private int amountPaid;
    private int noOfEMIsRemaining;

    public Balance(int amountPaid, int noOfEMIsRemaining) {
        this.amountPaid = amountPaid;
        this.noOfEMIsRemaining = noOfEMIsRemaining;
    }

    public int getNoOfEMIsRemaining() {
        return noOfEMIsRemaining;
    }

    public int getAmountPaid() {
        return amountPaid;
    }
}
