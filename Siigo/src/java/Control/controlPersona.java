/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Ejb.PersonaFacadeLocal;
import Modelo.Persona;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
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
@Named(value = "controlPersona")
@ViewScoped
public class controlPersona implements Serializable {

    @EJB
    private PersonaFacadeLocal personaEJB;
    private Persona persona;
    private FacesContext context;
    private LinkedList<Persona> listaPersonas;

    @PostConstruct
    public void init() {
        try {
//        Todas las operaciones realizadas en el FacesContext? utilizan un hilo por petición de usuario. 
//                De esta forma, no existe el problema de que múltiples peticiones de usuarios puedan producir deadlock.
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("persona", persona);
            persona = new Persona();
            context = FacesContext.getCurrentInstance();
            listaPersonas = new LinkedList<>();
        } catch (Exception e) {
            System.out.println("error al cargar en la clase controlPersona:" + e);
        }

    }

//    getter and setter
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(LinkedList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

//    FacesContext.getCurrentInstance ()
//
//    .getExternalContext().getSessionMap().put("usuario", usuarioInicioSesion);
    public void agregar() throws Exception {
        try {
            if (!persona.getPerNombre().equals("") || !persona.getPerApellido().equals("")) {
                personaEJB.create(persona);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrado exitosamente", ""));
                persona = new Persona();
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar", ""));

            }
        } catch (Exception e) {
        }
    }

    public void listar() {
        personaEJB.findAll();
    }

    public void update(Persona item) throws Exception {
        try {
//            editamos
            personaEJB.edit(item);
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
