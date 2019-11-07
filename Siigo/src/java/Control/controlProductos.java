/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Ejb.ProductosFacadeLocal;
import Modelo.Productos;
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
@Named
@ViewScoped
public class controlProductos implements Serializable {

    @EJB
    private ProductosFacadeLocal productosEJB;
    private Productos productos;
    private FacesContext context;

    @PostConstruct
    public void init() {
        productos = new Productos();
        context = FacesContext.getCurrentInstance();
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public void agregar() {
        try {
            if (!productos.getProNombre().equals("") || productos.getProPrecio() > 0
                    || !productos.getProDescripcion().equals("")
                    || !productos.getIdEmpresa().equals(0)) {
                productosEJB.create(productos);
                productos = new Productos();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrado exitosamente", ""));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar", ""));

            }
        } catch (Exception e) {
            System.out.println("error al agregar " + e);
        }
    }

    public void listar() {
        productosEJB.findAll();
    }

    public void update(Productos item) throws Exception {
        try {
//            editamos
            productosEJB.edit(item);
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
