package org.kata.fizzbuzz;

public class FizzBuzz {

    private static final String NULL_NUMBER_MESSAGE = "Number must not be null";
    private static final int FIZZ_DIVISOR = 3;
    private static final int BUZZ_DIVISOR = 5;

    public String calculateResponse(Integer number) {
        validateNotNull(number);
        if (isFizzBuzz(number)) {
            return "FizzBuzz";
        }
        if (isFizz(number)) {
            return "Fizz";
        }
        if (isBuzz(number)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    private void validateNotNull(Integer number) {
        if (number == null) {
            throw new IllegalArgumentException(NULL_NUMBER_MESSAGE);
        }
    }

    private boolean isFizzBuzz(int number) {
        return isFizz(number) && isBuzz(number);
    }

    private boolean isFizz(int number) {
        return isMultipleOf(number, FIZZ_DIVISOR);
    }

    private boolean isBuzz(int number) {
        return isMultipleOf(number, BUZZ_DIVISOR);
    }

    private boolean isMultipleOf(int number, int divisor) {
        return number % divisor == 0;
    }
}
