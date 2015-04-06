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
@Table(name = "TIPO_DIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDia.findAll", query = "SELECT t FROM TipoDia t"),
    @NamedQuery(name = "TipoDia.findByIdtipodia", query = "SELECT t FROM TipoDia t WHERE t.idtipodia = :idtipodia"),
    @NamedQuery(name = "TipoDia.findByDescripcion", query = "SELECT t FROM TipoDia t WHERE t.descripcion = :descripcion")})
public class TipoDia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_dia")
    private Short idtipodia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idtipodia")
    private Collection<TipoPrefijo> tipoPrefijoCollection;

    public TipoDia() {
    }

    public TipoDia(Short idtipodia) {
        this.idtipodia = idtipodia;
    }

    public TipoDia(Short idtipodia, String descripcion) {
        this.idtipodia = idtipodia;
        this.descripcion = descripcion;
    }

    public Short getIdtipodia() {
        return idtipodia;
    }

    public void setIdtipodia(Short idtipodia) {
        this.idtipodia = idtipodia;
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
        hash += (idtipodia != null ? idtipodia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDia)) {
            return false;
        }
        TipoDia other = (TipoDia) object;
        if ((this.idtipodia == null && other.idtipodia != null) || (this.idtipodia != null && !this.idtipodia.equals(other.idtipodia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.TipoDia[ idtipodia=" + idtipodia + " ]";
    }
    
}
