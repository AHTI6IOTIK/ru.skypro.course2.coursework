package ru.skypro.course2.coursework.coursework2.service;

import org.springframework.stereotype.Service;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.MethodNotAllowedException;
import ru.skypro.course2.coursework.coursework2.operation.OperationInterface;

import java.util.Collection;
import java.util.Random;

@Service("mathQuestionService")
public class MathQuestionService implements QuestionServiceInterface {
    private static final int BASE_BOUND_RANDOM = 1000;
    private final Random random;
    public final OperationService operationService;

    public MathQuestionService(OperationService operationService, Random random) {
        this.operationService = operationService;
        this.random = random;
    }

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        OperationInterface operation = operationService.createRandomOperation(
            random.nextInt(operationService.sizeOperations()),
            random.nextInt(BASE_BOUND_RANDOM),
            random.nextInt(BASE_BOUND_RANDOM)
        );

        return operation.toQuestion();
    }

    @Override
    public int size() {
        throw new MethodNotAllowedException();
    }
}
