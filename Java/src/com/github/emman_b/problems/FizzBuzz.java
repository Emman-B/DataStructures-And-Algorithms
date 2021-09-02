package com.github.emman_b.problems;

public class FizzBuzz {
    /* Problem description:
        Write a program that prints numbers from 1 to 100. However, if a number is
        divisible by 3, "Fizz" is printed. If a number is divisible by 5, "Buzz" is
        printed. If a number is divisible by both 3 and 5, "FizzBuzz" is printed.
     */

    public void printFizzBuzz() {
        for (int i = 1; i <= 100; ++i) {
            StringBuilder output = new StringBuilder();

            if (i % 3 == 0) {
                output.append("Fizz");
            }
            if (i % 5 == 0) {
                output.append("Buzz");
            }

            if (output.isEmpty()) {
                output.append(i);
            }

            System.out.println(output.toString());
        }
    }

    // Run this main method to print fizz buzz
    public static void main(String[] args) {
        new FizzBuzz().printFizzBuzz();
    }
}
