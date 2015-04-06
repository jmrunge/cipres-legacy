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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "PAR_TELEFONICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParTelefonico.findAll", query = "SELECT p FROM ParTelefonico p"),
    @NamedQuery(name = "ParTelefonico.findByIdcable", query = "SELECT p FROM ParTelefonico p WHERE p.parTelefonicoPK.idcable = :idcable"),
    @NamedQuery(name = "ParTelefonico.findByIdcaja", query = "SELECT p FROM ParTelefonico p WHERE p.parTelefonicoPK.idcaja = :idcaja"),
    @NamedQuery(name = "ParTelefonico.findByIdpar", query = "SELECT p FROM ParTelefonico p WHERE p.parTelefonicoPK.idpar = :idpar"),
    @NamedQuery(name = "ParTelefonico.findByDescripcion", query = "SELECT p FROM ParTelefonico p WHERE p.descripcion = :descripcion")})
public class ParTelefonico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParTelefonicoPK parTelefonicoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinTable(name = "EMPALME", joinColumns = {
        @JoinColumn(name = "Id_cable_destino", referencedColumnName = "Id_cable"),
        @JoinColumn(name = "Id_caja_destino", referencedColumnName = "Id_caja"),
        @JoinColumn(name = "Id_par_destino", referencedColumnName = "Id_par")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_cable_origen", referencedColumnName = "Id_cable"),
        @JoinColumn(name = "Id_caja_origen", referencedColumnName = "Id_caja"),
        @JoinColumn(name = "Id_par_origen", referencedColumnName = "Id_par")})
    @ManyToMany
    private Collection<ParTelefonico> parTelefonicoCollection;
    @ManyToMany(mappedBy = "parTelefonicoCollection")
    private Collection<ParTelefonico> parTelefonicoCollection1;
    @JoinColumns({
        @JoinColumn(name = "Id_cable", referencedColumnName = "Id_cable", insertable = false, updatable = false),
        @JoinColumn(name = "Id_caja", referencedColumnName = "Id_caja", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CajaTelefonica cajaTelefonica;
    @OneToMany(mappedBy = "parTelefonico")
    private Collection<ConexionTelefonica> conexionTelefonicaCollection;

    public ParTelefonico() {
    }

    public ParTelefonico(ParTelefonicoPK parTelefonicoPK) {
        this.parTelefonicoPK = parTelefonicoPK;
    }

    public ParTelefonico(ParTelefonicoPK parTelefonicoPK, String descripcion) {
        this.parTelefonicoPK = parTelefonicoPK;
        this.descripcion = descripcion;
    }

    public ParTelefonico(short idcable, short idcaja, short idpar) {
        this.parTelefonicoPK = new ParTelefonicoPK(idcable, idcaja, idpar);
    }

    public ParTelefonicoPK getParTelefonicoPK() {
        return parTelefonicoPK;
    }

    public void setParTelefonicoPK(ParTelefonicoPK parTelefonicoPK) {
        this.parTelefonicoPK = parTelefonicoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<ParTelefonico> getParTelefonicoCollection() {
        return parTelefonicoCollection;
    }

    public void setParTelefonicoCollection(Collection<ParTelefonico> parTelefonicoCollection) {
        this.parTelefonicoCollection = parTelefonicoCollection;
    }

    @XmlTransient
    public Collection<ParTelefonico> getParTelefonicoCollection1() {
        return parTelefonicoCollection1;
    }

    public void setParTelefonicoCollection1(Collection<ParTelefonico> parTelefonicoCollection1) {
        this.parTelefonicoCollection1 = parTelefonicoCollection1;
    }

    public CajaTelefonica getCajaTelefonica() {
        return cajaTelefonica;
    }

    public void setCajaTelefonica(CajaTelefonica cajaTelefonica) {
        this.cajaTelefonica = cajaTelefonica;
    }

    @XmlTransient
    public Collection<ConexionTelefonica> getConexionTelefonicaCollection() {
        return conexionTelefonicaCollection;
    }

    public void setConexionTelefonicaCollection(Collection<ConexionTelefonica> conexionTelefonicaCollection) {
        this.conexionTelefonicaCollection = conexionTelefonicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parTelefonicoPK != null ? parTelefonicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParTelefonico)) {
            return false;
        }
        ParTelefonico other = (ParTelefonico) object;
        if ((this.parTelefonicoPK == null && other.parTelefonicoPK != null) || (this.parTelefonicoPK != null && !this.parTelefonicoPK.equals(other.parTelefonicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.ParTelefonico[ parTelefonicoPK=" + parTelefonicoPK + " ]";
    }
    
}
