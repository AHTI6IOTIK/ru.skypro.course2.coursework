package ru.skypro.course2.coursework.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.skypro.course2.coursework.coursework2.entity.Question;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateQuestionException extends RuntimeException {
    public DuplicateQuestionException(Question questionEntity) {
        super(String.format(
            "Question #%s has already been added before",
            questionEntity.getQuestion()
        ));
    }
}
