/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.cuenta;

import ar.com.zir.cipres.legacy.api.security.Usuario;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Martin Runge {@literal <jmrunge@gmail.com>}
 */
@Entity
@Table(name = "CIERRE_OPERADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CierreOperador.findAll", query = "SELECT c FROM CierreOperador c"),
    @NamedQuery(name = "CierreOperador.findByIdcierreoper", query = "SELECT c FROM CierreOperador c WHERE c.idcierreoper = :idcierreoper"),
    @NamedQuery(name = "CierreOperador.findByFechacierre", query = "SELECT c FROM CierreOperador c WHERE c.fechacierre = :fechacierre"),
    @NamedQuery(name = "CierreOperador.findByFecharendicion", query = "SELECT c FROM CierreOperador c WHERE c.fecharendicion = :fecharendicion")})
public class CierreOperador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_cierre_oper")
    private Integer idcierreoper;
    @Column(name = "Fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacierre;
    @Column(name = "Fecha_rendicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharendicion;
    @JoinColumn(name = "Id_cierre_gen", referencedColumnName = "Id_cierre_gen")
    @ManyToOne
    private CierreGeneral idcierregen;
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcierreoper")
    private Collection<Comprobante> comprobanteCollection;
    @OneToMany(mappedBy = "idcierreopcancela")
    private Collection<Comprobante> comprobanteCollection1;

    public CierreOperador() {
    }

    public CierreOperador(Integer idcierreoper) {
        this.idcierreoper = idcierreoper;
    }

    public Integer getIdcierreoper() {
        return idcierreoper;
    }

    public void setIdcierreoper(Integer idcierreoper) {
        this.idcierreoper = idcierreoper;
    }

    public Date getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(Date fechacierre) {
        this.fechacierre = fechacierre;
    }

    public Date getFecharendicion() {
        return fecharendicion;
    }

    public void setFecharendicion(Date fecharendicion) {
        this.fecharendicion = fecharendicion;
    }

    public CierreGeneral getIdcierregen() {
        return idcierregen;
    }

    public void setIdcierregen(CierreGeneral idcierregen) {
        this.idcierregen = idcierregen;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public Collection<Comprobante> getComprobanteCollection() {
        return comprobanteCollection;
    }

    public void setComprobanteCollection(Collection<Comprobante> comprobanteCollection) {
        this.comprobanteCollection = comprobanteCollection;
    }

    @XmlTransient
    public Collection<Comprobante> getComprobanteCollection1() {
        return comprobanteCollection1;
    }

    public void setComprobanteCollection1(Collection<Comprobante> comprobanteCollection1) {
        this.comprobanteCollection1 = comprobanteCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcierreoper != null ? idcierreoper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CierreOperador)) {
            return false;
        }
        CierreOperador other = (CierreOperador) object;
        if ((this.idcierreoper == null && other.idcierreoper != null) || (this.idcierreoper != null && !this.idcierreoper.equals(other.idcierreoper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.cuenta.CierreOperador[ idcierreoper=" + idcierreoper + " ]";
    }
    
}
