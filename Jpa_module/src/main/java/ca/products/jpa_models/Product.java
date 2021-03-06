package ca.products.jpa_models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Created by mtaboubi on 16-07-14.
 */

@Entity
@Table(name = "shopping_product")
public class Product {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;
    private String description;

    @ManyToOne(cascade=CascadeType.ALL)
    ShoppingBag shoppingBag;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

}
