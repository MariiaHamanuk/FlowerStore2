package ucu.edu.flowerstore2.flower;
public class Main {
    private static final int PRICE = 1;
    private static final int DEFAULT_PRICES = 100;
    private static final int SEPAL_LENGTH = 100;
    private static final int DEFAULT_AMOUNT = 11;

    public static void main(String[] args) {
        Flower flower = new Flower();
        flower.setColor(FlowerColor.RED);
        flower.setSepalLength(SEPAL_LENGTH);
        flower.setPrice(DEFAULT_PRICES);
        flower.setFlowerType(FlowerType.ROSE);

        FlowerPack flowerPack = new FlowerPack(flower, DEFAULT_AMOUNT);
        flowerPack.setFlower(flower);
        flowerPack.setAmount(DEFAULT_AMOUNT);

        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.addFlowerPack(flowerPack);

        System.out.println(flowerBucket.getPrice());

        flower.setPrice(PRICE);
 
        System.out.println(flowerBucket.getPrice());
        System.out.println(flower.getColor());
    }
}