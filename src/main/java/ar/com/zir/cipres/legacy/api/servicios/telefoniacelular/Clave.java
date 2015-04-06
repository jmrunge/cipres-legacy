/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author jmrunge
 */
@Entity
@Table(name = "CLAVE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clave.findAll", query = "SELECT c FROM Clave c"),
    @NamedQuery(name = "Clave.findByIdclave", query = "SELECT c FROM Clave c WHERE c.idclave = :idclave"),
    @NamedQuery(name = "Clave.findByDescripcion", query = "SELECT c FROM Clave c WHERE c.descripcion = :descripcion")})
public class Clave implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_clave")
    private Short idclave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idclave")
    private Collection<TipoPrefijo> tipoPrefijoCollection;

    public Clave() {
    }

    public Clave(Short idclave) {
        this.idclave = idclave;
    }

    public Clave(Short idclave, String descripcion) {
        this.idclave = idclave;
        this.descripcion = descripcion;
    }

    public Short getIdclave() {
        return idclave;
    }

    public void setIdclave(Short idclave) {
        this.idclave = idclave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<TipoPrefijo> getTipoPrefijoCollection() {
        return tipoPrefijoCollection;
    }

    public void setTipoPrefijoCollection(Collection<TipoPrefijo> tipoPrefijoCollection) {
        this.tipoPrefijoCollection = tipoPrefijoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclave != null ? idclave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clave)) {
            return false;
        }
        Clave other = (Clave) object;
        if ((this.idclave == null && other.idclave != null) || (this.idclave != null && !this.idclave.equals(other.idclave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Clave[ idclave=" + idclave + " ]";
    }
    
}
