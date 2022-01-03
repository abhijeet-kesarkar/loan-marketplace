package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

public class PaymentCommand extends Command {
    public PaymentCommand(MarketPlace marketPlace, String command) {
        super(marketPlace, command);
    }

    @Override
    public void execute() {

    }
}
