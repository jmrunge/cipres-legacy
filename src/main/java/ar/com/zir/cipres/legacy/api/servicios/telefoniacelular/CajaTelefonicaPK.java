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
public class CajaTelefonicaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_cable")
    private short idcable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_caja")
    private short idcaja;

    public CajaTelefonicaPK() {
    }

    public CajaTelefonicaPK(short idcable, short idcaja) {
        this.idcable = idcable;
        this.idcaja = idcaja;
    }

    public short getIdcable() {
        return idcable;
    }

    public void setIdcable(short idcable) {
        this.idcable = idcable;
    }

    public short getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(short idcaja) {
        this.idcaja = idcaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcable;
        hash += (int) idcaja;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CajaTelefonicaPK)) {
            return false;
        }
        CajaTelefonicaPK other = (CajaTelefonicaPK) object;
        if (this.idcable != other.idcable) {
            return false;
        }
        if (this.idcaja != other.idcaja) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.CajaTelefonicaPK[ idcable=" + idcable + ", idcaja=" + idcaja + " ]";
    }
    
}
