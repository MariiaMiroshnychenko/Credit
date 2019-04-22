package view;

public class CreditView implements MessageConstant {
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
