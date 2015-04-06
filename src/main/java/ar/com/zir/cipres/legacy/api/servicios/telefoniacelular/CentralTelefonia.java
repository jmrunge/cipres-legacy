/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

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
 * @author jmrunge
 */
@Entity
@Table(name = "CENTRAL_TELEFONIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentralTelefonia.findAll", query = "SELECT c FROM CentralTelefonia c"),
    @NamedQuery(name = "CentralTelefonia.findByIdcentral", query = "SELECT c FROM CentralTelefonia c WHERE c.idcentral = :idcentral"),
    @NamedQuery(name = "CentralTelefonia.findByDescripcion", query = "SELECT c FROM CentralTelefonia c WHERE c.descripcion = :descripcion")})
public class CentralTelefonia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_central")
    private Short idcentral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcentral")
    private Collection<CableTelefonico> cableTelefonicoCollection;

    public CentralTelefonia() {
    }

    public CentralTelefonia(Short idcentral) {
        this.idcentral = idcentral;
    }

    public CentralTelefonia(Short idcentral, String descripcion) {
        this.idcentral = idcentral;
        this.descripcion = descripcion;
    }

    public Short getIdcentral() {
        return idcentral;
    }

    public void setIdcentral(Short idcentral) {
        this.idcentral = idcentral;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<CableTelefonico> getCableTelefonicoCollection() {
        return cableTelefonicoCollection;
    }

    public void setCableTelefonicoCollection(Collection<CableTelefonico> cableTelefonicoCollection) {
        this.cableTelefonicoCollection = cableTelefonicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcentral != null ? idcentral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentralTelefonia)) {
            return false;
        }
        CentralTelefonia other = (CentralTelefonia) object;
        if ((this.idcentral == null && other.idcentral != null) || (this.idcentral != null && !this.idcentral.equals(other.idcentral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.CentralTelefonia[ idcentral=" + idcentral + " ]";
    }
    
}
