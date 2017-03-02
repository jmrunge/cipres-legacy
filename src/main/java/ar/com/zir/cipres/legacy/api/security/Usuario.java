/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.security;

import ar.com.zir.cipres.legacy.api.cuenta.CierreGeneral;
import ar.com.zir.cipres.legacy.api.cuenta.CierreOperador;
import ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.ConsTelefMovil;
import ar.com.zir.cipres.legacy.api.impresion.DatosImgFacturado;
import ar.com.zir.cipres.legacy.api.facturacion.Facturacion;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jmrunge
 */
@Entity
@Table(name = "Usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByAbreviatura", query = "SELECT u FROM Usuario u WHERE u.abreviatura = :abreviatura"),
    @NamedQuery(name = "Usuario.findByHabilitado", query = "SELECT u FROM Usuario u WHERE u.habilitado = :habilitado"),
    @NamedQuery(name = "Usuario.findByExpirausu", query = "SELECT u FROM Usuario u WHERE u.expirausu = :expirausu"),
    @NamedQuery(name = "Usuario.findByCambiarpass", query = "SELECT u FROM Usuario u WHERE u.cambiarpass = :cambiarpass"),
    @NamedQuery(name = "Usuario.findByPassunicas", query = "SELECT u FROM Usuario u WHERE u.passunicas = :passunicas"),
    @NamedQuery(name = "Usuario.findByFuerzacambiopass", query = "SELECT u FROM Usuario u WHERE u.fuerzacambiopass = :fuerzacambiopass"),
    @NamedQuery(name = "Usuario.findByDiaspass", query = "SELECT u FROM Usuario u WHERE u.diaspass = :diaspass"),
    @NamedQuery(name = "Usuario.findByGracelogins", query = "SELECT u FROM Usuario u WHERE u.gracelogins = :gracelogins"),
    @NamedQuery(name = "Usuario.findByCantgracelogins", query = "SELECT u FROM Usuario u WHERE u.cantgracelogins = :cantgracelogins"),
    @NamedQuery(name = "Usuario.findBySysuserid", query = "SELECT u FROM Usuario u WHERE u.sysuserid = :sysuserid")})
public class Usuario implements Serializable {
    @Size(max = 60)
    @Column(name = "Nro_cospel")
    private String nrocospel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<CierreOperador> cierreOperadorCollection;
    @OneToMany(mappedBy = "idusuario")
    private Collection<CierreGeneral> cierreGeneralCollection;
    @OneToMany(mappedBy = "idusuariocontrol")
    private Collection<CierreGeneral> cierreGeneralCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<ConsTelefMovil> consTelefMovilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<Facturacion> facturacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<DatosImgFacturado> datosImgFacturadoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_usuario")
    private Short idusuario;
    @Basic(optional = false)
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Abreviatura")
    private String abreviatura;
    @Basic(optional = false)
    @Column(name = "Habilitado")
    private boolean habilitado;
    @Column(name = "Expira_usu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirausu;
    @Basic(optional = false)
    @Column(name = "Cambiar_pass")
    private boolean cambiarpass;
    @Basic(optional = false)
    @Column(name = "Pass_unicas")
    private boolean passunicas;
    @Basic(optional = false)
    @Column(name = "Fuerza_cambio_pass")
    private boolean fuerzacambiopass;
    @Column(name = "Dias_pass")
    private Short diaspass;
    @Column(name = "Grace_logins")
    private Short gracelogins;
    @Column(name = "Cant_grace_logins")
    private Short cantgracelogins;
    @Column(name = "Sys_user_id")
    private Integer sysuserid;
    @JoinColumn(name = "Id_sector", referencedColumnName = "Id_sector")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Sector idsector;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.EAGER)
    private Collection<Usuariopassword> usuariopasswordCollection;

    public Usuario() {
    }

