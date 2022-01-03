package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintStream;

public class CommandReader {

    public static void read(String fileName, PrintStream out) throws Exception {
        LineNumberReader reader = new LineNumberReader(new FileReader(fileName));
        MarketPlace marketPlace = new MarketPlace();
        CommandFactory commandFactory = new CommandFactory(marketPlace);

        String line;
        while ((line = reader.readLine()) != null) {
            commandFactory.create(line).execute(out);
        }
    }
}
