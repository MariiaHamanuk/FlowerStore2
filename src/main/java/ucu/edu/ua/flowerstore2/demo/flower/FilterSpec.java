package ucu.edu.ua.flowerstore2.demo.flower;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FilterSpec {
    private FlowerColor color;
    private FlowerType flowerType;
    private Double minPrice;
    private Double maxPrice;
    private Double sepalLength;

    public FilterSpec() { }
}
