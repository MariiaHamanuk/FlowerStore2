package ucu.edu.flowerstore2.flower;


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
