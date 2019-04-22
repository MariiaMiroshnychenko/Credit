package controller;

import model.CreditModel;
import model.data.IntMenuConstant;
import model.entity.Credit;
import view.CreditView;
import view.MessageConstant;

import java.util.*;

public class CreditController implements MessageConstant, IntMenuConstant, RegexContainer {
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


    public void startProcess() {
        creditView.printMessage(CHANGE_LANGUAGE);
        bundle = creditView.getBundle(scanner);

        listInitialization();

        creditView.printMessage(bundle.getString(WELCOME_MESSAGE));

        sortByCreditParameter();
    }

    private void sortByCreditParameter() {
        sortByEarlyRepayment();

        sortByRiseCreditLine();

        sortByCreditPurpose();

        showAllAvailableCredits();
    }

    private void showAllAvailableCredits() {
        if (allAvailableCredits.size() == 0) {
            creditView.printMessage(bundle.getString(EMPTY_CREDIT_LIST));
        } else {
            creditView.printMessage(bundle.getString(MAKE_DECISION), bundle.getString(CLIENT_CHOICE));

            int counter = 0;

            for (Credit obj : allAvailableCredits) {
                creditView.printDecision((counter + 1), DECISION_NUMBER, getStringWithAvailableCredits(obj));
                counter++;
            }

            creditView.printMessage(getStringWithAvailableCredits(finalChoice()));
            creditView.printCongratulation(bundle.getString(CONGRATULATION), bundle.getString(clientCredit));
        }
    }

    private void listInitialization() {
        creditModel.addToList();

        allAvailableCredits = creditModel.allCredits;
    }

    private String getStringWithAvailableCredits(Credit obj) {
        return bundle.getString(obj.getBankName()) + bundle.getString(SIZE) + obj.getCreditSize() +
                bundle.getString(TERM) + obj.getTerm() + bundle.getString(MONTHS) +
                bundle.getString(PERCENT) + obj.getPercent() +
                bundle.getString(IS_EARLY_PREPAYMENT) + obj.isEarlyRepayment() +
                bundle.getString(IS_RISE_CREDIT_LINE) + obj.isRiseCreditLine() +
                bundle.getString(PURPOSE) + bundle.getString(obj.getPurpose());
    }

    private Credit finalChoice() {
        int answer = scanner.nextInt();

        clientCredit = allAvailableCredits.get(answer - 1).getBankName();

        return allAvailableCredits.get(answer - 1);
    }

    private void sortByCreditPurpose() {
        if (allAvailableCredits.size() == 0){
            creditView.printMessage(bundle.getString(EMPTY_CREDIT_LIST));
        } else {
            creditView.printMessage(bundle.getString(SEARCH_RESULT));
            creditView.printMessage(bundle.getString(CREDIT_PURPOSE), bundle.getString(PURPOSE_CHOOSE));

            String[] purposes = {CAR, REAL_ESTATE, DEVICE, EDUCATION, APARTMENT_REPAIR, CARD, BUSINESS};

            try {
                String answer = scanner.nextLine();

                if (Integer.parseInt(answer) <= 0 || Integer.parseInt(answer) >= purposes.length){
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

    private void removeFromListByCreditPurpose(String purpose) {
            Iterator<Credit> iterator = getCreditIterator();

            while (iterator.hasNext()) {
                if (!iterator.next().getPurpose().equals(purpose)) {
                    iterator.remove();
                }
            }
    }

    private void sortByEarlyRepayment(){
        if (allAvailableCredits.size() == 0){
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

    private Iterator<Credit> getCreditIterator() {
        return allAvailableCredits.iterator();
    }

    private void sortByRiseCreditLine() {
        if (allAvailableCredits.size() == 0){
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
}
