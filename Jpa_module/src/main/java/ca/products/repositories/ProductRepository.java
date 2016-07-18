package ca.products.repositories;

import ca.products.jpa_models.Product;
import com.google.inject.persist.Transactional;

import java.util.List;

/**
 * Created by mtaboubi on 16-07-16.
 */
public interface ProductRepository {


    @Transactional
    void persist(final Product product);

    Product find(final String id);

    List<Product> findProductByName(final String name);

    List<Product> listAllProductsInCatalogue();

    void resetProductDB();
}
