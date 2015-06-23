/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author levictore
 */
@Entity
@Table(name = "statecost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statecost.findAll", query = "SELECT s FROM Statecost s"),
    @NamedQuery(name = "Statecost.findByIdstatecost", query = "SELECT s FROM Statecost s WHERE s.idstatecost = :idstatecost"),
    @NamedQuery(name = "Statecost.findByState", query = "SELECT s FROM Statecost s WHERE s.state = :state"),
    @NamedQuery(name = "Statecost.findByCost", query = "SELECT s FROM Statecost s WHERE s.cost = :cost")})
public class Statecost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "idstatecost")
    private String idstatecost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private float cost;

    public Statecost() {
    }

    public Statecost(String idstatecost) {
        this.idstatecost = idstatecost;
    }

    public Statecost(String idstatecost, String state, float cost) {
        this.idstatecost = idstatecost;
        this.state = state;
        this.cost = cost;
    }

    public String getIdstatecost() {
        return idstatecost;
    }

    public void setIdstatecost(String idstatecost) {
        this.idstatecost = idstatecost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstatecost != null ? idstatecost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statecost)) {
            return false;
        }
        Statecost other = (Statecost) object;
        if ((this.idstatecost == null && other.idstatecost != null) || (this.idstatecost != null && !this.idstatecost.equals(other.idstatecost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Statecost[ idstatecost=" + idstatecost + " ]";
    }
    
}
