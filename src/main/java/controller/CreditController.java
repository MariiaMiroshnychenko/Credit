package controller;

import model.CreditModel;
import model.data.IkrSibBankData;
import model.data.IntMenuConstant;
import model.data.PimbBankData;
import model.data.PrivitBankData;
import model.entity.Credit;
import view.CreditView;
import view.MessageConstant;

import java.util.*;

public class CreditController implements MessageConstant, IntMenuConstant {
    private CreditView creditView;
    private CreditModel creditModel;
    private ResourceBundle bundle;

    String clientCredit;
    List<Credit> allAvailableCredits;

    Scanner scanner = new Scanner(System.in);

    public CreditController(CreditView creditView, CreditModel creditModel) {
        this.creditView = creditView;
        this.creditModel = creditModel;
    }


    public void startProcess() {
        creditView.printMessage(CHANGE_LANGUAGE);
        bundle = creditView.getBundle(scanner);

        listInitialization();

        for (Credit obj : creditModel.allCredits) {
            creditView.printMessage(getStringWithAvailableCredits(obj));
        }
        creditView.printMessage(bundle.getString(WELCOME_MESSAGE), bundle.getString(EARLY_REPAYMENT), bundle.getString(ANSWER_YES_NO));

        sortByEarlyRepayment();
        for (Credit obj : allAvailableCredits) {
            creditView.printMessage(getStringWithAvailableCredits(obj));
        }
        creditView.printMessage(bundle.getString(RISE_CREDIT_LINE), bundle.getString(ANSWER_YES_NO));
        sortByRiseCreditLine();
        for (Credit obj : allAvailableCredits) {
            creditView.printMessage(getStringWithAvailableCredits(obj));
        }
        creditView.printMessage(bundle.getString(CREDIT_PURPOSE), bundle.getString(PURPOSE_CHOOSE));
        sortByCreditPurpose();

        creditView.printMessage(bundle.getString(SEARCH_RESULT));


            creditView.printDecision(allAvailableCredits, DESISION_NUMBER, getStringWithAvailableCredits(obj));

        creditView.printMessage(bundle.getString(MAKE_DECISION));

        creditView.printMessage(bundle.getString(CLIENT_CHOICE), getStringWithAvailableCredits());

        creditView.printCongratulation(bundle.getString(CONGRATULATION), bundle.getString(clientCredit));
    }

    private void listInitialization() {
        creditModel.addToList();

        allAvailableCredits = creditModel.allCredits;
    }

    private String getStringWithAvailableCredits() {
        return bundle.getString(allAvailableCredits.iterator().next().getBankName()) + bundle.getString(SIZE) +allAvailableCredits.iterator().next().getCreditSize() +
                bundle.getString(TERM) + allAvailableCredits.iterator().next().getTerm() + bundle.getString(MONTHS) +
                bundle.getString(PERCENT) + allAvailableCredits.iterator().next().getPercent() +
                bundle.getString(IS_EARLY_PREPAYMENT) + allAvailableCredits.iterator().next().isEarlyRepayment() +
                bundle.getString(IS_RISE_CREDIT_LINE) + allAvailableCredits.iterator().next().isRiseCreditLine() +
                bundle.getString(PURPOSE) + bundle.getString(allAvailableCredits.iterator().next().getPurpose());
    }

    private String getStringWithAvailableCredits(Credit obj) {
        return bundle.getString(obj.getBankName()) + bundle.getString(SIZE) +obj.getCreditSize() +
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
        int answer = scanner.nextInt();

        Iterator<Credit> iterator = getCreditIterator();
        String[] purposes = {CAR, REAL_ESTATE, DEVICE, EDUCATION, APARTMENT_REPAIR, CARD, BUSINESS};

        while (iterator.hasNext()) {
            if (!iterator.next().getPurpose().equals(purposes[answer - 1])) {
                iterator.remove();
            }
        }
    }

    private void sortByEarlyRepayment() {
        int ans = scanner.nextInt();

        if (ans == DIGIT_ONE) {
                removeEarlyRepayment(true);//addToList(true, allAvailableCredits);
        } else if (ans == DIGIT_TWO) {
            removeEarlyRepayment(false);//addToList(false, allAvailableCredits);
        } else {
            // Неправильный ввод
        }
    }

    private Iterator<Credit> getCreditIterator() {
        return allAvailableCredits.iterator();
    }

    private void sortByRiseCreditLine() {
        int answer = scanner.nextInt();

        if (answer == DIGIT_ONE) {
                removeRiseCreditLine(true);
        } else if (answer == DIGIT_TWO) {
                removeRiseCreditLine(false);
        } else {
            // Неправильный ввод
        }
        //System.out.println(allAvailableCredits);
    }

    private void removeEarlyRepayment (boolean argument) {
        Iterator<Credit> iterator = getCreditIterator();

        while (iterator.hasNext()) {
            if (iterator.next().isEarlyRepayment() != argument) {
                iterator.remove();
            }
        }
    }

    private void removeRiseCreditLine (boolean argument) {
        Iterator<Credit> iterator = getCreditIterator();

        while (iterator.hasNext()) {
            if (iterator.next().isRiseCreditLine() != argument) {
                iterator.remove();
            }
        }
    }
}
