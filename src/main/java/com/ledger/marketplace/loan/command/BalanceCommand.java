package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

import java.io.PrintStream;

public class BalanceCommand extends Command {


    private int emiNo;

    public BalanceCommand(MarketPlace marketPlace, String bankName, String borrowerName, String commandParams) {
        super(marketPlace, bankName, borrowerName, commandParams);
    }

    @Override
    protected void parseParams(String commandParams) {
        String[] params = commandParams.split("\\s");
        this.emiNo = Integer.parseInt(params[0]);
    }

    @Override
    public void execute(PrintStream... out) {
        out[0].println(marketPlace.getBalance(bankName, borrowerName, emiNo));
    }
}
