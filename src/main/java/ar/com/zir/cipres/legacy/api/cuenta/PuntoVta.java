/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.cuenta;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Martin Runge {@literal <jmrunge@gmail.com>}
 */
@Entity
@Table(name = "PUNTO_VTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntoVta.findAll", query = "SELECT p FROM PuntoVta p"),
    @NamedQuery(name = "PuntoVta.findByIdpuntovta", query = "SELECT p FROM PuntoVta p WHERE p.idpuntovta = :idpuntovta"),
    @NamedQuery(name = "PuntoVta.findByDescripcion", query = "SELECT p FROM PuntoVta p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PuntoVta.findByFacturaelectronica", query = "SELECT p FROM PuntoVta p WHERE p.facturaelectronica = :facturaelectronica")})
public class PuntoVta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_punto_vta")
    private Short idpuntovta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Factura_electronica")
    private boolean facturaelectronica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puntoVta")
    private Collection<TipoCompNumeracion> tipoCompNumeracionCollection;

    public PuntoVta() {
    }

    public PuntoVta(Short idpuntovta) {
        this.idpuntovta = idpuntovta;
    }

    public PuntoVta(Short idpuntovta, String descripcion, boolean facturaelectronica) {
        this.idpuntovta = idpuntovta;
        this.descripcion = descripcion;
        this.facturaelectronica = facturaelectronica;
    }

    public Short getIdpuntovta() {
        return idpuntovta;
    }

    public void setIdpuntovta(Short idpuntovta) {
        this.idpuntovta = idpuntovta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getFacturaelectronica() {
        return facturaelectronica;
    }

    public void setFacturaelectronica(boolean facturaelectronica) {
        this.facturaelectronica = facturaelectronica;
    }

    @XmlTransient
    public Collection<TipoCompNumeracion> getTipoCompNumeracionCollection() {
        return tipoCompNumeracionCollection;
    }

    public void setTipoCompNumeracionCollection(Collection<TipoCompNumeracion> tipoCompNumeracionCollection) {
        this.tipoCompNumeracionCollection = tipoCompNumeracionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpuntovta != null ? idpuntovta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntoVta)) {
            return false;
        }
        PuntoVta other = (PuntoVta) object;
        if ((this.idpuntovta == null && other.idpuntovta != null) || (this.idpuntovta != null && !this.idpuntovta.equals(other.idpuntovta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.cuenta.PuntoVta[ idpuntovta=" + idpuntovta + " ]";
    }
    
}
