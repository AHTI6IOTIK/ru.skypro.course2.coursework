package ru.skypro.course2.coursework.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.MethodNotAllowedException;
import ru.skypro.course2.coursework.coursework2.operation.impl.Divide;
import ru.skypro.course2.coursework.coursework2.operation.impl.Minus;
import ru.skypro.course2.coursework.coursework2.operation.impl.Multiply;
import ru.skypro.course2.coursework.coursework2.operation.impl.Plus;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    private static final int A = 10;
    private static final int B = 2;
    private static final int DIVIDE_NUM = 0;
    private static final int MINUS_NUM = 1;
    private static final int MULTIPLY_NUM = 2;
    private static final int PLUS_NUM = 3;
    private final Random random = mock(Random.class);
    private final OperationService operationService = mock(OperationService.class);
    private QuestionServiceInterface out;

    @Test
    void addTest() {
        assertThrows(MethodNotAllowedException.class, () -> out.add("Test", "Test"));
    }

    @Test
    void testAddTest() {
        assertThrows(MethodNotAllowedException.class, () -> out.add(new Question("Test", "Test")));
    }

    @Test
    void removeTest() {
        assertThrows(MethodNotAllowedException.class, () -> out.remove(new Question("Test", "Test")));
    }

    @Test
    void getAllTest() {
        assertThrows(MethodNotAllowedException.class, out::getAll);
    }

    @Test
    void generateRandomDivideTest() {
        when(random.nextInt(any(Integer.class)))
            .thenReturn(DIVIDE_NUM);
        Question expected = (new Divide()).setA(A).setB(B).toQuestion();
        assertEquals(expected, out.getRandomQuestion());
    }

    @Test
    void generateRandomMinusTest() {
        when(random.nextInt(any(Integer.class)))
            .thenReturn(MINUS_NUM);
        Question expected = (new Minus()).setA(A).setB(B).toQuestion();
        assertEquals(expected, out.getRandomQuestion());
    }

    @Test
    void generateRandomMultiplyTest() {
        when(random.nextInt(any(Integer.class)))
            .thenReturn(MULTIPLY_NUM);
        Question expected = (new Multiply()).setA(A).setB(B).toQuestion();
        assertEquals(expected, out.getRandomQuestion());
    }

    @Test
    void generateRandomPlusTest() {
        when(random.nextInt(any(Integer.class)))
            .thenReturn(PLUS_NUM);
        Question expected = (new Plus()).setA(A).setB(B).toQuestion();
        assertEquals(expected, out.getRandomQuestion());
    }

    @Test
    void sizeTest() {
        assertThrows(MethodNotAllowedException.class, () -> out.size());
    }

    @BeforeEach
    void setUp() {
        when(operationService.sizeOperations()).thenReturn(4);
        when(
            operationService.createRandomOperation(
                eq(DIVIDE_NUM),
                any(Double.class),
                any(Double.class)
            )
        ).thenReturn((new Divide()).setA(A).setB(B));
        when(
            operationService.createRandomOperation(
                eq(MINUS_NUM),
                any(Double.class),
                any(Double.class)
            )
        ).thenReturn((new Minus()).setA(A).setB(B));
        when(
            operationService.createRandomOperation(
                eq(MULTIPLY_NUM),
                any(Double.class),
                any(Double.class)
            )
        ).thenReturn((new Multiply()).setA(A).setB(B));
        when(
            operationService.createRandomOperation(
                eq(PLUS_NUM),
                any(Double.class),
                any(Double.class)
            )
        ).thenReturn((new Plus()).setA(A).setB(B));

        out = new MathQuestionService(operationService, random);
    }
}
