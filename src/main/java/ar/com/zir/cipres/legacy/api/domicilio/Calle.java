/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.domicilio;

import ar.com.zir.cipres.legacy.api.cliente.Cliente;
import ar.com.zir.cipres.legacy.api.cuenta.Cuenta;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "CALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calle.findAll", query = "SELECT c FROM Calle c"),
    @NamedQuery(name = "Calle.findByIdprovincia", query = "SELECT c FROM Calle c WHERE c.callePK.idprovincia = :idprovincia"),
    @NamedQuery(name = "Calle.findByIdlocalidad", query = "SELECT c FROM Calle c WHERE c.callePK.idlocalidad = :idlocalidad"),
    @NamedQuery(name = "Calle.findByIdcalle", query = "SELECT c FROM Calle c WHERE c.callePK.idcalle = :idcalle"),
    @NamedQuery(name = "Calle.findByDescripcion", query = "SELECT c FROM Calle c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Calle.findByMapa", query = "SELECT c FROM Calle c WHERE c.mapa = :mapa"),
    @NamedQuery(name = "Calle.findByCoordXY", query = "SELECT c FROM Calle c WHERE c.coordXY = :coordXY"),
    @NamedQuery(name = "Calle.findByEsdificil", query = "SELECT c FROM Calle c WHERE c.esdificil = :esdificil")})
public class Calle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CallePK callePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 5)
    @Column(name = "Mapa")
    private String mapa;
    @Size(max = 3)
    @Column(name = "Coord_X_Y")
    private String coordXY;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Es_dificil")
    private boolean esdificil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calle")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calle")
    private Collection<Catastro> catastroCollection;
    @JoinColumns({
        @JoinColumn(name = "Id_provincia", referencedColumnName = "Id_provincia", insertable = false, updatable = false),
        @JoinColumn(name = "Id_localidad", referencedColumnName = "Id_localidad", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Localidad localidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calle")
    private Collection<Cuenta> cuentaCollection;

    public Calle() {
    }

    public Calle(CallePK callePK) {
        this.callePK = callePK;
    }

    public Calle(CallePK callePK, String descripcion, boolean esdificil) {
        this.callePK = callePK;
        this.descripcion = descripcion;
        this.esdificil = esdificil;
    }

    public Calle(short idprovincia, short idlocalidad, short idcalle) {
        this.callePK = new CallePK(idprovincia, idlocalidad, idcalle);
    }

    public CallePK getCallePK() {
        return callePK;
    }

    public void setCallePK(CallePK callePK) {
        this.callePK = callePK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getCoordXY() {
        return coordXY;
    }

    public void setCoordXY(String coordXY) {
        this.coordXY = coordXY;
    }

    public boolean getEsdificil() {
        return esdificil;
    }

    public void setEsdificil(boolean esdificil) {
        this.esdificil = esdificil;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Catastro> getCatastroCollection() {
        return catastroCollection;
    }

    public void setCatastroCollection(Collection<Catastro> catastroCollection) {
        this.catastroCollection = catastroCollection;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
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
        hash += (callePK != null ? callePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calle)) {
            return false;
        }
        Calle other = (Calle) object;
        if ((this.callePK == null && other.callePK != null) || (this.callePK != null && !this.callePK.equals(other.callePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Calle[ callePK=" + callePK + " ]";
    }
    
}
