/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author levictore
 */
@Entity
@Table(name = "candidate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c"),
    @NamedQuery(name = "Candidate.findByIdcandidate", query = "SELECT c FROM Candidate c WHERE c.idcandidate = :idcandidate"),
    @NamedQuery(name = "Candidate.findByName", query = "SELECT c FROM Candidate c WHERE c.name = :name"),
    @NamedQuery(name = "Candidate.findByDegree", query = "SELECT c FROM Candidate c WHERE c.degree = :degree"),
    @NamedQuery(name = "Candidate.findByNationality", query = "SELECT c FROM Candidate c WHERE c.nationality = :nationality"),
    @NamedQuery(name = "Candidate.findByDateofbirth", query = "SELECT c FROM Candidate c WHERE c.dateofbirth = :dateofbirth"),
    @NamedQuery(name = "Candidate.findByGender", query = "SELECT c FROM Candidate c WHERE c.gender = :gender"),
    @NamedQuery(name = "Candidate.findByAddress", query = "SELECT c FROM Candidate c WHERE c.address = :address"),
    @NamedQuery(name = "Candidate.findByEmail", query = "SELECT c FROM Candidate c WHERE c.email = :email"),
    @NamedQuery(name = "Candidate.findByTelephone", query = "SELECT c FROM Candidate c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Candidate.findByMaritalstatus", query = "SELECT c FROM Candidate c WHERE c.maritalstatus = :maritalstatus"),
    @NamedQuery(name = "Candidate.findByStartingdate", query = "SELECT c FROM Candidate c WHERE c.startingdate = :startingdate")})
public class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcandidate")
    private Integer idcandidate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "degree")
    private String degree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nationality")
    private String nationality;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private char gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maritalstatus")
    private char maritalstatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startingdate")
    @Temporal(TemporalType.DATE)
    private Date startingdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcandidate")
    private Collection<Costsheet> costsheetCollection;

    public Candidate() {
    }

    public Candidate(Integer idcandidate) {
        this.idcandidate = idcandidate;
    }

    public Candidate(Integer idcandidate, String name, String degree, String nationality, Date dateofbirth, char gender, String address, String email, String telephone, char maritalstatus, Date startingdate) {
        this.idcandidate = idcandidate;
        this.name = name;
        this.degree = degree;
        this.nationality = nationality;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.maritalstatus = maritalstatus;
        this.startingdate = startingdate;
    }

    public Integer getIdcandidate() {
        return idcandidate;
    }

    public void setIdcandidate(Integer idcandidate) {
        this.idcandidate = idcandidate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public char getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(char maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public Date getStartingdate() {
        return startingdate;
    }

    public void setStartingdate(Date startingdate) {
        this.startingdate = startingdate;
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
        hash += (idcandidate != null ? idcandidate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidate)) {
            return false;
        }
        Candidate other = (Candidate) object;
        if ((this.idcandidate == null && other.idcandidate != null) || (this.idcandidate != null && !this.idcandidate.equals(other.idcandidate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Candidate[ idcandidate=" + idcandidate + " ]";
    }
    
}
