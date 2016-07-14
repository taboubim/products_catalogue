package ca.products.jpa_models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mtaboubi on 16-07-14.
 */
@Entity
@Table(name = "shopping_bag")
public class ShoppingBag {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name="Product_id")
    Product product;

    private Date addingDate;

    public ShoppingBag() {
    }

    public ShoppingBag(Product product, Date addingDate) {
        this.product = product;
        this.addingDate = addingDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }
}
