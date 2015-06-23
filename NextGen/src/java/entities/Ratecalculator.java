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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ratecalculator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ratecalculator.findAll", query = "SELECT r FROM Ratecalculator r"),
    @NamedQuery(name = "Ratecalculator.findByIdRateCalculator", query = "SELECT r FROM Ratecalculator r WHERE r.idRateCalculator = :idRateCalculator"),
    @NamedQuery(name = "Ratecalculator.findByFixedmarkup", query = "SELECT r FROM Ratecalculator r WHERE r.fixedmarkup = :fixedmarkup"),
    @NamedQuery(name = "Ratecalculator.findByPayrate", query = "SELECT r FROM Ratecalculator r WHERE r.payrate = :payrate"),
    @NamedQuery(name = "Ratecalculator.findBySalary", query = "SELECT r FROM Ratecalculator r WHERE r.salary = :salary"),
    @NamedQuery(name = "Ratecalculator.findByBillrate", query = "SELECT r FROM Ratecalculator r WHERE r.billrate = :billrate"),
    @NamedQuery(name = "Ratecalculator.findByMargin", query = "SELECT r FROM Ratecalculator r WHERE r.margin = :margin"),
    @NamedQuery(name = "Ratecalculator.findByBssit", query = "SELECT r FROM Ratecalculator r WHERE r.bssit = :bssit"),
    @NamedQuery(name = "Ratecalculator.findByIdstatecost", query = "SELECT r FROM Ratecalculator r WHERE r.idstatecost = :idstatecost"),
    @NamedQuery(name = "Ratecalculator.findByCost", query = "SELECT r FROM Ratecalculator r WHERE r.cost = :cost"),
    @NamedQuery(name = "Ratecalculator.findByPdtype", query = "SELECT r FROM Ratecalculator r WHERE r.pdtype = :pdtype"),
    @NamedQuery(name = "Ratecalculator.findByPdrate", query = "SELECT r FROM Ratecalculator r WHERE r.pdrate = :pdrate"),
    @NamedQuery(name = "Ratecalculator.findByPdlength", query = "SELECT r FROM Ratecalculator r WHERE r.pdlength = :pdlength"),
    @NamedQuery(name = "Ratecalculator.findByPddate", query = "SELECT r FROM Ratecalculator r WHERE r.pddate = :pddate"),
    @NamedQuery(name = "Ratecalculator.findByPddeletedate", query = "SELECT r FROM Ratecalculator r WHERE r.pddeletedate = :pddeletedate"),
    @NamedQuery(name = "Ratecalculator.findByPdhoursforcostamort", query = "SELECT r FROM Ratecalculator r WHERE r.pdhoursforcostamort = :pdhoursforcostamort"),
    @NamedQuery(name = "Ratecalculator.findByPdcost", query = "SELECT r FROM Ratecalculator r WHERE r.pdcost = :pdcost"),
    @NamedQuery(name = "Ratecalculator.findByRtype", query = "SELECT r FROM Ratecalculator r WHERE r.rtype = :rtype"),
    @NamedQuery(name = "Ratecalculator.findByRamount", query = "SELECT r FROM Ratecalculator r WHERE r.ramount = :ramount"),
    @NamedQuery(name = "Ratecalculator.findByRdeletedate", query = "SELECT r FROM Ratecalculator r WHERE r.rdeletedate = :rdeletedate"),
    @NamedQuery(name = "Ratecalculator.findByRhoursforcostamort", query = "SELECT r FROM Ratecalculator r WHERE r.rhoursforcostamort = :rhoursforcostamort"),
    @NamedQuery(name = "Ratecalculator.findByRcost", query = "SELECT r FROM Ratecalculator r WHERE r.rcost = :rcost"),
    @NamedQuery(name = "Ratecalculator.findByTlairfare", query = "SELECT r FROM Ratecalculator r WHERE r.tlairfare = :tlairfare"),
    @NamedQuery(name = "Ratecalculator.findByTlhotel", query = "SELECT r FROM Ratecalculator r WHERE r.tlhotel = :tlhotel"),
    @NamedQuery(name = "Ratecalculator.findByTlauto", query = "SELECT r FROM Ratecalculator r WHERE r.tlauto = :tlauto"),
    @NamedQuery(name = "Ratecalculator.findByTlmeals", query = "SELECT r FROM Ratecalculator r WHERE r.tlmeals = :tlmeals"),
    @NamedQuery(name = "Ratecalculator.findByTldeletedate", query = "SELECT r FROM Ratecalculator r WHERE r.tldeletedate = :tldeletedate"),
    @NamedQuery(name = "Ratecalculator.findByTlhoursforcostamort", query = "SELECT r FROM Ratecalculator r WHERE r.tlhoursforcostamort = :tlhoursforcostamort"),
    @NamedQuery(name = "Ratecalculator.findByTlcost", query = "SELECT r FROM Ratecalculator r WHERE r.tlcost = :tlcost"),
    @NamedQuery(name = "Ratecalculator.findByRftype", query = "SELECT r FROM Ratecalculator r WHERE r.rftype = :rftype"),
    @NamedQuery(name = "Ratecalculator.findByRfamount", query = "SELECT r FROM Ratecalculator r WHERE r.rfamount = :rfamount"),
    @NamedQuery(name = "Ratecalculator.findByRfdeletedate", query = "SELECT r FROM Ratecalculator r WHERE r.rfdeletedate = :rfdeletedate"),
    @NamedQuery(name = "Ratecalculator.findByRfhourforcostamort", query = "SELECT r FROM Ratecalculator r WHERE r.rfhourforcostamort = :rfhourforcostamort"),
    @NamedQuery(name = "Ratecalculator.findByRfcost", query = "SELECT r FROM Ratecalculator r WHERE r.rfcost = :rfcost"),
    @NamedQuery(name = "Ratecalculator.findByTpf", query = "SELECT r FROM Ratecalculator r WHERE r.tpf = :tpf"),
    @NamedQuery(name = "Ratecalculator.findByTpfdeletedate", query = "SELECT r FROM Ratecalculator r WHERE r.tpfdeletedate = :tpfdeletedate"),
    @NamedQuery(name = "Ratecalculator.findByTpfhoursforcostamort", query = "SELECT r FROM Ratecalculator r WHERE r.tpfhoursforcostamort = :tpfhoursforcostamort"),
    @NamedQuery(name = "Ratecalculator.findByTpfcost", query = "SELECT r FROM Ratecalculator r WHERE r.tpfcost = :tpfcost"),
    @NamedQuery(name = "Ratecalculator.findByVt", query = "SELECT r FROM Ratecalculator r WHERE r.vt = :vt"),
    @NamedQuery(name = "Ratecalculator.findByVtdeletedate", query = "SELECT r FROM Ratecalculator r WHERE r.vtdeletedate = :vtdeletedate"),
    @NamedQuery(name = "Ratecalculator.findByVthoursforcostamort", query = "SELECT r FROM Ratecalculator r WHERE r.vthoursforcostamort = :vthoursforcostamort"),
    @NamedQuery(name = "Ratecalculator.findByVtcost", query = "SELECT r FROM Ratecalculator r WHERE r.vtcost = :vtcost"),
    @NamedQuery(name = "Ratecalculator.findByTotaladditionalcost", query = "SELECT r FROM Ratecalculator r WHERE r.totaladditionalcost = :totaladditionalcost")})
