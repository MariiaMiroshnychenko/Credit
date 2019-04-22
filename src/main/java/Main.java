import controller.CreditController;
import model.CreditModel;
import view.CreditView;

public class Main {
    public static void main(String[] args) {
        CreditView creditView = new CreditView();
        CreditModel creditModel = new CreditModel();
        CreditController creditController = new CreditController(creditView, creditModel);

        creditController.startProcess();
    }
}
