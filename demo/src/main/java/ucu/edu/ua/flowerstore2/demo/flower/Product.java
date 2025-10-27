package flower.store;
public interface Product {
    // double getPrice();
    // // String getDescription();
    // List<FlowerType> getFlowerType();
    boolean matches(FlowerSpec spec);  
}
