package ca.products.jpa_models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by mtaboubi on 16-07-14.
 */
@Entity
@Table(name = "shopping_bag")
public class ShoppingBag {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToMany
    @JoinColumn(name="Product_id")
    Set<Product> product;

    private Date addingDate;

    public ShoppingBag() {
    }



    public long getId() {
        return id;
    }

    public ShoppingBag(Set<Product> product, Date addingDate) {
        this.product = product;
        this.addingDate = addingDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }
}
