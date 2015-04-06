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

/**
 *
 * @author jmrunge
 */
@Embeddable
public class ConsTelefMovilPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_prestacion")
    private int idprestacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public ConsTelefMovilPK() {
    }

    public ConsTelefMovilPK(int idprestacion, Date fecha) {
        this.idprestacion = idprestacion;
        this.fecha = fecha;
    }

    public int getIdprestacion() {
        return idprestacion;
    }

    public void setIdprestacion(int idprestacion) {
        this.idprestacion = idprestacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idprestacion;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsTelefMovilPK)) {
            return false;
        }
        ConsTelefMovilPK other = (ConsTelefMovilPK) object;
        if (this.idprestacion != other.idprestacion) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.ConsTelefMovilPK[ idprestacion=" + idprestacion + ", fecha=" + fecha + " ]";
    }
    
}
