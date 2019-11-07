/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Ejb.ProductosHasFacturaFacadeLocal;
import Modelo.ProductosHasFactura;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author meshion
 */
@Named(value = "controlProductosFactura")
@ViewScoped
public class controlProductosFactura implements Serializable {

    @EJB
    private ProductosHasFacturaFacadeLocal productosHasFacturaEJB;
    private ProductosHasFactura productosHasFactura;
    private FacesContext context;

    @PostConstruct
    public void init() {
        productosHasFactura = new ProductosHasFactura();
        context = FacesContext.getCurrentInstance();
    }

    public ProductosHasFactura getProductosHasFactura() {
        return productosHasFactura;
    }

    public void setProductosHasFactura(ProductosHasFactura productosHasFactura) {
        this.productosHasFactura = productosHasFactura;
    }

    public void agregar() {
        try {
            if (!productosHasFactura.getFactura().equals(null)
                    || !productosHasFactura.getProductos().equals(null)) {
                productosHasFacturaEJB.create(productosHasFactura);

                productosHasFactura = new ProductosHasFactura();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrado exitosamente", ""));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar", ""));

            }
        } catch (Exception e) {
            System.out.println("error al agregar " + e);
        }
    }

    public void listar() {
        productosHasFacturaEJB.findAll();
    }

    public void update(ProductosHasFactura item) throws Exception {
        try {
//            editamos
            productosHasFacturaEJB.edit(item);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion del sistema", "Actualizacion Exitosa "));

        } catch (Exception e) {
            System.out.println("Error update controlpersona : " + e);
        }

    }

    public void cancelar(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion del sistema", "Actualizacion Cancelada"));
    }

}
