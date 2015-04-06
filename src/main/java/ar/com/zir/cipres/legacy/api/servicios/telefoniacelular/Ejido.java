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
@Table(name = "EJIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejido.findAll", query = "SELECT e FROM Ejido e"),
    @NamedQuery(name = "Ejido.findByIdejido", query = "SELECT e FROM Ejido e WHERE e.idejido = :idejido"),
    @NamedQuery(name = "Ejido.findByDescripcion", query = "SELECT e FROM Ejido e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Ejido.findByDefecto", query = "SELECT e FROM Ejido e WHERE e.defecto = :defecto"),
    @NamedQuery(name = "Ejido.findByCalcimpuesto", query = "SELECT e FROM Ejido e WHERE e.calcimpuesto = :calcimpuesto")})
public class Ejido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_ejido")
    private Short idejido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Defecto")
    private boolean defecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Calc_impuesto")
    private boolean calcimpuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idejido")
    private Collection<Cuenta> cuentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idejido")
    private Collection<Barrio> barrioCollection;

    public Ejido() {
    }

    public Ejido(Short idejido) {
        this.idejido = idejido;
    }

    public Ejido(Short idejido, String descripcion, boolean defecto, boolean calcimpuesto) {
        this.idejido = idejido;
        this.descripcion = descripcion;
        this.defecto = defecto;
        this.calcimpuesto = calcimpuesto;
    }

    public Short getIdejido() {
        return idejido;
    }

    public void setIdejido(Short idejido) {
        this.idejido = idejido;
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

    public boolean getCalcimpuesto() {
        return calcimpuesto;
    }

    public void setCalcimpuesto(boolean calcimpuesto) {
        this.calcimpuesto = calcimpuesto;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    @XmlTransient
    public Collection<Barrio> getBarrioCollection() {
        return barrioCollection;
    }

    public void setBarrioCollection(Collection<Barrio> barrioCollection) {
        this.barrioCollection = barrioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idejido != null ? idejido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejido)) {
            return false;
        }
        Ejido other = (Ejido) object;
        if ((this.idejido == null && other.idejido != null) || (this.idejido != null && !this.idejido.equals(other.idejido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Ejido[ idejido=" + idejido + " ]";
    }

}
