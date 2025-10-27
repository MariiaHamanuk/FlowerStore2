package ucu.edu.ua.flowerstore2.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ucu.edu.ua.flowerstore2.demo.flower.*;

import org.junit.jupiter.api.Assertions;

public class FlowerPackTest {
    private Flower flower;
    private FlowerPack flowerPack;

    private final double vall = 10;
    private final double valk = 5;
    private final double delta = 0.001;
    


    @BeforeEach
    public void init() {
        flower = new Flower();
        flower.setPrice(vall);
        flower.setSepalLength(valk);
        flower.setFlowerType(FlowerType.ROSE);
        flower.setColor(FlowerColor.RED);
        flowerPack = new FlowerPack(flower, (int) valk);
    }

    @Test
    public void testGetPrice() {
        double expectedPrice = vall * valk;
        Assertions.assertEquals(expectedPrice, flowerPack.getPrice(),
         delta, "Price calculation failed");
    }

    @Test
    public void testSetAmount() {
        flowerPack.setAmount((int) vall);
        double expectedPrice = vall * vall;
        Assertions.assertEquals(expectedPrice, flowerPack.getPrice(),
         delta,
          "Updated price calculation failed");
    }
}
