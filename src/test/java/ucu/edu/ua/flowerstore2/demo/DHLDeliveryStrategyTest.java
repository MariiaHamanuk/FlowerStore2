package ucu.edu.ua.flowerstore2.demo;

import org.junit.jupiter.api.Test;

import ucu.edu.ua.flowerstore2.demo.deliveryStrategy.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("DHL Delivery Strategy Tests")
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

@DisplayName("Postal Delivery Strategy Tests")
class PostalDeliveryTest {
    
    private PostalDelivery postalDelivery;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    void setUp() {
        postalDelivery = new PostalDelivery();
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    @DisplayName("Should return 0 when price is greater than 1000")
    void testDeliveryFreeForHighPrice() {
        double result = postalDelivery.delivery(1500.0);
        assertEquals(0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should return 0 at boundary price of 1000")
    void testDeliveryFreeAtBoundary() {
        double result = postalDelivery.delivery(1000.01);
        assertEquals(0, result, 0.01);
    }
    
    @Test
    @DisplayName("Should return 100 when price is less than or equal to 1000")
    void testDeliveryFlatFeeForLowPrice() {
        double result = postalDelivery.delivery(500.0);
        assertEquals(100, result, 0.01);
    }
    
    @Test
    @DisplayName("Should return 100 for very small prices")
    void testDeliveryFlatFeeForSmallPrice() {
        double result = postalDelivery.delivery(10.0);
        assertEquals(100, result, 0.01);
    }
    
    @Test
    @DisplayName("Should print postal service message")
    void testDeliveryPrintsMessage() {
        postalDelivery.delivery(50.0);
        assertTrue(outContent.toString().contains("This is postal service and we will be your delivery"));
        System.setOut(originalOut);
    }
}
