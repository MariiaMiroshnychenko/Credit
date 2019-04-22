package view;

import model.entity.Credit;

import java.util.*;

public class CreditView implements MessageConstant {
//    public static ResourceBundle bundle =
//            ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
////                    new Locale("uk_UA"));
//                    new Locale("en_GB"));        // English

public ResourceBundle bundle;


    public void printMessage(String... messages) {
        for (String value : messages) {
            System.out.println(value);
        }
    }

    public void printDecision(int number, String message, String credit) {
            System.out.printf(message, number);
            System.out.print(credit);
            System.out.println();
    }

    public void printCongratulation(String message, String parameter) {
        System.out.printf(message, parameter);
    }
}
