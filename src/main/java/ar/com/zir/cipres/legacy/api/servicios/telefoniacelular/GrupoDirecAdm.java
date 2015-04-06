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
@Table(name = "GRUPO_DIREC_ADM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoDirecAdm.findAll", query = "SELECT g FROM GrupoDirecAdm g"),
    @NamedQuery(name = "GrupoDirecAdm.findByIdgrupodirecadm", query = "SELECT g FROM GrupoDirecAdm g WHERE g.idgrupodirecadm = :idgrupodirecadm"),
    @NamedQuery(name = "GrupoDirecAdm.findByDescripcion", query = "SELECT g FROM GrupoDirecAdm g WHERE g.descripcion = :descripcion")})
public class GrupoDirecAdm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_grupo_direc_adm")
    private Short idgrupodirecadm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrupodirecadm")
    private Collection<ItemsAVender> itemsAVenderCollection;

    public GrupoDirecAdm() {
    }

    public GrupoDirecAdm(Short idgrupodirecadm) {
        this.idgrupodirecadm = idgrupodirecadm;
    }

    public GrupoDirecAdm(Short idgrupodirecadm, String descripcion) {
        this.idgrupodirecadm = idgrupodirecadm;
        this.descripcion = descripcion;
    }

    public Short getIdgrupodirecadm() {
        return idgrupodirecadm;
    }

    public void setIdgrupodirecadm(Short idgrupodirecadm) {
        this.idgrupodirecadm = idgrupodirecadm;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idgrupodirecadm != null ? idgrupodirecadm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoDirecAdm)) {
            return false;
        }
        GrupoDirecAdm other = (GrupoDirecAdm) object;
        if ((this.idgrupodirecadm == null && other.idgrupodirecadm != null) || (this.idgrupodirecadm != null && !this.idgrupodirecadm.equals(other.idgrupodirecadm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.GrupoDirecAdm[ idgrupodirecadm=" + idgrupodirecadm + " ]";
    }
    
}
