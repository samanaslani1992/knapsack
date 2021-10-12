package ir.samanaslani.asta;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface FindMostExpensiveProductsInputBoundary {

    /**
     * @param pack     :  pack information.
     * @param products : List of all available products.
     * @return List of most expensive products.
     * @author Saman Aslani
     */
    public List<Product> find(@NotNull Pack pack, @NotNull List<Product> products);

}
