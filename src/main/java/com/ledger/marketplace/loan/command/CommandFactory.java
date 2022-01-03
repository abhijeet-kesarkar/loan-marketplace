package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

public class CommandFactory {
    private static final String LOAN_COMMAND = "LOAN";
    private static final String PAYMENT_COMMAND = "PAYMENT";

    public CommandFactory(MarketPlace marketPlace) {
    }

    public Command create(String command) {
        if (command.startsWith(LOAN_COMMAND)) {
            return new LoanCommand();
        }
        else if (command.startsWith(PAYMENT_COMMAND)){
            return new PaymentCommand();
        }
        else return new BalanceCommand();
    }
}
