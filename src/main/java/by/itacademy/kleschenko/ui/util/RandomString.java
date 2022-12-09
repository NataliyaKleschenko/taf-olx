package by.itacademy.kleschenko.ui.util;

public class RandomString {
    public static String generateRandomString() {
        String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String result = "";
        for (int i = 0; i < 9; i++) {

            result += abc.charAt((int) (Math.random() * abc.length()));
        }
        return result;
    }
}
