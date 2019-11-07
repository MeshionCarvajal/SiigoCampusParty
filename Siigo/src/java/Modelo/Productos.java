/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author meshion
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findById", query = "SELECT p FROM Productos p WHERE p.id = :id")
    , @NamedQuery(name = "Productos.findByProNombre", query = "SELECT p FROM Productos p WHERE p.proNombre = :proNombre")
    , @NamedQuery(name = "Productos.findByProDescripcion", query = "SELECT p FROM Productos p WHERE p.proDescripcion = :proDescripcion")
    , @NamedQuery(name = "Productos.findByProPrecio", query = "SELECT p FROM Productos p WHERE p.proPrecio = :proPrecio")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)

    @Column(name = "pro_nombre")
    private String proNombre;
    @Basic(optional = false)

    @Column(name = "pro_descripcion")
    private String proDescripcion;
    @Basic(optional = false)

    @Column(name = "pro_precio")
    private float proPrecio;
    
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa idEmpresa;
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona Persona;

    public Productos() {
    }

    public Productos(Integer id) {
        this.id = id;
    }

    public Productos(Integer id, String proNombre, String proDescripcion, float proPrecio) {
        this.id = id;
        this.proNombre = proNombre;
        this.proDescripcion = proDescripcion;
        this.proPrecio = proPrecio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public float getProPrecio() {
        return proPrecio;
    }

    public void setProPrecio(float proPrecio) {
        this.proPrecio = proPrecio;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Productos[ id=" + id + " ]";
    }

}
