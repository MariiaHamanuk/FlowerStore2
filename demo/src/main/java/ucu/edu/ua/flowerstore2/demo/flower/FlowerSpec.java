package flower.store;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerSpec {
    private FlowerType flowerType;
    private FlowerColor color;

    public FlowerSpec(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    public boolean matches(Flower flower) {
        if (this.flowerType != null 
        && flower.getFlowerType() != this.flowerType) {
            return false;
        }
        if (this.color != null && flower.getColor() 
        != this.color.toString()) {
            return false;
        }
        return true;
    }
}