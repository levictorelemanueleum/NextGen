package controller;

import controller.util.JsfUtil;
import entities.Candidate;
import entities.Client;
import entities.Costsheet;
import entities.Parameter;
import entities.Statecost;
import extradata.AdditionalData;
import facades.ClientFacade;
import facades.CostsheetFacade;
import facades.StatecostFacade;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named("costsheetController")
@SessionScoped
public class CostsheetController implements Serializable {

    private Costsheet current;
    private ArrayList<Costsheet> items = null;
    private List<Costsheet> elements;
    @EJB
    private facades.CostsheetFacade ejbFacade;
    @EJB
    private facades.ClientFacade cliFacade;
    @EJB
    private facades.StatecostFacade staFacade;
    @EJB
    private facades.ParameterFacade paramFacade;
    private AdditionalData additional= new AdditionalData();
     
    private Parameter paramlocal;
    private String otbillcalcdetail = "";
    private String payclassdetail = "";
    private String vmsdetail = "";
    private String employeedetail="", overtimedetail="", costsheetdetail="",
            statedetail="", pdtypeofratedetail="", rtypedetail="";

    
    public CostsheetController() {
    }
    
    public String getOtbillcalcdetail() {
        return otbillcalcdetail;
    }

    public void setOtbillcalcdetail(String otbillcalcdetail) {
        this.otbillcalcdetail = otbillcalcdetail;
    }

    public String getPayclassdetail() {
        return payclassdetail;
    }

    public void setPayclassdetail(String payclassdetail) {
        this.payclassdetail = payclassdetail;
    }

    public Costsheet getSelected() {
        if (current == null) {
            current = new Costsheet();
            current.setIdclient(new Client());
            current.setIdcandidate(new Candidate());
        }else{
            if (current.getIdcandidate()==null)
                current.setIdcandidate(new Candidate());
            if (current.getIdclient()==null)
                current.setIdclient(new Client());
            
            if (current.getIdcostsheet()!=null){
                employeedetail = paramFacade.find(current.getIdparameter()).getDescription();
                /*payclassdetail = paramFacade.find(current.getIdparameter()).getDescription();*/
                overtimedetail = additional.getOvertimes()[Integer.valueOf(""+current.getOvertimestatus())].getLabel();
                costsheetdetail = additional.getCostsheets()[Integer.valueOf(""+current.getTypecostsheet())].getLabel();
                statedetail = staFacade.find(current.getIdstatecost()).getState();
                
                try{
                    pdtypeofratedetail = additional.getPierrates()[Integer.valueOf(""+current.getPdtypeofrate())].getLabel();
                }catch(Exception e){
                    pdtypeofratedetail = "";
                }
                try{
                    rtypedetail = additional.getRelocas()[Integer.parseInt(""+current.getRtype())].getLabel();
                }catch(Exception e){
                    rtypedetail= "";
                }
            }
        }
        return current;
    }
    
    public String getEmployeedetail() {
        return employeedetail;
    }

    public void setEmployeedetail(String employeedetail) {
        this.employeedetail = employeedetail;
    }

    public String getOvertimedetail() {
        return overtimedetail;
    }

    public void setOvertimedetail(String overtimedetail) {
        this.overtimedetail = overtimedetail;
    }

    public String getCostsheetdetail() {
        return costsheetdetail;
    }

    public void setCostsheetdetail(String costsheetdetail) {
        this.costsheetdetail = costsheetdetail;
    }

    public String getStatedetail() {
        return statedetail;
    }

    public void setStatedetail(String statedetail) {
        this.statedetail = statedetail;
    }

    public String getPdtypeofratedetail() {
        return pdtypeofratedetail;
    }

    public void setPdtypeofratedetail(String pdtypeofratedetail) {
        this.pdtypeofratedetail = pdtypeofratedetail;
    }

    public String getRtypedetail() {
        return rtypedetail;
    }

    public void setRtypedetail(String rtypedetail) {
        this.rtypedetail = rtypedetail;
    }

    
    
    public String getVmsdetail() {
        return vmsdetail;
    }

    public void setVmsdetail(String vmsdetail) {
        this.vmsdetail = vmsdetail;
    }
    
    private CostsheetFacade getFacade() {
        return ejbFacade;
    }
    
    private ClientFacade getcliFacade() {
        return cliFacade;
    }

    private StatecostFacade getstaFacade() {
        return staFacade;
    }
    
