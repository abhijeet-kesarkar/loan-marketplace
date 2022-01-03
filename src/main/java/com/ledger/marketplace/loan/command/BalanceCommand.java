package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

public class BalanceCommand extends Command {


    public BalanceCommand(MarketPlace marketPlace, String bankName, String borrowerName, String commandParams) {
        super(marketPlace, bankName, borrowerName, commandParams);
    }

    @Override
    protected void parseParams(String commandParams) {

    }

    @Override
    public void execute() {

    }
}
