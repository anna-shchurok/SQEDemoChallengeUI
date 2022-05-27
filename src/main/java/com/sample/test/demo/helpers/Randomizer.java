package com.sample.test.demo.helpers;

public class Randomizer {

    public static String randomString(String source, Integer len) {
        java.util.Random rnd = new java.util.Random();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(source.charAt(rnd.nextInt(source.length())));
        return sb.toString();
    }

    public static String randomStringChars(Integer len) {
        return randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", len);
    }

    public static String randomSpecialCharacters(Integer len) {
        return randomString("`!@#$%^&*)_+=╚{N▬♂♥♠,[]{}", len);
    }

    public static String randomSpecialCharacters() {
        return randomSpecialCharacters(10);
    }

    public static String randomNumbers(Integer len) {
        return randomString("1234567890", len);
    }

    public static String randomNumbers() {
        return randomNumbers(10);
    }

    public static String randomStringChars() {
        return randomStringChars(15);
    }
}
