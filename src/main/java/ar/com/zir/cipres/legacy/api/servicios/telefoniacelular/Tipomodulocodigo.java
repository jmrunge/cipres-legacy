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
@Table(name = "Tipo_modulo_codigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomodulocodigo.findAll", query = "SELECT t FROM Tipomodulocodigo t"),
    @NamedQuery(name = "Tipomodulocodigo.findByIdtipomodulo", query = "SELECT t FROM Tipomodulocodigo t WHERE t.idtipomodulo = :idtipomodulo"),
    @NamedQuery(name = "Tipomodulocodigo.findByDescripcion", query = "SELECT t FROM Tipomodulocodigo t WHERE t.descripcion = :descripcion")})
public class Tipomodulocodigo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_modulo")
    private Short idtipomodulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipomodulocodigo")
    private Collection<Modulocodigo> modulocodigoCollection;

    public Tipomodulocodigo() {
    }

    public Tipomodulocodigo(Short idtipomodulo) {
        this.idtipomodulo = idtipomodulo;
    }

    public Tipomodulocodigo(Short idtipomodulo, String descripcion) {
        this.idtipomodulo = idtipomodulo;
        this.descripcion = descripcion;
    }

    public Short getIdtipomodulo() {
        return idtipomodulo;
    }

    public void setIdtipomodulo(Short idtipomodulo) {
        this.idtipomodulo = idtipomodulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Modulocodigo> getModulocodigoCollection() {
        return modulocodigoCollection;
    }

    public void setModulocodigoCollection(Collection<Modulocodigo> modulocodigoCollection) {
        this.modulocodigoCollection = modulocodigoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipomodulo != null ? idtipomodulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomodulocodigo)) {
            return false;
        }
        Tipomodulocodigo other = (Tipomodulocodigo) object;
        if ((this.idtipomodulo == null && other.idtipomodulo != null) || (this.idtipomodulo != null && !this.idtipomodulo.equals(other.idtipomodulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Tipomodulocodigo[ idtipomodulo=" + idtipomodulo + " ]";
    }
    
}
