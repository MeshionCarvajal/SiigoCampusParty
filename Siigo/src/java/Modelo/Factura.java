/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author meshion
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.id = :id")
    , @NamedQuery(name = "Factura.findByFacFecha", query = "SELECT f FROM Factura f WHERE f.facFecha = :facFecha")
    , @NamedQuery(name = "Factura.findByFacNumero", query = "SELECT f FROM Factura f WHERE f.facNumero = :facNumero")
    , @NamedQuery(name = "Factura.findByFacDescuento", query = "SELECT f FROM Factura f WHERE f.facDescuento = :facDescuento")
    , @NamedQuery(name = "Factura.findByFacIva", query = "SELECT f FROM Factura f WHERE f.facIva = :facIva")
    , @NamedQuery(name = "Factura.findByFacTotal", query = "SELECT f FROM Factura f WHERE f.facTotal = :facTotal")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)

    @Column(name = "fac_fecha")
    @Temporal(TemporalType.DATE)
    private Date facFecha;
    @Basic(optional = false)

    @Column(name = "fac_numero")
    private String facNumero;

    @Basic(optional = false)
    @Column(name = "fac_descuento")
    private int facDescuento;

    @Column(name = "fac_iva")
    private int facIva;
    @Basic(optional = false)

    @Column(name = "fac_total")
    private int facTotal;

    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa Empresa;

    public Factura() {
    }

    public Factura(Integer id) {
        this.id = id;
    }

    public Factura(Integer id, Date facFecha, String facNumero, int facDescuento, int facIva, int facTotal) {
        this.id = id;
        this.facFecha = facFecha;
        this.facNumero = facNumero;
        this.facDescuento = facDescuento;
        this.facIva = facIva;
        this.facTotal = facTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFacFecha() {
        return facFecha;
    }

    public void setFacFecha(Date facFecha) {
        this.facFecha = facFecha;
    }

    public String getFacNumero() {
        return facNumero;
    }

    public void setFacNumero(String facNumero) {
        this.facNumero = facNumero;
    }

    public int getFacDescuento() {
        return facDescuento;
    }

    public void setFacDescuento(int facDescuento) {
        this.facDescuento = facDescuento;
    }

    public int getFacIva() {
        return facIva;
    }

    public void setFacIva(int facIva) {
        this.facIva = facIva;
    }

    public int getFacTotal() {
        return facTotal;
    }

    public void setFacTotal(int facTotal) {
        this.facTotal = facTotal;
    }

    public Empresa getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(Empresa Empresa) {
        this.Empresa = Empresa;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Factura[ id=" + id + " ]";
    }

}
