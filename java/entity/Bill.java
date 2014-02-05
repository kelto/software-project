/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kelto
 */
@Entity
@Table(name = "Bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id"),
    @NamedQuery(name = "Bill.findByIsPaid", query = "SELECT b FROM Bill b WHERE b.isPaid = :isPaid"),
    @NamedQuery(name = "Bill.findByDatePayment", query = "SELECT b FROM Bill b WHERE b.datePayment = :datePayment")})
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isPaid")
    private boolean isPaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_payment")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePayment;
    @JoinColumn(name = "User_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Userorder userorderid;

    public Bill() {
    }

    public Bill(Integer id) {
        this.id = id;
    }

    public Bill(Integer id, boolean isPaid, Date datePayment) {
        this.id = id;
        this.isPaid = isPaid;
        this.datePayment = datePayment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public Userorder getUserorderid() {
        return userorderid;
    }

    public void setUserorderid(Userorder userorderid) {
        this.userorderid = userorderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bill[ id=" + id + " ]";
    }
    
}
