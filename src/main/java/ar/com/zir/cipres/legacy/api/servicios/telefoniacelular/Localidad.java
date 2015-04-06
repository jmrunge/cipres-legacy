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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "LOCALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l"),
    @NamedQuery(name = "Localidad.findByIdprovincia", query = "SELECT l FROM Localidad l WHERE l.localidadPK.idprovincia = :idprovincia"),
    @NamedQuery(name = "Localidad.findByIdlocalidad", query = "SELECT l FROM Localidad l WHERE l.localidadPK.idlocalidad = :idlocalidad"),
    @NamedQuery(name = "Localidad.findByDescripcion", query = "SELECT l FROM Localidad l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "Localidad.findByDefecto", query = "SELECT l FROM Localidad l WHERE l.defecto = :defecto")})
public class Localidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocalidadPK localidadPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Defecto")
    private boolean defecto;
    @JoinColumn(name = "Id_provincia", referencedColumnName = "Id_provincia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Provincia provincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidad")
    private Collection<Calle> calleCollection;

    public Localidad() {
    }

    public Localidad(LocalidadPK localidadPK) {
        this.localidadPK = localidadPK;
    }

    public Localidad(LocalidadPK localidadPK, String descripcion, boolean defecto) {
        this.localidadPK = localidadPK;
        this.descripcion = descripcion;
        this.defecto = defecto;
    }

    public Localidad(short idprovincia, short idlocalidad) {
        this.localidadPK = new LocalidadPK(idprovincia, idlocalidad);
    }

    public LocalidadPK getLocalidadPK() {
        return localidadPK;
    }

    public void setLocalidadPK(LocalidadPK localidadPK) {
        this.localidadPK = localidadPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getDefecto() {
        return defecto;
    }

    public void setDefecto(boolean defecto) {
        this.defecto = defecto;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @XmlTransient
    public Collection<Calle> getCalleCollection() {
        return calleCollection;
    }

    public void setCalleCollection(Collection<Calle> calleCollection) {
        this.calleCollection = calleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localidadPK != null ? localidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.localidadPK == null && other.localidadPK != null) || (this.localidadPK != null && !this.localidadPK.equals(other.localidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Localidad[ localidadPK=" + localidadPK + " ]";
    }
    
}
