package view;

import model.entity.Credit;

import java.util.Locale;
import java.util.ResourceBundle;

public class CreditView implements MessageConstant {
//    public static ResourceBundle bundle =
//            ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
////                    new Locale("uk_UA"));
//                    new Locale("en_GB"));        // English

    public void printMessage(String... messages) {
        for (String value : messages) {
            System.out.println(value);
        }
    }
}
