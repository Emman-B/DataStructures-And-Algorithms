package com.github.emman_b.problems;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    // For replacing standard out, I used the following link
    // https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out; // used to keep track of standard out
    @BeforeEach
    void replaceStandardOut() {
        System.setOut(new PrintStream(output));
    }
    @AfterEach
    void restoreStandardOut() {
        System.setOut(standardOut);
    }

    @Test
    void FizzBuzz_ShouldHaveCorrectOutput() {
        // For the sake of testing, only the first 15 numbers are being tested
        String expected = "1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\nFizzBuzz";

        // run the test
        new FizzBuzz().printFizzBuzz();

        // get the result from the output PrintStream
        //      - removing any possible carriage returns
        //      - only get the first 15 numbers printed
        String actual = output.toString().replace("\r", "").substring(0, expected.length());

        // check the results
        assertEquals(expected, actual);
    }
}