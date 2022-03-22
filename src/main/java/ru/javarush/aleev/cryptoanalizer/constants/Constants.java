package ru.javarush.aleev.cryptoanalizer.constants;

import java.io.File;

public class Constants {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и',
            'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т',
            'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ы', 'ъ',
            'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':',
            '!', '?', ' ', '-', '\n', '\t', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0'};
    public static final String TXT_FOLDER = System.getProperty("user.dir")+File.separator+"text"+File.separator;


}
