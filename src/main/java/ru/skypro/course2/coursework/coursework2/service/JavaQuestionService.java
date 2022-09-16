package ru.skypro.course2.coursework.coursework2.service;

import org.springframework.stereotype.Service;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.DuplicateQuestionException;
import ru.skypro.course2.coursework.coursework2.exception.NotExistQuestionException;
import ru.skypro.course2.coursework.coursework2.factory.QuestionFactory;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionServiceInterface {
    private final List<Question> questions = new ArrayList<>();
    private final QuestionFactory factory;

    public JavaQuestionService(QuestionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Question add(String question, String answer) {
        Question questionEntity = factory.createItem(question, answer);

        return add(questionEntity);
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new DuplicateQuestionException(question);
        }

        questions.add(question);

        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new NotExistQuestionException(question);
        }

        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.get(
            (int)(Math.random() * questions.size())
        );
    }

    @Override
    public int size() {
        return questions.size();
    }
}
