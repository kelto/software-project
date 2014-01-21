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
public class CommandProductPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "command")
    private int command;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product")
    private int product;

    public CommandProductPK() {
    }

    public CommandProductPK(int command, int product) {
        this.command = command;
        this.product = product;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
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
        hash += (int) command;
        hash += (int) product;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandProductPK)) {
            return false;
        }
        CommandProductPK other = (CommandProductPK) object;
        if (this.command != other.command) {
            return false;
        }
        if (this.product != other.product) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CommandProductPK[ command=" + command + ", product=" + product + " ]";
    }
    
}
