package flower.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Flower implements Product {
    private double sepalLength;
    private FlowerColor color;
    private double price;
    private FlowerType flowerType;
    public Flower(Flower other) {
        this.flowerType = other.flowerType;
        this.price = other.price;
        this.sepalLength = other.sepalLength;
        this.color = other.color;
    }

    public String getColor() {
        return color.toString();
    }

    @Override
    public boolean matches(FlowerSpec spec) {
        return spec.matches(this);
    }
}
