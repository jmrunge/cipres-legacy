/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.domicilio;

import ar.com.zir.cipres.legacy.api.domicilio.Pais;
import ar.com.zir.cipres.legacy.api.domicilio.Localidad;
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
@Table(name = "PROVINCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.findByIdprovincia", query = "SELECT p FROM Provincia p WHERE p.idprovincia = :idprovincia"),
    @NamedQuery(name = "Provincia.findByDescripcion", query = "SELECT p FROM Provincia p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Provincia.findByDefecto", query = "SELECT p FROM Provincia p WHERE p.defecto = :defecto"),
    @NamedQuery(name = "Provincia.findByAbreviatura", query = "SELECT p FROM Provincia p WHERE p.abreviatura = :abreviatura"),
    @NamedQuery(name = "Provincia.findByIdafip", query = "SELECT p FROM Provincia p WHERE p.idafip = :idafip")})
public class Provincia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_provincia")
    private Short idprovincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Defecto")
    private boolean defecto;
    @Size(max = 5)
    @Column(name = "Abreviatura")
    private String abreviatura;
    @Column(name = "Id_afip")
    private Short idafip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia")
    private Collection<Localidad> localidadCollection;
    @JoinColumn(name = "Id_pais", referencedColumnName = "Id_pais")
    @ManyToOne(optional = false)
    private Pais idpais;

    public Provincia() {
    }

    public Provincia(Short idprovincia) {
        this.idprovincia = idprovincia;
    }

    public Provincia(Short idprovincia, String descripcion, boolean defecto) {
        this.idprovincia = idprovincia;
        this.descripcion = descripcion;
        this.defecto = defecto;
    }

    public Short getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(Short idprovincia) {
        this.idprovincia = idprovincia;
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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Short getIdafip() {
        return idafip;
    }

    public void setIdafip(Short idafip) {
        this.idafip = idafip;
    }

    @XmlTransient
    public Collection<Localidad> getLocalidadCollection() {
        return localidadCollection;
    }

    public void setLocalidadCollection(Collection<Localidad> localidadCollection) {
        this.localidadCollection = localidadCollection;
    }

    public Pais getIdpais() {
        return idpais;
    }

    public void setIdpais(Pais idpais) {
        this.idpais = idpais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprovincia != null ? idprovincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.idprovincia == null && other.idprovincia != null) || (this.idprovincia != null && !this.idprovincia.equals(other.idprovincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Provincia[ idprovincia=" + idprovincia + " ]";
    }
    
}
