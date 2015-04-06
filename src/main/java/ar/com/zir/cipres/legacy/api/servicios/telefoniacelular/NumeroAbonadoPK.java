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
import javax.validation.constraints.Size;

/**
 *
 * @author jmrunge
 */
@Embeddable
public class NumeroAbonadoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Prefijo")
    private String prefijo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nro_telefono")
    private int nrotelefono;

    public NumeroAbonadoPK() {
    }

    public NumeroAbonadoPK(String prefijo, int nrotelefono) {
        this.prefijo = prefijo;
        this.nrotelefono = nrotelefono;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prefijo != null ? prefijo.hashCode() : 0);
        hash += (int) nrotelefono;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumeroAbonadoPK)) {
            return false;
        }
        NumeroAbonadoPK other = (NumeroAbonadoPK) object;
        if ((this.prefijo == null && other.prefijo != null) || (this.prefijo != null && !this.prefijo.equals(other.prefijo))) {
            return false;
        }
        if (this.nrotelefono != other.nrotelefono) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.NumeroAbonadoPK[ prefijo=" + prefijo + ", nrotelefono=" + nrotelefono + " ]";
    }
    
}
