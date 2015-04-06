/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jmrunge
 */
@Entity
@Table(name = "FRECUENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frecuencia.findAll", query = "SELECT f FROM Frecuencia f"),
    @NamedQuery(name = "Frecuencia.findByIdfrecuencia", query = "SELECT f FROM Frecuencia f WHERE f.idfrecuencia = :idfrecuencia"),
    @NamedQuery(name = "Frecuencia.findByDescripcion", query = "SELECT f FROM Frecuencia f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "Frecuencia.findByFrecuencia", query = "SELECT f FROM Frecuencia f WHERE f.frecuencia = :frecuencia"),
    @NamedQuery(name = "Frecuencia.findByRepeticion", query = "SELECT f FROM Frecuencia f WHERE f.repeticion = :repeticion"),
    @NamedQuery(name = "Frecuencia.findByDia", query = "SELECT f FROM Frecuencia f WHERE f.dia = :dia"),
    @NamedQuery(name = "Frecuencia.findByReferencia", query = "SELECT f FROM Frecuencia f WHERE f.referencia = :referencia"),
    @NamedQuery(name = "Frecuencia.findByDesvio", query = "SELECT f FROM Frecuencia f WHERE f.desvio = :desvio"),
    @NamedQuery(name = "Frecuencia.findByIdafip", query = "SELECT f FROM Frecuencia f WHERE f.idafip = :idafip")})
public class Frecuencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_frecuencia")
    private Short idfrecuencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Frecuencia")
    private short frecuencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Repeticion")
    private short repeticion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Dia")
    private short dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Referencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date referencia;
    @Column(name = "Desvio")
    private Short desvio;
    @Column(name = "Id_afip")
    private Short idafip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfrecuencia")
    private Collection<Prestacion> prestacionCollection;

    public Frecuencia() {
    }

    public Frecuencia(Short idfrecuencia) {
        this.idfrecuencia = idfrecuencia;
    }

    public Frecuencia(Short idfrecuencia, String descripcion, short frecuencia, short repeticion, short dia, Date referencia) {
        this.idfrecuencia = idfrecuencia;
        this.descripcion = descripcion;
        this.frecuencia = frecuencia;
        this.repeticion = repeticion;
        this.dia = dia;
        this.referencia = referencia;
    }

    public Short getIdfrecuencia() {
        return idfrecuencia;
    }

    public void setIdfrecuencia(Short idfrecuencia) {
        this.idfrecuencia = idfrecuencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(short frecuencia) {
        this.frecuencia = frecuencia;
    }

    public short getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(short repeticion) {
        this.repeticion = repeticion;
    }

    public short getDia() {
        return dia;
    }

    public void setDia(short dia) {
        this.dia = dia;
    }

    public Date getReferencia() {
        return referencia;
    }

    public void setReferencia(Date referencia) {
        this.referencia = referencia;
    }

    public Short getDesvio() {
        return desvio;
    }

    public void setDesvio(Short desvio) {
        this.desvio = desvio;
    }

    public Short getIdafip() {
        return idafip;
    }

    public void setIdafip(Short idafip) {
        this.idafip = idafip;
    }

    @XmlTransient
    public Collection<Prestacion> getPrestacionCollection() {
        return prestacionCollection;
    }

    public void setPrestacionCollection(Collection<Prestacion> prestacionCollection) {
        this.prestacionCollection = prestacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfrecuencia != null ? idfrecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frecuencia)) {
            return false;
        }
        Frecuencia other = (Frecuencia) object;
        if ((this.idfrecuencia == null && other.idfrecuencia != null) || (this.idfrecuencia != null && !this.idfrecuencia.equals(other.idfrecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Frecuencia[ idfrecuencia=" + idfrecuencia + " ]";
    }
    
}
