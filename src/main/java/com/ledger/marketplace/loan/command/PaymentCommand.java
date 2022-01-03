package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

public class PaymentCommand extends Command {


    public PaymentCommand(MarketPlace marketPlace, String bankName, String borrowerName, String commandParams) {
        super(marketPlace, bankName, borrowerName, commandParams);
    }

    @Override
    protected void parseParams(String commandParams) {

    }

    @Override
    public void execute() {

    }
}
