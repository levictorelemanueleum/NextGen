package controller;

import entities.Statecost;
import controller.util.JsfUtil;
import facades.StatecostFacade;

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

@Named("statecostController")
@SessionScoped
public class StatecostController implements Serializable {

    private Statecost current;
    private ArrayList<Statecost> items = null;
    private List<Statecost> elements;
    @EJB
    private facades.StatecostFacade ejbFacade;

    public StatecostController() {
    }

    public Statecost getSelected() {
        if (current == null) {
            current = new Statecost();
        }
        return current;
    }

    private StatecostFacade getFacade() {
        return ejbFacade;
    }

    public String prepareList() {
        recreateModel();
        getStatecosts();
        return "liststatecost.xhtml?faces-redirect=true";
    }

    public String prepareView(String index) {
        current = getStatecost(index);
        return "viewstatecost.xhtml?faces-redirect=true";
    }

    public String prepareCreate() {
        current = new Statecost();
        return "createstatecost.xhtml?faces-redirect=true";
    }

    public String create() {
        current.setIdstatecost(current.getIdstatecost().toUpperCase());
        current.setState(current.getState().toUpperCase());
        
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("StatecostCreated"));
            current = new Statecost();
            return "createstatecost.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit(String index) {
        current = getStatecost(index);
        return "updatestatecost.xhtml?faces-redirect=true";
    }

    public String update() {
        current.setState(current.getState().toUpperCase());
        
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("StatecostUpdated"));
            return "viewstatecost.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public ArrayList<Statecost> getItems() {
        getStatecosts();
        return items;
    }
    
    private void recreateModel() {
        items = null;
    }

    public Statecost getStatecost(java.lang.String id) {
        return ejbFacade.find(id);
    }

    public void getStatecosts(){
        if (items == null) {
            items = new ArrayList<>();
        }
        items.clear();
        elements = getFacade().findAll();
        for (Statecost s: elements){        
            items.add(s);
        }
    }
    
    @FacesConverter(forClass = Statecost.class)
    public static class StatecostControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            StatecostController controller = (StatecostController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "statecostController");
            return controller.getStatecost(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Statecost) {
                Statecost o = (Statecost) object;
                return getStringKey(o.getIdstatecost());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Statecost.class.getName());
            }
        }

    }
    
     public List<SelectItem> getItemsMenu(){
        List<SelectItem> selectItems = new ArrayList<>();
        elements = getFacade().findAll();
        for (Statecost c:elements){
            SelectItem item = new SelectItem(c.getIdstatecost(), c.getState());
            selectItems.add(item);
        }
        return selectItems;
    }

}
