/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kelto
 */
@Entity
@Table(name = "Basket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Basket.findAll", query = "SELECT b FROM Basket b"),
    @NamedQuery(name = "Basket.findByUser", query = "SELECT b FROM Basket b WHERE b.basketPK.user = :user"),
    @NamedQuery(name = "Basket.findByProduct", query = "SELECT b FROM Basket b WHERE b.basketPK.product = :product"),
    @NamedQuery(name = "Basket.findByAmountProduct", query = "SELECT b FROM Basket b WHERE b.amountProduct = :amountProduct")})
public class Basket implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BasketPK basketPK;
    @Column(name = "amount_product")
    private Integer amountProduct;
    @JoinColumn(name = "product", referencedColumnName = "idProduct", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product1;
    @JoinColumn(name = "user", referencedColumnName = "idUser", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;

    public Basket() {
    }

    public Basket(BasketPK basketPK) {
        this.basketPK = basketPK;
    }

    public Basket(int user, int product) {
        this.basketPK = new BasketPK(user, product);
    }

    public BasketPK getBasketPK() {
        return basketPK;
    }

    public void setBasketPK(BasketPK basketPK) {
        this.basketPK = basketPK;
    }

    public Integer getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(Integer amountProduct) {
        this.amountProduct = amountProduct;
    }

    public Product getProduct1() {
        return product1;
    }

    public void setProduct1(Product product1) {
        this.product1 = product1;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (basketPK != null ? basketPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Basket)) {
            return false;
        }
        Basket other = (Basket) object;
        if ((this.basketPK == null && other.basketPK != null) || (this.basketPK != null && !this.basketPK.equals(other.basketPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Basket[ basketPK=" + basketPK + " ]";
    }
    
}
