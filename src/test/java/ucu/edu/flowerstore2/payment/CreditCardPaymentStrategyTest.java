package ucu.edu.flowerstore2.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditCardPaymentStrategyTest {

    private Payment creditCardPayment;

    @BeforeEach
    void setUp() {
        creditCardPayment = new CreditCardPaymentStrategy();
    }

    @Test
    void testPayReturnsCorrectPrice() {
        
        double price = 150.75;

        double result = creditCardPayment.pay(price);
        
        assertEquals(price, result, 0.001);
    }

    @Test
    void testPayWithZeroPrice() {
        
        double price = 0.0;
        

        double result = creditCardPayment.pay(price);
        
        
        assertEquals(price, result, 0.001);
    }
}