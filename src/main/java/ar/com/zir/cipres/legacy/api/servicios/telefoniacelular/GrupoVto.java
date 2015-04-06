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
@Table(name = "GRUPO_VTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoVto.findAll", query = "SELECT g FROM GrupoVto g"),
    @NamedQuery(name = "GrupoVto.findByIdgrupovto", query = "SELECT g FROM GrupoVto g WHERE g.idgrupovto = :idgrupovto"),
    @NamedQuery(name = "GrupoVto.findByDescripcion", query = "SELECT g FROM GrupoVto g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GrupoVto.findByFrecuencia", query = "SELECT g FROM GrupoVto g WHERE g.frecuencia = :frecuencia"),
    @NamedQuery(name = "GrupoVto.findByRepeticion", query = "SELECT g FROM GrupoVto g WHERE g.repeticion = :repeticion"),
    @NamedQuery(name = "GrupoVto.findByDia", query = "SELECT g FROM GrupoVto g WHERE g.dia = :dia"),
    @NamedQuery(name = "GrupoVto.findByReferencia", query = "SELECT g FROM GrupoVto g WHERE g.referencia = :referencia"),
    @NamedQuery(name = "GrupoVto.findByDias2dovto", query = "SELECT g FROM GrupoVto g WHERE g.dias2dovto = :dias2dovto"),
    @NamedQuery(name = "GrupoVto.findByDias3ervto", query = "SELECT g FROM GrupoVto g WHERE g.dias3ervto = :dias3ervto")})
public class GrupoVto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_grupo_vto")
    private Short idgrupovto;
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
    @Column(name = "Dias_2do_vto")
    private Short dias2dovto;
    @Column(name = "Dias_3er_vto")
    private Short dias3ervto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrupovto")
    private Collection<Prestacion> prestacionCollection;

    public GrupoVto() {
    }

    public GrupoVto(Short idgrupovto) {
        this.idgrupovto = idgrupovto;
    }

    public GrupoVto(Short idgrupovto, String descripcion, short frecuencia, short repeticion, short dia, Date referencia) {
        this.idgrupovto = idgrupovto;
        this.descripcion = descripcion;
        this.frecuencia = frecuencia;
        this.repeticion = repeticion;
        this.dia = dia;
        this.referencia = referencia;
    }

    public Short getIdgrupovto() {
        return idgrupovto;
    }

    public void setIdgrupovto(Short idgrupovto) {
        this.idgrupovto = idgrupovto;
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

    public Short getDias2dovto() {
        return dias2dovto;
    }

    public void setDias2dovto(Short dias2dovto) {
        this.dias2dovto = dias2dovto;
    }

    public Short getDias3ervto() {
        return dias3ervto;
    }

    public void setDias3ervto(Short dias3ervto) {
        this.dias3ervto = dias3ervto;
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
        hash += (idgrupovto != null ? idgrupovto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoVto)) {
            return false;
        }
        GrupoVto other = (GrupoVto) object;
        if ((this.idgrupovto == null && other.idgrupovto != null) || (this.idgrupovto != null && !this.idgrupovto.equals(other.idgrupovto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.GrupoVto[ idgrupovto=" + idgrupovto + " ]";
    }
    
}