    public void setPdNulleables(){
        current.setPdtypeofrate(null);
        current.setPdrate(null);
        current.setPdlengtth(null);
        current.setPddatebegin(null);
        current.setPddeletecostdate(null);
        current.setPdhrcostamort(null);
        current.setPdtotal(null);
    }
    
    public void setRNulleables(){
        current.setRtype(null);
        current.setRamount(null);
        current.setRdeletecostdate(null);
        current.setRhrcostamort(null);
        current.setRtotal(null);
    }
    
    public void setTlNulleables(){
        current.setTlairfare(null);
        current.setTlhotel(null);
        current.setTlauto(null);
        current.setTlmeals(null);
        current.setTldeletecostdate(null);
        current.setTlhrcostamort(null);
        current.setTltotal(null);
    }
    
    public void setRfNulleables(){
        current.setRftype(null);
        current.setRfamount(null);
        current.setRfdeletecostdate(null);
        current.setRfhrcostamort(null);
        current.setRftotal(null);
    }
    
    public void setVNulleables(){
        current.setVcost(null);
        current.setVdeletecostdate(null);
        current.setVhrcostamort(null);
        current.setVtotal(null);
    }
    
    public void setTpfNulleables(){
        current.setTpf(null);
        current.setTpfdeletecostdate(null);
        current.setTpfhrcostamort(null);
        current.setTpftotal(null);
    }
    
    public void setTotalNulleable(){
        current.setTotaladditionalcost(0.0f);
    }
    
    public void setDefaults(){
        if (current.getAdditionalcost()=='1'){
            current.setPdtypeofrate('0');
            current.setPdrate(0.0f);
            current.setPdlengtth(0);
            current.setPddatebegin(new Date());
            current.setPddeletecostdate(new Date());
            current.setPdhrcostamort(0.0f);
            current.setPdtotal(0.0f);

            current.setRtype('0');
            current.setRamount(0.0f);
            current.setRdeletecostdate(new Date());
            current.setRhrcostamort(0.0f);
            current.setRtotal(0.0f);

            current.setTlairfare(0.0f);
            current.setTlhotel(0.0f);
            current.setTlauto(0.0f);
            current.setTlmeals(0.0f);
            current.setTldeletecostdate(new Date());
            current.setTlhrcostamort(0.0f);
            current.setTltotal(0.0f);

            current.setRftype('0');
            current.setRfamount(0.0f);
            current.setRfdeletecostdate(new Date());
            current.setRfhrcostamort(0.0f);
            current.setRftotal(0.0f);

            current.setVcost(0.0f);
            current.setVdeletecostdate(new Date());
            current.setVhrcostamort(0.0f);
            current.setVtotal(0.0f);

            current.setTpf(0.0f);
            current.setTpfdeletecostdate(new Date());
            current.setTpfhrcostamort(0.0f);
            current.setTpftotal(0.0f);

            current.setTotaladditionalcost(0.0f);
        }else{
            setPdNulleables();
            setRNulleables();
            setTlNulleables();
            setRfNulleables();
            setVNulleables();
            setTpfNulleables();
            setTotalNulleable();
        }
    }
    
    public void showClient(){
        Client cli = getcliFacade().find(current.getIdclient().getIdclient());
        if (cli!=null){
            current.setIdclient(cli);
            otbillcalcdetail = additional.getOtpaybills()[current.getIdclient().getOtpaybill()].getLabel();
            vmsdetail = additional.getVmss()[current.getIdclient().getIdvms()].getLabel();
        }else{
            current.setIdclient(new Client());
        }
        
    }
    
    public void showStatecost()
    {
        Statecost sta = getstaFacade().find(current.getIdstatecost());
        if(sta != null)
        {
            current.setIdstatecost(sta.getIdstatecost());
            current.setStateload(sta.getCost());
        }
        
    }
    
    public String prepareList() {
        recreateModel();
        return "listcostsheet.xhtml?faces-redirect=true";
    }
    

//    public String prepareView() {
//        current = (Costsheet) getItems().getRowData();
//        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
//        return "viewcostsheet.xhtml?faces-redirect=true";
//    }

    public String prepareView(int index) {
        current = getCostsheet(index);
        return "viewcostsheet.xhtml?faces-redirect=true";
    }
    
//    public String prepareView(int index) {
//        current = getCostsheet(index);
//        setDetails(current.getIdcostsheet(), current.getIdcandidate().getName());
//        return "viewclient.xhtml?faces-redirect=true";
//    }
    
