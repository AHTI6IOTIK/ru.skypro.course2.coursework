package ru.skypro.course2.coursework.coursework2.factory;

import org.springframework.stereotype.Component;
import ru.skypro.course2.coursework.coursework2.entity.Question;
@Component
public class QuestionFactory {
    public Question createItem(String question, String answer) {
        return new Question(question, answer);
    }
}
