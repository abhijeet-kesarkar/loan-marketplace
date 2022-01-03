package com.ledger.marketplace.loan;

import com.ledger.marketplace.loan.command.CommandReader;

public class Main {

    public static void main(String[] args) throws Exception {
        String filePath = args[0];
        CommandReader.read(filePath, System.out);
    }
}
