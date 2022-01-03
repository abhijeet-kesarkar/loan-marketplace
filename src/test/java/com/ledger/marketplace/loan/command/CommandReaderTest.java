package com.ledger.marketplace.loan.command;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CommandReaderTest {

    @Test
    public void testReadFromFile1() throws Exception {
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

    @Test
    public void testReadFromFile2() throws Exception {
        CommandReader commandReader = new CommandReader();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String fileName = "./src/test/resources/test-file2.txt";
        commandReader.read(fileName, new PrintStream(output));

        String expectedOutput = "IDIDI Dale 1000 55\n" +
                "IDIDI Dale 8000 20\n" +
                "MBI Harry 1044 12\n" +
                "MBI Harry 0 24\n";
        assertEquals(expectedOutput, output.toString());
    }
}
