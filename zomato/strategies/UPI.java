package strategies;

public class UPI implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI Transaction.");
    }
}