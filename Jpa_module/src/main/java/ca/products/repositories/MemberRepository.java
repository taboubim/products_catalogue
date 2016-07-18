package ca.products.repositories;

import ca.products.jpa_models.Member;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by mtaboubi on 16-07-16.
 */
public interface MemberRepository {


    void saveInNewTransaction(Member object);

    List<Member> listAllMembers();

    void save(Member object);

    EntityManager getEntityManager();

    void resetMembersDB();
}
