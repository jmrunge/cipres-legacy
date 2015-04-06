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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CABLE_TELEFONICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CableTelefonico.findAll", query = "SELECT c FROM CableTelefonico c"),
    @NamedQuery(name = "CableTelefonico.findByIdcable", query = "SELECT c FROM CableTelefonico c WHERE c.idcable = :idcable"),
    @NamedQuery(name = "CableTelefonico.findByDescripcion", query = "SELECT c FROM CableTelefonico c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CableTelefonico.findByCantpares", query = "SELECT c FROM CableTelefonico c WHERE c.cantpares = :cantpares"),
    @NamedQuery(name = "CableTelefonico.findByFechainst", query = "SELECT c FROM CableTelefonico c WHERE c.fechainst = :fechainst")})
public class CableTelefonico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_cable")
    private Short idcable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cant_pares")
    private short cantpares;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_inst")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cableTelefonico")
    private Collection<CajaTelefonica> cajaTelefonicaCollection;
    @JoinColumn(name = "Id_central", referencedColumnName = "Id_central")
    @ManyToOne(optional = false)
    private CentralTelefonia idcentral;

    public CableTelefonico() {
    }

    public CableTelefonico(Short idcable) {
        this.idcable = idcable;
    }

    public CableTelefonico(Short idcable, String descripcion, short cantpares, Date fechainst) {
        this.idcable = idcable;
        this.descripcion = descripcion;
        this.cantpares = cantpares;
        this.fechainst = fechainst;
    }

    public Short getIdcable() {
        return idcable;
    }

    public void setIdcable(Short idcable) {
        this.idcable = idcable;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getCantpares() {
        return cantpares;
    }

    public void setCantpares(short cantpares) {
        this.cantpares = cantpares;
    }

    public Date getFechainst() {
        return fechainst;
    }

    public void setFechainst(Date fechainst) {
        this.fechainst = fechainst;
    }

    @XmlTransient
    public Collection<CajaTelefonica> getCajaTelefonicaCollection() {
        return cajaTelefonicaCollection;
    }

    public void setCajaTelefonicaCollection(Collection<CajaTelefonica> cajaTelefonicaCollection) {
        this.cajaTelefonicaCollection = cajaTelefonicaCollection;
    }

    public CentralTelefonia getIdcentral() {
        return idcentral;
    }

    public void setIdcentral(CentralTelefonia idcentral) {
        this.idcentral = idcentral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcable != null ? idcable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CableTelefonico)) {
            return false;
        }
        CableTelefonico other = (CableTelefonico) object;
        if ((this.idcable == null && other.idcable != null) || (this.idcable != null && !this.idcable.equals(other.idcable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.CableTelefonico[ idcable=" + idcable + " ]";
    }
    
}
