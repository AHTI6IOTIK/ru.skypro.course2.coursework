package ru.skypro.course2.coursework.coursework2.operation.impl;

import ru.skypro.course2.coursework.coursework2.entity.Question;
import ru.skypro.course2.coursework.coursework2.operation.OperationInterface;

import java.text.DecimalFormat;
import java.util.Objects;

public abstract class BaseOperation implements OperationInterface {

    protected DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private double a;

    private double b;

    private String error;

    public double getA() {
        return a;
    }

    public BaseOperation setA(double a) {
        this.a = a;
        return this;
    }

    public double getB() {
        return b;
    }

    public BaseOperation setB(double b) {
        this.b = b;
        return this;
    }

    public boolean isSuccess() {
        return true;
    }

    public BaseOperation setError(String error) {
        this.error = error;
        return this;
    }

    public String getError() {
        return error;
    }

    @Override
    public Question toQuestion() {
        return new Question(
            String.format(
                "%s %s %s",
                a,
                getOperationSymbol(),
                b
            ),
            getAnswer()
        );
    }

    public String getAnswer() {
        return String.valueOf(calculate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseOperation)) return false;
        BaseOperation that = (BaseOperation) o;
        return Double.compare(that.a, a) == 0 && Double.compare(that.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
