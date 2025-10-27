package ucu.edu.flowerstore2.flower;

// import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// @Data
@Getter
@Setter
public class FlowerPack implements Product {
    private Flower f;
    private int amount;
    public FlowerPack(Flower fsecond, int quantity) {
        this.f = new Flower(fsecond);
        this.amount = quantity;
    }
    public double getPrice() {
        return f.getPrice() * amount;
    }
    public void setFlower(Flower fsecond) {
        this.f = new Flower(fsecond);
    }

    
    @Override
    public boolean matches(FlowerSpec spec) {
        return spec.matches(this.getF());
    }

}
