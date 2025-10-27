package ucu.edu.ua.flowerstore2.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PayPalPaymentStrategyTest {

    private Payment payPalPayment;
    private static final double CASHBACK = 10.0;

    @BeforeEach
    void setUp() {
        payPalPayment = new PayPalPaymentStrategy();
    }

    @Test
    void testPayAppliesCashbackCorrectly() {

        double price = 100.0;
        double expectedPriceAfterCashback = price - CASHBACK; // 90.0
        

        double result = payPalPayment.pay(price);
        
        
        assertEquals(expectedPriceAfterCashback, result, 0.001);
    }

    @Test
    void testPayWhenPriceIsEqualToCashback() {
    
        double price = 10.0;
        double expectedPriceAfterCashback = 0.0;
        

        double result = payPalPayment.pay(price);
        

        assertEquals(expectedPriceAfterCashback, result, 0.001);
    }

    @Test
    void testPayWhenPriceIsLessThanCashback() {

        double price = 5.0;
        double expectedPriceAfterCashback = price - CASHBACK; 
        
        
        double result = payPalPayment.pay(price);
        
        
        assertEquals(expectedPriceAfterCashback, result, 0.001);
    }
}