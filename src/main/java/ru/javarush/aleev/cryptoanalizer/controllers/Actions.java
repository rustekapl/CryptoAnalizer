package ru.javarush.aleev.cryptoanalizer.controllers;

import ru.javarush.aleev.cryptoanalizer.commands.Action;
import ru.javarush.aleev.cryptoanalizer.commands.BruteForce;
import ru.javarush.aleev.cryptoanalizer.commands.Decoder;
import ru.javarush.aleev.cryptoanalizer.commands.Encoder;
import ru.javarush.aleev.cryptoanalizer.exceptions.AppException;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new BruteForce());


    private final Action action;

    Actions(Action action) {

        this.action = action;
    }

    public static Action find(String actionName){
        try{
        Actions value = Actions.valueOf(actionName.toUpperCase());
        return value.action;
        } catch (IllegalArgumentException e){
            throw new AppException("not found " + actionName, e);
        }
    }
}
