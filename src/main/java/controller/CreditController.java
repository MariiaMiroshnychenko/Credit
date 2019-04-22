package controller;

import model.CreditModel;
import model.data.IntMenuConstant;
import model.entity.Credit;
import view.CreditView;
import view.MessageConstant;

import java.util.*;

/**
 * Class checks input data and process credit selection
 *
 * @author Mariia Miroshnychenko
 * @version 1.0
 */
public class CreditController implements MessageConstant, IntMenuConstant {
    private CreditView creditView;
    private CreditModel creditModel;
    private ResourceBundle bundle;

    private String clientCredit;

    private List<Credit> allAvailableCredits;

    private Scanner scanner = new Scanner(System.in);

    public CreditController(CreditView creditView, CreditModel creditModel) {
        this.creditView = creditView;
        this.creditModel = creditModel;
    }

    /**
     * Method helps to get ResourceBundle according to selected locale
     *
     * @param scanner
     * @return bundle
     */
    private ResourceBundle getResourceBundle(Scanner scanner) {
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

    public void startProcess() {
        creditView.printMessage(CHANGE_LANGUAGE);
        bundle = getResourceBundle(scanner);

        listInitialization();

        creditView.printMessage(bundle.getString(WELCOME_MESSAGE));

        manageSearchProcessBuParameters();
    }

    private void listInitialization() {
        creditModel.addToList();

        allAvailableCredits = creditModel.allCredits;
    }

    private void manageSearchProcessBuParameters() {
        sortByEarlyRepayment();

        sortByRiseCreditLine();

        sortByCreditPurpose();

        showAllAvailableCredits();
    }

    private void sortByEarlyRepayment() {
        if (allAvailableCredits.size() == 0) {
            creditView.printMessage(bundle.getString(EMPTY_CREDIT_LIST));
        } else {
            creditView.printMessage(bundle.getString(EARLY_REPAYMENT), bundle.getString(ANSWER_YES_NO));
            try {
                String ans = scanner.nextLine();

                if (Integer.parseInt(ans) == DIGIT_ONE) {
                    removeEarlyRepayment(true);
                } else if (Integer.parseInt(ans) == DIGIT_TWO) {
                    removeEarlyRepayment(false);
                } else {
                    creditView.printMessage(bundle.getString(ERROR_MESSAGE));

                    sortByEarlyRepayment();
                }
            } catch (NumberFormatException e) {
                creditView.printMessage(bundle.getString(ERROR_MESSAGE));
                sortByEarlyRepayment();
            }
        }
    }

    private void sortByRiseCreditLine() {
        if (allAvailableCredits.size() == 0) {
            creditView.printMessage(bundle.getString(EMPTY_CREDIT_LIST));
        } else {
            creditView.printMessage(bundle.getString(RISE_CREDIT_LINE), bundle.getString(ANSWER_YES_NO));

            try {
                String answer = scanner.nextLine();
                if (Integer.parseInt(answer) == DIGIT_ONE) {
                    removeRiseCreditLine(true);
                } else if (Integer.parseInt(answer) == DIGIT_TWO) {
                    removeRiseCreditLine(false);
                } else {
                    creditView.printMessage(bundle.getString(ERROR_MESSAGE), bundle.getString(ANSWER_YES_NO));
                    sortByRiseCreditLine();
                }
            } catch (NumberFormatException e) {
                creditView.printMessage(bundle.getString(ERROR_MESSAGE), bundle.getString(ANSWER_YES_NO));
                sortByRiseCreditLine();
            }
        }
    }

    private void sortByCreditPurpose() {
        if (allAvailableCredits.size() == 0) {
            creditView.printMessage(bundle.getString(EMPTY_CREDIT_LIST));
        } else {
            creditView.printMessage(bundle.getString(SEARCH_RESULT));
            creditView.printMessage(bundle.getString(CREDIT_PURPOSE), bundle.getString(PURPOSE_CHOOSE));

            String[] purposes = {CAR, REAL_ESTATE, DEVICE, EDUCATION, APARTMENT_REPAIR, CARD, BUSINESS};

            try {
                String answer = scanner.nextLine();

                if (Integer.parseInt(answer) <= 0 || Integer.parseInt(answer) >= purposes.length) {
                    creditView.printMessage(bundle.getString(ERROR_MESSAGE));
                    sortByCreditPurpose();
                }
                removeFromListByCreditPurpose(purposes[Integer.parseInt(answer) - 1]);
            } catch (NumberFormatException e) {
                creditView.printMessage(bundle.getString(ERROR_MESSAGE));
                sortByCreditPurpose();
            }
        }
    }

    /**
     * method check credit list on empty and offers user to make
     */
    private void showAllAvailableCredits() {
        if (allAvailableCredits.size() == 0) {
            creditView.printMessage(bundle.getString(EMPTY_CREDIT_LIST));
        } else {
            creditView.printMessage(bundle.getString(MAKE_DECISION), bundle.getString(CLIENT_CHOICE));

            int numberOfAvailableCredit = 0;

            for (Credit obj : allAvailableCredits) {
                creditView.printDecision((numberOfAvailableCredit + 1), DECISION_NUMBER, getStringWithAvailableCredits(obj));
                numberOfAvailableCredit++;
            }
            creditView.printMessage(getStringWithAvailableCredits(finalChoice()));
            creditView.printCongratulation(bundle.getString(CONGRATULATION), bundle.getString(clientCredit));
        }
    }

    public String getStringWithAvailableCredits(Credit obj) {
        return bundle.getString(obj.getBankName()) + bundle.getString(SIZE) + obj.getCreditSize() +
                bundle.getString(TERM) + obj.getTerm() + bundle.getString(MONTHS) +
                bundle.getString(PERCENT) + obj.getPercent() +
                bundle.getString(IS_EARLY_PREPAYMENT) + obj.isEarlyRepayment() +
                bundle.getString(IS_RISE_CREDIT_LINE) + obj.isRiseCreditLine() +
                bundle.getString(PURPOSE) + bundle.getString(obj.getPurpose());
    }

    private void removeEarlyRepayment(boolean argument) {
        Iterator<Credit> iterator = getCreditIterator();

        while (iterator.hasNext()) {
            if (iterator.next().isEarlyRepayment() != argument) {
                iterator.remove();
            }
        }
    }

    private void removeRiseCreditLine(boolean argument) {
        Iterator<Credit> iterator = getCreditIterator();

        while (iterator.hasNext()) {
            if (iterator.next().isRiseCreditLine() != argument) {
                iterator.remove();
            }
        }
    }

    private void removeFromListByCreditPurpose(String purpose) {
        Iterator<Credit> iterator = getCreditIterator();

        while (iterator.hasNext()) {
            if (!iterator.next().getPurpose().equals(purpose)) {
                iterator.remove();
            }
        }
    }

    private Iterator<Credit> getCreditIterator() {
        return allAvailableCredits.iterator();
    }

    private Credit finalChoice(){
        String answer;

        while (true) {
            try {
                answer = scanner.nextLine();

                if (Integer.parseInt(answer) <= 0 || Integer.parseInt(answer) > allAvailableCredits.size()) {
                    creditView.printMessage(bundle.getString(ERROR_MESSAGE));
                    continue;
                } else {
                    clientCredit = allAvailableCredits.get(Integer.parseInt(answer) - 1).getBankName();
                }
            } catch (NumberFormatException e) {
                creditView.printMessage(bundle.getString(ERROR_MESSAGE));
                continue;
            }
            return allAvailableCredits.get(Integer.parseInt(answer) - 1);
        }
    }

    public void setBundle(String messagesBundleName, Locale locale) {
    }
}
