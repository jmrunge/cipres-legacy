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
@Table(name = "PAIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "Pais.findByIdpais", query = "SELECT p FROM Pais p WHERE p.idpais = :idpais"),
    @NamedQuery(name = "Pais.findByDescripcion", query = "SELECT p FROM Pais p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Pais.findByDefecto", query = "SELECT p FROM Pais p WHERE p.defecto = :defecto"),
    @NamedQuery(name = "Pais.findByEslimitrofe", query = "SELECT p FROM Pais p WHERE p.eslimitrofe = :eslimitrofe")})
public class Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_pais")
    private Short idpais;
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
    @Column(name = "Es_limitrofe")
    private boolean eslimitrofe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpais")
    private Collection<Provincia> provinciaCollection;

    public Pais() {
    }

    public Pais(Short idpais) {
        this.idpais = idpais;
    }

    public Pais(Short idpais, String descripcion, boolean defecto, boolean eslimitrofe) {
        this.idpais = idpais;
        this.descripcion = descripcion;
        this.defecto = defecto;
        this.eslimitrofe = eslimitrofe;
    }

    public Short getIdpais() {
        return idpais;
    }

    public void setIdpais(Short idpais) {
        this.idpais = idpais;
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

    public boolean getEslimitrofe() {
        return eslimitrofe;
    }

    public void setEslimitrofe(boolean eslimitrofe) {
        this.eslimitrofe = eslimitrofe;
    }

    @XmlTransient
    public Collection<Provincia> getProvinciaCollection() {
        return provinciaCollection;
    }

    public void setProvinciaCollection(Collection<Provincia> provinciaCollection) {
        this.provinciaCollection = provinciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpais != null ? idpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.idpais == null && other.idpais != null) || (this.idpais != null && !this.idpais.equals(other.idpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Pais[ idpais=" + idpais + " ]";
    }
    
}
