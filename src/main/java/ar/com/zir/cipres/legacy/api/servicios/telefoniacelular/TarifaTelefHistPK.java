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
public class TarifaTelefHistPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_prestacion")
    private int idprestacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadesde;

    public TarifaTelefHistPK() {
    }

    public TarifaTelefHistPK(int idprestacion, Date fechadesde) {
        this.idprestacion = idprestacion;
        this.fechadesde = fechadesde;
    }

    public int getIdprestacion() {
        return idprestacion;
    }

    public void setIdprestacion(int idprestacion) {
        this.idprestacion = idprestacion;
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
        hash += (fechadesde != null ? fechadesde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaTelefHistPK)) {
            return false;
        }
        TarifaTelefHistPK other = (TarifaTelefHistPK) object;
        if (this.idprestacion != other.idprestacion) {
            return false;
        }
        if ((this.fechadesde == null && other.fechadesde != null) || (this.fechadesde != null && !this.fechadesde.equals(other.fechadesde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.TarifaTelefHistPK[ idprestacion=" + idprestacion + ", fechadesde=" + fechadesde + " ]";
    }
    
}
