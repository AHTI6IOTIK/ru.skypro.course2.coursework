package ru.skypro.course2.coursework.coursework2.exception;

public class DivisionErrorException extends IllegalArgumentException {
    public DivisionErrorException() {
        super("Делить на 0 нельзя");
    }
}