    public String prepareCreate() {
        current = new Costsheet();
        //No aditional
        current.setAdditionalcost('0');
        current.setDate(new Date());
        current.setEnddate(new Date());
        current.setStartdate(new Date());
        return "createcostsheet.xhtml?faces-redirect=true";
    }

    public String create() {
        try {
            if (current.getPdtotal()!=null){
                if (current.getPdtotal()==0.0f)
                    setPdNulleables();
            }
            if (current.getRtotal()!=null){
                if (current.getRtotal()==0.0f)
                    setRNulleables();
            }
            if (current.getTltotal()!=null){
                if (current.getTltotal()==0.0f)
                    setTlNulleables();
            }
            if (current.getRftotal()!=null){
                if (current.getRftotal()==0.0f)
                    setRfNulleables();
            }
            if (current.getVtotal()!=null){
                if (current.getVtotal()==0.0f)
                    setVNulleables();
            }
            if (current.getTpftotal()!=null){
                if (current.getTpftotal()==0.0f)
                    setTpfNulleables();
            }
            if (current.getRtotal()!=null){
                if (current.getRtotal()==0.0f)
                    setTotalNulleable();    
            }
            
            current.setDate(new Date());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("CostsheetCreated"));
            current = new Costsheet();
            return "createcostsheet.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    
    public String prepareEdit(int index) {
        current = getCostsheet(index);
        return "updatecostsheet.xhtml?faces-redirect=true";
    }

//     public String prepareEdit(int index) {
//        current = getCostsheet(index);
//        setDetails(current.getIdcostsheet(), current.getIdcandidate().getName());
//        return "updatecostsheet.xhtml?faces-redirect=true";
//    }

    
    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("CostsheetUpdated"));
            return "viewcostsheet.xhtml?faces-redirect=true";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public ArrayList<Costsheet> getItems() {
        getCostsheet();
        return items;
    }

     public void getCostsheet() {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.clear();
        elements = getFacade().findAll();
        for (Costsheet c: elements){        
            items.add(c);
        }
    }
     
