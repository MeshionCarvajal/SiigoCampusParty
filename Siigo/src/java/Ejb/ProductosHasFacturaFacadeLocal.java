/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import Modelo.ProductosHasFactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author meshion
 */
@Local
public interface ProductosHasFacturaFacadeLocal {

    void create(ProductosHasFactura productosHasFactura);

    void edit(ProductosHasFactura productosHasFactura);

    void remove(ProductosHasFactura productosHasFactura);

    ProductosHasFactura find(Object id);

    List<ProductosHasFactura> findAll();

    List<ProductosHasFactura> findRange(int[] range);

    int count();

    List<ProductosHasFactura> ListarProductos() throws Exception;

}
