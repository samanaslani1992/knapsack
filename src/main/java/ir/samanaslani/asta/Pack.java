package ir.samanaslani.asta;

public class Pack {

    private final float maxWeight;
    private float weight = 0;

    public Pack(int maxWeight) {
        this.maxWeight = maxWeight;
    }


    public boolean isNewProductAcceptable(Product product) {
        return product.getWeight() + weight <= maxWeight;
    }

    public void gainingWeight(Product product) {
        weight += product.getWeight();
    }


}
