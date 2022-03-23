package ru.javarush.aleev.cryptoanalizer.commands;

import ru.javarush.aleev.cryptoanalizer.entity.Result;

public interface Action {
    Result execute(String[] parametrs);

}
