package ucu.edu.ua.flowerstore2.demo.flower;

import java.util.ArrayList;
import java.util.List;

// import lombok.Data;
import lombok.Getter;
import lombok.Setter;
// import ucu.edu.ua.flowerstore2.demo.flower.Item;
import ucu.edu.ua.flowerstore2.demo.payment.Payment;
import ucu.edu.ua.flowerstore2.demo.deliveryStrategy.Delivery;
@Getter
@Setter
public class Order {

    private Payment pay;
    private List<Item> items;
    private Delivery delivery;

    public Order(){
        this.items = new ArrayList<>();
    }
    public double getOrderFinalPrice() {
        double finalPrice = items.stream()
            .mapToDouble(Item::getPrice)
            .sum();
        finalPrice = pay.pay(finalPrice);
        finalPrice += delivery.delivery(finalPrice);
        return finalPrice;
    }
    public void addItem(Item it){
        items.add(it);
    }


}
