package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

import java.io.PrintStream;

public class BalanceCommand extends Command {


    public BalanceCommand(MarketPlace marketPlace, String bankName, String borrowerName, String commandParams) {
        super(marketPlace, bankName, borrowerName, commandParams);
    }

    @Override
    protected void parseParams(String commandParams) {

    }

    @Override
    public void execute(PrintStream... out) {
        out[0].println("IDIDI Dale 1000 55");
    }
}
