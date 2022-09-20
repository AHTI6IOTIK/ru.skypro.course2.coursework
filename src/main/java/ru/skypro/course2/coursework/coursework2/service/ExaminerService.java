package ru.skypro.course2.coursework.coursework2.service;

import org.springframework.stereotype.Service;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.CountQuestionException;

import java.util.*;

@Service
public class ExaminerService implements ExaminerServiceInterface {
    private final Map<String, QuestionServiceInterface> questionServices;

    public ExaminerService(
        Map<String, QuestionServiceInterface> questionServices
    ) {
        this.questionServices = questionServices;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int maxQueries = 0;
        for (QuestionServiceInterface service : questionServices.values()) {
            if (service instanceof MathQuestionService) {
                continue;
            }
            maxQueries += service.size();
        }

        if (amount > maxQueries) {
            throw new CountQuestionException();
        }

        Set<Question> questions = new LinkedHashSet<>();
        int distinctCountQuestions = amount;

        while (distinctCountQuestions > 0) {
            for (QuestionServiceInterface service : questionServices.values()) {
                boolean isUniq = questions.add(
                    service.getRandomQuestion()
                );

                if (isUniq) {
                    distinctCountQuestions--;
                }
            }
        }

        return new ArrayList<>(questions);
    }
}
