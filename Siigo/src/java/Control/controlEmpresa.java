/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Ejb.EmpresaFacade;
import Ejb.EmpresaFacadeLocal;
import Modelo.Empresa;
import Modelo.Persona;
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
@Named(value = "controlEmpresa")
@ViewScoped
public class controlEmpresa implements Serializable {

    @EJB
    private EmpresaFacadeLocal empresaEJB;
    private Empresa empresa;
    private FacesContext context;

    @PostConstruct
    public void init() {
        empresa = new Empresa();
        context = FacesContext.getCurrentInstance();
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void agregar() {
        try {
            if (!empresa.getEmpNombre().equals("")) {
                empresaEJB.create(empresa);

                empresa = new Empresa();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrado exitosamente", ""));
            } else {
            }
        } catch (Exception e) {
            System.out.println("error al agregar " + e);
        }
    }

    public void listar() {
        empresaEJB.findAll();
    }

    public void update(Empresa item) throws Exception {
        try {
//            editamos
            empresaEJB.edit(item);
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
