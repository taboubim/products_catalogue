package ca.products.jpa_models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mtaboubi on 16-07-14.
 */
@Entity
@Table(name = "shopping_bag")
public class ShoppingBag {


    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @OneToOne(cascade=CascadeType.ALL)
    @JsonIgnore
    private Member member;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Product> product = new HashSet<Product>();

    public ShoppingBag() {
    }

    public ShoppingBag(Set<Product> product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
