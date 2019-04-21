import controller.CreditController;
import view.CreditView;

public class Main {
    public static void main(String[] args) {
        CreditView creditView = new CreditView();
        CreditController creditController = new CreditController(creditView);

        creditController.startProcess();
    }
}
