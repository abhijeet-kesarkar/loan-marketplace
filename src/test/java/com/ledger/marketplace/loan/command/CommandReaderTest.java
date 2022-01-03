package com.ledger.marketplace.loan.command;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CommandReaderTest {

    @Test
    public void testRead() throws Exception {
        CommandReader commandReader = new CommandReader();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String fileName = "./src/test/resources/test-file1.txt";
        commandReader.read(fileName, new PrintStream(output));

        String expectedOutput = "IDIDI Dale 1326 9\n" +
                "IDIDI Dale 3652 4\n" +
                "UON Shelly 15856 3\n" +
                "MBI Harry 9044 10\n";
        assertEquals(expectedOutput, output.toString());
    }
}