     private void recreateModel() {
        items = null;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Costsheet getCostsheet(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Costsheet.class)
    public static class CostsheetControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CostsheetController controller = (CostsheetController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "costsheetController");
            return controller.getCostsheet(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Costsheet) {
                Costsheet o = (Costsheet) object;
                return getStringKey(o.getIdcostsheet());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Costsheet.class.getName());
            }
        }

    }

    public void calctotaladditionalcost()
    {
        current.setTotaladditionalcost(current.getTpftotal() +
                                       current.getVtotal() +
                                       current.getTltotal() +
                                       current.getPdtotal() +
                                       current.getRftotal() +
                                       current.getRtotal());
        calctotalhourlycost();
        
    }
    
    public void calctotalv()
    {
        current.setVtotal( current.getVcost()/ current.getVhrcostamort());
        calctotaladditionalcost();
    }
    
    public void calctotaltpf()
    {
        current.setTpftotal(current.getTpf()/ current.getTpfhrcostamort());
        calctotaladditionalcost();
    }
    
    public void calctotaltl()
    {
        current.setTltotal((current.getTlairfare()+ 
                            current.getTlhotel() + current.getTlauto()+ 
                            current.getTlmeals())/ current.getTlhrcostamort());
        calctotaladditionalcost();
    }
    
    public void calctotalrf()
    {
        current.setRftotal(current.getRfamount()/ current.getRfhrcostamort());
        calctotaladditionalcost();
    }
    
    public void calctotalr()
    {
        current.setRtotal(current.getRamount()/ current.getRhrcostamort());
        calctotaladditionalcost();
    }
    
    public void calctotalpd()
    {
        current.setPdtotal((current.getPdrate()* current.getPdlengtth())/
                           current.getPdhrcostamort());
        calctotaladditionalcost();
    }
    
    public void calcotpayrate()
    {
        current.setDiscount(current.getIdclient().getDiscount()/100);
        current.setMarkup(current.getIdclient().getFixedmarkup()/100);
        current.setOtmarkup(current.getIdclient().getOtmarkup()/100);
        current.setOtbillratecalculated(current.getIdclient().getOtpaybill());
        
        paramlocal = paramFacade.find(current.getIdparameter());
        if (paramlocal!=null){
        
        payclassdetail = paramlocal.getDescription();
        if(paramlocal.getDescription().equalsIgnoreCase("Salary"))  // == "Salary"
        {
                 current.setOtpayrate((float)current.getPayrate()/2080);
        }
        else
        {
            if(current.getOvertimestatus()=='0') // yes time and half
            { 
                
                 current.setOtpayrate((float)(current.getPayrate()*1.5));
            }else{
                 current.setOtpayrate((float)current.getPayrate());
            }
        }
        calcotbillrate();
        }
    }
    
    public void calcotbillrate()
    {
        System.out.println("ot = " + current.getOtbillratecalculated());
        System.out.println("ov = " + current.getOvertimestatus());
        if(current.getOtbillratecalculated()==1)  // == "Bill Rate"
        {
            if(current.getOvertimestatus()=='0') // yes time and half
            {    
                current.setOtbillrate((float)current.getBillrate() * ( 1 + current.getOtmarkup()));
            }else
            {
                current.setOtbillrate((float)current.getBillrate());
            }
        }else
        {
            if(current.getOtbillratecalculated()==3) // == "5% Discount- J&J"
            {
                if(current.getOvertimestatus()=='0') // yes time and half
                {
                    current.setOtbillrate((float)(current.getBillrate()*1.5*0.95));
                }else
                {
                    current.setOtbillrate((float)(current.getBillrate()*0.95));
                }
            }else
            {
                if(current.getOtbillratecalculated()==2)  //== OT Pay Rate
                {
                    if(current.getOvertimestatus()=='0') // yes time and half
                    {    
                        current.setOtbillrate((float)(current.getOtpayrate() * (1 + current.getOtmarkup())));
                    }else
                    {
                        current.setOtbillrate((float)current.getBillrate());
                    }
                }else
                {
                    if(current.getOtbillratecalculated()==5)  //== Pay Rate
                    {
                        if(current.getOvertimestatus()=='0') // yes time and half
                        {
                            current.setOtbillrate((float)(current.getPayrate() * (1 + current.getOtmarkup())));
                        }else
                        {
                            current.setOtbillrate((float)current.getPayrate());
                        }
                    }else
                    {
                        current.setOtbillrate((float)(current.getBillrate() + (current.getPayrate()/2)));
                    }
                }
            }
        }
        calcdiscountbillrate();
    }
    
    public void calcdiscountbillrate()
    {
        current.setDiscountbillrate((float)(current.getBillrate() - (current.getBillrate() * current.getDiscount())));
        current.setDiscountotbillrate((float)(current.getOtbillrate() - (current.getOtbillrate() * current.getDiscount())));
        // calcula actual cost
        if(paramlocal.getDescription().equalsIgnoreCase("Salary")) //"Salary"
        {
            List<Parameter> pl = paramFacade.findByType(1);
            current.setActualcost((float)(current.getPayrate()/Float.parseFloat(pl.get(0).getValue()) * ((Float.parseFloat(paramlocal.getValue())/100) +1)));
            //el dato 1912 se saca de parametros de Benefit hours
            //el dato 0.26 se saca de parametros de salary
        }
        else
        {
            if(paramlocal.getDescription().equalsIgnoreCase("1099")) //1099
            {
                current.setActualcost((float)(((Float.parseFloat(paramlocal.getValue())/100) +1) * current.getPayrate()));
            }else
            {
                current.setActualcost((float)(((Float.parseFloat(paramlocal.getValue())/100) +1)*current.getPayrate()));
                //el dato 0.16 se saca de parametros de hourly o 0.14 de payroll o 0.04 de subcontrator
            }
        }
        calctotalhourlycost();
        //calcula Hourly gross profit
        current.setHourlygrossprofit((float)(current.getBillrate() - current.getTotalhourlycost()));
        //calcula Gross margin
        current.setGrossmargin((float)(current.getHourlygrossprofit()/current.getBillrate())*100);
        //calcula discount gross profit y discount gross margin
        if(current.getDiscount() != 0)
        {
            current.setDiscountgrossprofit((float)(current.getDiscountbillrate() - current.getTotalhourlycost()));
            current.setDiscountgrossmargin((float)(current.getDiscountgrossprofit()/ current.getDiscountbillrate())*100);
        }
    }
    
    public void calctotalhourlycost()
    {
        current.setTotalhourlycost(current.getActualcost() + current.getTotaladditionalcost());
    }
    
}