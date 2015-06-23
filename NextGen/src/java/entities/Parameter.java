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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "parameter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parameter.findAll", query = "SELECT p FROM Parameter p"),
    @NamedQuery(name = "Parameter.findByIdparameter", query = "SELECT p FROM Parameter p WHERE p.idparameter = :idparameter"),
    @NamedQuery(name = "Parameter.findByType", query = "SELECT p FROM Parameter p WHERE p.type = :type"),
    @NamedQuery(name = "Parameter.findByDescription", query = "SELECT p FROM Parameter p WHERE p.description = :description"),
    @NamedQuery(name = "Parameter.findByValue", query = "SELECT p FROM Parameter p WHERE p.value = :value")})
public class Parameter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparameter")
    private Short idparameter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private short type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "value")
    private String value;

    public Parameter() {
    }

    public Parameter(Short idparameter) {
        this.idparameter = idparameter;
    }

    public Parameter(Short idparameter, short type, String description, String value) {
        this.idparameter = idparameter;
        this.type = type;
        this.description = description;
        this.value = value;
    }

    public Short getIdparameter() {
        return idparameter;
    }

    public void setIdparameter(Short idparameter) {
        this.idparameter = idparameter;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparameter != null ? idparameter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter) object;
        if ((this.idparameter == null && other.idparameter != null) || (this.idparameter != null && !this.idparameter.equals(other.idparameter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Parameter[ idparameter=" + idparameter + " ]";
    }
    
}
