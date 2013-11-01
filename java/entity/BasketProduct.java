/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kelto
 */
@Entity
@Table(name = "Basket_Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BasketProduct.findAll", query = "SELECT b FROM BasketProduct b"),
    @NamedQuery(name = "BasketProduct.findByBasket", query = "SELECT b FROM BasketProduct b WHERE b.basket = :basket"),
    @NamedQuery(name = "BasketProduct.findByAmount", query = "SELECT b FROM BasketProduct b WHERE b.amount = :amount")})
public class BasketProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "basket")
    private Integer basket;
    @Column(name = "amount")
    private Integer amount;
    @JoinColumn(name = "product", referencedColumnName = "idProduct")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "basket", referencedColumnName = "idBasket", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Basket basket1;

    public BasketProduct() {
    }

    public BasketProduct(Integer basket) {
        this.basket = basket;
    }

    public Integer getBasket() {
        return basket;
    }

    public void setBasket(Integer basket) {
        this.basket = basket;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Basket getBasket1() {
        return basket1;
    }

    public void setBasket1(Basket basket1) {
        this.basket1 = basket1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (basket != null ? basket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BasketProduct)) {
            return false;
        }
        BasketProduct other = (BasketProduct) object;
        if ((this.basket == null && other.basket != null) || (this.basket != null && !this.basket.equals(other.basket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BasketProduct[ basket=" + basket + " ]";
    }
    
}
