package ru.skypro.course2.coursework.coursework2.operation.impl;

public class Plus extends BaseOperation {
    public static final String TYPE = "plus";
    @Override
    public Number calculate() {
        return getA() + getB();
    }

    @Override
    public String getCalculationAnswerMessage() {
        return String.format(
            "%s + %s = %s",
            decimalFormat.format(getA()),
            decimalFormat.format(getB()),
            decimalFormat.format(calculate())
        );
    }

    @Override
    public String getOperationSymbol() {
        return "+";
    }

    @Override
    public String toString() {
        return "Plus{" +
            "a = " + getA() +
            "b = " + getB() +
            "}";
    }
}
