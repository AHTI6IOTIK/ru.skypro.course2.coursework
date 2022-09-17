package ru.skypro.course2.coursework.coursework2.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.DuplicateQuestionException;
import ru.skypro.course2.coursework.coursework2.exception.NotExistQuestionException;
import ru.skypro.course2.coursework.coursework2.factory.QuestionFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {
    private QuestionRepositoryInterface out;

    @BeforeEach
    void setUp() {
        out = new MathQuestionRepository(new QuestionFactory());
    }

    @Test
    void addFromObjectValueTest() {
        out.add(new Question("1 + 2", "2"));
        System.out.println(out.getAll());
        assertEquals(
            new ArrayList<>(List.of(new Question("1 + 2", "2"))),
            out.getAll()
        );
    }

    @Test
    void addFromObjectReturnValueTest() {
        Question expected = new Question("1 + 2", "2");
        Question actual = out.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    void addFromObjectChangeSizeTest() {
        out.add(new Question("1 + 2", "2"));
        assertEquals(1, out.count());
    }

    @Test
    void addFromObjectThrowExceptionTest() {
        out.add(new Question("1 + 2", "2"));
        assertThrows(DuplicateQuestionException.class, () -> out.add(new Question("1 + 2", "2")));
    }

    @Test
    void addFromStringReturnValueTest() {
        Question expected = new Question("1 + 2", "2");
        Question actual = out.add("1 + 2", "2");
        assertEquals(expected, actual);
    }

    @Test
    void addFromStringChangeSizeTest() {
        out.add("1 + 2", "2");
        assertEquals(1, out.count());
    }

    @Test
    void addFromStringThrowExceptionTest() {
        out.add("1 + 2", "2");
        assertThrows(DuplicateQuestionException.class, () -> out.add("1 + 2", "2"));
    }

    @Test
    void removeReturnValueTest() {
        Question expected = new Question("1 + 1", "2");
        out.add("1 + 2", "3");
        out.add("1 + 1", "2");
        out.add("1 + 3", "4");
        Question actual = out.remove(new Question("1 + 1", "2"));
        assertEquals(expected, actual);
    }

    @Test
    void removeTest() {
        out.add("1 + 2", "3");
        out.add("1 + 1", "2");
        out.add("1 + 3", "4");
        out.remove(new Question("1 + 2", "3"));
        assertEquals(
            new ArrayList<>(List.of(
                new Question("1 + 2", "3"),
                new Question("1 + 3", "4")
            )),
            out.getAll()
        );
    }

    @Test
    void removeThrowExceptionTest() {
        out.add("1 + 1", "2");
        out.add("1 + 2", "3");
        out.add("1 + 3", "4");
        assertThrows(
            NotExistQuestionException.class,
            () -> out.remove(new Question("Question100", "2"))
        );
    }

    @Test
    void getAll() {
        out.add("1 + 1", "2");
        out.add("1 + 2", "3");
        out.add("1 + 3", "4");
        assertEquals(
            new ArrayList<>(List.of(
                new Question("Question2", "2"),
                new Question("1 + 2", "3"),
                new Question("Question3", "2")
            )),
            out.getAll()
        );
    }
}