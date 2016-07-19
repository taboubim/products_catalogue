package ca.products.repositories;

import ca.products.jpa_models.Product;
import ca.products.jpa_models.ShoppingBag;
import com.google.inject.persist.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by mtaboubi on 16-07-16.
 */
public interface ShoppingBagRepository {

    void persist(final ShoppingBag shoppingBag);

    ShoppingBag find(final String id);

    List<ShoppingBag> findShoppingBagByName(final String name) ;

    List<Product> listAllProductsInCatalogue();

    void resetShoppingBagDB();
}
