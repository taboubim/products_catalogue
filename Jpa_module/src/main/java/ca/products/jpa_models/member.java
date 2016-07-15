package ca.products.jpa_models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by mtaboubi on 16-07-15.
 */
@Entity
@Table(name = "shopping_member")
public class member {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String pseudoname;

    @OneToOne
    @JoinColumn(name="shopping_bag_id")
    ShoppingBag shoppingBag;

    public member(String pseudoname) {
        this.pseudoname = pseudoname;
    }

    //Useless but IntelliJ suggest that!
    public member() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPseudoname() {
        return pseudoname;
    }

    public void setPseudoname(String pseudoname) {
        this.pseudoname = pseudoname;
    }

    public ShoppingBag getShoppingBag() {
        return shoppingBag;
    }

    public void setShoppingBag(ShoppingBag shoppingBag) {
        this.shoppingBag = shoppingBag;
    }
}
