/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author levictore
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdclient", query = "SELECT c FROM Client c WHERE c.idclient = :idclient"),
    @NamedQuery(name = "Client.findByClientname", query = "SELECT c FROM Client c WHERE c.clientname = :clientname"),
    @NamedQuery(name = "Client.findByFixedmarkup", query = "SELECT c FROM Client c WHERE c.fixedmarkup = :fixedmarkup"),
    @NamedQuery(name = "Client.findByInfomarkup", query = "SELECT c FROM Client c WHERE c.infomarkup = :infomarkup"),
    @NamedQuery(name = "Client.findByOtmarkup", query = "SELECT c FROM Client c WHERE c.otmarkup = :otmarkup"),
    @NamedQuery(name = "Client.findByOtpaybill", query = "SELECT c FROM Client c WHERE c.otpaybill = :otpaybill"),
    @NamedQuery(name = "Client.findByDiscount", query = "SELECT c FROM Client c WHERE c.discount = :discount"),
    @NamedQuery(name = "Client.findByIdvms", query = "SELECT c FROM Client c WHERE c.idvms = :idvms"),
    @NamedQuery(name = "Client.findBySub1099", query = "SELECT c FROM Client c WHERE c.sub1099 = :sub1099")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclient")
    private Integer idclient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "clientname")
    private String clientname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fixedmarkup")
    private float fixedmarkup=0.0f;
    @Basic(optional = false)
    @NotNull
    @Column(name = "infomarkup")
    private short infomarkup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otmarkup")
    private float otmarkup=0.0f;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otpaybill")
    private short otpaybill;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private float discount=0.0f;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvms")
    private int idvms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub1099")
    private char sub1099;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclient")
    private Collection<Costsheet> costsheetCollection;

    public Client() {
    }

    public Client(Integer idclient) {
        this.idclient = idclient;
    }

    public Client(Integer idclient, String clientname, float fixedmarkup, short infomarkup, float otmarkup, short otpaybill, float discount, int idvms, char sub1099) {
        this.idclient = idclient;
        this.clientname = clientname;
        this.fixedmarkup = fixedmarkup;
        this.infomarkup = infomarkup;
        this.otmarkup = otmarkup;
        this.otpaybill = otpaybill;
        this.discount = discount;
        this.idvms = idvms;
        this.sub1099 = sub1099;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public float getFixedmarkup() {
        return fixedmarkup;
    }

    public void setFixedmarkup(float fixedmarkup) {
        this.fixedmarkup = fixedmarkup;
    }

    public short getInfomarkup() {
        return infomarkup;
    }

    public void setInfomarkup(short infomarkup) {
        this.infomarkup = infomarkup;
    }

    public float getOtmarkup() {
        return otmarkup;
    }

    public void setOtmarkup(float otmarkup) {
        this.otmarkup = otmarkup;
    }

    public short getOtpaybill() {
        return otpaybill;
    }

    public void setOtpaybill(short otpaybill) {
        this.otpaybill = otpaybill;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getIdvms() {
        return idvms;
    }

    public void setIdvms(int idvms) {
        this.idvms = idvms;
    }

    public char getSub1099() {
        return sub1099;
    }

    public void setSub1099(char sub1099) {
        this.sub1099 = sub1099;
    }

    @XmlTransient
    public Collection<Costsheet> getCostsheetCollection() {
        return costsheetCollection;
    }

    public void setCostsheetCollection(Collection<Costsheet> costsheetCollection) {
        this.costsheetCollection = costsheetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclient != null ? idclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idclient == null && other.idclient != null) || (this.idclient != null && !this.idclient.equals(other.idclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Client[ idclient=" + idclient + " ]";
    }
    
}
