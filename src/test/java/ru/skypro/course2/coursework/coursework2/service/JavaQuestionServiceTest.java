package ru.skypro.course2.coursework.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.repository.JavaQuestionRepository;
import ru.skypro.course2.coursework.coursework2.repository.QuestionRepositoryInterface;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    QuestionRepositoryInterface repository = mock(JavaQuestionRepository.class);
    QuestionServiceInterface out;

    @BeforeEach
    void setUp() {
        Question returnObject = new Question("Java?", "Java!");
        when(repository.add("Java?", "Java!")).thenReturn(returnObject);
        when(repository.add(new Question("Java?", "Java!"))).thenReturn(returnObject);
        when(repository.remove(new Question("Java?", "Java!"))).thenReturn(returnObject);
        when(repository.getAll()).thenReturn(List.of(returnObject));
        when(repository.findByIndex(any(Integer.class))).thenReturn(returnObject);

        out = new JavaQuestionService(repository);
    }

    @Test
    void addReturnValueByStringsTest() {
        Question expected = new Question("Java?", "Java!");
        assertEquals(expected, repository.add("Java?", "Java!"));
    }

    @Test
    void addReturnValueByObjectTest() {
        Question expected = new Question("Java?", "Java!");
        assertEquals(expected, out.add(new Question("Java?", "Java!")));
    }

    @Test
    void removeReturnValueTest() {
        Question expected = new Question("Java?", "Java!");
        assertEquals(expected, out.remove(new Question("Java?", "Java!")));
    }

    @Test
    void getAllTest() {
        assertEquals(List.of(new Question("Java?", "Java!")), out.getAll());
    }

    @Test
    void getRandomQuestionTest() {
        assertEquals(new Question("Java?", "Java!"), out.getRandomQuestion());
    }
}