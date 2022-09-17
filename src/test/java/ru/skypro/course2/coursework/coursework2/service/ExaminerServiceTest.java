package ru.skypro.course2.coursework.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.CountQuestionException;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExaminerServiceTest {
    QuestionServiceInterface questionService = mock(JavaQuestionService.class);
    ExaminerServiceInterface out;

    @BeforeEach
    void setUp() {
        when(questionService.getRandomQuestion())
            .thenReturn(new Question("String1", "String1"))
            .thenReturn(new Question("String1", "String1"))
            .thenReturn(new Question("String2", "String2"))
            .thenReturn(new Question("String2", "String2"))
            .thenReturn(new Question("String3", "String3"))
            .thenReturn(new Question("String3", "String3"))
            .thenReturn(new Question("String4", "String4"))
            .thenReturn(new Question("String4", "String4"))
            .thenReturn(new Question("String5", "String5"))
            .thenReturn(new Question("String5", "String5"))
            .thenReturn(new Question("String6", "String6"))
            .thenReturn(new Question("String6", "String6"))
        ;

        when(questionService.size()).thenReturn(6); // потому что уникальных 6

        out = new ExaminerService(questionService);
    }

    @Test
    void getQuestionsDistinctTest() {
        Collection<Question> questions = out.getQuestions(4);
        assertEquals(
            questions
                .stream()
                .distinct()
                .collect(Collectors.toList()),
            questions
        );
    }

    @Test
    void getQuestionsThrowExceptionTest() {
        assertThrows(CountQuestionException.class, () -> out.getQuestions(Integer.MAX_VALUE));
    }
}