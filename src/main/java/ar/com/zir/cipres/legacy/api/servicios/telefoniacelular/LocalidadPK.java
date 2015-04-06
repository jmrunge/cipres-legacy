/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jmrunge
 */
@Embeddable
public class LocalidadPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_provincia")
    private short idprovincia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_localidad")
    private short idlocalidad;

    public LocalidadPK() {
    }

    public LocalidadPK(short idprovincia, short idlocalidad) {
        this.idprovincia = idprovincia;
        this.idlocalidad = idlocalidad;
    }

    public short getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(short idprovincia) {
        this.idprovincia = idprovincia;
    }

    public short getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(short idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idprovincia;
        hash += (int) idlocalidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalidadPK)) {
            return false;
        }
        LocalidadPK other = (LocalidadPK) object;
        if (this.idprovincia != other.idprovincia) {
            return false;
        }
        if (this.idlocalidad != other.idlocalidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.LocalidadPK[ idprovincia=" + idprovincia + ", idlocalidad=" + idlocalidad + " ]";
    }
    
}
