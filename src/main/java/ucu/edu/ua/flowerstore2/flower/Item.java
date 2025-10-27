package ucu.edu.ua.flowerstore2.flower;

// import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item { 
    private FlowerBucket fb;
    public double getPrice(){
        return fb.getPrice();
    }
}
