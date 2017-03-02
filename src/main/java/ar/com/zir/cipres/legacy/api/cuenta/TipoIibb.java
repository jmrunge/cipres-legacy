/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.cuenta;

import ar.com.zir.cipres.legacy.api.cuenta.ItemsAVender;
import ar.com.zir.cipres.legacy.api.cuenta.Cuenta;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TIPO_IIBB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIibb.findAll", query = "SELECT t FROM TipoIibb t"),
    @NamedQuery(name = "TipoIibb.findByIdtipoIIBB", query = "SELECT t FROM TipoIibb t WHERE t.idtipoIIBB = :idtipoIIBB"),
    @NamedQuery(name = "TipoIibb.findByDescripcion", query = "SELECT t FROM TipoIibb t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoIibb.findByAbreviatura", query = "SELECT t FROM TipoIibb t WHERE t.abreviatura = :abreviatura"),
    @NamedQuery(name = "TipoIibb.findByCorrespondepercepcion", query = "SELECT t FROM TipoIibb t WHERE t.correspondepercepcion = :correspondepercepcion"),
    @NamedQuery(name = "TipoIibb.findByDefecto", query = "SELECT t FROM TipoIibb t WHERE t.defecto = :defecto")})
public class TipoIibb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_IIBB")
    private Short idtipoIIBB;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Abreviatura")
    private String abreviatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Corresponde_percepcion")
    private boolean correspondepercepcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Defecto")
    private boolean defecto;
    @JoinColumn(name = "Id_item", referencedColumnName = "Id_item")
    @ManyToOne
    private ItemsAVender iditem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoIIBB")
    private Collection<Cuenta> cuentaCollection;

    public TipoIibb() {
    }

    public TipoIibb(Short idtipoIIBB) {
        this.idtipoIIBB = idtipoIIBB;
    }

    public TipoIibb(Short idtipoIIBB, String descripcion, String abreviatura, boolean correspondepercepcion, boolean defecto) {
        this.idtipoIIBB = idtipoIIBB;
        this.descripcion = descripcion;
        this.abreviatura = abreviatura;
        this.correspondepercepcion = correspondepercepcion;
        this.defecto = defecto;
    }

    public Short getIdtipoIIBB() {
        return idtipoIIBB;
    }

    public void setIdtipoIIBB(Short idtipoIIBB) {
        this.idtipoIIBB = idtipoIIBB;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public boolean getCorrespondepercepcion() {
        return correspondepercepcion;
    }

    public void setCorrespondepercepcion(boolean correspondepercepcion) {
        this.correspondepercepcion = correspondepercepcion;
    }

    public boolean getDefecto() {
        return defecto;
    }

    public void setDefecto(boolean defecto) {
        this.defecto = defecto;
    }

    public ItemsAVender getIditem() {
        return iditem;
    }

    public void setIditem(ItemsAVender iditem) {
        this.iditem = iditem;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoIIBB != null ? idtipoIIBB.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIibb)) {
            return false;
        }
        TipoIibb other = (TipoIibb) object;
        if ((this.idtipoIIBB == null && other.idtipoIIBB != null) || (this.idtipoIIBB != null && !this.idtipoIIBB.equals(other.idtipoIIBB))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.TipoIibb[ idtipoIIBB=" + idtipoIIBB + " ]";
    }
    
}
