/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.cuenta;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juan Martin Runge {@literal <jmrunge@gmail.com>}
 */
@Embeddable
public class TipoCompNumeracionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_comp")
    private short idtipocomp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_punto_vta")
    private short idpuntovta;

    public TipoCompNumeracionPK() {
    }

    public TipoCompNumeracionPK(short idtipocomp, short idpuntovta) {
        this.idtipocomp = idtipocomp;
        this.idpuntovta = idpuntovta;
    }

    public short getIdtipocomp() {
        return idtipocomp;
    }

    public void setIdtipocomp(short idtipocomp) {
        this.idtipocomp = idtipocomp;
    }

    public short getIdpuntovta() {
        return idpuntovta;
    }

    public void setIdpuntovta(short idpuntovta) {
        this.idpuntovta = idpuntovta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtipocomp;
        hash += (int) idpuntovta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCompNumeracionPK)) {
            return false;
        }
        TipoCompNumeracionPK other = (TipoCompNumeracionPK) object;
        if (this.idtipocomp != other.idtipocomp) {
            return false;
        }
        if (this.idpuntovta != other.idpuntovta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.cuenta.TipoCompNumeracionPK[ idtipocomp=" + idtipocomp + ", idpuntovta=" + idpuntovta + " ]";
    }
    
}
