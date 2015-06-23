/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.util.JsfUtil;
import entities.User;
import facades.UserFacade;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author nextgen_team
 */
@Named
@SessionScoped
public class LoginController implements Serializable {
    private User current;
    @EJB
    private facades.UserFacade ejbFacade;
    private String namedetail;
    private int ismenu[];
    
    
    public User getSelected() {
        if (current==null)
            current = new User();
        
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
    
    public String getNamedetail() {
        return namedetail;
    }
    
    public String prepareLogin(){
        current = getLogin(current.getUser(), current.getPassword());
        if (current!=null){
            //Session
            namedetail = current.getName().split("\\ ")[0];
            if (current.getType()=='1')// admin
                ismenu= new int[]{1,1,1,1,1,1,1};
            else //general
                ismenu= new int[]{0,1,1,1,1,1,1};
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/conf").getString("LoginSuccess"));
            return "index.xhtml?faces-redirect=true";
        }else{
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/conf").getString("LoginErrorOccured"));
            return null;
        }
    }
    
    public User getLogin(java.lang.String user, java.lang.String password) {
        return getFacade().findByUserAndPassword(user, password);
    }
    
    public String prepareExit(){
        current = new User();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }
}
