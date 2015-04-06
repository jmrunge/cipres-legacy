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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jmrunge
 */
@Embeddable
public class ConexionTelefonicaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_prestacion")
    private int idprestacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Prefijo")
    private String prefijo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nro_telefono")
    private int nrotelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadesde;

    public ConexionTelefonicaPK() {
    }

    public ConexionTelefonicaPK(int idprestacion, String prefijo, int nrotelefono, Date fechadesde) {
        this.idprestacion = idprestacion;
        this.prefijo = prefijo;
        this.nrotelefono = nrotelefono;
        this.fechadesde = fechadesde;
    }

    public int getIdprestacion() {
        return idprestacion;
    }

    public void setIdprestacion(int idprestacion) {
        this.idprestacion = idprestacion;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public int getNrotelefono() {
        return nrotelefono;
    }

    public void setNrotelefono(int nrotelefono) {
        this.nrotelefono = nrotelefono;
    }

    public Date getFechadesde() {
        return fechadesde;
    }

    public void setFechadesde(Date fechadesde) {
        this.fechadesde = fechadesde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idprestacion;
        hash += (prefijo != null ? prefijo.hashCode() : 0);
        hash += (int) nrotelefono;
        hash += (fechadesde != null ? fechadesde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConexionTelefonicaPK)) {
            return false;
        }
        ConexionTelefonicaPK other = (ConexionTelefonicaPK) object;
        if (this.idprestacion != other.idprestacion) {
            return false;
        }
        if ((this.prefijo == null && other.prefijo != null) || (this.prefijo != null && !this.prefijo.equals(other.prefijo))) {
            return false;
        }
        if (this.nrotelefono != other.nrotelefono) {
            return false;
        }
        if ((this.fechadesde == null && other.fechadesde != null) || (this.fechadesde != null && !this.fechadesde.equals(other.fechadesde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.ConexionTelefonicaPK[ idprestacion=" + idprestacion + ", prefijo=" + prefijo + ", nrotelefono=" + nrotelefono + ", fechadesde=" + fechadesde + " ]";
    }
    
}
