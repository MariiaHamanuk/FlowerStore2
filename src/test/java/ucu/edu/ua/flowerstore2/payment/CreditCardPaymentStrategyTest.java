package ucu.edu.ua.flowerstore2.payment;

import org.junit.jupiter.api.Test;

import ucu.edu.ua.flowerstore2.payment.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
