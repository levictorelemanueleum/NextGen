/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author levictore
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "pngPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public User findByUserAndPassword(String usr, String password) {
        User us;
        try{
            us = (User) em.createNamedQuery("User.findByUserAndPassword")
                                        .setParameter("user", usr)
                                        .setParameter("password", password).getSingleResult();
            return us;
        }catch(Exception e){
            return null;
        }    
    }
}
