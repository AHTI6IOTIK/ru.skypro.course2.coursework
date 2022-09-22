package ru.skypro.course2.coursework.coursework2.operation.impl;

import ru.skypro.course2.coursework.coursework2.exception.DivisionErrorException;

public class Divide extends BaseOperation {
    public static final String TYPE = "divide";

    @Override
    public boolean isSuccess() {
        boolean hasError = (getA() == 0 || getB() == 0);
        if (hasError) {
            throw new DivisionErrorException();
        }

        return true;
    }

    @Override
    public Number calculate() {
        return getA() / getB();
    }

    @Override
    public String getCalculationAnswerMessage() {
        return String.format(
            "%s / %s = %s",
            decimalFormat.format(getA()),
            decimalFormat.format(getB()),
            decimalFormat.format(calculate())
        );
    }

    @Override
    public String getOperationSymbol() {
        return "/";
    }

    @Override
    public String toString() {
        return "Divide{" +
            "a = " + getA() +
            "b = " + getB() +
        "}";
    }
}
