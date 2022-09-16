package ru.skypro.course2.coursework.coursework2.service;

import org.springframework.stereotype.Service;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.CountQuestionException;

import java.util.*;

@Service
public class ExaminerService implements ExaminerServiceInterface {

    QuestionServiceInterface questionService;

    public ExaminerService(QuestionServiceInterface questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.size()) {
            throw new CountQuestionException();
        }

        int distinctCountQuestions = amount;
        Set<Question> questions = new HashSet<>();

        while (distinctCountQuestions > 0) {
            boolean isUniq = questions.add(
                questionService.getRandomQuestion()
            );

            if (isUniq) {
                distinctCountQuestions--;
            }
        }

        return new ArrayList<>(questions);
    }
}
