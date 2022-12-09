package by.itacademy.kleschenko.user;

public class CorrectUser extends User{
   public static final String EMAIL = "knv1920qq@gmail.com";
   public static final String PASSWORD = "Greenhead3000";

    public CorrectUser() {
        super(EMAIL, PASSWORD);
    }

    public static User getCorrectUser() {
        return new User(EMAIL, PASSWORD);
    }
}
