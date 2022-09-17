package ru.skypro.course2.coursework.coursework2.service;

import org.springframework.stereotype.Service;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.NotMathematicalQuestionException;
import ru.skypro.course2.coursework.coursework2.repository.QuestionRepositoryInterface;

@Service
public class MathQuestionService extends JavaQuestionService {

    public MathQuestionService(QuestionRepositoryInterface mathQuestionRepository) {
        super(mathQuestionRepository);
    }

    @Override
    public Question add(String question, String answer) {
        mathematicalQuestionGuard(question);
        return super.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        mathematicalQuestionGuard(question.getQuestion());
        return super.add(question);
    }

    private void mathematicalQuestionGuard(String question) {
        if (
            !question.contains("+")
                && !question.contains("-")
                && !question.contains("/")
                && !question.contains("*")
        ) {
            throw new NotMathematicalQuestionException();
        }
    }
}
