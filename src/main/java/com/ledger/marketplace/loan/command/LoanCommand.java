package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

public class LoanCommand extends Command {
    public LoanCommand(MarketPlace marketPlace, String command) {
        super(marketPlace, command);
    }

    public void execute() {
        this.marketPlace.createLoan("bank", "borrower", 100, 1, 1);
    }
}
