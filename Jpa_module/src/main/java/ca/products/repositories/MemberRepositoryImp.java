package ca.products.repositories;

import ca.products.jpa_models.Member;
import ca.products.jpa_models.Product;
import ca.products.jpa_models.ShoppingBag;
import com.google.inject.Inject;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

/**
 * Created by mtaboubi on 16-07-16.
 */
public class MemberRepositoryImp implements MemberRepository {

    private Provider<EntityManager> emProvider;

    @Inject
    public MemberRepositoryImp(Provider<EntityManager> emProvider) {
        this.emProvider = emProvider;
    }

    public Member find(final String id) {
        return getEntityManager().find(Member.class, id);
    }


    public List<Member> listAllMembers() {
        TypedQuery<Member> q = getEntityManager()
                .createQuery("select e from Member e", Member.class);
        return q.getResultList();
    }

    public void resetMembersDB() {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        getEntityManager().createQuery("DELETE FROM Member e").executeUpdate();

        for (int i = 0; i < 10; i++) {

            Set<Product> products = new HashSet<>();

            ShoppingBag s = new ShoppingBag(products);
            em.persist(s);
            Member m = new Member("Member_" + i);
            s.setMember(m);

            m = new Member("Member_" + i);
            s.setMember(m);
            save(m);
        }
        em.flush();
        em.getTransaction().commit();
    }

    public EntityManager getEntityManager() {
        return emProvider.get();
    }

    public void save(Member object) {
        getEntityManager().persist(object);
    }

    public void saveInNewTransaction(Member object) {
        getEntityManager().getTransaction().begin();
        save(object);
        getEntityManager().getTransaction().commit();
    }

}
