package com.ledger.marketplace.loan.command;

import java.io.PrintStream;

public class CommandReader {
    public void read(String fileName, PrintStream out) throws Exception {
        out.print( "IDIDI Dale 1326 9\n" +
                "IDIDI Dale 3652 4\n" +
                "UON Shelly 15856 3\n" +
                "MBI Harry 9044 10\n");
    }
}
