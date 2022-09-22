package ru.skypro.course2.coursework.coursework2.service;

import ru.skypro.course2.coursework.coursework2.entity.Question;

import java.util.Collection;

public interface ExaminerServiceInterface {
    Collection<Question> getQuestions(int amount);
}
