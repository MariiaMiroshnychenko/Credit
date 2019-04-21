package controller;

import model.data.IkrSibBankData;
import model.data.IntMenuConstant;
import model.data.PimbBankData;
import model.data.PrivitBankData;
import model.entity.Credit;
import model.entity.IkrSibBankCredit;
import view.CreditView;
import view.MessageConstant;

import java.util.*;

public class CreditController implements MessageConstant, IntMenuConstant {
    private CreditView creditView;
    private ResourceBundle bundle;

    List<Credit> allAvailableCredits = new ArrayList<Credit>();

    Scanner scanner = new Scanner(System.in);

    public CreditController(CreditView creditView) {
        this.creditView = creditView;
    }

    public void startProcess() {
        creditView.printMessage(CHANGE_LANGUAGE);

        bundle = getBundle();
        creditView.printMessage(bundle.getString(WELCOME_MESSAGE), bundle.getString(EARLY_REPAYMENT), bundle.getString(ANSWER_YES_NO));

        sortByEarlyRepayment();

        creditView.printMessage(bundle.getString(RISE_CREDIT_LINE), bundle.getString(ANSWER_YES_NO));
        sortByRiseCreditLine(allAvailableCredits);

        creditView.printMessage(bundle.getString(CREDIT_AMOUNT));

        for (Credit obj : allAvailableCredits) {
            creditView.printMessage(bundle.getString(obj.getBankName()) + bundle.getString(SIZE) + obj.getCreditSize() +
                                              bundle.getString(TERM) + obj.getTerm() + bundle.getString(MONTHS) +
                                              bundle.getString(PERCENT) + obj.getPercent() +
                                              bundle.getString(IS_EARLY_PREPAYMENT) + obj.isEarlyRepayment() +
                                              bundle.getString(IS_RISE_CREDIT_LINE) + obj.isRiseCreditLine() +
                                              bundle.getString(PURPOSE) + bundle.getString(obj.getPurpose()));
        }
    }

    private List<Credit> sortByEarlyRepayment() {
        int ans = scanner.nextInt();

        if (ans == DIGIT_YES) {
            addToList(true, allAvailableCredits);
        } else if (ans == DIGIT_NO) {
            addToList(false, allAvailableCredits);
        } else {
            // Неправильный ввод
        }

        return allAvailableCredits;
    }

    private List<Credit> sortByRiseCreditLine(List<Credit> listAfterEarlyRepaymentSort) {
        int answer = scanner.nextInt();

        if (answer == DIGIT_YES) {
            removeFromList(true, listAfterEarlyRepaymentSort);
        } else if (answer == DIGIT_NO) {
            removeFromList(true, listAfterEarlyRepaymentSort);
        } else {
            // Неправильный ввод
        }
        //System.out.println(allAvailableCredits);
        return allAvailableCredits;
    }


    public ResourceBundle getBundle() {
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

    private List<Credit> addToList(boolean earlyRep, List<Credit> list) {
        for (IkrSibBankData value : IkrSibBankData.values()) {
            if (value.getIkrSibBankCredit().isEarlyRepayment() == earlyRep) {
                list.add(value.getIkrSibBankCredit());
            }
        }
        for (PimbBankData value : PimbBankData.values()) {
            if (value.getPimbBankCredit().isEarlyRepayment() == earlyRep) {
                list.add(value.getPimbBankCredit());
            }
        }
        for (PrivitBankData value : PrivitBankData.values()) {
            if (value.getPrivitBankCredit().isEarlyRepayment() == earlyRep) {
                list.add(value.getPrivitBankCredit());
            }
        }
        return list;
    }

    private List<Credit> removeFromList(boolean riseCreditLine, List<Credit> list) {
        for (IkrSibBankData value : IkrSibBankData.values()) {
            if (value.getIkrSibBankCredit().isRiseCreditLine() != riseCreditLine) {
                list.remove(value.getIkrSibBankCredit());
            }
        }
        for (PimbBankData value : PimbBankData.values()) {
            if (value.getPimbBankCredit().isRiseCreditLine() != riseCreditLine) {
                list.remove(value.getPimbBankCredit());
            }
        }
        for (PrivitBankData value : PrivitBankData.values()) {
            if (value.getPrivitBankCredit().isRiseCreditLine() != riseCreditLine) {
                list.remove(value.getPrivitBankCredit());
            }
        }
        return list;
    }
}
