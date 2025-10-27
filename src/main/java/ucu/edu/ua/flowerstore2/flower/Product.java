package ucu.edu.ua.flowerstore2.flower;
public interface Product {
    // double getPrice();
    // // String getDescription();
    // List<FlowerType> getFlowerType();
    boolean matches(FlowerSpec spec);  
}
