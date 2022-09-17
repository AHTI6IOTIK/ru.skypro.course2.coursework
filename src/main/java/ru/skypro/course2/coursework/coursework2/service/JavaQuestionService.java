package ru.skypro.course2.coursework.coursework2.service;

import org.springframework.stereotype.Service;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.repository.QuestionRepositoryInterface;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionServiceInterface {
    private final QuestionRepositoryInterface repository;
    public JavaQuestionService(QuestionRepositoryInterface javaQuestionRepository) {
        this.repository = javaQuestionRepository;
    }
    @Override
    public Question add(String question, String answer) {
        return repository.add(question, answer);
    }
    @Override
    public Question add(Question question) {
        return repository.add(question);
    }
    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }
    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return repository.findByIndex((int)(Math.random() * repository.count()));
    }
    @Override
    public int size() {
        return repository.count();
    }
}
