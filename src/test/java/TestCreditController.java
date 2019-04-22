import controller.CreditController;
import model.CreditModel;
import model.entity.Credit;
import org.junit.Before;
import org.junit.Test;
import view.CreditView;

import java.util.Locale;

import static view.MessageConstant.MESSAGES_BUNDLE_NAME;

public class TestCreditController {
    private CreditController controller;
    private CreditView view = new CreditView();
    private CreditModel model = new CreditModel();

    @Before
    public void initialize() {
        controller = new CreditController(view, model);
        controller.setBundle(MESSAGES_BUNDLE_NAME, new Locale("uk","UA"));
    }

    @Test (expected = NullPointerException.class)
    public void getStringWithAvailableCreditsTest() {
        controller.getStringWithAvailableCredits(null);
    }
}
