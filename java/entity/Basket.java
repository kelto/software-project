/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Basket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Basket.findAll", query = "SELECT b FROM Basket b"),
    @NamedQuery(name = "Basket.findByIdBasket", query = "SELECT b FROM Basket b WHERE b.idBasket = :idBasket")})
public class Basket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBasket")
    private Integer idBasket;
    @JoinColumn(name = "idBasket", referencedColumnName = "idUser", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "basket1")
    private BasketProduct basketProduct;

    public Basket() {
    }

    public Basket(Integer idBasket) {
        this.idBasket = idBasket;
    }

    public Integer getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(Integer idBasket) {
        this.idBasket = idBasket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BasketProduct getBasketProduct() {
        return basketProduct;
    }

    public void setBasketProduct(BasketProduct basketProduct) {
        this.basketProduct = basketProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBasket != null ? idBasket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Basket)) {
            return false;
        }
        Basket other = (Basket) object;
        if ((this.idBasket == null && other.idBasket != null) || (this.idBasket != null && !this.idBasket.equals(other.idBasket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Basket[ idBasket=" + idBasket + " ]";
    }
    
}
