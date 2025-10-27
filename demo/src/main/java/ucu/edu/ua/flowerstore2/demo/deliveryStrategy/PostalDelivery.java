package ucu.edu.ua.flowerstore2.demo.deliveryStrategy;

public class PostalDelivery implements Delivery {
    // System.out.println();

    @Override
    public double delivery(double DeliveryPrice) {
        System.out.println("This is postal service and we will be your delivery");

        if(DeliveryPrice > 1000){
            return 0;
        }
        return 100;
    }
}
