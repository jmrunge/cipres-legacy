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
public class CallePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_provincia")
    private short idprovincia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_localidad")
    private short idlocalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_calle")
    private short idcalle;

    public CallePK() {
    }

    public CallePK(short idprovincia, short idlocalidad, short idcalle) {
        this.idprovincia = idprovincia;
        this.idlocalidad = idlocalidad;
        this.idcalle = idcalle;
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

    public short getIdcalle() {
        return idcalle;
    }

    public void setIdcalle(short idcalle) {
        this.idcalle = idcalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idprovincia;
        hash += (int) idlocalidad;
        hash += (int) idcalle;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CallePK)) {
            return false;
        }
        CallePK other = (CallePK) object;
        if (this.idprovincia != other.idprovincia) {
            return false;
        }
        if (this.idlocalidad != other.idlocalidad) {
            return false;
        }
        if (this.idcalle != other.idcalle) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.CallePK[ idprovincia=" + idprovincia + ", idlocalidad=" + idlocalidad + ", idcalle=" + idcalle + " ]";
    }
    
}
