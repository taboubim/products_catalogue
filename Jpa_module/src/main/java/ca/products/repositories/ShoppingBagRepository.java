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

    public void persist(final ShoppingBag shoppingBag);

    public Product find(final String id);

    public List<Product> findProductByName(final String name) ;

    public List<Product> listAllProductsInCatalogue();
}
