package controller;

import entities.Client;
import controller.util.JsfUtil;
import extradata.AdditionalData;
import facades.ClientFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
@Named("clientController")
@SessionScoped
public class ClientController implements Serializable {

    private Client current;
    private ArrayList<Client> items = null;
    private List<Client> elements;
    @EJB
    private facades.ClientFacade ejbFacade;
    
    private AdditionalData additional = new AdditionalData();
    private String infomarkupdetail;
    private String vmsdetail;
    private String otpaybilldetail;
    private String sub1090detail;
    private int isotmarkup;
    private float otmarkup;
    private String otpdetail;
    

    public ClientController() {
    }

    public Client getSelected() {
        setDetails(current.getIdvms(), current.getInfomarkup(), current.getOtpaybill(), current.getSub1099());
        return current;
    }

    private void setDetails(int idvms, short infomarkup, short otpaybill, char sub1099){
        int sub=0;
        this.vmsdetail=additional.getVmss()[idvms].getLabel();
        this.infomarkupdetail=additional.getInfomarkups()[infomarkup].getLabel();
        this.otpaybilldetail=additional.getOtpaybills()[otpaybill].getLabel();
        
        try{
            sub = Integer.parseInt(""+sub1099);
        }catch(NumberFormatException f){
            sub=0;
        }
        
        this.sub1090detail=additional.getSub1099()[sub].getLabel();
        if (otmarkup == -1.0f)
            this.otpdetail = additional.getPagerate()[0].getLabel();
        else
            this.otpdetail = String.valueOf(otmarkup)+" %";
    }

    public void upOtmarkup(){
        if (this.isotmarkup==0){
           this.otmarkup = 0.0f;
        }else{
           if (current.getOtmarkup()!=-1.0f)
               this.otmarkup = current.getOtmarkup();
           else
               this.otmarkup = 0.0f;
        }
    }
    
    public String getOtpdetail() {
        return otpdetail;
    }

    public void setOtpdetail(String otpdetail) {
        this.otpdetail = otpdetail;
    }
    
    public float getOtmarkup() {
        return otmarkup;
    }

    public void setOtmarkup(float otmarkup) {
        this.otmarkup = otmarkup;
    }
    
    public int getIsotmarkup() {
        return isotmarkup;
    }

    public void setIsotmarkup(int isotmarkup) {
        this.isotmarkup = isotmarkup;
    }
    
    public String getInfomarkupdetail() {
        return infomarkupdetail;
    }

    public void setInfomarkupdetail(String infomarkupdetail) {
        this.infomarkupdetail = infomarkupdetail;
    }

    public String getVmsdetail() {
        return vmsdetail;
    }

    public void setVmsdetail(String vmsdetail) {
        this.vmsdetail = vmsdetail;
    }

    public String getOtpaybilldetail() {
        return otpaybilldetail;
    }

    public void setOtpaybilldetail(String otpaybilldetail) {
        this.otpaybilldetail = otpaybilldetail;
    }

    public String getSub1090detail() {
        return sub1090detail;
    }

    public void setSub1090detail(String sub1090detail) {
        this.sub1090detail = sub1090detail;
    }
    
    private ClientFacade getFacade() {
        return ejbFacade;
    }

    public String prepareList() {
        recreateModel();
        getClients();
        return "listclient.xhtml?faces-redirect=true";
    }

    public String prepareView(int index) {
        current = getClient(index);
        otmarkup = current.getOtmarkup();
        return "viewclient.xhtml?faces-redirect=true";
    }

    public String prepareCreate() {
        current = new Client();
        isotmarkup=0;
        otmarkup=0.0f;
        return "createclient.xhtml?faces-redirect=true";
    }

    public String create() {  
       try {
            if (isotmarkup==0){
                current.setOtmarkup(new Float(-1.0));
                otmarkup = current.getOtmarkup();
            }else
                current.setOtmarkup(otmarkup);
            
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("ClientCreated"));
            current = new Client();
            isotmarkup=0;
            otmarkup=0.0f;
            return "createclient.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit(int index) {
        current = getClient(index);
        otmarkup=current.getOtmarkup();
        
        if (otmarkup==-1.0f){
            isotmarkup = 0;
            otmarkup = 0.0f;
        }else
            isotmarkup = 1;
        
        return "updateclient.xhtml?faces-redirect=true";
    }

    public String update() {
        try {
            if (isotmarkup==0){
                current.setOtmarkup(new Float(-1.0));
                otmarkup = current.getOtmarkup();
            }
            else
                current.setOtmarkup(otmarkup);
            
            
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("ClientUpdated"));
            return "viewclient.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public ArrayList<Client> getItems() {
        getClients();
        return items;
    }

    public void getClients() {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.clear();
        elements = getFacade().findAll();
        for (Client c: elements){        
            items.add(c);
        }
    }

    private void recreateModel() {
        items = null;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public List<SelectItem> getItemsMenu() {
        List<SelectItem> selectItems = new ArrayList<>();
        elements = getFacade().findAll();
        for (Client c: elements){ 
            SelectItem item = new  SelectItem(c.getIdclient().toString(), c.getClientname());
            
            selectItems.add(item);
        }
        return selectItems;
    }
    
    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Client getClient(java.lang.Integer id) {
        return ejbFacade.find(id);
    }
    
    @FacesConverter(forClass = Client.class)
    public static class ClientControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClientController controller = (ClientController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clientController");
            return controller.getClient(getKey(value));
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
            if (object instanceof Client) {
                Client o = (Client) object;
                return getStringKey(o.getIdclient());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Client.class.getName());
            }
        }

    }

}
