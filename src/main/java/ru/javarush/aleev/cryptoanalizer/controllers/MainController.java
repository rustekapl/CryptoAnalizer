package ru.javarush.aleev.cryptoanalizer.controllers;

import ru.javarush.aleev.cryptoanalizer.commands.Action;
import ru.javarush.aleev.cryptoanalizer.entity.Result;

public class MainController {
    public Result doAction (String actionName, String[] parameters) {
        Action action = Actions.find(actionName);
        return action.execute(parameters);


    }
}
