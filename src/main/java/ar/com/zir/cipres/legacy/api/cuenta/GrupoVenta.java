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
 * @author jmrunge
 */
@Entity
@Table(name = "GRUPO_VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoVenta.findAll", query = "SELECT g FROM GrupoVenta g"),
    @NamedQuery(name = "GrupoVenta.findByIdgrupo", query = "SELECT g FROM GrupoVenta g WHERE g.idgrupo = :idgrupo"),
    @NamedQuery(name = "GrupoVenta.findByDescripcion", query = "SELECT g FROM GrupoVenta g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GrupoVenta.findByGeneraasociado", query = "SELECT g FROM GrupoVenta g WHERE g.generaasociado = :generaasociado")})
public class GrupoVenta implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "Genera_asociado")
    private boolean generaasociado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrupo")
    private Collection<ItemsAVender> itemsAVenderCollection;

    public GrupoVenta() {
    }

    public GrupoVenta(Short idgrupo) {
        this.idgrupo = idgrupo;
    }

    public GrupoVenta(Short idgrupo, String descripcion, boolean generaasociado) {
        this.idgrupo = idgrupo;
        this.descripcion = descripcion;
        this.generaasociado = generaasociado;
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

    public boolean getGeneraasociado() {
        return generaasociado;
    }

    public void setGeneraasociado(boolean generaasociado) {
        this.generaasociado = generaasociado;
    }

    @XmlTransient
    public Collection<ItemsAVender> getItemsAVenderCollection() {
        return itemsAVenderCollection;
    }

    public void setItemsAVenderCollection(Collection<ItemsAVender> itemsAVenderCollection) {
        this.itemsAVenderCollection = itemsAVenderCollection;
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
        if (!(object instanceof GrupoVenta)) {
            return false;
        }
        GrupoVenta other = (GrupoVenta) object;
        if ((this.idgrupo == null && other.idgrupo != null) || (this.idgrupo != null && !this.idgrupo.equals(other.idgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.GrupoVenta[ idgrupo=" + idgrupo + " ]";
    }
    
}
