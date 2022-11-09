package ru.netology;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BinOpsTests {

    private BinOps binOps;

    @BeforeAll
    public static void startedAll() {
        System.out.println("BinOps tests started");
    }

    @BeforeEach
    public void init() {
        binOps = new BinOps();
        System.out.println("BinOps test started");
    }

    @AfterEach
    public void finished() {
        System.out.println("BinOps test finished");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("BinOps tests finished");
    }

    @ParameterizedTest
    @MethodSource("sourceForTestSum")
    public void testSum(String operand1, String operand2, String expected) {
        //when:
        String result = binOps.sum(operand1, operand2);
        //then:
        Assertions.assertTrue(result.contains(expected));
    }

    @ParameterizedTest
    @MethodSource("sourceForTestMult")
    public void testMult(String operand1, String operand2, String expected) {
        //when:
        String result = binOps.mult(operand1, operand2);
        //then:
        Assertions.assertTrue(result.contains(expected));
    }

    @ParameterizedTest
    @MethodSource("sourceForThrowsNumberFormatException")
    public void testSum_throwsNumberFormatException(String operand1, String operand2, String expectedMessage) {
        //when:
        Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            binOps.sum(operand1, operand2);
        });
        String actualMessage = exception.getMessage();
        //then:
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @MethodSource("sourceForThrowsNumberFormatException")
    public void testMult_throwsNumberFormatException(String operand1, String operand2, String expectedMessage) {
        //when:
        Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            binOps.mult(operand1, operand2);
        });
        String actualMessage = exception.getMessage();
        //then:
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @MethodSource("sourceForDoesNotThrowNumberFormatException")
    public void testSum_doesNotThrowNumberFormatException(String operand1, String operand2) {
        //then:
        Assertions.assertDoesNotThrow(() -> binOps.sum(operand1, operand2));
    }

    @ParameterizedTest
    @MethodSource("sourceForDoesNotThrowNumberFormatException")
    public void testMult_doesNotThrowNumberFormatException(String operand1, String operand2) {
        //then:
        Assertions.assertDoesNotThrow(() -> binOps.mult(operand1, operand2));
    }

    private static Stream<Arguments> sourceForTestSum() {
        return Stream.of(
                Arguments.of("0", "0", "0"),
                Arguments.of("0", "1", "1"),
                Arguments.of("1111", "111", "10110"));
    }

    private static Stream<Arguments> sourceForTestMult() {
        return Stream.of(
                Arguments.of("0", "0", "0"),
                Arguments.of("0", "1", "0"),
                Arguments.of("101", "1001", "101101"));
    }

    private static Stream<Arguments> sourceForThrowsNumberFormatException() {
        return Stream.of(
                Arguments.of(new String(), new String(),
                        "One or more operands are not in binary format!"),
                Arguments.of("", "", "One or more operands are not in binary format!"),
                Arguments.of("2", "0", "One or more operands are not in binary format!"),
                Arguments.of("0", "9", "One or more operands are not in binary format!"),
                Arguments.of("str", "1", "One or more operands are not in binary format!"),
                Arguments.of("0", "str", "One or more operands are not in binary format!"));
    }

    private static Stream<Arguments> sourceForDoesNotThrowNumberFormatException() {
        return Stream.of(
                Arguments.of("0", "0"),
                Arguments.of("0", "1"),
                Arguments.of("101", "1101"));
    }
}