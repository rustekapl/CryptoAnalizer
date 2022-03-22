package ru.javarush.aleev.cryptoanalizer.controllers;

import ru.javarush.aleev.cryptoanalizer.commands.Action;
import ru.javarush.aleev.cryptoanalizer.entity.Result;

import java.io.IOException;

public class MainController {
    public Result doAction (String actionName, String[] parameters) throws IOException {
        Action action = Actions.find(actionName);
        return action.execute(parameters);


    }
}
