package ru.skypro.course2.coursework.coursework2.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.exception.DuplicateQuestionException;
import ru.skypro.course2.coursework.coursework2.exception.NotExistQuestionException;
import ru.skypro.course2.coursework.coursework2.factory.QuestionFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class JavaQuestionRepository implements QuestionRepositoryInterface {
    private final List<Question> questions = new ArrayList<>();

    private final QuestionFactory factory;

    public JavaQuestionRepository(QuestionFactory factory) {
        this.factory = factory;
    }

    @PostConstruct
    public void init() {
        questions.add(factory.createItem("String1", "String1"));
        questions.add(factory.createItem("String2", "String2"));
        questions.add(factory.createItem("String3", "String3"));
        questions.add(factory.createItem("String4", "String4"));
        questions.add(factory.createItem("String5", "String5"));
        questions.add(factory.createItem("String6", "String6"));
        questions.add(factory.createItem("String7", "String7"));
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
    public int count() {
        return questions.size();
    }

    @Override
    public Question findByIndex(int index) {
        return questions.get(index);
    }
}
