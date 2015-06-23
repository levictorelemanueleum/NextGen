/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;



import entities.User;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nextgen_team
 */
@Named
@ViewScoped
public class SessionController implements Serializable {

    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }
    
    public void verifySession(){
        FacesContext context =FacesContext.getCurrentInstance();
        try{
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            if (session != null && !session.isNew()){
                User user = (User)context.getExternalContext().getSessionMap().get("user");
            
                if (user==null){
                    context.getExternalContext().invalidateSession();
                    context.getExternalContext().redirect("login.xhtml");
                }
            }else{
                context.getExternalContext().invalidateSession();
                context.getExternalContext().redirect("login.xhtml");
            }
        }catch(IOException e){
        }
    }
    
    public void verifySession2(){
        FacesContext context =FacesContext.getCurrentInstance();
        try{
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            if (session != null && !session.isNew()){
                User user = (User)context.getExternalContext().getSessionMap().get("user");
            
                if (user==null){
                    context.getExternalContext().redirect("./../../login.xhtml");
                }
            }else{
                context.getExternalContext().redirect("./../../login.xhtml");
            }
        }catch(IOException e){
        }
    }
}
