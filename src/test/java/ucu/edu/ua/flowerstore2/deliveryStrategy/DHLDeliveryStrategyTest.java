package ucu.edu.ua.flowerstore2.demo;

import org.junit.jupiter.api.Test;

import ucu.edu.ua.flowerstore2.deliveryStrategy.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class DHLDeliveryStrategyTest {
    
    private DHLDeliveryStrategy dhlDelivery;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    void setUp() {
        dhlDelivery = new DHLDeliveryStrategy();
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    @DisplayName("Should return 0 when price is greater than 25")
    void testDeliveryFreeForHighPrice() {
        double result = dhlDelivery.delivery(30.0);
        assertEquals(0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should return 0 when price equals 25")
    void testDeliveryFreeAtBoundary() {
        double result = dhlDelivery.delivery(25.01);
        assertEquals(0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should return price/10 when price is less than or equal to 25")
    void testDeliveryChargeForLowPrice() {
        double result = dhlDelivery.delivery(20.0);
        assertEquals(2.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should calculate correct delivery fee for small price")
    void testDeliveryChargeForSmallPrice() {
        double result = dhlDelivery.delivery(10.0);
        assertEquals(1.0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should print DHL service message")
    void testDeliveryPrintsMessage() {
        dhlDelivery.delivery(15.0);
        assertTrue(outContent.toString().contains("This is dhl service and we will be your delivery"));
        System.setOut(originalOut);
    }
}
