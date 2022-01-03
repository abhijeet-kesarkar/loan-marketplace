package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandFactory {
    private static final String LOAN_COMMAND = "LOAN";
    private static final String PAYMENT_COMMAND = "PAYMENT";
    private static final String BALANCE_COMMAND = "BALANCE";
    private final MarketPlace marketPlace;
    private final Pattern pattern = Pattern.compile("(LOAN|PAYMENT|BALANCE)\\s([a-z]+)\\s([a-z]+)\\s([0-9\\s]+)", Pattern.CASE_INSENSITIVE);

    public CommandFactory(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    public Command create(String command) throws Exception {
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            String commandName = matcher.group(1).toUpperCase();
            String bankName = matcher.group(2);
            String borrowerName = matcher.group(3);
            String commandParams = matcher.group(4);
            switch (commandName) {
                case LOAN_COMMAND:
                    return new LoanCommand(marketPlace, bankName, borrowerName, commandParams);
                case BALANCE_COMMAND:
                    return new BalanceCommand(marketPlace, bankName, borrowerName, commandParams);
                case PAYMENT_COMMAND:
                    return new PaymentCommand(marketPlace, bankName, borrowerName, commandParams);
            }
        }
        throw new Exception("Invalid command");
    }
}
