package by.itacademy.kleschenko.user;

import by.itacademy.kleschenko.ui.util.RandomString;

public class RandomUser extends User{
    public RandomUser(String email, String password) {
        super(email, password);
    }
    public static User createRandomUser(){
        return new User(RandomString.generateRandomString() + "@gmail.com",RandomString.generateRandomString());
    }
}
