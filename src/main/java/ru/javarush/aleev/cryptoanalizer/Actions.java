package ru.javarush.aleev.cryptoanalizer;

import ru.javarush.aleev.cryptoanalizer.constants.Constants;

import java.io.*;
import java.util.Scanner;

public class Actions {

    public static void encode(String[] args) throws IOException {
        String fileInput = args[0];
        String fileOutput = args[1];
        int key = Integer.parseInt(args[2]);

        if (fileInput.isEmpty()) {
            System.out.println("Проверьте исходный файл"); //!!! отловить FileNotFound exception!!!

        } else {
            if (key > 0 && key < Constants.ALPHABET.length - 1) {


                BufferedReader reader = new BufferedReader(new FileReader(fileInput));
                String line;
                StringBuilder text = new StringBuilder();


                while ((line = reader.readLine()) != null) {
                    text.append(line);
                }

                System.out.println("Text = " + text);

                char[] temp = new char[text.length()];
                char[] encode = new char[text.length()];


                for (int i = 0; i < text.length(); i++) {
                    temp[i] = Character.toLowerCase(text.charAt(i));
                    for (int j = 0; j < Constants.ALPHABET.length; j++) {
                        if (temp[i] == Constants.ALPHABET[j]) {
                            encode[i] = Constants.ALPHABET[(j + key) % Constants.ALPHABET.length];
                        }
                    }
                }
                File encoder = new File(fileOutput);
                if (!encoder.exists()) {
                    encoder.createNewFile();
                }

                FileWriter fileWriterEncoder = new FileWriter(encoder);
                fileWriterEncoder.write(encode);
                fileWriterEncoder.flush();
                fileWriterEncoder.close();


                System.out.println("--------------");
                System.out.print("Encode = ");
                System.out.println(encode);
                System.out.println("--------------");
            } else
                System.out.println("Вы ввели неправильный сдвиг");
        }
    }

    public static void decode(String[] args) throws IOException {
        String fileInput = args[0];
        int key = Integer.parseInt(args[1]);

        BufferedReader readerDecoder = new BufferedReader(new FileReader(fileInput));
        String line1;
        StringBuilder text1 = new StringBuilder();


        while ((line1 = readerDecoder.readLine()) != null) {
            text1.append(line1);
        }

        System.out.println("text1 = " + text1);
        System.out.println("--------------");

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
        File decoder = new File("decode.txt");
        if (!decoder.exists()) {
            decoder.createNewFile();
        }

        FileWriter fileWriterDecoder = new FileWriter(decoder);
        fileWriterDecoder.write(decode);
        fileWriterDecoder.flush();
        fileWriterDecoder.close();

        System.out.print("Decode = ");
        System.out.println(decode);
        System.out.println("--------------");
    }

    public static void bruteForce(String [] args) throws IOException {
        String fileInput = args[0];
        String fileOutput = args[1];

        BufferedReader readerBruteForce = new BufferedReader(new FileReader(fileInput));
        String lineBF;
        StringBuilder textForBruteForce = new StringBuilder();


        while ((lineBF = readerBruteForce.readLine()) != null) {
            textForBruteForce.append(lineBF);
        }

        System.out.println("textBF = " + textForBruteForce);
        System.out.println("--------------");


        for (int shift = 0; shift < Constants.ALPHABET.length; shift++) {
            char[] bruteForce = new char[textForBruteForce.length()];
            char[] temp = new char[textForBruteForce.length()];
            for (int i = 0; i < textForBruteForce.length(); i++) {
                temp[i] = textForBruteForce.charAt(i);
                for (int j = 0; j < Constants.ALPHABET.length; j++) {
                    if (temp[i] == Constants.ALPHABET[j]) {
                        if ((j - shift) >= 0) {

                            bruteForce[i] = Constants.ALPHABET[j - shift];
                        } else {
                            bruteForce[i] = Constants.ALPHABET[Constants.ALPHABET.length + j - shift];
                        }


                    }
                }
            }

            System.out.print("For Shift = " + shift + " : ");
            System.out.println(bruteForce);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер наилучшего результата");
        int shift = scanner.nextInt();
        char[] temp = new char[textForBruteForce.length()];
        char[] bruteForce = new char[textForBruteForce.length()];
        for (int i = 0; i < textForBruteForce.length(); i++) {
            temp[i] = textForBruteForce.charAt(i);
            for (int j = 0; j < Constants.ALPHABET.length; j++) {
                if (temp[i] == Constants.ALPHABET[j]) {
                    if ((j - shift) >= 0) {

                        bruteForce[i] = Constants.ALPHABET[j - shift];
                    } else {
                        bruteForce[i] = Constants.ALPHABET[Constants.ALPHABET.length + j - shift];
                    }


                }
            }
        }


        File fileBF = new File(fileOutput);
        if (!fileBF.exists()) {
            fileBF.createNewFile();
        }

        FileWriter fileWriterBruteForce = new FileWriter(fileBF);
        fileWriterBruteForce.write(bruteForce);
        fileWriterBruteForce.flush();
        fileWriterBruteForce.close();

        System.out.print("BruteForce = ");
        System.out.println(bruteForce);
        System.out.println("--------------");
    }

}
