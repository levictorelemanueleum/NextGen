package controller;

import entities.Parameter;
import controller.util.JsfUtil;
import extradata.AdditionalData;
import facades.ParameterFacade;

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
@Named("parameterController")
@SessionScoped
public class ParameterController implements Serializable {

    private Parameter current;
    private ArrayList<Parameter> items = null;
    private List<Parameter> elements;
    @EJB
    private facades.ParameterFacade ejbFacade;
    private float value = 0.0f;
    private String typedetail;
    private AdditionalData additional = new AdditionalData();

    public ParameterController() {
    }

    public Parameter getSelected() {
        if (current == null){
            current = new Parameter();
            value=0.0f;
        }
        
        typedetail = additional.getParams()[0].getLabel();
        return current;
    }

    private ParameterFacade getFacade() {
        return ejbFacade;
    }

    public String getTypedetail() {
        return typedetail;
    }

    public void setTypedetail(String typedetail) {
        this.typedetail = typedetail;
    }
    
    public String prepareList() {
        recreateModel();
        getParameters();
        return "listparameter.xhtml?faces-redirect=true";
    }

    public String prepareView(Short key) {
        current = getFacade().find(key);
        return "viewparameter.xhtml?faces-redirect=true";
    }

    public String prepareCreate() {
        current = new Parameter();
        value=0.0f;
        return "createparameter.xhtml?faces-redirect=true";
    }

    public String create() {
        try {
            current.setValue(String.valueOf(value));
            current.setDescription(current.getDescription().toUpperCase());
            
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("ParameterCreated"));
            current = new Parameter();
            value=0.0f;
            return "createparameter.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit(Short key) {
        current = getFacade().find(key);
        value = Float.valueOf(current.getValue());
        return "updateparameter.xhtml?faces-redirect=true";
    }

    public String update() {
        try {
            current.setValue(String.valueOf(value));
            
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("ParameterUpdated"));
            return "viewparameter.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

     public void getParameters() {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.clear();
        elements = getFacade().findAll();
        for (Parameter c: elements){        
            items.add(c);
        }
    }

    public ArrayList<Parameter> getItems() {
        getParameters();
        return items;
    }

    public void setItems(ArrayList<Parameter> items) {
        this.items = items;
    }
     
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
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

    public Parameter getParameters(java.lang.Short id) {
        return ejbFacade.find(id);
    }

    public List<SelectItem> getItemsMenu(int typ){
        List<SelectItem> selectItems = new ArrayList<>();
        elements = getFacade().findByType(typ);
        for (Parameter c:elements){
            SelectItem item = new SelectItem(c.getIdparameter(), c.getDescription());
            selectItems.add(item);
        }
        return selectItems;
    }
    
    @FacesConverter(forClass = Parameter.class)
    public static class ParametersControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ParameterController controller = (ParameterController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "parametersController");
            return controller.getParameters(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Parameter) {
                Parameter o = (Parameter) object;
                return getStringKey(o.getIdparameter());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Parameter.class.getName());
            }
        }

    }
    
}
