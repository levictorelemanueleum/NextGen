/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author levictore
 */
@Entity
@Table(name = "costsheet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costsheet.findAll", query = "SELECT c FROM Costsheet c"),
    @NamedQuery(name = "Costsheet.findByIdcostsheet", query = "SELECT c FROM Costsheet c WHERE c.idcostsheet = :idcostsheet"),
    @NamedQuery(name = "Costsheet.findByDate", query = "SELECT c FROM Costsheet c WHERE c.date = :date"),
    @NamedQuery(name = "Costsheet.findByAcountmanager", query = "SELECT c FROM Costsheet c WHERE c.acountmanager = :acountmanager"),
    @NamedQuery(name = "Costsheet.findByRecruites", query = "SELECT c FROM Costsheet c WHERE c.recruites = :recruites"),
    @NamedQuery(name = "Costsheet.findByTypecostsheet", query = "SELECT c FROM Costsheet c WHERE c.typecostsheet = :typecostsheet"),
    @NamedQuery(name = "Costsheet.findBySrprojectnumber", query = "SELECT c FROM Costsheet c WHERE c.srprojectnumber = :srprojectnumber"),
    @NamedQuery(name = "Costsheet.findByStartdate", query = "SELECT c FROM Costsheet c WHERE c.startdate = :startdate"),
    @NamedQuery(name = "Costsheet.findByEnddate", query = "SELECT c FROM Costsheet c WHERE c.enddate = :enddate"),
    @NamedQuery(name = "Costsheet.findByPayrate", query = "SELECT c FROM Costsheet c WHERE c.payrate = :payrate"),
    @NamedQuery(name = "Costsheet.findByBillrate", query = "SELECT c FROM Costsheet c WHERE c.billrate = :billrate"),
    @NamedQuery(name = "Costsheet.findByIdparameter", query = "SELECT c FROM Costsheet c WHERE c.idparameter = :idparameter"),
    @NamedQuery(name = "Costsheet.findByOvertimestatus", query = "SELECT c FROM Costsheet c WHERE c.overtimestatus = :overtimestatus"),
    @NamedQuery(name = "Costsheet.findByIdstatecost", query = "SELECT c FROM Costsheet c WHERE c.idstatecost = :idstatecost"),
    @NamedQuery(name = "Costsheet.findByStateload", query = "SELECT c FROM Costsheet c WHERE c.stateload = :stateload"),
    @NamedQuery(name = "Costsheet.findByAdditionalcost", query = "SELECT c FROM Costsheet c WHERE c.additionalcost = :additionalcost"),
    @NamedQuery(name = "Costsheet.findByPdtypeofrate", query = "SELECT c FROM Costsheet c WHERE c.pdtypeofrate = :pdtypeofrate"),
    @NamedQuery(name = "Costsheet.findByPdrate", query = "SELECT c FROM Costsheet c WHERE c.pdrate = :pdrate"),
    @NamedQuery(name = "Costsheet.findByPdlengtth", query = "SELECT c FROM Costsheet c WHERE c.pdlengtth = :pdlengtth"),
    @NamedQuery(name = "Costsheet.findByPddatebegin", query = "SELECT c FROM Costsheet c WHERE c.pddatebegin = :pddatebegin"),
    @NamedQuery(name = "Costsheet.findByPddeletecostdate", query = "SELECT c FROM Costsheet c WHERE c.pddeletecostdate = :pddeletecostdate"),
    @NamedQuery(name = "Costsheet.findByPdhrcostamort", query = "SELECT c FROM Costsheet c WHERE c.pdhrcostamort = :pdhrcostamort"),
    @NamedQuery(name = "Costsheet.findByPdtotal", query = "SELECT c FROM Costsheet c WHERE c.pdtotal = :pdtotal"),
    @NamedQuery(name = "Costsheet.findByRtype", query = "SELECT c FROM Costsheet c WHERE c.rtype = :rtype"),
    @NamedQuery(name = "Costsheet.findByRamount", query = "SELECT c FROM Costsheet c WHERE c.ramount = :ramount"),
    @NamedQuery(name = "Costsheet.findByRdeletecostdate", query = "SELECT c FROM Costsheet c WHERE c.rdeletecostdate = :rdeletecostdate"),
    @NamedQuery(name = "Costsheet.findByRhrcostamort", query = "SELECT c FROM Costsheet c WHERE c.rhrcostamort = :rhrcostamort"),
    @NamedQuery(name = "Costsheet.findByRtotal", query = "SELECT c FROM Costsheet c WHERE c.rtotal = :rtotal"),
    @NamedQuery(name = "Costsheet.findByTlairfare", query = "SELECT c FROM Costsheet c WHERE c.tlairfare = :tlairfare"),
    @NamedQuery(name = "Costsheet.findByTlhotel", query = "SELECT c FROM Costsheet c WHERE c.tlhotel = :tlhotel"),
    @NamedQuery(name = "Costsheet.findByTlauto", query = "SELECT c FROM Costsheet c WHERE c.tlauto = :tlauto"),
    @NamedQuery(name = "Costsheet.findByTlmeals", query = "SELECT c FROM Costsheet c WHERE c.tlmeals = :tlmeals"),
    @NamedQuery(name = "Costsheet.findByTldeletecostdate", query = "SELECT c FROM Costsheet c WHERE c.tldeletecostdate = :tldeletecostdate"),
    @NamedQuery(name = "Costsheet.findByTlhrcostamort", query = "SELECT c FROM Costsheet c WHERE c.tlhrcostamort = :tlhrcostamort"),
    @NamedQuery(name = "Costsheet.findByTltotal", query = "SELECT c FROM Costsheet c WHERE c.tltotal = :tltotal"),
    @NamedQuery(name = "Costsheet.findByRftype", query = "SELECT c FROM Costsheet c WHERE c.rftype = :rftype"),
    @NamedQuery(name = "Costsheet.findByRfamount", query = "SELECT c FROM Costsheet c WHERE c.rfamount = :rfamount"),
    @NamedQuery(name = "Costsheet.findByRfdeletecostdate", query = "SELECT c FROM Costsheet c WHERE c.rfdeletecostdate = :rfdeletecostdate"),
    @NamedQuery(name = "Costsheet.findByRfhrcostamort", query = "SELECT c FROM Costsheet c WHERE c.rfhrcostamort = :rfhrcostamort"),
    @NamedQuery(name = "Costsheet.findByRftotal", query = "SELECT c FROM Costsheet c WHERE c.rftotal = :rftotal"),
    @NamedQuery(name = "Costsheet.findByVcost", query = "SELECT c FROM Costsheet c WHERE c.vcost = :vcost"),
    @NamedQuery(name = "Costsheet.findByVdeletecostdate", query = "SELECT c FROM Costsheet c WHERE c.vdeletecostdate = :vdeletecostdate"),
    @NamedQuery(name = "Costsheet.findByVhrcostamort", query = "SELECT c FROM Costsheet c WHERE c.vhrcostamort = :vhrcostamort"),
    @NamedQuery(name = "Costsheet.findByVtotal", query = "SELECT c FROM Costsheet c WHERE c.vtotal = :vtotal"),
    @NamedQuery(name = "Costsheet.findByTpf", query = "SELECT c FROM Costsheet c WHERE c.tpf = :tpf"),
    @NamedQuery(name = "Costsheet.findByTpfdeletecostdate", query = "SELECT c FROM Costsheet c WHERE c.tpfdeletecostdate = :tpfdeletecostdate"),
    @NamedQuery(name = "Costsheet.findByTpfhrcostamort", query = "SELECT c FROM Costsheet c WHERE c.tpfhrcostamort = :tpfhrcostamort"),
    @NamedQuery(name = "Costsheet.findByTpftotal", query = "SELECT c FROM Costsheet c WHERE c.tpftotal = :tpftotal"),
    @NamedQuery(name = "Costsheet.findByTotaladditionalcost", query = "SELECT c FROM Costsheet c WHERE c.totaladditionalcost = :totaladditionalcost"),
    @NamedQuery(name = "Costsheet.findByMarkup", query = "SELECT c FROM Costsheet c WHERE c.markup = :markup"),
    @NamedQuery(name = "Costsheet.findByOtmarkup", query = "SELECT c FROM Costsheet c WHERE c.otmarkup = :otmarkup"),
    @NamedQuery(name = "Costsheet.findByDiscount", query = "SELECT c FROM Costsheet c WHERE c.discount = :discount"),
    @NamedQuery(name = "Costsheet.findByOtpayrate", query = "SELECT c FROM Costsheet c WHERE c.otpayrate = :otpayrate"),
    @NamedQuery(name = "Costsheet.findByOtbillratecalculated", query = "SELECT c FROM Costsheet c WHERE c.otbillratecalculated = :otbillratecalculated"),
    @NamedQuery(name = "Costsheet.findByOtbillrate", query = "SELECT c FROM Costsheet c WHERE c.otbillrate = :otbillrate"),
    @NamedQuery(name = "Costsheet.findByDiscountbillrate", query = "SELECT c FROM Costsheet c WHERE c.discountbillrate = :discountbillrate"),
    @NamedQuery(name = "Costsheet.findByDiscountotbillrate", query = "SELECT c FROM Costsheet c WHERE c.discountotbillrate = :discountotbillrate"),
    @NamedQuery(name = "Costsheet.findByVms", query = "SELECT c FROM Costsheet c WHERE c.vms = :vms"),
    @NamedQuery(name = "Costsheet.findByActualcost", query = "SELECT c FROM Costsheet c WHERE c.actualcost = :actualcost"),
    @NamedQuery(name = "Costsheet.findByTotalhourlycost", query = "SELECT c FROM Costsheet c WHERE c.totalhourlycost = :totalhourlycost"),
    @NamedQuery(name = "Costsheet.findByHourlygrossprofit", query = "SELECT c FROM Costsheet c WHERE c.hourlygrossprofit = :hourlygrossprofit"),
    @NamedQuery(name = "Costsheet.findByGrossmargin", query = "SELECT c FROM Costsheet c WHERE c.grossmargin = :grossmargin"),
    @NamedQuery(name = "Costsheet.findByDiscountgrossprofit", query = "SELECT c FROM Costsheet c WHERE c.discountgrossprofit = :discountgrossprofit"),
    @NamedQuery(name = "Costsheet.findByDiscountgrossmargin", query = "SELECT c FROM Costsheet c WHERE c.discountgrossmargin = :discountgrossmargin")})
