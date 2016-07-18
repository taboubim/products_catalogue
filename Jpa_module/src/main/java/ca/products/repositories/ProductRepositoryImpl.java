package ca.products.repositories;

import ca.products.jpa_models.Member;
import ca.products.jpa_models.Product;
import ca.products.jpa_models.ShoppingBag;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by mtaboubi on 16-07-16.
 */
public class ProductRepositoryImpl implements ProductRepository {

    private Provider<EntityManager> emProvider;

    @Inject
    public ProductRepositoryImpl(Provider<EntityManager> emProvider) {
        this.emProvider = emProvider;
    }

    @Transactional
    public void persist(final Product product) {
        getEntityManager().persist(product);
    }

    public Product find(final String id) {
        return getEntityManager().find(Product.class, id);
    }

    public List<Product> findProductByName(final String name) {
        TypedQuery<Product> q = getEntityManager()
                .createQuery("select e from Product e where e.name like :name", Product.class)
                .setParameter("name", name);
        return q.getResultList();
    }

    public List<Product> listAllProductsInCatalogue() {
        TypedQuery<Product> q = getEntityManager()
                .createQuery("select e from Product e", Product.class);
        return q.getResultList();
    }

    public void resetProductDB() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        for (int i = 0; i < 10; i++) {
            em.persist(new Product("Product_" + i, "Desc_" + i));
        }
        em.flush();
        em.getTransaction().commit();

    }

    public EntityManager getEntityManager() {
        return emProvider.get();
    }

    public void save(Product object) {
        getEntityManager().persist(object);
    }

    public void saveInNewTransaction(Product object) {
        getEntityManager().getTransaction().begin();
        save(object);
        getEntityManager().getTransaction().commit();
    }
}
