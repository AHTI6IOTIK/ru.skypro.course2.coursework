package ru.skypro.course2.coursework.coursework2.operation.impl;

public class Minus extends BaseOperation {
    public static final String TYPE = "minus";
    @Override
    public Number calculate() {
        return getA() - getB();
    }

    @Override
    public String getCalculationAnswerMessage() {
        return String.format(
            "%s - %s = %s",
            decimalFormat.format(getA()),
            decimalFormat.format(getB()),
            decimalFormat.format(calculate())
        );
    }

    @Override
    public String getOperationSymbol() {
        return "-";
    }

    @Override
    public String toString() {
        return "Minus{" +
            "a = " + getA() +
            "b = " + getB() +
            "}";
    }
}