public class Costsheet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcostsheet")
    private Integer idcostsheet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "acountmanager")
    private String acountmanager;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "recruites")
    private String recruites;
    @Basic(optional = false)
    @NotNull
    @Column(name = "typecostsheet")
    private char typecostsheet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "srprojectnumber")
    private String srprojectnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payrate")
    private double payrate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "billrate")
    private double billrate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idparameter")
    private short idparameter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "overtimestatus")
    private char overtimestatus='0';
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "idstatecost")
    private String idstatecost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stateload")
    private float stateload;
    @Basic(optional = false)
    @NotNull
    @Column(name = "additionalcost")
    private char additionalcost;
    @Column(name = "pdtypeofrate")
    private Character pdtypeofrate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pdrate")
    private Float pdrate;
    @Column(name = "pdlengtth")
    private Integer pdlengtth;
    @Column(name = "pddatebegin")
    @Temporal(TemporalType.DATE)
    private Date pddatebegin;
    @Column(name = "pddeletecostdate")
    @Temporal(TemporalType.DATE)
    private Date pddeletecostdate;
    @Column(name = "pdhrcostamort")
    private Float pdhrcostamort=936.0f;
    @Column(name = "pdtotal")
    private Float pdtotal;
    @Column(name = "rtype")
    private Character rtype;
    @Column(name = "ramount")
    private Float ramount;
    @Column(name = "rdeletecostdate")
    @Temporal(TemporalType.DATE)
    private Date rdeletecostdate;
    @Column(name = "rhrcostamort")
    private Float rhrcostamort=936.0f;
    @Column(name = "rtotal")
    private Float rtotal;
    @Column(name = "tlairfare")
    private Float tlairfare;
    @Column(name = "tlhotel")
    private Float tlhotel;
    @Column(name = "tlauto")
    private Float tlauto;
    @Column(name = "tlmeals")
    private Float tlmeals;
    @Column(name = "tldeletecostdate")
    @Temporal(TemporalType.DATE)
    private Date tldeletecostdate;
    @Column(name = "tlhrcostamort")
    private Float tlhrcostamort=936.0f;
    @Column(name = "tltotal")
    private Float tltotal;
    @Column(name = "rftype")
    private Character rftype;
    @Column(name = "rfamount")
    private Float rfamount;
    @Column(name = "rfdeletecostdate")
    @Temporal(TemporalType.DATE)
    private Date rfdeletecostdate;
    @Column(name = "rfhrcostamort")
    private Float rfhrcostamort=936.0f;
    @Column(name = "rftotal")
    private Float rftotal;
    @Column(name = "vcost")
    private Float vcost;
    @Column(name = "vdeletecostdate")
    @Temporal(TemporalType.DATE)
    private Date vdeletecostdate;
    @Column(name = "vhrcostamort")
    private Float vhrcostamort=936.0f;
    @Column(name = "vtotal")
    private Float vtotal;
    @Column(name = "tpf")
    private Float tpf;
    @Column(name = "tpfdeletecostdate")
    @Temporal(TemporalType.DATE)
    private Date tpfdeletecostdate;
    @Column(name = "tpfhrcostamort")
    private Float tpfhrcostamort=936.0f;
    @Column(name = "tpftotal")
    private Float tpftotal;
    @Column(name = "totaladditionalcost")
    private Float totaladditionalcost=0.0f;
    @Basic(optional = false)
    @NotNull
    @Column(name = "markup")
    private float markup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otmarkup")
    private float otmarkup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private float discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otpayrate")
    private float otpayrate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otbillratecalculated")
    private short otbillratecalculated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otbillrate")
    private float otbillrate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discountbillrate")
    private float discountbillrate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discountotbillrate")
    private float discountotbillrate;
    @Column(name = "vms")
    private Integer vms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actualcost")
    private float actualcost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalhourlycost")
    private float totalhourlycost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hourlygrossprofit")
    private float hourlygrossprofit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grossmargin")
    private float grossmargin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discountgrossprofit")
    private float discountgrossprofit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discountgrossmargin")
    private float discountgrossmargin;
    @JoinColumn(name = "idclient", referencedColumnName = "idclient")
    @ManyToOne(optional = false)
    private Client idclient;
    @JoinColumn(name = "idcandidate", referencedColumnName = "idcandidate")
    @ManyToOne(optional = false)
    private Candidate idcandidate;

    public Costsheet() {
    }

    public Costsheet(Integer idcostsheet) {
        this.idcostsheet = idcostsheet;
    }

    public Costsheet(Integer idcostsheet, Date date, String acountmanager, String recruites, char typecostsheet, String srprojectnumber, Date startdate, Date enddate, double payrate, double billrate, short idparameter, char overtimestatus, String idstatecost, float stateload, char additionalcost, float markup, float otmarkup, float discount, float otpayrate, short otbillratecalculated, float otbillrate, float discountbillrate, float discountotbillrate, float actualcost, float totalhourlycost, float hourlygrossprofit, float grossmargin, float discountgrossprofit, float discountgrossmargin) {
        this.idcostsheet = idcostsheet;
        this.date = date;
        this.acountmanager = acountmanager;
        this.recruites = recruites;
        this.typecostsheet = typecostsheet;
        this.srprojectnumber = srprojectnumber;
        this.startdate = startdate;
        this.enddate = enddate;
        this.payrate = payrate;
        this.billrate = billrate;
        this.idparameter = idparameter;
        this.overtimestatus = overtimestatus;
        this.idstatecost = idstatecost;
        this.stateload = stateload;
        this.additionalcost = additionalcost;
        this.markup = markup;
        this.otmarkup = otmarkup;
        this.discount = discount;
        this.otpayrate = otpayrate;
        this.otbillratecalculated = otbillratecalculated;
        this.otbillrate = otbillrate;
        this.discountbillrate = discountbillrate;
        this.discountotbillrate = discountotbillrate;
        this.actualcost = actualcost;
        this.totalhourlycost = totalhourlycost;
        this.hourlygrossprofit = hourlygrossprofit;
        this.grossmargin = grossmargin;
        this.discountgrossprofit = discountgrossprofit;
        this.discountgrossmargin = discountgrossmargin;
    }

    public Integer getIdcostsheet() {
        return idcostsheet;
    }

    public void setIdcostsheet(Integer idcostsheet) {
        this.idcostsheet = idcostsheet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAcountmanager() {
        return acountmanager;
    }

    public void setAcountmanager(String acountmanager) {
        this.acountmanager = acountmanager;
    }

    public String getRecruites() {
        return recruites;
    }

    public void setRecruites(String recruites) {
        this.recruites = recruites;
    }

    public char getTypecostsheet() {
        return typecostsheet;
    }

    public void setTypecostsheet(char typecostsheet) {
        this.typecostsheet = typecostsheet;
    }

    public String getSrprojectnumber() {
        return srprojectnumber;
    }

    public void setSrprojectnumber(String srprojectnumber) {
        this.srprojectnumber = srprojectnumber;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public double getPayrate() {
        return payrate;
    }

    public void setPayrate(double payrate) {
        this.payrate = payrate;
    }

    public double getBillrate() {
        return billrate;
    }

    public void setBillrate(double billrate) {
        this.billrate = billrate;
    }

    public short getIdparameter() {
        return idparameter;
    }

    public void setIdparameter(short idparameter) {
        this.idparameter = idparameter;
    }

    public char getOvertimestatus() {
        return overtimestatus;
    }

    public void setOvertimestatus(char overtimestatus) {
        this.overtimestatus = overtimestatus;
    }

    public String getIdstatecost() {
        return idstatecost;
    }

    public void setIdstatecost(String idstatecost) {
        this.idstatecost = idstatecost;
    }

    public float getStateload() {
        return stateload;
    }

    public void setStateload(float stateload) {
        this.stateload = stateload;
    }

    public char getAdditionalcost() {
        return additionalcost;
    }

    public void setAdditionalcost(char additionalcost) {
        this.additionalcost = additionalcost;
    }

    public Character getPdtypeofrate() {
        return pdtypeofrate;
    }

    public void setPdtypeofrate(Character pdtypeofrate) {
        this.pdtypeofrate = pdtypeofrate;
    }

    public Float getPdrate() {
        return pdrate;
    }

    public void setPdrate(Float pdrate) {
        this.pdrate = pdrate;
    }

    public Integer getPdlengtth() {
        return pdlengtth;
    }

    public void setPdlengtth(Integer pdlengtth) {
        this.pdlengtth = pdlengtth;
    }

    public Date getPddatebegin() {
        return pddatebegin;
    }

    public void setPddatebegin(Date pddatebegin) {
        this.pddatebegin = pddatebegin;
    }

    public Date getPddeletecostdate() {
        return pddeletecostdate;
    }

    public void setPddeletecostdate(Date pddeletecostdate) {
        this.pddeletecostdate = pddeletecostdate;
    }

    public Float getPdhrcostamort() {
        return pdhrcostamort;
    }

    public void setPdhrcostamort(Float pdhrcostamort) {
        this.pdhrcostamort = pdhrcostamort;
    }

    public Float getPdtotal() {
        return pdtotal;
    }

    public void setPdtotal(Float pdtotal) {
        this.pdtotal = pdtotal;
    }

    public Character getRtype() {
        return rtype;
    }

    public void setRtype(Character rtype) {
        this.rtype = rtype;
    }

    public Float getRamount() {
        return ramount;
    }

    public void setRamount(Float ramount) {
        this.ramount = ramount;
    }

    public Date getRdeletecostdate() {
        return rdeletecostdate;
    }

    public void setRdeletecostdate(Date rdeletecostdate) {
        this.rdeletecostdate = rdeletecostdate;
    }

    public Float getRhrcostamort() {
        return rhrcostamort;
    }

    public void setRhrcostamort(Float rhrcostamort) {
        this.rhrcostamort = rhrcostamort;
    }

    public Float getRtotal() {
        return rtotal;
    }

    public void setRtotal(Float rtotal) {
        this.rtotal = rtotal;
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

    public Date getTldeletecostdate() {
        return tldeletecostdate;
    }

    public void setTldeletecostdate(Date tldeletecostdate) {
        this.tldeletecostdate = tldeletecostdate;
    }

    public Float getTlhrcostamort() {
        return tlhrcostamort;
    }

    public void setTlhrcostamort(Float tlhrcostamort) {
        this.tlhrcostamort = tlhrcostamort;
    }

    public Float getTltotal() {
        return tltotal;
    }

    public void setTltotal(Float tltotal) {
        this.tltotal = tltotal;
    }

    public Character getRftype() {
        return rftype;
    }

    public void setRftype(Character rftype) {
        this.rftype = rftype;
    }

    public Float getRfamount() {
        return rfamount;
    }

    public void setRfamount(Float rfamount) {
        this.rfamount = rfamount;
    }

    public Date getRfdeletecostdate() {
        return rfdeletecostdate;
    }

    public void setRfdeletecostdate(Date rfdeletecostdate) {
        this.rfdeletecostdate = rfdeletecostdate;
    }

    public Float getRfhrcostamort() {
        return rfhrcostamort;
    }

    public void setRfhrcostamort(Float rfhrcostamort) {
        this.rfhrcostamort = rfhrcostamort;
    }

    public Float getRftotal() {
        return rftotal;
    }

    public void setRftotal(Float rftotal) {
        this.rftotal = rftotal;
    }

    public Float getVcost() {
        return vcost;
    }

    public void setVcost(Float vcost) {
        this.vcost = vcost;
    }

    public Date getVdeletecostdate() {
        return vdeletecostdate;
    }

    public void setVdeletecostdate(Date vdeletecostdate) {
        this.vdeletecostdate = vdeletecostdate;
    }

    public Float getVhrcostamort() {
        return vhrcostamort;
    }

    public void setVhrcostamort(Float vhrcostamort) {
        this.vhrcostamort = vhrcostamort;
    }

    public Float getVtotal() {
        return vtotal;
    }

    public void setVtotal(Float vtotal) {
        this.vtotal = vtotal;
    }

    public Float getTpf() {
        return tpf;
    }

    public void setTpf(Float tpf) {
        this.tpf = tpf;
    }

    public Date getTpfdeletecostdate() {
        return tpfdeletecostdate;
    }

    public void setTpfdeletecostdate(Date tpfdeletecostdate) {
        this.tpfdeletecostdate = tpfdeletecostdate;
    }

    public Float getTpfhrcostamort() {
        return tpfhrcostamort;
    }

    public void setTpfhrcostamort(Float tpfhrcostamort) {
        this.tpfhrcostamort = tpfhrcostamort;
    }

    public Float getTpftotal() {
        return tpftotal;
    }

    public void setTpftotal(Float tpftotal) {
        this.tpftotal = tpftotal;
    }

    public Float getTotaladditionalcost() {
        return totaladditionalcost;
    }

    public void setTotaladditionalcost(Float totaladditionalcost) {
        this.totaladditionalcost = totaladditionalcost;
    }

    public float getMarkup() {
        return markup;
    }

    public void setMarkup(float markup) {
        this.markup = markup;
    }

    public float getOtmarkup() {
        return otmarkup;
    }

    public void setOtmarkup(float otmarkup) {
        this.otmarkup = otmarkup;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getOtpayrate() {
        return otpayrate;
    }

    public void setOtpayrate(float otpayrate) {
        this.otpayrate = otpayrate;
    }

    public short getOtbillratecalculated() {
        return otbillratecalculated;
    }

    public void setOtbillratecalculated(short otbillratecalculated) {
        this.otbillratecalculated = otbillratecalculated;
    }

    public float getOtbillrate() {
        return otbillrate;
    }

    public void setOtbillrate(float otbillrate) {
        this.otbillrate = otbillrate;
    }

    public float getDiscountbillrate() {
        return discountbillrate;
    }

    public void setDiscountbillrate(float discountbillrate) {
        this.discountbillrate = discountbillrate;
    }

    public float getDiscountotbillrate() {
        return discountotbillrate;
    }

    public void setDiscountotbillrate(float discountotbillrate) {
        this.discountotbillrate = discountotbillrate;
    }

    public Integer getVms() {
        return vms;
    }

    public void setVms(Integer vms) {
        this.vms = vms;
    }

    public float getActualcost() {
        return actualcost;
    }

    public void setActualcost(float actualcost) {
        this.actualcost = actualcost;
    }

    public float getTotalhourlycost() {
        return totalhourlycost;
    }

    public void setTotalhourlycost(float totalhourlycost) {
        this.totalhourlycost = totalhourlycost;
    }

    public float getHourlygrossprofit() {
        return hourlygrossprofit;
    }

    public void setHourlygrossprofit(float hourlygrossprofit) {
        this.hourlygrossprofit = hourlygrossprofit;
    }

    public float getGrossmargin() {
        return grossmargin;
    }

    public void setGrossmargin(float grossmargin) {
        this.grossmargin = grossmargin;
    }

    public float getDiscountgrossprofit() {
        return discountgrossprofit;
    }

    public void setDiscountgrossprofit(float discountgrossprofit) {
        this.discountgrossprofit = discountgrossprofit;
    }

    public float getDiscountgrossmargin() {
        return discountgrossmargin;
    }

    public void setDiscountgrossmargin(float discountgrossmargin) {
        this.discountgrossmargin = discountgrossmargin;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    public Candidate getIdcandidate() {
        return idcandidate;
    }

    public void setIdcandidate(Candidate idcandidate) {
        this.idcandidate = idcandidate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcostsheet != null ? idcostsheet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costsheet)) {
            return false;
        }
        Costsheet other = (Costsheet) object;
        if ((this.idcostsheet == null && other.idcostsheet != null) || (this.idcostsheet != null && !this.idcostsheet.equals(other.idcostsheet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Costsheet[ idcostsheet=" + idcostsheet + " ]";
    }
    
}
