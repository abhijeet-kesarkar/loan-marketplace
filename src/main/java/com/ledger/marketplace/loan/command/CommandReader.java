package com.ledger.marketplace.loan.command;

import com.ledger.marketplace.loan.MarketPlace;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class CommandReader {

    public static void read(String fileName, PrintStream out) throws Exception {

        MarketPlace marketPlace = new MarketPlace();
        CommandFactory commandFactory = new CommandFactory(marketPlace);
        Files.lines(Paths.get(fileName))
                .map(commandFactory::create)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(c->c.execute(out));
    }
}
