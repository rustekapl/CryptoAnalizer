package ru.javarush.aleev.cryptoanalizer;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {


        //Actions.encode(args);
        //Actions.decode(args);
        Actions.bruteForce(args);

        //Actions.encode("text.txt", "encode.txt", 15);
        //Actions.decode("text1.txt", 15);
        //Actions.bruteForce("textForBruteForce.txt", "bf.txt");


    }
}