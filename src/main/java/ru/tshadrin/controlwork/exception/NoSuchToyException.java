package ru.tshadrin.controlwork.exception;

public class NoSuchToyException extends IllegalStateException{
    public NoSuchToyException(String s) {
        super(s);
    }
}
