package controller;

import controller.util.JsfUtil;
import entities.User;
import extradata.AdditionalData;
import facades.UserFacade;

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

/**
 * @version 7.01
 * @author nextgen_team
 */
@Named("userController")
@SessionScoped
public class UserController implements Serializable {
    
    private User current;
    private List<User> elements;
    private ArrayList<User> items = null;
    @EJB
    private facades.UserFacade ejbFacade;
    private String typedetail;
    private int ismenu[];
    private AdditionalData additional = new AdditionalData();

    
    public UserController() {
    }
    
    public User getSelected() {
        if (current==null){
            current = new User();
        }
        return current;
    }

    public int[] getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(int[] ismenu) {
        this.ismenu = ismenu;
    }
    
    private UserFacade getFacade() {
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
        getUsers();
        return "listuser.xhtml?faces-redirect=true";
    }

    public String prepareView(int index) {
        current = getUser(index);
        typedetail = additional.getUsertypes()[Integer.valueOf(""+current.getType())].getLabel();
        return "viewuser.xhtml?faces-redirect=true";
    }
    
    public String prepareCreate() {
        current = new User();
        return "createuser.xhtml?faces-redirect=true";
    }
    
    public String create() {
        try {
            current.setName(current.getName().toUpperCase());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("UserCreated"));
            current=new User();
            return "createuser.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit(int index) {
        current = getUser(index);
        return "updateuser.xhtml?faces-redirect=true";
    }

    public String update() {
        try {
            current.setName(current.getName().toUpperCase());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("UserUpdated"));
            return "viewuser.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/conf").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public ArrayList<User> getItems() {
        getUsers();
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    public void getUsers() {
        if (items == null) {
            items = new ArrayList<>();
        }else{
            items.clear();
            elements = getFacade().findAll();
            for (User c: elements){        
                items.add(c);
            }
        }
    }

    public User getUser(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = User.class)
    public static class UserControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UserController controller = (UserController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "userController");
            return controller.getUser(getKey(value));
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
            if (object instanceof User) {
                User o = (User) object;
                return getStringKey(o.getIduser());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + User.class.getName());
            }
        }

    }

}
