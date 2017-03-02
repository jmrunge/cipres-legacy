/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.zir.cipres.legacy.api.cuenta;

import ar.com.zir.cipres.legacy.api.cuenta.Cuenta;
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
@Table(name = "FAMILIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familias.findAll", query = "SELECT f FROM Familias f"),
    @NamedQuery(name = "Familias.findByFamilia", query = "SELECT f FROM Familias f WHERE f.familia = :familia"),
    @NamedQuery(name = "Familias.findByDescripcion", query = "SELECT f FROM Familias f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "Familias.findByMsg", query = "SELECT f FROM Familias f WHERE f.msg = :msg")})
public class Familias implements Serializable {
    @Column(name = "idFenix")
    private Integer idFenix;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Familia")
    private Short familia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "Msg")
    private String msg;
    @OneToMany(mappedBy = "familia")
    private Collection<Cuenta> cuentaCollection;

    public Familias() {
    }

    public Familias(Short familia) {
        this.familia = familia;
    }

    public Familias(Short familia, String descripcion) {
        this.familia = familia;
        this.descripcion = descripcion;
    }

    public Short getFamilia() {
        return familia;
    }

    public void setFamilia(Short familia) {
        this.familia = familia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
        hash += (familia != null ? familia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familias)) {
            return false;
        }
        Familias other = (Familias) object;
        if ((this.familia == null && other.familia != null) || (this.familia != null && !this.familia.equals(other.familia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Familias[ familia=" + familia + " ]";
    }

    public Integer getIdFenix() {
        return idFenix;
    }

    public void setIdFenix(Integer idFenix) {
        this.idFenix = idFenix;
    }

}
