package test.java.ucu.edu.ua.flowerstore2.demo;


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