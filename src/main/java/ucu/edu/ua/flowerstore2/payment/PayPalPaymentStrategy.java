package ucu.edu.ua.flowerstore2.payment;

public class PayPalPaymentStrategy implements Payment{
    private static  final double CASHBACK = 10;
    @Override
    public double pay(double p){
        System.out.println("Here is your cashback, for using paypal");
        return p-CASHBACK;
    }
}
