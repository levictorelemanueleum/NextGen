/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import entities.Costsheet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mauro
 */
@Stateless
public class CostsheetFacade extends AbstractFacade<Costsheet> {
    @PersistenceContext(unitName = "pngPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CostsheetFacade() {
        super(Costsheet.class);
    }
    
}
