package ucu.edu.ua.flowerstore2.demo.flower;

public enum FlowerColor {
    /**
     * Flower colors.
     */
    RED("#FF0000"),
    BLUE("#0000FF"),
    WHITE("#FFFFFF");

    private final String stringRepresentation;

    FlowerColor(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }
    
    @Override
    public String toString() {
        return stringRepresentation;
    }
}
