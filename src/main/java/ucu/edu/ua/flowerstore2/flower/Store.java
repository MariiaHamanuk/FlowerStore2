package ucu.edu.ua.flowerstore2.flower;

// import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private List<Product> products;
    
    public void addItem(Product product) {
        this.products.add(product);
    }
    public List<Product> search(FlowerSpec searchSpec) {
        return products.stream()
            .filter(product -> product.matches(searchSpec))
            .collect(Collectors.toList());
    }
}