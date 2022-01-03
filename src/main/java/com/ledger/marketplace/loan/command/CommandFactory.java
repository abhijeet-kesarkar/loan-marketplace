package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

public class CommandFactory {
    public CommandFactory(MarketPlace marketPlace) {
    }

    public Command create(String command) {
        return new LoanCommand();
    }
}
