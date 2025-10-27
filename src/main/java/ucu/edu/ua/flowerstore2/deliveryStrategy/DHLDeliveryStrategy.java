package ucu.edu.ua.flowerstore2.deliveryStrategy;

public class DHLDeliveryStrategy implements Delivery{
    @Override
    public double delivery(double p){
        System.out.println("This is dhl service and we will be your delivery");
        if (p > 25){
            return 0;
        }
        return p/10;

    }
}
