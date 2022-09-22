package ru.skypro.course2.coursework.coursework2.operation.impl;

public class Multiply extends BaseOperation {
    public static final String TYPE = "multiply";
    @Override
    public Number calculate() {
        return getA() * getB();
    }

    @Override
    public String getCalculationAnswerMessage() {
        return String.format(
            "%s * %s = %s",
            decimalFormat.format(getA()),
            decimalFormat.format(getB()),
            decimalFormat.format(calculate())
        );
    }

    @Override
    public String getOperationSymbol() {
        return "*";
    }

    @Override
    public String toString() {
        return "Multiply{" +
            "a = " + getA() +
            "b = " + getB() +
            "}";
    }
}
