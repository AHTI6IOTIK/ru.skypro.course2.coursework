package ru.skypro.course2.coursework.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.NotMathematicalQuestionException;
import ru.skypro.course2.coursework.coursework2.repository.MathQuestionRepository;
import ru.skypro.course2.coursework.coursework2.repository.QuestionRepositoryInterface;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MathQuestionServiceTest {
    QuestionRepositoryInterface repository = mock(MathQuestionRepository.class);
    QuestionServiceInterface out;

    @BeforeEach
    void setUp() {
        Question returnObject = new Question("1 + 1", "2");
        when(repository.add("1 + 1", "2")).thenReturn(returnObject);
        when(repository.add(new Question("1 + 1", "2"))).thenReturn(returnObject);
        when(repository.remove(new Question("1 + 1", "2"))).thenReturn(returnObject);
        when(repository.getAll()).thenReturn(List.of(returnObject));
        when(repository.findByIndex(any(Integer.class))).thenReturn(returnObject);

        out = new MathQuestionService(repository);
    }

    @Test
    void addReturnValueByStringsTest() {
        Question expected = new Question("1 + 1", "2");
        assertEquals(expected, repository.add("1 + 1", "2"));
    }

    @Test
    void addReturnValueByObjectTest() {
        Question expected = new Question("1 + 1", "2");
        assertEquals(expected, out.add(new Question("1 + 1", "2")));
    }

    @Test
    void removeReturnValueTest() {
        Question expected = new Question("1 + 1", "2");
        assertEquals(expected, out.remove(new Question("1 + 1", "2")));
    }

    @Test
    void getAllTest() {
        assertEquals(List.of(new Question("1 + 1", "2")), out.getAll());
    }

    @Test
    void getRandomQuestionTest() {
        assertEquals(new Question("1 + 1", "2"), out.getRandomQuestion());
    }

    @Test
    void addWithThrowByStringsTest() {
        assertThrows(NotMathematicalQuestionException.class, () -> out.add("Java?", "Java!"));
    }

    @Test
    void addWithThrowByObjTest() {
        assertThrows(
            NotMathematicalQuestionException.class,
            () -> out.add(new Question("Java?", "Java!"))
        );
    }
}