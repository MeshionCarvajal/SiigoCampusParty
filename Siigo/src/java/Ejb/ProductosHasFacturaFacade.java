/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import Modelo.ProductosHasFactura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author meshion
 */
@Stateless
public class ProductosHasFacturaFacade extends AbstractFacade<ProductosHasFactura> implements ProductosHasFacturaFacadeLocal {

    @PersistenceContext(unitName = "SiigoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosHasFacturaFacade() {
        super(ProductosHasFactura.class);
    }

    @Override
    public List<ProductosHasFactura> ListarProductos() throws Exception {
        List<ProductosHasFactura> list = null;
        String consulta;
        try {
            consulta = "SELECT p FROM ProductosHasFactura p";
            Query query = em.createQuery(consulta);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("error al listar :" + e);
        }
        return list;
    }

}
