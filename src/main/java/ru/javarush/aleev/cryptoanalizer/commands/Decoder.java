package ru.javarush.aleev.cryptoanalizer.commands;

import ru.javarush.aleev.cryptoanalizer.constants.Constants;
import ru.javarush.aleev.cryptoanalizer.entity.Result;
import ru.javarush.aleev.cryptoanalizer.entity.ResultCode;
import java.io.*;

public class Decoder implements Action {
    @Override
    public Result execute(String[] parametrs) {

        String fileInput = parametrs[0];
        String fileOutput = parametrs[1];
        int key = Integer.parseInt(parametrs[2]);
        String line1 = null;
        StringBuilder text1 = new StringBuilder();


        BufferedReader readerDecoder;
        try {
            readerDecoder = new BufferedReader(new FileReader(Constants.TXT_FOLDER + fileInput));


            while (true) {
                try {
                    if ((line1 = readerDecoder.readLine()) == null) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                text1.append(line1);
            }

            char[] temp = new char[text1.length()];
            char[] decode = new char[text1.length()];
            for (int i = 0; i < text1.length(); i++) {
                temp[i] = text1.charAt(i);
                for (int j = 0; j < Constants.ALPHABET.length; j++) {
                    if (temp[i] == Constants.ALPHABET[j]) {
                        if ((j - key) >= 0) {

                            decode[i] = Constants.ALPHABET[j - key];
                        } else {
                            decode[i] = Constants.ALPHABET[Constants.ALPHABET.length + j - key];
                        }


                    }
                }
            }


            FileWriter fileWriterDecoder = new FileWriter(Constants.TXT_FOLDER + fileOutput);
            fileWriterDecoder.write(decode);
            fileWriterDecoder.flush();
            fileWriterDecoder.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return new Result("Decode all right", ResultCode.OK);
    }
}
