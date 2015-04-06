/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.security;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmrunge
 */
@Entity
@Table(name = "Usuario_password")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariopassword.findAll", query = "SELECT u FROM Usuariopassword u"),
    @NamedQuery(name = "Usuariopassword.findByIdusuario", query = "SELECT u FROM Usuariopassword u WHERE u.usuariopasswordPK.idusuario = :idusuario"),
    @NamedQuery(name = "Usuariopassword.findByPassword", query = "SELECT u FROM Usuariopassword u WHERE u.usuariopasswordPK.password = :password"),
    @NamedQuery(name = "Usuariopassword.findByFecha", query = "SELECT u FROM Usuariopassword u WHERE u.usuariopasswordPK.fecha = :fecha")})
public class Usuariopassword implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariopasswordPK usuariopasswordPK;
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Usuariopassword() {
    }

    public Usuariopassword(UsuariopasswordPK usuariopasswordPK) {
        this.usuariopasswordPK = usuariopasswordPK;
    }

    public Usuariopassword(short idusuario, String password, Date fecha) {
        this.usuariopasswordPK = new UsuariopasswordPK(idusuario, password, fecha);
    }

    public UsuariopasswordPK getUsuariopasswordPK() {
        return usuariopasswordPK;
    }

    public void setUsuariopasswordPK(UsuariopasswordPK usuariopasswordPK) {
        this.usuariopasswordPK = usuariopasswordPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariopasswordPK != null ? usuariopasswordPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariopassword)) {
            return false;
        }
        Usuariopassword other = (Usuariopassword) object;
        if ((this.usuariopasswordPK == null && other.usuariopasswordPK != null) || (this.usuariopasswordPK != null && !this.usuariopasswordPK.equals(other.usuariopasswordPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.Usuariopassword[ usuariopasswordPK=" + usuariopasswordPK + " ]";
    }
    
}
