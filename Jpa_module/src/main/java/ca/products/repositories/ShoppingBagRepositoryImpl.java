package ca.products.repositories;

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
public class ShoppingBagRepositoryImpl implements ShoppingBagRepository {

    private Provider<EntityManager> emProvider;

    @Inject
    public ShoppingBagRepositoryImpl(Provider<EntityManager> emProvider) {
        this.emProvider = emProvider;
    }

    @Transactional
    public void persist(final ShoppingBag shoppingBag) {
        getEntityManager().persist(shoppingBag);
    }

    public ShoppingBag find(final String id) {
        return getEntityManager().find(ShoppingBag.class, id);
    }

    public List<ShoppingBag> findShoppingBagByName(final String name) {
        TypedQuery<ShoppingBag> q = getEntityManager()
                .createQuery("select e from Product e where e.name like :name", ShoppingBag.class)
                .setParameter("name", name);
        return q.getResultList();
    }
    @Transactional
    public List<Product> listAllProductsInCatalogue() {
        TypedQuery<Product> q = getEntityManager()
                .createQuery("select e from Product e", Product.class);
        return q.getResultList();
    }

    public void resetShoppingBagDB() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        getEntityManager().createQuery("DELETE FROM ShoppingBag e").executeUpdate();

        em.flush();
        em.getTransaction().commit();
    }

    public EntityManager getEntityManager() {
        return emProvider.get();
    }
}
