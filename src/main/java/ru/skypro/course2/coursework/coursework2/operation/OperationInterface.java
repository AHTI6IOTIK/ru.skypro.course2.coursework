package ru.skypro.course2.coursework.coursework2.operation;

import ru.skypro.course2.coursework.coursework2.entity.Question;

public interface OperationInterface {
    Number calculate();

    String getCalculationAnswerMessage();

    String getOperationSymbol();

    String getAnswer();

    Question toQuestion();
}
