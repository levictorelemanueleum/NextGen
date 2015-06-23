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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author levictore
 */
@Entity
@Table(name = "complementratecalculator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complementratecalculator.findAll", query = "SELECT c FROM Complementratecalculator c"),
    @NamedQuery(name = "Complementratecalculator.findByIdcomplementratecalculator", query = "SELECT c FROM Complementratecalculator c WHERE c.idcomplementratecalculator = :idcomplementratecalculator"),
    @NamedQuery(name = "Complementratecalculator.findByEmployeetype", query = "SELECT c FROM Complementratecalculator c WHERE c.employeetype = :employeetype"),
    @NamedQuery(name = "Complementratecalculator.findByPayrate", query = "SELECT c FROM Complementratecalculator c WHERE c.payrate = :payrate"),
    @NamedQuery(name = "Complementratecalculator.findByBillrate", query = "SELECT c FROM Complementratecalculator c WHERE c.billrate = :billrate"),
    @NamedQuery(name = "Complementratecalculator.findByMarkup", query = "SELECT c FROM Complementratecalculator c WHERE c.markup = :markup"),
    @NamedQuery(name = "Complementratecalculator.findByCalculatedmarkup", query = "SELECT c FROM Complementratecalculator c WHERE c.calculatedmarkup = :calculatedmarkup"),
    @NamedQuery(name = "Complementratecalculator.findByInfomarkup", query = "SELECT c FROM Complementratecalculator c WHERE c.infomarkup = :infomarkup"),
    @NamedQuery(name = "Complementratecalculator.findByOtmarkup", query = "SELECT c FROM Complementratecalculator c WHERE c.otmarkup = :otmarkup"),
    @NamedQuery(name = "Complementratecalculator.findByOtpayrate", query = "SELECT c FROM Complementratecalculator c WHERE c.otpayrate = :otpayrate"),
    @NamedQuery(name = "Complementratecalculator.findByOtbillcalculateby", query = "SELECT c FROM Complementratecalculator c WHERE c.otbillcalculateby = :otbillcalculateby"),
    @NamedQuery(name = "Complementratecalculator.findByOtbillrate", query = "SELECT c FROM Complementratecalculator c WHERE c.otbillrate = :otbillrate"),
    @NamedQuery(name = "Complementratecalculator.findByDiscount", query = "SELECT c FROM Complementratecalculator c WHERE c.discount = :discount"),
    @NamedQuery(name = "Complementratecalculator.findByDiscountbillrate", query = "SELECT c FROM Complementratecalculator c WHERE c.discountbillrate = :discountbillrate"),
    @NamedQuery(name = "Complementratecalculator.findByDicountotbillrate", query = "SELECT c FROM Complementratecalculator c WHERE c.dicountotbillrate = :dicountotbillrate"),
    @NamedQuery(name = "Complementratecalculator.findByAdditionalcost", query = "SELECT c FROM Complementratecalculator c WHERE c.additionalcost = :additionalcost"),
    @NamedQuery(name = "Complementratecalculator.findByHourlycost", query = "SELECT c FROM Complementratecalculator c WHERE c.hourlycost = :hourlycost"),
    @NamedQuery(name = "Complementratecalculator.findByMargin", query = "SELECT c FROM Complementratecalculator c WHERE c.margin = :margin"),
    @NamedQuery(name = "Complementratecalculator.findByGrossmargin", query = "SELECT c FROM Complementratecalculator c WHERE c.grossmargin = :grossmargin")})
