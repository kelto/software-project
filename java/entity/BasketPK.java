/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kelto
 */
@Embeddable
public class BasketPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "user")
    private int user;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product")
    private int product;

    public BasketPK() {
    }

    public BasketPK(int user, int product) {
        this.user = user;
        this.product = product;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) user;
        hash += (int) product;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BasketPK)) {
            return false;
        }
        BasketPK other = (BasketPK) object;
        if (this.user != other.user) {
            return false;
        }
        if (this.product != other.product) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BasketPK[ user=" + user + ", product=" + product + " ]";
    }
    
}
