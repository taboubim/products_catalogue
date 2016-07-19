package ca.products.jpa_models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by mtaboubi on 16-07-15.
 */
@Entity
@Table(name = "shopping_member")
public class Member {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String pseudonym;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "member")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.DELETE,
            org.hibernate.annotations.CascadeType.MERGE,
            org.hibernate.annotations.CascadeType.PERSIST,
            org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private ShoppingBag shoppingBag;

    public Member(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public Member() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public ShoppingBag getShoppingBag() {
        return shoppingBag;
    }

    public void setShoppingBag(ShoppingBag shoppingBag) {
        this.shoppingBag = shoppingBag;
    }
}
