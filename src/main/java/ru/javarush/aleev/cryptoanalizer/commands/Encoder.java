package ru.javarush.aleev.cryptoanalizer.commands;

import ru.javarush.aleev.cryptoanalizer.constants.Constants;
import ru.javarush.aleev.cryptoanalizer.entity.Result;
import ru.javarush.aleev.cryptoanalizer.entity.ResultCode;
import ru.javarush.aleev.cryptoanalizer.exceptions.AppException;

import java.io.*;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parametrs) {

        String fileInput = parametrs[0];
        String fileOutput = parametrs[1];
        int key = Integer.parseInt(parametrs[2]);

        if (fileInput.isEmpty()) {
            System.out.println("Проверьте исходный файл");
        } else {
            if (key > 0 && key < Constants.ALPHABET.length - 1) {
                File file = new File(Constants.TXT_FOLDER + fileInput);
                BufferedReader br;
                try {
                    br = new BufferedReader(new FileReader(file));

                    String readLine;
                    StringBuilder text = new StringBuilder();


                    while (true) {
                        try {
                            if ((readLine = br.readLine()) == null) break;
                        } catch (IOException e) {
                            throw new AppException();
                        }
                        text.append(readLine);
                    }

                    char[] temp = new char[text.length()];
                    char[] encode = new char[text.length()];

                    for (int i = 0; i < text.length(); i++) {
                        temp[i] = Character.toLowerCase(text.charAt(i));
                        int index = 0;
                        for (int j = 0; j < Constants.ALPHABET.length; j++) {
                            if (temp[i] == Constants.ALPHABET[j]) {
                                encode[i] = Constants.ALPHABET[(j + key) % Constants.ALPHABET.length];
                            } else index++;
                        }
                        if (index == 0) {
                            encode[i] = temp[i];
                        }
                    }

                    FileWriter fileWriterEncoder = new FileWriter(Constants.TXT_FOLDER + fileOutput);
                    fileWriterEncoder.write(encode);
                    fileWriterEncoder.flush();
                    fileWriterEncoder.close();
                } catch (IOException e) {
                    throw new AppException();
                }

            } else
                System.out.println("Вы ввели неправильный сдвиг");
        }


        return new Result("Encode all right", ResultCode.OK);
    }

}

