/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kelto
 */
@Entity
@Table(name = "Command")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Command.findAll", query = "SELECT c FROM Command c"),
    @NamedQuery(name = "Command.findByIdCommand", query = "SELECT c FROM Command c WHERE c.idCommand = :idCommand"),
    @NamedQuery(name = "Command.findByStatus", query = "SELECT c FROM Command c WHERE c.status = :status")})
public class Command implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCommand")
    private Integer idCommand;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "user", referencedColumnName = "idUser")
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "command1")
    private Collection<CommandProduct> commandProductCollection;
    @OneToMany(mappedBy = "command")
    private Collection<Bill> billCollection;

    public Command() {
    }

    public Command(Integer idCommand) {
        this.idCommand = idCommand;
    }

    public Integer getIdCommand() {
        return idCommand;
    }

    public void setIdCommand(Integer idCommand) {
        this.idCommand = idCommand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlTransient
    public Collection<CommandProduct> getCommandProductCollection() {
        return commandProductCollection;
    }

    public void setCommandProductCollection(Collection<CommandProduct> commandProductCollection) {
        this.commandProductCollection = commandProductCollection;
    }

    @XmlTransient
    public Collection<Bill> getBillCollection() {
        return billCollection;
    }

    public void setBillCollection(Collection<Bill> billCollection) {
        this.billCollection = billCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommand != null ? idCommand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Command)) {
            return false;
        }
        Command other = (Command) object;
        if ((this.idCommand == null && other.idCommand != null) || (this.idCommand != null && !this.idCommand.equals(other.idCommand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Command[ idCommand=" + idCommand + " ]";
    }
    
}