public class Complementratecalculator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomplementratecalculator")
    private Integer idcomplementratecalculator;
    @Size(max = 20)
    @Column(name = "employeetype")
    private String employeetype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "payrate")
    private Float payrate;
    @Column(name = "billrate")
    private Float billrate;
    @Column(name = "markup")
    private Float markup;
    @Column(name = "calculatedmarkup")
    private Float calculatedmarkup;
    @Column(name = "infomarkup")
    private Short infomarkup;
    @Column(name = "otmarkup")
    private Float otmarkup;
    @Column(name = "otpayrate")
    private Float otpayrate;
    @Column(name = "otbillcalculateby")
    private Float otbillcalculateby;
    @Column(name = "otbillrate")
    private Float otbillrate;
    @Column(name = "discount")
    private Float discount;
    @Column(name = "discountbillrate")
    private Float discountbillrate;
    @Column(name = "dicountotbillrate")
    private Float dicountotbillrate;
    @Column(name = "additionalcost")
    private Float additionalcost;
    @Column(name = "hourlycost")
    private Float hourlycost;
    @Column(name = "margin")
    private Float margin;
    @Column(name = "grossmargin")
    private Float grossmargin;
    @JoinColumn(name = "idratecalculator", referencedColumnName = "idRateCalculator")
    @ManyToOne(optional = false)
    private Ratecalculator idratecalculator;

    public Complementratecalculator() {
    }

    public Complementratecalculator(Integer idcomplementratecalculator) {
        this.idcomplementratecalculator = idcomplementratecalculator;
    }

    public Integer getIdcomplementratecalculator() {
        return idcomplementratecalculator;
    }

    public void setIdcomplementratecalculator(Integer idcomplementratecalculator) {
        this.idcomplementratecalculator = idcomplementratecalculator;
    }

    public String getEmployeetype() {
        return employeetype;
    }

    public void setEmployeetype(String employeetype) {
        this.employeetype = employeetype;
    }

    public Float getPayrate() {
        return payrate;
    }

    public void setPayrate(Float payrate) {
        this.payrate = payrate;
    }

    public Float getBillrate() {
        return billrate;
    }

    public void setBillrate(Float billrate) {
        this.billrate = billrate;
    }

    public Float getMarkup() {
        return markup;
    }

    public void setMarkup(Float markup) {
        this.markup = markup;
    }

    public Float getCalculatedmarkup() {
        return calculatedmarkup;
    }

    public void setCalculatedmarkup(Float calculatedmarkup) {
        this.calculatedmarkup = calculatedmarkup;
    }

    public Short getInfomarkup() {
        return infomarkup;
    }

    public void setInfomarkup(Short infomarkup) {
        this.infomarkup = infomarkup;
    }

    public Float getOtmarkup() {
        return otmarkup;
    }

    public void setOtmarkup(Float otmarkup) {
        this.otmarkup = otmarkup;
    }

    public Float getOtpayrate() {
        return otpayrate;
    }

    public void setOtpayrate(Float otpayrate) {
        this.otpayrate = otpayrate;
    }

    public Float getOtbillcalculateby() {
        return otbillcalculateby;
    }

    public void setOtbillcalculateby(Float otbillcalculateby) {
        this.otbillcalculateby = otbillcalculateby;
    }

    public Float getOtbillrate() {
        return otbillrate;
    }

    public void setOtbillrate(Float otbillrate) {
        this.otbillrate = otbillrate;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getDiscountbillrate() {
        return discountbillrate;
    }

    public void setDiscountbillrate(Float discountbillrate) {
        this.discountbillrate = discountbillrate;
    }

    public Float getDicountotbillrate() {
        return dicountotbillrate;
    }

    public void setDicountotbillrate(Float dicountotbillrate) {
        this.dicountotbillrate = dicountotbillrate;
    }

    public Float getAdditionalcost() {
        return additionalcost;
    }

    public void setAdditionalcost(Float additionalcost) {
        this.additionalcost = additionalcost;
    }

    public Float getHourlycost() {
        return hourlycost;
    }

    public void setHourlycost(Float hourlycost) {
        this.hourlycost = hourlycost;
    }

    public Float getMargin() {
        return margin;
    }

    public void setMargin(Float margin) {
        this.margin = margin;
    }

    public Float getGrossmargin() {
        return grossmargin;
    }

    public void setGrossmargin(Float grossmargin) {
        this.grossmargin = grossmargin;
    }

    public Ratecalculator getIdratecalculator() {
        return idratecalculator;
    }

    public void setIdratecalculator(Ratecalculator idratecalculator) {
        this.idratecalculator = idratecalculator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomplementratecalculator != null ? idcomplementratecalculator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complementratecalculator)) {
            return false;
        }
        Complementratecalculator other = (Complementratecalculator) object;
        if ((this.idcomplementratecalculator == null && other.idcomplementratecalculator != null) || (this.idcomplementratecalculator != null && !this.idcomplementratecalculator.equals(other.idcomplementratecalculator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Complementratecalculator[ idcomplementratecalculator=" + idcomplementratecalculator + " ]";
    }
    
}
