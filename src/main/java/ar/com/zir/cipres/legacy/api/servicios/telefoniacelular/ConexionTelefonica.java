/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmrunge
 */
@Entity
@Table(name = "CONEXION_TELEFONICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConexionTelefonica.findAll", query = "SELECT c FROM ConexionTelefonica c"),
    @NamedQuery(name = "ConexionTelefonica.findByIdprestacion", query = "SELECT c FROM ConexionTelefonica c WHERE c.conexionTelefonicaPK.idprestacion = :idprestacion"),
    @NamedQuery(name = "ConexionTelefonica.findByPrefijo", query = "SELECT c FROM ConexionTelefonica c WHERE c.conexionTelefonicaPK.prefijo = :prefijo"),
    @NamedQuery(name = "ConexionTelefonica.findByNrotelefono", query = "SELECT c FROM ConexionTelefonica c WHERE c.conexionTelefonicaPK.nrotelefono = :nrotelefono"),
    @NamedQuery(name = "ConexionTelefonica.findByFechadesde", query = "SELECT c FROM ConexionTelefonica c WHERE c.conexionTelefonicaPK.fechadesde = :fechadesde"),
    @NamedQuery(name = "ConexionTelefonica.findByFechahasta", query = "SELECT c FROM ConexionTelefonica c WHERE c.fechahasta = :fechahasta"),
    @NamedQuery(name = "ConexionTelefonica.findByFechaconexion", query = "SELECT c FROM ConexionTelefonica c WHERE c.fechaconexion = :fechaconexion")})
public class ConexionTelefonica implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConexionTelefonicaPK conexionTelefonicaPK;
    @Column(name = "Fecha_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_conexion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaconexion;
    @JoinColumns({
        @JoinColumn(name = "Prefijo", referencedColumnName = "Prefijo", insertable = false, updatable = false),
        @JoinColumn(name = "Nro_telefono", referencedColumnName = "Nro_telefono", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private NumeroAbonado numeroAbonado;
    @JoinColumns({
        @JoinColumn(name = "Id_cable", referencedColumnName = "Id_cable"),
        @JoinColumn(name = "Id_caja", referencedColumnName = "Id_caja"),
        @JoinColumn(name = "Id_par", referencedColumnName = "Id_par")})
    @ManyToOne
    private ParTelefonico parTelefonico;
    @JoinColumn(name = "Id_prestacion", referencedColumnName = "Id_prestacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrestTelefonia prestTelefonia;

    public ConexionTelefonica() {
    }

    public ConexionTelefonica(ConexionTelefonicaPK conexionTelefonicaPK) {
        this.conexionTelefonicaPK = conexionTelefonicaPK;
    }

    public ConexionTelefonica(ConexionTelefonicaPK conexionTelefonicaPK, Date fechaconexion) {
        this.conexionTelefonicaPK = conexionTelefonicaPK;
        this.fechaconexion = fechaconexion;
    }

    public ConexionTelefonica(int idprestacion, String prefijo, int nrotelefono, Date fechadesde) {
        this.conexionTelefonicaPK = new ConexionTelefonicaPK(idprestacion, prefijo, nrotelefono, fechadesde);
    }

    public ConexionTelefonicaPK getConexionTelefonicaPK() {
        return conexionTelefonicaPK;
    }

    public void setConexionTelefonicaPK(ConexionTelefonicaPK conexionTelefonicaPK) {
        this.conexionTelefonicaPK = conexionTelefonicaPK;
    }

    public Date getFechahasta() {
        return fechahasta;
    }

    public void setFechahasta(Date fechahasta) {
        this.fechahasta = fechahasta;
    }

    public Date getFechaconexion() {
        return fechaconexion;
    }

    public void setFechaconexion(Date fechaconexion) {
        this.fechaconexion = fechaconexion;
    }

    public NumeroAbonado getNumeroAbonado() {
        return numeroAbonado;
    }

    public void setNumeroAbonado(NumeroAbonado numeroAbonado) {
        this.numeroAbonado = numeroAbonado;
    }

    public ParTelefonico getParTelefonico() {
        return parTelefonico;
    }

    public void setParTelefonico(ParTelefonico parTelefonico) {
        this.parTelefonico = parTelefonico;
    }

    public PrestTelefonia getPrestTelefonia() {
        return prestTelefonia;
    }

    public void setPrestTelefonia(PrestTelefonia prestTelefonia) {
        this.prestTelefonia = prestTelefonia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conexionTelefonicaPK != null ? conexionTelefonicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConexionTelefonica)) {
            return false;
        }
        ConexionTelefonica other = (ConexionTelefonica) object;
        if ((this.conexionTelefonicaPK == null && other.conexionTelefonicaPK != null) || (this.conexionTelefonicaPK != null && !this.conexionTelefonicaPK.equals(other.conexionTelefonicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.ConexionTelefonica[ conexionTelefonicaPK=" + conexionTelefonicaPK + " ]";
    }
    
}
