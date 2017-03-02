/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.domicilio;

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
@Table(name = "BARRIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrio.findAll", query = "SELECT b FROM Barrio b"),
    @NamedQuery(name = "Barrio.findByIdbarrio", query = "SELECT b FROM Barrio b WHERE b.idbarrio = :idbarrio"),
    @NamedQuery(name = "Barrio.findByDescripcion", query = "SELECT b FROM Barrio b WHERE b.descripcion = :descripcion")})
public class Barrio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_barrio")
    private Short idbarrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbarrio")
    private Collection<Catastro> catastroCollection;
    @JoinColumn(name = "Id_ejido", referencedColumnName = "Id_ejido")
    @ManyToOne(optional = false)
    private Ejido idejido;

    public Barrio() {
    }

    public Barrio(Short idbarrio) {
        this.idbarrio = idbarrio;
    }

    public Barrio(Short idbarrio, String descripcion) {
        this.idbarrio = idbarrio;
        this.descripcion = descripcion;
    }

    public Short getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(Short idbarrio) {
        this.idbarrio = idbarrio;
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

    public Ejido getIdejido() {
        return idejido;
    }

    public void setIdejido(Ejido idejido) {
        this.idejido = idejido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbarrio != null ? idbarrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrio)) {
            return false;
        }
        Barrio other = (Barrio) object;
        if ((this.idbarrio == null && other.idbarrio != null) || (this.idbarrio != null && !this.idbarrio.equals(other.idbarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Barrio[ idbarrio=" + idbarrio + " ]";
    }
    
}
