package ir.samanaslani.asta;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFindMostExpensiveProducts {
    private FindMostExpensiveProductsInputBoundary findMostExpensiveProductsInputBoundary;

    @Before
    public void beforeEachTestMethod() {
        // Arrange
        findMostExpensiveProductsInputBoundary = new FindMostExpensiveProductsUsecase();
    }


    @Test
    public void oneProduct_ProductItself() {
        // Act
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products, new Product(1, 1, 1));
        List<Product> actual = findMostExpensiveProductsInputBoundary.find(new Pack(1), products);

        // Assert

        List<Product> expected = new ArrayList<Product>();
        Collections.addAll(expected, new Product(1, 1, 1));
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void twoProducts_MostExpensiveProduct() {
        // Act
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products, new Product(1, 1, 1), new Product(2, 2, 1));
        List<Product> actual = findMostExpensiveProductsInputBoundary.find(new Pack(1), products);

        // Assert
        List<Product> expected = new ArrayList<Product>();
        Collections.addAll(expected, new Product(2, 2, 1));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fiveProducts_MostExpensiveProduct() {
        // Act
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products, new Product(1, 1, 1),
            new Product(2, 5, 1),
            new Product(3, 9, 1),
            new Product(4, 4, 1),
            new Product(5, 3, 1));
        List<Product> actual = findMostExpensiveProductsInputBoundary.find(new Pack(1), products);

        // Assert
        List<Product> expected = new ArrayList<Product>();
        Collections.addAll(expected, new Product(3, 9, 1));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TwoProductsWithTheSamePriceAndPackWeightIs2_TwoProduct() {
        // Act
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products, new Product(1, 1, 1), new Product(2, 1, 1));
        List<Product> actual = findMostExpensiveProductsInputBoundary.find(new Pack(2), products);

        // Assert
        List<Product> expected = new ArrayList<Product>();
        Collections.addAll(expected, new Product(1, 1, 1),
            new Product(2, 1, 1));
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void TwoProductsWithTheSamePriceAndPackWeightIs2ButFirstOneHasMoreWeightThanPackWeight_OneProduct() {
        // Act
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products, new Product(1, 1, 3), new Product(2, 1, 1));
        List<Product> actual = findMostExpensiveProductsInputBoundary.find(new Pack(1), products);

        // Assert
        List<Product> expected = new ArrayList<Product>();
        Collections.addAll(expected, new Product(2, 1, 1));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void integration1() {
        // Act
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products,
            new Product(1, 45, 53.38f),
            new Product(2, 98, 88.62f),
            new Product(3, 3, 78.48f),
            new Product(4, 76, 72.30f),
            new Product(5, 9, 30.18f),
            new Product(6, 48, 46.34f)
        );
        List<Product> actual = findMostExpensiveProductsInputBoundary.find(new Pack(81), products);

        // Assert
        List<Product> expected = new ArrayList<Product>();
        Collections.addAll(expected, new Product(4, 76, 72.30f));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void integration2() {
        // Act
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products,
            new Product(1, 34, 15.3f)
        );
        List<Product> actual = findMostExpensiveProductsInputBoundary.find(new Pack(8), products);

        // Assert
        List<Product> expected = new ArrayList<Product>();

        Assert.assertEquals(expected, actual);
    }

    /**
     * The algorithm of Greedy quickly and can also be optimal in some cases. However, in some special cases,
     * it does not give the optimal solution.
     * Here I have an example:
     */
    @Test
    public void integration3() {
        // Act
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products,
            new Product(1, 29, 85.31f),
            new Product(2, 74, 14.55f),
            new Product(3, 16, 3.98f),
            new Product(4, 55, 26.24f),
            new Product(5, 52, 63.69f),
            new Product(6, 75, 76.25f),
            new Product(7, 74, 60.02f),
            new Product(8, 35, 93.18f),
            new Product(9, 78, 89.95f)
        );

        List<Product> actual = findMostExpensiveProductsInputBoundary.find(new Pack(75), products);

        // Assert
        List<Product> expected = new ArrayList<Product>();
        Collections.addAll(expected, new Product(2, 74, 14.55f), new Product(7, 74, 60.02f));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void integration4() {
        // Act
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products,
            new Product(1, 13, 90.72f),
            new Product(2, 40, 33.80f),
            new Product(3, 10, 43.15f),
            new Product(4, 16, 37.97f),
            new Product(5, 36, 46.81f),
            new Product(6, 79, 48.77f),
            new Product(7, 45, 81.80f),
            new Product(8, 79, 19.36f),
            new Product(9, 64, 6.76f)
        );
        List<Product> actual = findMostExpensiveProductsInputBoundary.find(new Pack(56), products);

        // Assert
        List<Product> expected = new ArrayList<Product>();
        Collections.addAll(expected,
            new Product(9, 64, 6.76f), new Product(8, 79, 19.36f));
        Assert.assertEquals(expected, actual);
    }


}
