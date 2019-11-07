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
@Table(name = "productos_has_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosHasFactura.findAll", query = "SELECT p FROM ProductosHasFactura p")
    , @NamedQuery(name = "ProductosHasFactura.findById", query = "SELECT p FROM ProductosHasFactura p WHERE p.id = :id")})
public class ProductosHasFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;

    @JoinColumn(name = "id_factura", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Factura Factura;

    @JoinColumn(name = "id_productos", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productos Productos;

    @Column(name = "pro_cantidad")
    private int proCantidad;

    @Column(name = "pro_valorunidad")
    private float proValorUnidad;

    public ProductosHasFactura() {
    }

    public ProductosHasFactura(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Factura getFactura() {
        return Factura;
    }

    public void setFactura(Factura Factura) {
        this.Factura = Factura;
    }

    public Productos getProductos() {
        return Productos;
    }

    public void setProductos(Productos Productos) {
        this.Productos = Productos;
    }

    public int getProCantidad() {
        return proCantidad;
    }

    public void setProCantidad(int proCantidad) {
        this.proCantidad = proCantidad;
    }

    public float getProValorUnidad() {
        return proValorUnidad;
    }

    public void setProValorUnidad(float proValorUnidad) {
        this.proValorUnidad = proValorUnidad;
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
        if (!(object instanceof ProductosHasFactura)) {
            return false;
        }
        ProductosHasFactura other = (ProductosHasFactura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.ProductosHasFactura[ id=" + id + " ]";
    }

}
