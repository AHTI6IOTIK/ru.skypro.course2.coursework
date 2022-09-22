package ru.skypro.course2.coursework.coursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.service.ExaminerServiceInterface;

import java.util.Collection;

@RequestMapping("/exam")
@RestController
public class ExaminerController {
    private final ExaminerServiceInterface examinerService;

    public ExaminerController(ExaminerServiceInterface examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }
}
