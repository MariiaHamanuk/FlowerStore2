package test.java.ucu.edu.ua.flowerstore2.delivery;


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
