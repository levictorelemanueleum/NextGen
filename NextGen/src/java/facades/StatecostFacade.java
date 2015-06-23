/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import entities.Statecost;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author levictore
 */
@Stateless
public class StatecostFacade extends AbstractFacade<Statecost> {
    @PersistenceContext(unitName = "pngPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatecostFacade() {
        super(Statecost.class);
    }
    
}
