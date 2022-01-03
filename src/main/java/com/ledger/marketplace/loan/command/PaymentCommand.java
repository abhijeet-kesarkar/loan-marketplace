package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

public class PaymentCommand extends Command {

    private int lumpSumAmount;
    private int emiNo;

    public PaymentCommand(MarketPlace marketPlace, String bankName, String borrowerName, String commandParams) {
        super(marketPlace, bankName, borrowerName, commandParams);
    }

    @Override
    protected void parseParams(String commandParams) {
        String[] params = commandParams.split("\\s");
        lumpSumAmount = Integer.parseInt(params[0]);
        emiNo = Integer.parseInt(params[1]);
    }

    @Override
    public void execute() {
        this.marketPlace.makePayment(bankName, borrowerName, lumpSumAmount, emiNo);
    }
}
