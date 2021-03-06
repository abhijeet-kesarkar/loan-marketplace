package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

import java.util.Optional;
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

    public Optional<Command> create(String command) {
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            String commandName = matcher.group(1).toUpperCase();
            String bankName = matcher.group(2);
            String borrowerName = matcher.group(3);
            String commandParams = matcher.group(4);
            switch (commandName) {
                case LOAN_COMMAND:
                    return Optional.of(new LoanCommand(marketPlace, bankName, borrowerName, commandParams));
                case BALANCE_COMMAND:
                    return Optional.of(new BalanceCommand(marketPlace, bankName, borrowerName, commandParams));
                case PAYMENT_COMMAND:
                    return Optional.of(new PaymentCommand(marketPlace, bankName, borrowerName, commandParams));
            }
        }
        return Optional.empty();
    }
}
