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
@Table(name = "DISTRITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distrito.findAll", query = "SELECT d FROM Distrito d"),
    @NamedQuery(name = "Distrito.findByIddistrito", query = "SELECT d FROM Distrito d WHERE d.iddistrito = :iddistrito"),
    @NamedQuery(name = "Distrito.findByDescripcion", query = "SELECT d FROM Distrito d WHERE d.descripcion = :descripcion")})
public class Distrito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_distrito")
    private Short iddistrito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "iddistrito")
    private Collection<Catastro> catastroCollection;

    public Distrito() {
    }

    public Distrito(Short iddistrito) {
        this.iddistrito = iddistrito;
    }

    public Distrito(Short iddistrito, String descripcion) {
        this.iddistrito = iddistrito;
        this.descripcion = descripcion;
    }

    public Short getIddistrito() {
        return iddistrito;
    }

    public void setIddistrito(Short iddistrito) {
        this.iddistrito = iddistrito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Catastro> getCatastroCollection() {
        return catastroCollection;
    }

    public void setCatastroCollection(Collection<Catastro> catastroCollection) {
        this.catastroCollection = catastroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddistrito != null ? iddistrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distrito)) {
            return false;
        }
        Distrito other = (Distrito) object;
        if ((this.iddistrito == null && other.iddistrito != null) || (this.iddistrito != null && !this.iddistrito.equals(other.iddistrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Distrito[ iddistrito=" + iddistrito + " ]";
    }
    
}
