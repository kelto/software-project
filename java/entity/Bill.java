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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Bill.findByIdBill", query = "SELECT b FROM Bill b WHERE b.idBill = :idBill"),
    @NamedQuery(name = "Bill.findByTotalPrice", query = "SELECT b FROM Bill b WHERE b.totalPrice = :totalPrice"),
    @NamedQuery(name = "Bill.findByIspaid", query = "SELECT b FROM Bill b WHERE b.ispaid = :ispaid"),
    @NamedQuery(name = "Bill.findByDatePayment", query = "SELECT b FROM Bill b WHERE b.datePayment = :datePayment")})
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBill")
    private Integer idBill;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "ispaid")
    private Boolean ispaid;
    @Column(name = "date_payment")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePayment;
    @JoinColumn(name = "command", referencedColumnName = "idCommand")
    @ManyToOne
    private Command command;

    public Bill() {
    }

    public Bill(Integer idBill) {
        this.idBill = idBill;
    }

    public Integer getIdBill() {
        return idBill;
    }

    public void setIdBill(Integer idBill) {
        this.idBill = idBill;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getIspaid() {
        return ispaid;
    }

    public void setIspaid(Boolean ispaid) {
        this.ispaid = ispaid;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBill != null ? idBill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.idBill == null && other.idBill != null) || (this.idBill != null && !this.idBill.equals(other.idBill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bill[ idBill=" + idBill + " ]";
    }
    
}
