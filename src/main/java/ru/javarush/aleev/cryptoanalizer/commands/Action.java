package ru.javarush.aleev.cryptoanalizer.commands;

import ru.javarush.aleev.cryptoanalizer.entity.Result;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Action {
    Result execute(String[] parametrs) throws IOException;

}
