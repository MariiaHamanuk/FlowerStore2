package ucu.edu.ua.flowerstore2.demo.payment;

public class CreditCardPaymentStrategy implements Payment {
    @Override
    public double pay(double p){
        System.out.println("You`re using credit card");
        return p;
    }
}
