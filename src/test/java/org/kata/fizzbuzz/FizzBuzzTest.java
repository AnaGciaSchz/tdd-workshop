package org.kata.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FizzBuzzTest {

    private final FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void testNumberOne_ShouldReturnOne() {
        assertEquals("1", fizzBuzz.calculateResponse(1));
    }

    @Test
    void testNumberTwo_ShouldReturnTwo() {
        assertEquals("2", fizzBuzz.calculateResponse(2));
    }

    @Test
    void testNumberThree_ShouldReturnFizz() {
        assertEquals("Fizz", fizzBuzz.calculateResponse(3));
    }

    @Test
    void testNumberFive_ShouldReturnBuzz() {
        assertEquals("Buzz", fizzBuzz.calculateResponse(5));
    }

    @Test
    void testNumberSix_ShouldReturnFizz() {
        assertEquals("Fizz", fizzBuzz.calculateResponse(6));
    }

    @Test
    void testNumberTen_ShouldReturnBuzz() {
        assertEquals("Buzz", fizzBuzz.calculateResponse(10));
    }

    @Test
    void testNumberFifteen_ShouldReturnFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.calculateResponse(15));
    }

    @Test
    void testNumberThirty_ShouldReturnFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.calculateResponse(30));
    }

    @Test
    void testNumberSeven_ShouldReturnSeven() {
        assertEquals("7", fizzBuzz.calculateResponse(7));
    }

    @Test
    void testNullNumber_ShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> fizzBuzz.calculateResponse(null));
    }
}
