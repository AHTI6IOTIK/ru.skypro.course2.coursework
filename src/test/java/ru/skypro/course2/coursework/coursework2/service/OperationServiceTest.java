package ru.skypro.course2.coursework.coursework2.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.skypro.course2.coursework.coursework2.operation.OperationInterface;
import ru.skypro.course2.coursework.coursework2.operation.impl.Divide;
import ru.skypro.course2.coursework.coursework2.operation.impl.Minus;
import ru.skypro.course2.coursework.coursework2.operation.impl.Multiply;
import ru.skypro.course2.coursework.coursework2.operation.impl.Plus;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperationServiceTest {

    private final OperationService operationService = new OperationService();

    @ParameterizedTest
    @MethodSource("getParameters")
    void operationGenerateTest(String operationType, double a, double b, OperationInterface expected) {
        assertEquals(
            operationService.createOperation(operationType, a, b),
            expected
        );
    }

    public static Stream<Arguments> getParameters() {
        return Stream.of(
            Arguments.of(Divide.TYPE, 10, 10, (new Divide()).setA(10).setB(10)),
            Arguments.of(Multiply.TYPE, 10, 10, (new Multiply()).setA(10).setB(10)),
            Arguments.of(Minus.TYPE, 10, 10, (new Minus()).setA(10).setB(10)),
            Arguments.of(Plus.TYPE, 10, 10, (new Plus()).setA(10).setB(10))
        );
    }
}