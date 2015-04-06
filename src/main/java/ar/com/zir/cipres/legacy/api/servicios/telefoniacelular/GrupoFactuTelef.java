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
@Table(name = "GRUPO_FACTU_TELEF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoFactuTelef.findAll", query = "SELECT g FROM GrupoFactuTelef g"),
    @NamedQuery(name = "GrupoFactuTelef.findByIdgrupo", query = "SELECT g FROM GrupoFactuTelef g WHERE g.idgrupo = :idgrupo"),
    @NamedQuery(name = "GrupoFactuTelef.findByDescripcion", query = "SELECT g FROM GrupoFactuTelef g WHERE g.descripcion = :descripcion")})
public class GrupoFactuTelef implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_grupo")
    private Short idgrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrupo")
    private Collection<PrestTelefonia> prestTelefoniaCollection;

    public GrupoFactuTelef() {
    }

    public GrupoFactuTelef(Short idgrupo) {
        this.idgrupo = idgrupo;
    }

    public GrupoFactuTelef(Short idgrupo, String descripcion) {
        this.idgrupo = idgrupo;
        this.descripcion = descripcion;
    }

    public Short getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Short idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<PrestTelefonia> getPrestTelefoniaCollection() {
        return prestTelefoniaCollection;
    }

    public void setPrestTelefoniaCollection(Collection<PrestTelefonia> prestTelefoniaCollection) {
        this.prestTelefoniaCollection = prestTelefoniaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupo != null ? idgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoFactuTelef)) {
            return false;
        }
        GrupoFactuTelef other = (GrupoFactuTelef) object;
        if ((this.idgrupo == null && other.idgrupo != null) || (this.idgrupo != null && !this.idgrupo.equals(other.idgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.GrupoFactuTelef[ idgrupo=" + idgrupo + " ]";
    }
    
}
