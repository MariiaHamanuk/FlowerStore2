// package main.java.ucu.edu.ua.flowerstore2.demo.flower;

package ucu.edu.ua.flowerstore2.flower;
import java.util.List;
import java.util.ArrayList;
import lombok.Data;

@Data
public class FlowerBucket implements Product {
    private List<FlowerPack> flowerPacks;

    public FlowerBucket() { 
        
        this.flowerPacks = new ArrayList<>();
    }
    public void addFlowerPack(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }
    public double getPrice() {
        return flowerPacks.stream()
        .mapToDouble(pack-> pack.getPrice())
        .sum();
    }
    public void add(FlowerPack fp) {
        flowerPacks.add(fp);    
   }
   @Override
    public boolean matches(FlowerSpec spec) {
        for (FlowerPack pack : flowerPacks) {
            if (pack.matches(spec)) {
                return true;
            }
        }
        return false;
    }
}
