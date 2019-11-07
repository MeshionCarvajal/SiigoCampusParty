/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Ejb.FacturaFacadeLocal;
import Modelo.Factura;
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
@Named(value = "controlFactura")
@ViewScoped
public class controlFactura implements Serializable {

    @EJB
    private FacturaFacadeLocal facturaEJB;
    private Factura factura;
    private FacesContext context;

    @PostConstruct
    public void init() {
        context = FacesContext.getCurrentInstance();
        factura = new Factura();
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void agregar() {
        try {
            if (!factura.getFacNumero().equals("") || factura.getFacTotal() > 0
                    || factura.getFacIva() > 0) {

                facturaEJB.create(factura);
                factura = new Factura();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrado exitosamente", ""));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar", ""));

            }
        } catch (Exception e) {
            System.out.println("error al agregar " + e);
        }
    }

    public void listar() {
        facturaEJB.findAll();
    }

    public void update(Factura item) throws Exception {
        try {
//            editamos
            facturaEJB.edit(item);
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
