/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import entities.Parameter;
import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author levictore
 */
@Stateless
public class ParameterFacade extends AbstractFacade<Parameter> {
    @PersistenceContext(unitName = "pngPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParameterFacade() {
        super(Parameter.class);
    }
      
    public List<Parameter> findByType(int type) {
        List<Parameter> list=null;
        try{
            list = (List<Parameter>)em.createNamedQuery("Parameter.findByType")
                                        .setParameter("type", type).getResultList();
            if (list!=null){
            for(Parameter p:list){
                System.out.println("--"+p.getDescription());
            }}else{
                System.out.println("Nullllllo");
            }
            return list;
        }catch(Exception e){
            return null;
        }    
    }
}