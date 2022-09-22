package ru.skypro.course2.coursework.coursework2.service;

import ru.skypro.course2.coursework.coursework2.entity.Question;

import java.util.Collection;

public interface QuestionServiceInterface {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int size();
}
