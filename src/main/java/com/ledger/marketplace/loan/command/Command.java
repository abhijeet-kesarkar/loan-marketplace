package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

public abstract class Command {
    protected MarketPlace marketPlace;


    public Command(MarketPlace marketPlace, String command) {
        this.marketPlace = marketPlace;
    }

    public abstract void execute();
}
