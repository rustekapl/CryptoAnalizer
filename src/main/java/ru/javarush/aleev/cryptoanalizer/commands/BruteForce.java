package ru.javarush.aleev.cryptoanalizer.commands;
import ru.javarush.aleev.cryptoanalizer.constants.Constants;
import ru.javarush.aleev.cryptoanalizer.entity.Result;
import ru.javarush.aleev.cryptoanalizer.entity.ResultCode;
import ru.javarush.aleev.cryptoanalizer.exceptions.AppException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce implements Action {
    @Override
    public Result execute(String[] parametrs) {
        String fileInput = parametrs[0];
        String fileOutput = parametrs[1];



//Read to Buffer from encode.txt
        String line1;
        StringBuilder text1 = new StringBuilder();
        BufferedReader readerDecoder;
        try {
            readerDecoder = new BufferedReader(new FileReader(Constants.TXT_FOLDER + fileInput));

            while (true) {
            try {
                if ((line1 = readerDecoder.readLine()) == null) break;
            } catch (IOException e) {
               throw new AppException();
            }
            text1.append(line1);
        }

        int[] counts = new int[Constants.ALPHABET.length];

        String reg = "[а-яА-ЯёЁ]+[,.!?;:][ ]"; //reg sentence for russian text
        Pattern pattern = Pattern.compile(reg);

        //decoding in loops for different shift
            for (int shift = 0; shift < Constants.ALPHABET.length; shift++){
                char[] temp = new char[text1.length()];
                char[] decode = new char[text1.length()];
                for (int i = 0; i < text1.length(); i++) {
                    temp[i] = text1.charAt(i);
                    for (int j = 0; j < Constants.ALPHABET.length; j++) {
                        if (temp[i] == Constants.ALPHABET[j]) {
                            if ((j - shift) >= 0) {

                                decode[i] = Constants.ALPHABET[j - shift];
                            } else {
                                decode[i] = Constants.ALPHABET[Constants.ALPHABET.length + j - shift];
                            }


                        }
                    }
                }
                String res = String.valueOf(decode);
                Matcher matcher = pattern.matcher(res);
                while (matcher.find()) {
                    counts[shift]++;
                }
            }
//get shift with the most mathes
            int max = 0;
            for (int i : counts) {
                if (i > max) {
                    max = i;
                }
            }

            int key = 0;
            for (int index = 0; index < counts.length; index++) {
                if (counts[index] == max) {
                    key = index;
                }
            }
//decoding
            char[] temp = new char[text1.length()];
            char[] decodeBF = new char[text1.length()];
            for (int i = 0; i < text1.length(); i++) {
                temp[i] = text1.charAt(i);
                for (int j = 0; j < Constants.ALPHABET.length; j++) {
                    if (temp[i] == Constants.ALPHABET[j]) {
                        if ((j - key) >= 0) {

                            decodeBF[i] = Constants.ALPHABET[j - key];
                        } else {
                            decodeBF[i] = Constants.ALPHABET[Constants.ALPHABET.length + j - key];
                        }


                    }
                }
            }
//saving to a file bf.txt
            FileWriter fileWriterDecoder = new FileWriter(Constants.TXT_FOLDER + fileOutput);
            fileWriterDecoder.write(decodeBF);
            fileWriterDecoder.flush();
            fileWriterDecoder.close();

        } catch (IOException e) {
            throw new AppException();
        }

        return new Result(" BruteForce all right", ResultCode.OK);
    }
}

