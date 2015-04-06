/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.security;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jmrunge
 */
@Embeddable
public class UsuariopasswordPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Id_usuario")
    private short idusuario;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public UsuariopasswordPK() {
    }

    public UsuariopasswordPK(short idusuario, String password, Date fecha) {
        this.idusuario = idusuario;
        this.password = password;
        this.fecha = fecha;
    }

    public short getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(short idusuario) {
        this.idusuario = idusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (int) idusuario;
        hash += (password != null ? password.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariopasswordPK)) {
            return false;
        }
        UsuariopasswordPK other = (UsuariopasswordPK) object;
        if (this.idusuario != other.idusuario) {
            return false;
        }
        if ((this.password == null && other.password != null) || (this.password != null && !this.password.equals(other.password))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.UsuariopasswordPK[ idusuario=" + idusuario + ", password=" + password + ", fecha=" + fecha + " ]";
    }
    
}
