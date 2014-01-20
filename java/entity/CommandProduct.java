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
@Table(name = "Command_Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommandProduct.findAll", query = "SELECT c FROM CommandProduct c"),
    @NamedQuery(name = "CommandProduct.findByCommand", query = "SELECT c FROM CommandProduct c WHERE c.commandProductPK.command = :command"),
    @NamedQuery(name = "CommandProduct.findByProduct", query = "SELECT c FROM CommandProduct c WHERE c.commandProductPK.product = :product"),
    @NamedQuery(name = "CommandProduct.findByAmountProduct", query = "SELECT c FROM CommandProduct c WHERE c.amountProduct = :amountProduct")})
public class CommandProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommandProductPK commandProductPK;
    @Column(name = "amount_product")
    private Integer amountProduct;
    @JoinColumn(name = "product", referencedColumnName = "idProduct", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product1;
    @JoinColumn(name = "command", referencedColumnName = "idCommand", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Command command1;

    public CommandProduct() {
    }

    public CommandProduct(CommandProductPK commandProductPK) {
        this.commandProductPK = commandProductPK;
    }

    public CommandProduct(int command, int product) {
        this.commandProductPK = new CommandProductPK(command, product);
    }

    public CommandProductPK getCommandProductPK() {
        return commandProductPK;
    }

    public void setCommandProductPK(CommandProductPK commandProductPK) {
        this.commandProductPK = commandProductPK;
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

    public Command getCommand1() {
        return command1;
    }

    public void setCommand1(Command command1) {
        this.command1 = command1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commandProductPK != null ? commandProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandProduct)) {
            return false;
        }
        CommandProduct other = (CommandProduct) object;
        if ((this.commandProductPK == null && other.commandProductPK != null) || (this.commandProductPK != null && !this.commandProductPK.equals(other.commandProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CommandProduct[ commandProductPK=" + commandProductPK + " ]";
    }
    
}
