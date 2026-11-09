package org.kata.fizzbuzz;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

public class FizzBuzzConsole {

    private static final String NUMBER_PROMPT = "Introduce un número: ";
    private static final String INVALID_NUMBER_MESSAGE = "Eso no es un número válido";

    private final Scanner input;
    private final PrintStream output;
    private final FizzBuzz fizzBuzz;

    public FizzBuzzConsole(Scanner input, PrintStream output, FizzBuzz fizzBuzz) {
        this.input = input;
        this.output = output;
        this.fizzBuzz = fizzBuzz;
    }

    public static void main(String[] args) {
        new FizzBuzzConsole(new Scanner(System.in), System.out, new FizzBuzz()).run();
    }

    public void run() {
        parseNumber(askForNumber())
                .map(fizzBuzz::calculateResponse)
                .ifPresentOrElse(output::println, this::printInvalidNumber);
    }

    private String askForNumber() {
        output.print(NUMBER_PROMPT);
        return input.nextLine();
    }

    private Optional<Integer> parseNumber(String text) {
        try {
            return Optional.of(Integer.valueOf(text.trim()));
        } catch (NumberFormatException exception) {
            return Optional.empty();
        }
    }

    private void printInvalidNumber() {
        output.println(INVALID_NUMBER_MESSAGE);
    }
}
