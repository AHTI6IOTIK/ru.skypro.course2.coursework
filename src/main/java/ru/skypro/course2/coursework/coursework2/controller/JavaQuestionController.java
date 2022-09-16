package ru.skypro.course2.coursework.coursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.service.QuestionServiceInterface;

import java.util.Collection;

@RequestMapping("/exam/java")
@RestController
public class JavaQuestionController {

    private final QuestionServiceInterface questionService;

    public JavaQuestionController(QuestionServiceInterface questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Collection<Question> index() {
        return questionService.getAll();
    }

    @GetMapping("add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }
}
