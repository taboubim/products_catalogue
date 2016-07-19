package ca.products.jpa_models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by mtaboubi on 16-07-15.
 */
@Entity
@Table(name = "shopping_member")
public class Member {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String pseudonym;

    @OneToOne(cascade=CascadeType.ALL, mappedBy = "member")
    private ShoppingBag shoppingBag;

    public Member(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    //Useless but IntelliJ suggest that!
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
