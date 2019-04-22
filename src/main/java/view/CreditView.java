package view;

import model.entity.Credit;

import java.util.*;

public class CreditView implements MessageConstant {
//    public static ResourceBundle bundle =
//            ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
////                    new Locale("uk_UA"));
//                    new Locale("en_GB"));        // English

public ResourceBundle bundle;
    public ResourceBundle getBundle(Scanner scanner) {
        String letter = scanner.nextLine();
        if (letter.equalsIgnoreCase(LETTER_U)) {
            return ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME, new Locale("uk", "UA"));
        } else if (letter.equalsIgnoreCase(LETTER_R)) {
            return ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME, new Locale("ru", "RU"));
        } else {
            return ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME, new Locale("en", "GB"));
        }
    }

    public void printMessage(String... messages) {
        for (String value : messages) {
            System.out.println(value);
        }
    }

    public void printDecision(List<Credit> creditList, String message, String credit) {
        Iterator<Credit> iterator = creditList.iterator();
        int counter = 0;
        while (iterator.hasNext()){
            System.out.printf(message, (counter + 1));
            System.out.print(iterator.next());
            System.out.println();
            counter++;
        }
    }

    public void printCongratulation(String message, String parameter) {
        System.out.printf(message, parameter);
    }

    private String getStringWithAvailableCredits(Credit obj) {
        return bundle.getString(obj.getBankName()) + bundle.getString(SIZE) +obj.getCreditSize() +
                bundle.getString(TERM) + obj.getTerm() + bundle.getString(MONTHS) +
                bundle.getString(PERCENT) + obj.getPercent() +
                bundle.getString(IS_EARLY_PREPAYMENT) + obj.isEarlyRepayment() +
                bundle.getString(IS_RISE_CREDIT_LINE) + obj.isRiseCreditLine() +
                bundle.getString(PURPOSE) + bundle.getString(obj.getPurpose());
    }
}
