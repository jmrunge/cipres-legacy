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
@Table(name = "GRUPO_IMPRESION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoImpresion.findAll", query = "SELECT g FROM GrupoImpresion g"),
    @NamedQuery(name = "GrupoImpresion.findByIdgrupoimp", query = "SELECT g FROM GrupoImpresion g WHERE g.idgrupoimp = :idgrupoimp"),
    @NamedQuery(name = "GrupoImpresion.findByDescripcion", query = "SELECT g FROM GrupoImpresion g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GrupoImpresion.findByOrdenimp", query = "SELECT g FROM GrupoImpresion g WHERE g.ordenimp = :ordenimp"),
    @NamedQuery(name = "GrupoImpresion.findBySubtotales", query = "SELECT g FROM GrupoImpresion g WHERE g.subtotales = :subtotales")})
public class GrupoImpresion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_grupo_imp")
    private Short idgrupoimp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Orden_imp")
    private short ordenimp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Subtotales")
    private boolean subtotales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrupoimp")
    private Collection<ItemsAVender> itemsAVenderCollection;

    public GrupoImpresion() {
    }

    public GrupoImpresion(Short idgrupoimp) {
        this.idgrupoimp = idgrupoimp;
    }

    public GrupoImpresion(Short idgrupoimp, String descripcion, short ordenimp, boolean subtotales) {
        this.idgrupoimp = idgrupoimp;
        this.descripcion = descripcion;
        this.ordenimp = ordenimp;
        this.subtotales = subtotales;
    }

    public Short getIdgrupoimp() {
        return idgrupoimp;
    }

    public void setIdgrupoimp(Short idgrupoimp) {
        this.idgrupoimp = idgrupoimp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getOrdenimp() {
        return ordenimp;
    }

    public void setOrdenimp(short ordenimp) {
        this.ordenimp = ordenimp;
    }

    public boolean getSubtotales() {
        return subtotales;
    }

    public void setSubtotales(boolean subtotales) {
        this.subtotales = subtotales;
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
        hash += (idgrupoimp != null ? idgrupoimp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoImpresion)) {
            return false;
        }
        GrupoImpresion other = (GrupoImpresion) object;
        if ((this.idgrupoimp == null && other.idgrupoimp != null) || (this.idgrupoimp != null && !this.idgrupoimp.equals(other.idgrupoimp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.GrupoImpresion[ idgrupoimp=" + idgrupoimp + " ]";
    }
    
}
