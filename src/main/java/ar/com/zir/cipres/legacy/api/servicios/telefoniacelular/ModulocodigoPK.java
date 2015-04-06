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
public class ModulocodigoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_modulo")
    private short idtipomodulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_modulo")
    private short idmodulo;

    public ModulocodigoPK() {
    }

    public ModulocodigoPK(short idtipomodulo, short idmodulo) {
        this.idtipomodulo = idtipomodulo;
        this.idmodulo = idmodulo;
    }

    public short getIdtipomodulo() {
        return idtipomodulo;
    }

    public void setIdtipomodulo(short idtipomodulo) {
        this.idtipomodulo = idtipomodulo;
    }

    public short getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(short idmodulo) {
        this.idmodulo = idmodulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtipomodulo;
        hash += (int) idmodulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModulocodigoPK)) {
            return false;
        }
        ModulocodigoPK other = (ModulocodigoPK) object;
        if (this.idtipomodulo != other.idtipomodulo) {
            return false;
        }
        if (this.idmodulo != other.idmodulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.ModulocodigoPK[ idtipomodulo=" + idtipomodulo + ", idmodulo=" + idmodulo + " ]";
    }
    
}
