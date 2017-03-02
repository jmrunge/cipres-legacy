/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.cuenta;

import ar.com.zir.cipres.legacy.api.security.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Martin Runge {@literal <jmrunge@gmail.com>}
 */
@Entity
@Table(name = "CIERRE_GENERAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CierreGeneral.findAll", query = "SELECT c FROM CierreGeneral c"),
    @NamedQuery(name = "CierreGeneral.findByIdcierregen", query = "SELECT c FROM CierreGeneral c WHERE c.idcierregen = :idcierregen"),
    @NamedQuery(name = "CierreGeneral.findByFechacierre", query = "SELECT c FROM CierreGeneral c WHERE c.fechacierre = :fechacierre"),
    @NamedQuery(name = "CierreGeneral.findByImpinicio", query = "SELECT c FROM CierreGeneral c WHERE c.impinicio = :impinicio"),
    @NamedQuery(name = "CierreGeneral.findByImpemitido", query = "SELECT c FROM CierreGeneral c WHERE c.impemitido = :impemitido"),
    @NamedQuery(name = "CierreGeneral.findByImpcancelado", query = "SELECT c FROM CierreGeneral c WHERE c.impcancelado = :impcancelado"),
    @NamedQuery(name = "CierreGeneral.findByImpcierre", query = "SELECT c FROM CierreGeneral c WHERE c.impcierre = :impcierre"),
    @NamedQuery(name = "CierreGeneral.findByDiferencia", query = "SELECT c FROM CierreGeneral c WHERE c.diferencia = :diferencia"),
    @NamedQuery(name = "CierreGeneral.findByObservaciones", query = "SELECT c FROM CierreGeneral c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "CierreGeneral.findByImpotros", query = "SELECT c FROM CierreGeneral c WHERE c.impotros = :impotros"),
    @NamedQuery(name = "CierreGeneral.findByFechacontrol", query = "SELECT c FROM CierreGeneral c WHERE c.fechacontrol = :fechacontrol"),
    @NamedQuery(name = "CierreGeneral.findByDifcontrol", query = "SELECT c FROM CierreGeneral c WHERE c.difcontrol = :difcontrol")})
public class CierreGeneral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_cierre_gen")
    private Integer idcierregen;
    @Column(name = "Fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacierre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Imp_inicio")
    private BigDecimal impinicio;
    @Column(name = "Imp_emitido")
    private BigDecimal impemitido;
    @Column(name = "Imp_cancelado")
    private BigDecimal impcancelado;
    @Column(name = "Imp_cierre")
    private BigDecimal impcierre;
    @Column(name = "Diferencia")
    private BigDecimal diferencia;
    @Size(max = 255)
    @Column(name = "Observaciones")
    private String observaciones;
    @Column(name = "Imp_otros")
    private BigDecimal impotros;
    @Column(name = "Fecha_control")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacontrol;
    @Column(name = "Dif_control")
    private BigDecimal difcontrol;
    @OneToMany(mappedBy = "idcierregen")
    private Collection<CierreOperador> cierreOperadorCollection;
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    @ManyToOne
    private Usuario idusuario;
    @JoinColumn(name = "Id_usuario_control", referencedColumnName = "Id_usuario")
    @ManyToOne
    private Usuario idusuariocontrol;

    public CierreGeneral() {
    }

    public CierreGeneral(Integer idcierregen) {
        this.idcierregen = idcierregen;
    }

    public Integer getIdcierregen() {
        return idcierregen;
    }

    public void setIdcierregen(Integer idcierregen) {
        this.idcierregen = idcierregen;
    }

    public Date getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(Date fechacierre) {
        this.fechacierre = fechacierre;
    }

    public BigDecimal getImpinicio() {
        return impinicio;
    }

    public void setImpinicio(BigDecimal impinicio) {
        this.impinicio = impinicio;
    }

    public BigDecimal getImpemitido() {
        return impemitido;
    }

    public void setImpemitido(BigDecimal impemitido) {
        this.impemitido = impemitido;
    }

    public BigDecimal getImpcancelado() {
        return impcancelado;
    }

    public void setImpcancelado(BigDecimal impcancelado) {
        this.impcancelado = impcancelado;
    }

    public BigDecimal getImpcierre() {
        return impcierre;
    }

    public void setImpcierre(BigDecimal impcierre) {
        this.impcierre = impcierre;
    }

    public BigDecimal getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(BigDecimal diferencia) {
        this.diferencia = diferencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getImpotros() {
        return impotros;
    }

    public void setImpotros(BigDecimal impotros) {
        this.impotros = impotros;
    }

    public Date getFechacontrol() {
        return fechacontrol;
    }

    public void setFechacontrol(Date fechacontrol) {
        this.fechacontrol = fechacontrol;
    }

    public BigDecimal getDifcontrol() {
        return difcontrol;
    }

    public void setDifcontrol(BigDecimal difcontrol) {
        this.difcontrol = difcontrol;
    }

    @XmlTransient
    public Collection<CierreOperador> getCierreOperadorCollection() {
        return cierreOperadorCollection;
    }

    public void setCierreOperadorCollection(Collection<CierreOperador> cierreOperadorCollection) {
        this.cierreOperadorCollection = cierreOperadorCollection;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario getIdusuariocontrol() {
        return idusuariocontrol;
    }

    public void setIdusuariocontrol(Usuario idusuariocontrol) {
        this.idusuariocontrol = idusuariocontrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcierregen != null ? idcierregen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CierreGeneral)) {
            return false;
        }
        CierreGeneral other = (CierreGeneral) object;
        if ((this.idcierregen == null && other.idcierregen != null) || (this.idcierregen != null && !this.idcierregen.equals(other.idcierregen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.cuenta.CierreGeneral[ idcierregen=" + idcierregen + " ]";
    }
    
}
