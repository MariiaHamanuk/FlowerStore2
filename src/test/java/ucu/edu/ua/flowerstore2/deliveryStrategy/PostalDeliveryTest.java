package ucu.edu.ua.flowerstore2.deliveryStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PostalDeliveryTest {

    private Delivery postalDelivery;

    @BeforeEach
    void setUp() {
        postalDelivery = new PostalDelivery();
    }

    @Test
    void testDeliveryPriceGreaterThan1000() {
    
        double price = 1200.0;
        
        
        double deliveryCost = postalDelivery.delivery(price);
        

        assertEquals(0.0, deliveryCost, 0.001);
    }

    @Test
    void testDeliveryPriceLessThan1000() {
       
        double price = 500.0;
        
        
        double deliveryCost = postalDelivery.delivery(price);
        
    
        assertEquals(100.0, deliveryCost, 0.001);
    }

    @Test
    void testDeliveryPriceExactly1000() {

        double price = 1000.0;
        

        double deliveryCost = postalDelivery.delivery(price);
        
    
        assertEquals(100.0, deliveryCost, 0.001);
    }
}