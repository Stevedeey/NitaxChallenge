package com.example.nitaxcodingchallenge.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Util {

    private static int randLength = 10;
    private static String strNumbers = "1234567890";
    private static List<String> accountNumbers = new ArrayList<>();

    public static Date generateCurrentDate() {
        return new Date();
    }

    public static String generateAccountID() {

        Random rand = new Random();
        char[] textData = new char[randLength];
        for (int i = 0; i < strNumbers.length(); i++) {
            textData[i] = strNumbers.charAt(rand.nextInt(strNumbers.length()));
        }

        if (accountNumbers.contains(new String(textData))) generateAccountID();
        else accountNumbers.add(new String(textData));

        return new String(textData);
    }
}
