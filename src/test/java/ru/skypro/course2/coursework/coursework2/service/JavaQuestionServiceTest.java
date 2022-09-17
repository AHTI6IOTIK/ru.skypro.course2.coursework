package ru.skypro.course2.coursework.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.DuplicateQuestionException;
import ru.skypro.course2.coursework.coursework2.exception.NotExistQuestionException;
import ru.skypro.course2.coursework.coursework2.factory.QuestionFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private QuestionServiceInterface out;

    @BeforeEach
    void setUp() {
        out = new JavaQuestionService(new QuestionFactory());
    }

    @Test
    void addFromObjectValueTest() {
        out.add(new Question("Question", "Answer"));
        assertEquals(
            new ArrayList<>(List.of(new Question("Question", "Answer"))),
            out.getAll()
        );
    }

    @Test
    void addFromObjectReturnValueTest() {
        Question expected = new Question("Question", "Answer");
        Question actual = out.add(expected);
        assertEquals(expected, actual);
    }

    @Test
    void addFromObjectChangeSizeTest() {
        out.add(new Question("Question", "Answer"));
        assertEquals(1, out.size());
    }

    @Test
    void addFromObjectThrowExceptionTest() {
        out.add(new Question("Question", "Answer"));
        assertThrows(DuplicateQuestionException.class, () -> out.add(new Question("Question", "Answer")));
    }

    @Test
    void addFromStringReturnValueTest() {
        Question expected = new Question("Question", "Answer");
        Question actual = out.add("Question", "Answer");
        assertEquals(expected, actual);
    }

    @Test
    void addFromStringChangeSizeTest() {
        out.add("Question", "Answer");
        assertEquals(1, out.size());
    }

    @Test
    void addFromStringThrowExceptionTest() {
        out.add("Question", "Answer");
        assertThrows(DuplicateQuestionException.class, () -> out.add("Question", "Answer"));
    }

    @Test
    void removeReturnValueTest() {
        Question expected = new Question("Question1", "Answer");
        out.add("Question2", "Answer");
        out.add("Question1", "Answer");
        out.add("Question3", "Answer");
        Question actual = out.remove(new Question("Question1", "Answer"));
        assertEquals(expected, actual);
    }

    @Test
    void removeTest() {
        out.add("Question2", "Answer");
        out.add("Question1", "Answer");
        out.add("Question3", "Answer");
        out.remove(new Question("Question1", "Answer"));
        assertEquals(
            new ArrayList<>(List.of(
                new Question("Question2", "Answer"),
                new Question("Question3", "Answer")
            )),
            out.getAll()
        );
    }

    @Test
    void removeThrowExceptionTest() {
        out.add("Question2", "Answer");
        out.add("Question1", "Answer");
        out.add("Question3", "Answer");
        assertThrows(
            NotExistQuestionException.class,
            () -> out.remove(new Question("Question100", "Answer"))
        );
    }

    @Test
    void getAll() {
        out.add("Question2", "Answer");
        out.add("Question1", "Answer");
        out.add("Question3", "Answer");
        assertEquals(
            new ArrayList<>(List.of(
                new Question("Question2", "Answer"),
                new Question("Question1", "Answer"),
                new Question("Question3", "Answer")
            )),
            out.getAll()
        );
    }

    @Test
    void getRandomQuestion() {
        out.add("Question2", "Answer");
        out.add("Question1", "Answer");
        out.add("Question3", "Answer");
        assertTrue(
            (new ArrayList<>(List.of(
                new Question("Question2", "Answer"),
                new Question("Question1", "Answer"),
                new Question("Question3", "Answer")
            ))).contains(out.getRandomQuestion())
        );
    }
}