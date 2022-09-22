package ru.skypro.course2.coursework.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.skypro.course2.coursework.coursework2.entity.Question;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotExistQuestionException extends RuntimeException {
    public NotExistQuestionException(Question question) {
        super(String.format(
            "Question #%s does not exist",
            question.getQuestion()
        ));
    }
}