    public Usuario(Short idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Short idusuario, String usuario, String nombre, String abreviatura, boolean habilitado, boolean cambiarpass, boolean passunicas, boolean fuerzacambiopass) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.habilitado = habilitado;
        this.cambiarpass = cambiarpass;
        this.passunicas = passunicas;
        this.fuerzacambiopass = fuerzacambiopass;
    }

    public Short getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Short idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Date getExpirausu() {
        return expirausu;
    }

    public void setExpirausu(Date expirausu) {
        this.expirausu = expirausu;
    }

    public boolean getCambiarpass() {
        return cambiarpass;
    }

    public void setCambiarpass(boolean cambiarpass) {
        this.cambiarpass = cambiarpass;
    }

    public boolean getPassunicas() {
        return passunicas;
    }

    public void setPassunicas(boolean passunicas) {
        this.passunicas = passunicas;
    }

    public boolean getFuerzacambiopass() {
        return fuerzacambiopass;
    }

    public void setFuerzacambiopass(boolean fuerzacambiopass) {
        this.fuerzacambiopass = fuerzacambiopass;
    }

    public Short getDiaspass() {
        return diaspass;
    }

    public void setDiaspass(Short diaspass) {
        this.diaspass = diaspass;
    }

    public Short getGracelogins() {
        return gracelogins;
    }

    public void setGracelogins(Short gracelogins) {
        this.gracelogins = gracelogins;
    }

    public Short getCantgracelogins() {
        return cantgracelogins;
    }

    public void setCantgracelogins(Short cantgracelogins) {
        this.cantgracelogins = cantgracelogins;
    }

    public Integer getSysuserid() {
        return sysuserid;
    }

    public void setSysuserid(Integer sysuserid) {
        this.sysuserid = sysuserid;
    }

    public Sector getIdsector() {
        return idsector;
    }

    public void setIdsector(Sector idsector) {
        this.idsector = idsector;
    }

    @XmlTransient
    public Collection<Usuariopassword> getUsuariopasswordCollection() {
        return usuariopasswordCollection;
    }

    public void setUsuariopasswordCollection(Collection<Usuariopassword> usuariopasswordCollection) {
        this.usuariopasswordCollection = usuariopasswordCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    @XmlTransient
    public Collection<ConsTelefMovil> getConsTelefMovilCollection() {
        return consTelefMovilCollection;
    }

    public void setConsTelefMovilCollection(Collection<ConsTelefMovil> consTelefMovilCollection) {
        this.consTelefMovilCollection = consTelefMovilCollection;
    }

    @XmlTransient
    public Collection<Facturacion> getFacturacionCollection() {
        return facturacionCollection;
    }

    public void setFacturacionCollection(Collection<Facturacion> facturacionCollection) {
        this.facturacionCollection = facturacionCollection;
    }

    @XmlTransient
    public Collection<DatosImgFacturado> getDatosImgFacturadoCollection() {
        return datosImgFacturadoCollection;
    }

    public void setDatosImgFacturadoCollection(Collection<DatosImgFacturado> datosImgFacturadoCollection) {
        this.datosImgFacturadoCollection = datosImgFacturadoCollection;
    }

    public String getNrocospel() {
        return nrocospel;
    }

    public void setNrocospel(String nrocospel) {
        this.nrocospel = nrocospel;
    }

    @XmlTransient
    public Collection<CierreOperador> getCierreOperadorCollection() {
        return cierreOperadorCollection;
    }

    public void setCierreOperadorCollection(Collection<CierreOperador> cierreOperadorCollection) {
        this.cierreOperadorCollection = cierreOperadorCollection;
    }

    @XmlTransient
    public Collection<CierreGeneral> getCierreGeneralCollection() {
        return cierreGeneralCollection;
    }

    public void setCierreGeneralCollection(Collection<CierreGeneral> cierreGeneralCollection) {
        this.cierreGeneralCollection = cierreGeneralCollection;
    }

    @XmlTransient
    public Collection<CierreGeneral> getCierreGeneralCollection1() {
        return cierreGeneralCollection1;
    }

    public void setCierreGeneralCollection1(Collection<CierreGeneral> cierreGeneralCollection1) {
        this.cierreGeneralCollection1 = cierreGeneralCollection1;
    }
    
}
