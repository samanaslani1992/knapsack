package ir.samanaslani.asta;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FindMostExpensiveProductsUsecase implements FindMostExpensiveProductsInputBoundary {


    /**
     * @param pack     :  pack information.
     * @param products : List of all available products.
     * @return List of most expensive products.
     * @author Saman Aslani
     */
    @Override
    public List<Product> find(@NotNull Pack pack, @NotNull List<Product> products) {


        products.sort(Product::compareCost);


        List<Product> result = new ArrayList<>();

        for (Product product : products) {

            if (pack.isNewProductAcceptable(product)) {
                pack.gainingWeight(product);
                result.add(product);
            }

        }

        return result;


    }

}
