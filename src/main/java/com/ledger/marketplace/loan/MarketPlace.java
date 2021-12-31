package com.ledger.marketplace.loan;

import java.util.HashMap;

public class MarketPlace {

    private final HashMap<String, Loan> loans = new HashMap<>();

    public String getBalance(String bankName, String borrowerName, int emiNo) {
        return loans.get(getKey(bankName, borrowerName)).balance(emiNo).toString();
    }

    public void createLoan(String bankName, String borrowerName, int principal, int noOfYears, int rateOfInterest) {
        loans.put(getKey(bankName, borrowerName), new Loan(bankName, borrowerName, principal, noOfYears, rateOfInterest));
    }

    private String getKey(String bankName, String borrowerName) {
        return (bankName + borrowerName).toUpperCase();
    }

    public void makePayment(String bankName, String borrowerName, int lumpSumAmount, int emiNo) {
        loans.get(getKey(bankName, borrowerName)).payment(lumpSumAmount, emiNo);
    }
}
