package ru.skypro.course2.coursework.coursework2.repository;

import ru.skypro.course2.coursework.coursework2.entity.Question;

import java.util.Collection;

public interface QuestionRepositoryInterface {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    int count();

    Question findByIndex(int index);
}
