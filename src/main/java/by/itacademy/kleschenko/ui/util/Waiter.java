package by.itacademy.kleschenko.ui.util;

public class Waiter {
    public static void unwelcomeWait() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
