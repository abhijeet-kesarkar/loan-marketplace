package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

public class CommandFactory {
    private static final String LOAN_COMMAND = "LOAN";
    private static final String PAYMENT_COMMAND = "PAYMENT";
    private static final String BALANCE_COMMAND = "BALANCE";

    public CommandFactory(MarketPlace marketPlace) {
    }

    public Command create(String command) throws Exception {
        if (command.toUpperCase().startsWith(LOAN_COMMAND)) {
            return new LoanCommand();
        }
        else if (command.toUpperCase().startsWith(PAYMENT_COMMAND)){
            return new PaymentCommand();
        }
        else if (command.toUpperCase().startsWith(BALANCE_COMMAND)) {
            return new BalanceCommand();
        }
        else throw new Exception("Invalid command");
    }
}
