package ru.skypro.course2.coursework.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.CountQuestionException;
import ru.skypro.course2.coursework.coursework2.exception.MethodNotAllowedException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExaminerServiceTest {
    QuestionServiceInterface javaQuestionService = mock(JavaQuestionService.class);
    QuestionServiceInterface mathQuestionService = mock(MathQuestionService.class);
    ExaminerServiceInterface out;

    @BeforeEach
    void setUp() {
        when(javaQuestionService.getRandomQuestion())
            .thenReturn(new Question("String1", "String1"))
            .thenReturn(new Question("String2", "String2"))
            .thenReturn(new Question("String3", "String3"))
            .thenReturn(new Question("String4", "String4"))
            .thenReturn(new Question("String5", "String5"))
            .thenReturn(new Question("String6", "String6"))
        ;

        when(mathQuestionService.getRandomQuestion())
            .thenReturn(new Question("1 + 1", "2"))
            .thenReturn(new Question("1 + 2", "3"))
            .thenReturn(new Question("1 + 3", "4"))
            .thenReturn(new Question("1 + 4", "5"))
            .thenReturn(new Question("1 + 5", "6"))
            .thenReturn(new Question("1 + 6", "7"))
        ;

        when(javaQuestionService.size()).thenReturn(6);
        when(mathQuestionService.size()).thenThrow(new MethodNotAllowedException());

        out = new ExaminerService(new HashMap<>(
            Map.of(
                "javaQuestionService", javaQuestionService,
                "mathQuestionService", mathQuestionService
            )
        ));
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