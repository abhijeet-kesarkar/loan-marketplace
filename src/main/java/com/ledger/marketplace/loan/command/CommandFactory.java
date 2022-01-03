package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

public class CommandFactory {
    private static final String LOAN_COMMAND = "LOAN";
    private static final String PAYMENT_COMMAND = "PAYMENT";
    private static final String BALANCE_COMMAND = "BALANCE";
    private final MarketPlace marketPlace;

    public CommandFactory(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    public Command create(String command) throws Exception {
        if (command.toUpperCase().startsWith(LOAN_COMMAND)) {
            return new LoanCommand(marketPlace, command);
        }
        else if (command.toUpperCase().startsWith(PAYMENT_COMMAND)){
            return new PaymentCommand(marketPlace, command);
        }
        else if (command.toUpperCase().startsWith(BALANCE_COMMAND)) {
            return new BalanceCommand(marketPlace, command);
        }
        else throw new Exception("Invalid command");
    }
}
