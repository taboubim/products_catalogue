package ca.products.jpa_models;

import javax.persistence.*;

/**
 * Created by mtaboubi on 16-07-15.
 */
@Entity
@Table(name = "shopping_member")
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String pseudonym;

    @OneToOne
    @JoinColumn(name="shopping_bag_id")
    ShoppingBag shoppingBag;

    public Member(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    //Useless but IntelliJ suggest that!
    public Member() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudoname) {
        this.pseudonym = pseudoname;
    }

    public ShoppingBag getShoppingBag() {
        return shoppingBag;
    }

    public void setShoppingBag(ShoppingBag shoppingBag) {
        this.shoppingBag = shoppingBag;
    }
}
