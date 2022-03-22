package ru.javarush.aleev.cryptoanalizer;

import ru.javarush.aleev.cryptoanalizer.controllers.MainController;
import ru.javarush.aleev.cryptoanalizer.entity.Result;
import ru.javarush.aleev.cryptoanalizer.exceptions.AppException;

import java.io.IOException;
import java.util.Arrays;

public class Aplication {
    private final MainController mainController;

    public Aplication() {
        mainController = new MainController();


    }

    public Result run(String[] args) throws IOException {
        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            return mainController.doAction(action, parameters);
        }
        else {

            throw new AppException("no args");
        }
    }
}
