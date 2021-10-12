package ir.samanaslani.asta;

public class Product {
    private final int id;
    private final float price;
    private final float weight;

    public Product(int id, float price, float weight) {
        this.id = id;
        this.price = price;
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Product) obj).id;
    }


    public float cost() {
        return price / weight;
    }


    public int compareCost(Product product) {
        return Float.compare(product.cost(), this.cost());
    }

}
