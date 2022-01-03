package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

import java.io.PrintStream;

public class LoanCommand extends Command {

    private int principal;
    private int noOfYears;
    private double rateOfInterest;

    public LoanCommand(MarketPlace marketPlace, String bankName, String borrowerName, String commandParams) {
        super(marketPlace, bankName, borrowerName, commandParams);
    }

    @Override
    protected void parseParams(String commandParams) {
        String[] params = commandParams.split("\\s");
        principal = Integer.parseInt(params[0]);
        noOfYears = Integer.parseInt(params[1]);
        rateOfInterest = Integer.parseInt(params[2]);
    }

    @Override
    public void execute(PrintStream... out) {
        this.marketPlace.createLoan(bankName, borrowerName, principal, noOfYears, rateOfInterest);
    }
}
