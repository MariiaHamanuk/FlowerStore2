
package ucu.edu.ua.flowerstore2.demo;

import org.junit.jupiter.api.Test;

import ucu.edu.ua.flowerstore2.demo.payment.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("Credit Card Payment Strategy Tests")
class CreditCardPaymentStrategyTest {
    
    private CreditCardPaymentStrategy creditCardPayment;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    void setUp() {
        creditCardPayment = new CreditCardPaymentStrategy();
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    @DisplayName("Should return the same price without any fees")
    void testPayReturnsSamePrice() {
        double result = creditCardPayment.pay(100.0);
        assertEquals(100.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should handle zero price")
    void testPayWithZeroPrice() {
        double result = creditCardPayment.pay(0.0);
        assertEquals(0.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should handle large amounts")
    void testPayWithLargeAmount() {
        double result = creditCardPayment.pay(10000.0);
        assertEquals(10000.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should print credit card message")
    void testPayPrintsMessage() {
        creditCardPayment.pay(50.0);
        assertTrue(outContent.toString().contains("You`re using credit card"));
        System.setOut(originalOut);
    }
}

@DisplayName("PayPal Payment Strategy Tests")
class PayPalPaymentStrategyTest {
    
    private PayPalPaymentStrategy payPalPayment;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    void setUp() {
        payPalPayment = new PayPalPaymentStrategy();
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    @DisplayName("Should apply 10 cashback to price")
    void testPayAppliesCashback() {
        double result = payPalPayment.pay(100.0);
        assertEquals(90.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should apply cashback for small amounts")
    void testPayCashbackForSmallAmount() {
        double result = payPalPayment.pay(20.0);
        assertEquals(10.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should apply cashback for large amounts")
    void testPayCashbackForLargeAmount() {
        double result = payPalPayment.pay(1000.0);
        assertEquals(990.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should handle edge case where price equals cashback")
    void testPayWhenPriceEqualsCashback() {
        double result = payPalPayment.pay(10.0);
        assertEquals(0.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should print PayPal cashback message")
    void testPayPrintsMessage() {
        payPalPayment.pay(50.0);
        assertTrue(outContent.toString().contains("Here is your cashback, for using paypal"));
        System.setOut(originalOut);
    }
}