public class Ratecalculator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRateCalculator")
    private Integer idRateCalculator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fixedmarkup")
    private float fixedmarkup;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "payrate")
    private Float payrate;
    @Column(name = "salary")
    private Float salary;
    @Column(name = "billrate")
    private Float billrate;
    @Column(name = "margin")
    private Float margin;
    @Column(name = "bssit")
    private Character bssit;
    @Size(max = 2)
    @Column(name = "idstatecost")
    private String idstatecost;
    @Column(name = "cost")
    private Float cost;
    @Column(name = "pdtype")
    private Float pdtype;
    @Column(name = "pdrate")
    private Float pdrate;
    @Column(name = "pdlength")
    private Float pdlength;
    @Column(name = "pddate")
    @Temporal(TemporalType.DATE)
    private Date pddate;
    @Column(name = "pddeletedate")
    @Temporal(TemporalType.DATE)
    private Date pddeletedate;
    @Column(name = "pdhoursforcostamort")
    private Float pdhoursforcostamort;
    @Column(name = "pdcost")
    private Float pdcost;
    @Column(name = "rtype")
    private Float rtype;
    @Column(name = "ramount")
    private Float ramount;
    @Column(name = "rdeletedate")
    @Temporal(TemporalType.DATE)
    private Date rdeletedate;
    @Column(name = "rhoursforcostamort")
    private Float rhoursforcostamort;
    @Column(name = "rcost")
    private Float rcost;
    @Column(name = "tlairfare")
    private Float tlairfare;
    @Column(name = "tlhotel")
    private Float tlhotel;
    @Column(name = "tlauto")
    private Float tlauto;
    @Column(name = "tlmeals")
    private Float tlmeals;
    @Column(name = "tldeletedate")
    @Temporal(TemporalType.DATE)
    private Date tldeletedate;
    @Column(name = "tlhoursforcostamort")
    private Float tlhoursforcostamort;
    @Column(name = "tlcost")
    private Float tlcost;
    @Column(name = "rftype")
    private Float rftype;
    @Column(name = "rfamount")
    private Float rfamount;
    @Column(name = "rfdeletedate")
    @Temporal(TemporalType.DATE)
    private Date rfdeletedate;
    @Column(name = "rfhourforcostamort")
    private Float rfhourforcostamort;
    @Column(name = "rfcost")
    private Float rfcost;
    @Column(name = "tpf")
    private Float tpf;
    @Column(name = "tpfdeletedate")
    @Temporal(TemporalType.DATE)
    private Date tpfdeletedate;
    @Column(name = "tpfhoursforcostamort")
    private Float tpfhoursforcostamort;
    @Column(name = "tpfcost")
    private Float tpfcost;
    @Column(name = "vt")
    private Float vt;
    @Column(name = "vtdeletedate")
    @Temporal(TemporalType.DATE)
    private Date vtdeletedate;
    @Column(name = "vthoursforcostamort")
    private Float vthoursforcostamort;
    @Column(name = "vtcost")
    private Float vtcost;
    @Column(name = "totaladditionalcost")
    private Float totaladditionalcost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idratecalculator")
    private Collection<Complementratecalculator> complementratecalculatorCollection;
    @JoinColumn(name = "idclient", referencedColumnName = "idclient")
    @ManyToOne(optional = false)
    private Client idclient;

    public Ratecalculator() {
    }

    public Ratecalculator(Integer idRateCalculator) {
        this.idRateCalculator = idRateCalculator;
    }

    public Ratecalculator(Integer idRateCalculator, float fixedmarkup) {
        this.idRateCalculator = idRateCalculator;
        this.fixedmarkup = fixedmarkup;
    }

    public Integer getIdRateCalculator() {
        return idRateCalculator;
    }

    public void setIdRateCalculator(Integer idRateCalculator) {
        this.idRateCalculator = idRateCalculator;
    }

    public float getFixedmarkup() {
        return fixedmarkup;
    }

    public void setFixedmarkup(float fixedmarkup) {
        this.fixedmarkup = fixedmarkup;
    }

    public Float getPayrate() {
        return payrate;
    }

    public void setPayrate(Float payrate) {
        this.payrate = payrate;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Float getBillrate() {
        return billrate;
    }

    public void setBillrate(Float billrate) {
        this.billrate = billrate;
    }

    public Float getMargin() {
        return margin;
    }

    public void setMargin(Float margin) {
        this.margin = margin;
    }

    public Character getBssit() {
        return bssit;
    }

    public void setBssit(Character bssit) {
        this.bssit = bssit;
    }

    public String getIdstatecost() {
        return idstatecost;
    }

    public void setIdstatecost(String idstatecost) {
        this.idstatecost = idstatecost;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getPdtype() {
        return pdtype;
    }

    public void setPdtype(Float pdtype) {
        this.pdtype = pdtype;
    }

    public Float getPdrate() {
        return pdrate;
    }

    public void setPdrate(Float pdrate) {
        this.pdrate = pdrate;
    }

    public Float getPdlength() {
        return pdlength;
    }

    public void setPdlength(Float pdlength) {
        this.pdlength = pdlength;
    }

    public Date getPddate() {
        return pddate;
    }

    public void setPddate(Date pddate) {
        this.pddate = pddate;
    }

    public Date getPddeletedate() {
        return pddeletedate;
    }

    public void setPddeletedate(Date pddeletedate) {
        this.pddeletedate = pddeletedate;
    }

    public Float getPdhoursforcostamort() {
        return pdhoursforcostamort;
    }

    public void setPdhoursforcostamort(Float pdhoursforcostamort) {
        this.pdhoursforcostamort = pdhoursforcostamort;
    }

    public Float getPdcost() {
        return pdcost;
    }

    public void setPdcost(Float pdcost) {
        this.pdcost = pdcost;
    }

    public Float getRtype() {
        return rtype;
    }

    public void setRtype(Float rtype) {
        this.rtype = rtype;
    }

    public Float getRamount() {
        return ramount;
    }

    public void setRamount(Float ramount) {
        this.ramount = ramount;
    }

    public Date getRdeletedate() {
        return rdeletedate;
    }

    public void setRdeletedate(Date rdeletedate) {
        this.rdeletedate = rdeletedate;
    }

    public Float getRhoursforcostamort() {
        return rhoursforcostamort;
    }

    public void setRhoursforcostamort(Float rhoursforcostamort) {
        this.rhoursforcostamort = rhoursforcostamort;
    }

    public Float getRcost() {
        return rcost;
    }

    public void setRcost(Float rcost) {
        this.rcost = rcost;
    }

    public Float getTlairfare() {
        return tlairfare;
    }

    public void setTlairfare(Float tlairfare) {
        this.tlairfare = tlairfare;
    }

    public Float getTlhotel() {
        return tlhotel;
    }

    public void setTlhotel(Float tlhotel) {
        this.tlhotel = tlhotel;
    }

    public Float getTlauto() {
        return tlauto;
    }

    public void setTlauto(Float tlauto) {
        this.tlauto = tlauto;
    }

    public Float getTlmeals() {
        return tlmeals;
    }

    public void setTlmeals(Float tlmeals) {
        this.tlmeals = tlmeals;
    }

    public Date getTldeletedate() {
        return tldeletedate;
    }

    public void setTldeletedate(Date tldeletedate) {
        this.tldeletedate = tldeletedate;
    }

    public Float getTlhoursforcostamort() {
        return tlhoursforcostamort;
    }

    public void setTlhoursforcostamort(Float tlhoursforcostamort) {
        this.tlhoursforcostamort = tlhoursforcostamort;
    }

    public Float getTlcost() {
        return tlcost;
    }

    public void setTlcost(Float tlcost) {
        this.tlcost = tlcost;
    }

    public Float getRftype() {
        return rftype;
    }

    public void setRftype(Float rftype) {
        this.rftype = rftype;
    }

    public Float getRfamount() {
        return rfamount;
    }

    public void setRfamount(Float rfamount) {
        this.rfamount = rfamount;
    }

    public Date getRfdeletedate() {
        return rfdeletedate;
    }

    public void setRfdeletedate(Date rfdeletedate) {
        this.rfdeletedate = rfdeletedate;
    }

    public Float getRfhourforcostamort() {
        return rfhourforcostamort;
    }

    public void setRfhourforcostamort(Float rfhourforcostamort) {
        this.rfhourforcostamort = rfhourforcostamort;
    }

    public Float getRfcost() {
        return rfcost;
    }

    public void setRfcost(Float rfcost) {
        this.rfcost = rfcost;
    }

    public Float getTpf() {
        return tpf;
    }

    public void setTpf(Float tpf) {
        this.tpf = tpf;
    }

    public Date getTpfdeletedate() {
        return tpfdeletedate;
    }

    public void setTpfdeletedate(Date tpfdeletedate) {
        this.tpfdeletedate = tpfdeletedate;
    }

    public Float getTpfhoursforcostamort() {
        return tpfhoursforcostamort;
    }

    public void setTpfhoursforcostamort(Float tpfhoursforcostamort) {
        this.tpfhoursforcostamort = tpfhoursforcostamort;
    }

    public Float getTpfcost() {
        return tpfcost;
    }

    public void setTpfcost(Float tpfcost) {
        this.tpfcost = tpfcost;
    }

    public Float getVt() {
        return vt;
    }

    public void setVt(Float vt) {
        this.vt = vt;
    }

    public Date getVtdeletedate() {
        return vtdeletedate;
    }

    public void setVtdeletedate(Date vtdeletedate) {
        this.vtdeletedate = vtdeletedate;
    }

    public Float getVthoursforcostamort() {
        return vthoursforcostamort;
    }

    public void setVthoursforcostamort(Float vthoursforcostamort) {
        this.vthoursforcostamort = vthoursforcostamort;
    }

    public Float getVtcost() {
        return vtcost;
    }

    public void setVtcost(Float vtcost) {
        this.vtcost = vtcost;
    }

    public Float getTotaladditionalcost() {
        return totaladditionalcost;
    }

    public void setTotaladditionalcost(Float totaladditionalcost) {
        this.totaladditionalcost = totaladditionalcost;
    }

    @XmlTransient
    public Collection<Complementratecalculator> getComplementratecalculatorCollection() {
        return complementratecalculatorCollection;
    }

    public void setComplementratecalculatorCollection(Collection<Complementratecalculator> complementratecalculatorCollection) {
        this.complementratecalculatorCollection = complementratecalculatorCollection;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRateCalculator != null ? idRateCalculator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratecalculator)) {
            return false;
        }
        Ratecalculator other = (Ratecalculator) object;
        if ((this.idRateCalculator == null && other.idRateCalculator != null) || (this.idRateCalculator != null && !this.idRateCalculator.equals(other.idRateCalculator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ratecalculator[ idRateCalculator=" + idRateCalculator + " ]";
    }
    
}
