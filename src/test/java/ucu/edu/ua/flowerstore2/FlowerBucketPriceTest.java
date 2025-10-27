package ucu.edu.ua.flowerstore2.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ucu.edu.ua.flowerstore2.demo.flower.Flower;
import ucu.edu.ua.flowerstore2.demo.flower.FlowerBucket;
import ucu.edu.ua.flowerstore2.demo.flower.FlowerColor;
import ucu.edu.ua.flowerstore2.demo.flower.FlowerPack;
import ucu.edu.ua.flowerstore2.demo.flower.FlowerType;

import org.junit.jupiter.api.Assertions;

public class FlowerBucketPriceTest {
    private static final double FIRSTSEPAL = 23.32;
    private static final double SECONDSEPAL = 14.5;
    private static final double FIRSTPRICE = 20.00;
    private static final double SECONDPRICE = 12.5;
    private static final double THIRDPRICE = 0.00;

    private static final int FIRSTQUANTITY = 8;
    private static final double PRICEPERFLOWER = 15.5;
    private static final int QUANTITY = 10;
    private static final double TOTAL = 155.0;
    private static final double SEPAL = 43.5;
    private static final double EXPECTED = 300.0;

    private FlowerBucket flowerBucket;
    @BeforeEach
    public void setUp() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void getPriceForEmptyBucket() {
        double actualPrice = flowerBucket.getPrice();

        Assertions.assertEquals(THIRDPRICE, actualPrice);
    }

    @Test
    public void getPriceForSinglePack() {
        Flower flower = new Flower(SEPAL, 
        FlowerColor.RED, PRICEPERFLOWER, FlowerType.ROSE);
        FlowerPack flowerPack = new FlowerPack(flower, QUANTITY);
        flowerBucket.add(flowerPack);

        double actualPrice = flowerBucket.getPrice();

        Assertions.assertEquals(TOTAL, actualPrice);
    }

    @Test
    public void getPriceForMultipleDifferentPacks() {

        Flower rose = new Flower(FIRSTSEPAL,
        FlowerColor.RED, FIRSTPRICE, FlowerType.ROSE);
        FlowerPack rosePack = new FlowerPack(rose, QUANTITY);

        Flower tulip = new Flower(SECONDSEPAL,
        FlowerColor.WHITE, SECONDPRICE, FlowerType.TULIP);
        FlowerPack tulipPack = new FlowerPack(tulip, FIRSTQUANTITY);

        flowerBucket.add(rosePack);
        flowerBucket.add(tulipPack);
        

        double actualPrice = flowerBucket.getPrice();

        Assertions.assertEquals(EXPECTED, actualPrice);
    }

}