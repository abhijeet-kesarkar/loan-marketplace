package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

import java.io.PrintStream;

public abstract class Command {
    protected MarketPlace marketPlace;
    protected String bankName;
    protected String borrowerName;

    public Command(MarketPlace marketPlace, String bankName, String borrowerName, String commandParams) {

        this.marketPlace = marketPlace;
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.parseParams(commandParams);
    }

    protected abstract void parseParams(String commandParams);

    protected abstract void execute(PrintStream... out);
}
