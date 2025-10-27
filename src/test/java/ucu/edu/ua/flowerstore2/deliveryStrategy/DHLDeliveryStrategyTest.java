package ucu.edu.ua.flowerstore2.deliveryStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DHLDeliveryStrategyTest {

    private Delivery dhlDelivery;

    @BeforeEach
    void setUp() {
        dhlDelivery = new DHLDeliveryStrategy();
    }

    @Test
    void testDeliveryPriceGreaterThan25() {
    
        double price = 50.0;
        

        double deliveryCost = dhlDelivery.delivery(price);
 
        assertEquals(0.0, deliveryCost, 0.001);
    }

    @Test
    void testDeliveryPriceLessThan25() {
        
        double price = 20.0;
        double expectedCost = 2.0;
        

        double deliveryCost = dhlDelivery.delivery(price);
        

        assertEquals(expectedCost, deliveryCost, 0.001);
    }

    @Test
    void testDeliveryPriceExactly25() {
        double price = 25.0;
        double expectedCost = 2.5;

        double deliveryCost = dhlDelivery.delivery(price);
 
        assertEquals(expectedCost, deliveryCost, 0.001);
    }
}