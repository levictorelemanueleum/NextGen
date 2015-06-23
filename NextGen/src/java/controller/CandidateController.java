package controller;

import entities.Candidate;
import facades.CandidateFacade;
import controller.util.JsfUtil;
import extradata.AdditionalData;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

/**
 * @version 7.01
 * @author nextgen_team
 */

@Named("candidateController")
@SessionScoped
public class CandidateController implements Serializable {

    private Candidate current;
    private ArrayList<Candidate> items = null;
    private List<Candidate> elements;
    @EJB
    private facades.CandidateFacade ejbFacade;
    private String maritaldetail;
    private String genderdetail;
    private String birthdetail;
    private String startdetail;
    private Date today, maxdate;
    private Calendar lastdate;
    private AdditionalData additional= new AdditionalData();

    public CandidateController() {
    }
    
    @PostConstruct
    public void setday(){
        today = new Date();
        lastdate = Calendar.getInstance();
        lastdate.add(Calendar.YEAR,-10);
        maxdate = lastdate.getTime();
    }
    
    private void setDetails(Date dateofbirth, char gender, char marital, Date startingdate){
        int mar;
        try{
            mar = Integer.parseInt(""+marital);
        }catch(NumberFormatException f){
            mar = 0;
        }
        this.maritaldetail = additional.getMaritals()[mar].getLabel();
        
        try{
            mar = Integer.parseInt(""+gender);
        }catch(NumberFormatException f){
            mar = 0;
        }
        this.genderdetail = additional.getGenders()[mar].getLabel();
        
        this.birthdetail = DateFormat(dateofbirth);
        this.startdetail = DateFormat(startingdate);
    }

    public Date getMaxdate() {
        return maxdate;
    }

    public void setMaxdate(Date maxdate) {
        this.maxdate = maxdate;
    }
    
    /**
     * Tranform the date format to US.format
     * @param date Date to tranform
     * @return String
     */
    public String DateFormat(Date date){
        String dat;
        try{
            DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);
            dat = df3.format(date).toUpperCase();
        }catch(Exception e){
            dat = "";
        }
        return dat;
    }
    
    public Candidate getSelected() {
        setDetails(current.getDateofbirth(), current.getGender(), current.getMaritalstatus(), current.getStartingdate());
        return current;
    }

    private CandidateFacade getFacade() {
        return ejbFacade;
    }

    public String prepareList() {
        recreateModel();
        getItems();
        return "listcandidate.xhtml?faces-redirect=true";
    }

    public String prepareView(int index) {
        current = getCandidate(index);
        return "viewcandidate.xhtml?faces-redirect=true";
    }

    public String prepareCreate() {
        current = new Candidate();
        return "createcandidate.xhtml?faces-redirect=true";
    }

    public String create() {
        try {
            current.setDegree(current.getDegree().toUpperCase());
            current.setAddress(current.getAddress().toUpperCase());
            current.setName(current.getName().toUpperCase());
            current.setStartingdate(today);
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("CandidateCreated"));
            current = new Candidate();
            return "createcandidate.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit(int index) {
        current = getCandidate(index);
        return "updatecandidate.xhtml?faces-redirect=true";
    }

    public String update() {
        try {
            current.setName(current.getName().toUpperCase());
            current.setDegree(current.getDegree().toUpperCase());
            current.setAddress(current.getAddress().toUpperCase());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("CandidateUpdated"));
            return "viewcandidate.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public ArrayList<Candidate> getItems() {
        getCandidates();
        return items;
    }


    public void getCandidates(){
        if (items == null) {
            items = new ArrayList<>();
        }
        items.clear();
        elements = getFacade().findAll();
        for (Candidate c: elements){        
            items.add(c);
        }
    }

    private void recreateModel() {
        items = null;
    }

    public String getMaritaldetail() {
        return maritaldetail;
    }

    public void setMaritaldetail(String maritaldetail) {
        this.maritaldetail = maritaldetail;
    }

    public String getGenderdetail() {
        return genderdetail;
    }

    public void setGenderdetail(String genderdetail) {
        this.genderdetail = genderdetail;
    }

    public String getStartdetail() {
        return startdetail;
    }

    public void setStartdetail(String startdetail) {
        this.startdetail = startdetail;
    }

    public String getBirthdetail() {
        return birthdetail;
    }

    public void setBirthdetail(String birthdetail) {
        this.birthdetail = birthdetail;
    }

    public List<SelectItem> getItemsMenu() {
        List<SelectItem> selectItems = new ArrayList<>();
        elements = getFacade().findAll();
        for (Candidate c: elements){ 
            SelectItem item = new  SelectItem(c.getIdcandidate().toString(), c.getName());
            selectItems.add(item);
        }
        return selectItems;
    }
    
    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Candidate getCandidate(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Candidate.class)
    public static class CandidateControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CandidateController controller = (CandidateController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "candidateController");
            return controller.getCandidate(getKey(value));
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
            if (object instanceof Candidate) {
                Candidate o = (Candidate) object;
                return getStringKey(o.getIdcandidate());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Candidate.class.getName());
            }
        }

    }

}
