package ru.javarush.aleev.cryptoanalizer;

import ru.javarush.aleev.cryptoanalizer.entity.Result;

import java.io.IOException;


public class ConsoleRunner {
    public static void main(String[] args) throws IOException {

//        if(args[0].equalsIgnoreCase("encode")){
//            Actions.encode(args);
//        }
//        else if(args[0].equalsIgnoreCase("decode")){
//            Actions.decode(args);
//        }
//        else if(args[0].equalsIgnoreCase("bruteforce")){
//            Actions.bruteForce(args);
//        }
        //encode text.txt encode.txt 15
        //decode text1.txt decode.txt 15
        //bruteforce textForBruteForce.txt bf.txt

        Aplication aplication = new Aplication();
        Result result = aplication.run(args);

        System.out.println(result);


        //Actions.encode(args);
        //Actions.decode(args);
        //Actions.bruteForce(args);

        //Actions.encode("text.txt", "encode.txt", 15);
        //Actions.decode("text1.txt", 15);
        //Actions.bruteForce("textForBruteForce.txt", "bf.txt");


    }
}