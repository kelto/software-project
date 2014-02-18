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
public class OrderedProductPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "User_order_id")
    private int userorderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_id")
    private int productid;

    public OrderedProductPK() {
    }

    public OrderedProductPK(int userorderid, int productid) {
        this.userorderid = userorderid;
        this.productid = productid;
    }

    public int getUserorderid() {
        return userorderid;
    }

    public void setUserorderid(int userorderid) {
        this.userorderid = userorderid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userorderid;
        hash += (int) productid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderedProductPK)) {
            return false;
        }
        OrderedProductPK other = (OrderedProductPK) object;
        if (this.userorderid != other.userorderid) {
            return false;
        }
        if (this.productid != other.productid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderedProductPK[ userorderid=" + userorderid + ", productid=" + productid + " ]";
    }
    
}
