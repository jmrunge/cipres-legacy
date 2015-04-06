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
public class ParTelefonicoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_cable")
    private short idcable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_caja")
    private short idcaja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_par")
    private short idpar;

    public ParTelefonicoPK() {
    }

    public ParTelefonicoPK(short idcable, short idcaja, short idpar) {
        this.idcable = idcable;
        this.idcaja = idcaja;
        this.idpar = idpar;
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

    public short getIdpar() {
        return idpar;
    }

    public void setIdpar(short idpar) {
        this.idpar = idpar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcable;
        hash += (int) idcaja;
        hash += (int) idpar;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParTelefonicoPK)) {
            return false;
        }
        ParTelefonicoPK other = (ParTelefonicoPK) object;
        if (this.idcable != other.idcable) {
            return false;
        }
        if (this.idcaja != other.idcaja) {
            return false;
        }
        if (this.idpar != other.idpar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.ParTelefonicoPK[ idcable=" + idcable + ", idcaja=" + idcaja + ", idpar=" + idpar + " ]";
    }
    
}
