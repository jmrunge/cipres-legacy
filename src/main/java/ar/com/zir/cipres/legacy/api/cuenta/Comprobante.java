/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.cuenta;

import ar.com.zir.cipres.legacy.api.servicios.Prestacion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "COMPROBANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprobante.findAll", query = "SELECT c FROM Comprobante c"),
    @NamedQuery(name = "Comprobante.findByIdcomprobante", query = "SELECT c FROM Comprobante c WHERE c.idcomprobante = :idcomprobante"),
    @NamedQuery(name = "Comprobante.findByNrocomprobante", query = "SELECT c FROM Comprobante c WHERE c.nrocomprobante = :nrocomprobante"),
    @NamedQuery(name = "Comprobante.findByImporte", query = "SELECT c FROM Comprobante c WHERE c.importe = :importe"),
    @NamedQuery(name = "Comprobante.findByFechaemision", query = "SELECT c FROM Comprobante c WHERE c.fechaemision = :fechaemision"),
    @NamedQuery(name = "Comprobante.findByVtofinanciero", query = "SELECT c FROM Comprobante c WHERE c.vtofinanciero = :vtofinanciero"),
    @NamedQuery(name = "Comprobante.findByFechacorte", query = "SELECT c FROM Comprobante c WHERE c.fechacorte = :fechacorte"),
    @NamedQuery(name = "Comprobante.findByFechacancelado", query = "SELECT c FROM Comprobante c WHERE c.fechacancelado = :fechacancelado"),
    @NamedQuery(name = "Comprobante.findByAnulado", query = "SELECT c FROM Comprobante c WHERE c.anulado = :anulado"),
    @NamedQuery(name = "Comprobante.findByExclusivo", query = "SELECT c FROM Comprobante c WHERE c.exclusivo = :exclusivo"),
    @NamedQuery(name = "Comprobante.findByPrf", query = "SELECT c FROM Comprobante c WHERE c.prf = :prf"),
    @NamedQuery(name = "Comprobante.findByPrfXor", query = "SELECT c FROM Comprobante c WHERE c.prfXor = :prfXor"),
    @NamedQuery(name = "Comprobante.findByNrolegal", query = "SELECT c FROM Comprobante c WHERE c.nrolegal = :nrolegal"),
    @NamedQuery(name = "Comprobante.findByEntraprocesos", query = "SELECT c FROM Comprobante c WHERE c.entraprocesos = :entraprocesos"),
    @NamedQuery(name = "Comprobante.findByCae", query = "SELECT c FROM Comprobante c WHERE c.cae = :cae")})
public class Comprobante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_comprobante")
    private Integer idcomprobante;
    @Column(name = "Nro_comprobante")
    private Integer nrocomprobante;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Importe")
    private BigDecimal importe;
    @Column(name = "Fecha_emision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaemision;
    @Column(name = "Vto_financiero")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vtofinanciero;
    @Column(name = "Fecha_corte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacorte;
    @Column(name = "Fecha_cancelado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacancelado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Anulado")
    private boolean anulado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Exclusivo")
    private boolean exclusivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRF")
    private boolean prf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRF_XOR")
    private boolean prfXor;
    @Column(name = "Nro_legal")
    private Integer nrolegal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Entra_procesos")
    private boolean entraprocesos;
    @Size(max = 20)
    @Column(name = "CAE")
    private String cae;
    @JoinTable(name = "COMP_INCO", joinColumns = {
        @JoinColumn(name = "Id_comprobante", referencedColumnName = "Id_comprobante")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_comp_inco", referencedColumnName = "Id_comprobante")})
    @ManyToMany
    private Collection<Comprobante> comprobanteCollection;
    @ManyToMany(mappedBy = "comprobanteCollection")
    private Collection<Comprobante> comprobanteCollection1;
    @JoinTable(name = "DIST_PAGO_CTA", joinColumns = {
        @JoinColumn(name = "Id_comp_credito", referencedColumnName = "Id_comprobante")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_comp_debito", referencedColumnName = "Id_comprobante")})
    @ManyToMany
    private Collection<Comprobante> comprobanteCollection2;
    @ManyToMany(mappedBy = "comprobanteCollection2")
    private Collection<Comprobante> comprobanteCollection3;
    @JoinTable(name = "COMP_TRANS", joinColumns = {
        @JoinColumn(name = "Id_comprobante", referencedColumnName = "Id_comprobante")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_comp_trans", referencedColumnName = "Id_comprobante")})
    @ManyToMany
    private Collection<Comprobante> comprobanteCollection4;
    @ManyToMany(mappedBy = "comprobanteCollection4")
    private Collection<Comprobante> comprobanteCollection5;
    @JoinColumn(name = "Id_cierre_oper", referencedColumnName = "Id_cierre_oper")
    @ManyToOne(optional = false)
    private CierreOperador idcierreoper;
    @JoinColumn(name = "Id_cierre_op_cancela", referencedColumnName = "Id_cierre_oper")
    @ManyToOne
    private CierreOperador idcierreopcancela;
    @JoinColumn(name = "Id_cuenta", referencedColumnName = "Id_cuenta")
    @ManyToOne(optional = false)
    private Cuenta idcuenta;
    @JoinColumn(name = "Id_prestacion", referencedColumnName = "Id_prestacion")
    @ManyToOne
    private Prestacion idprestacion;
    @JoinColumns({
        @JoinColumn(name = "Id_tipo_comp", referencedColumnName = "Id_tipo_comp"),
        @JoinColumn(name = "Id_punto_vta", referencedColumnName = "Id_punto_vta")})
    @ManyToOne(optional = false)
    private TipoCompNumeracion tipoCompNumeracion;
    @JoinColumn(name = "Id_tipo_IVA", referencedColumnName = "Id_tipo_IVA")
    @ManyToOne
    private TipoIva idtipoIVA;

    public Comprobante() {
    }

    public Comprobante(Integer idcomprobante) {
        this.idcomprobante = idcomprobante;
    }

    public Comprobante(Integer idcomprobante, BigDecimal importe, boolean anulado, boolean exclusivo, boolean prf, boolean prfXor, boolean entraprocesos) {
        this.idcomprobante = idcomprobante;
        this.importe = importe;
        this.anulado = anulado;
        this.exclusivo = exclusivo;
        this.prf = prf;
        this.prfXor = prfXor;
        this.entraprocesos = entraprocesos;
    }

    public Integer getIdcomprobante() {
        return idcomprobante;
    }

    public void setIdcomprobante(Integer idcomprobante) {
        this.idcomprobante = idcomprobante;
    }

    public Integer getNrocomprobante() {
        return nrocomprobante;
    }

    public void setNrocomprobante(Integer nrocomprobante) {
        this.nrocomprobante = nrocomprobante;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public Date getVtofinanciero() {
        return vtofinanciero;
    }

    public void setVtofinanciero(Date vtofinanciero) {
        this.vtofinanciero = vtofinanciero;
    }

    public Date getFechacorte() {
        return fechacorte;
    }

    public void setFechacorte(Date fechacorte) {
        this.fechacorte = fechacorte;
    }

    public Date getFechacancelado() {
        return fechacancelado;
    }

    public void setFechacancelado(Date fechacancelado) {
        this.fechacancelado = fechacancelado;
    }

    public boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }

    public boolean getExclusivo() {
        return exclusivo;
    }

    public void setExclusivo(boolean exclusivo) {
        this.exclusivo = exclusivo;
    }

    public boolean getPrf() {
        return prf;
    }

    public void setPrf(boolean prf) {
        this.prf = prf;
    }

    public boolean getPrfXor() {
        return prfXor;
    }

    public void setPrfXor(boolean prfXor) {
        this.prfXor = prfXor;
    }

    public Integer getNrolegal() {
        return nrolegal;
    }

    public void setNrolegal(Integer nrolegal) {
        this.nrolegal = nrolegal;
    }

    public boolean getEntraprocesos() {
        return entraprocesos;
    }

    public void setEntraprocesos(boolean entraprocesos) {
        this.entraprocesos = entraprocesos;
    }

    public String getCae() {
        return cae;
    }

    public void setCae(String cae) {
        this.cae = cae;
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

    @XmlTransient
    public Collection<Comprobante> getComprobanteCollection2() {
        return comprobanteCollection2;
    }

    public void setComprobanteCollection2(Collection<Comprobante> comprobanteCollection2) {
        this.comprobanteCollection2 = comprobanteCollection2;
    }

    @XmlTransient
    public Collection<Comprobante> getComprobanteCollection3() {
        return comprobanteCollection3;
    }

    public void setComprobanteCollection3(Collection<Comprobante> comprobanteCollection3) {
        this.comprobanteCollection3 = comprobanteCollection3;
    }

    @XmlTransient
    public Collection<Comprobante> getComprobanteCollection4() {
        return comprobanteCollection4;
    }

    public void setComprobanteCollection4(Collection<Comprobante> comprobanteCollection4) {
        this.comprobanteCollection4 = comprobanteCollection4;
    }

    @XmlTransient
    public Collection<Comprobante> getComprobanteCollection5() {
        return comprobanteCollection5;
    }

    public void setComprobanteCollection5(Collection<Comprobante> comprobanteCollection5) {
        this.comprobanteCollection5 = comprobanteCollection5;
    }

    public CierreOperador getIdcierreoper() {
        return idcierreoper;
    }

    public void setIdcierreoper(CierreOperador idcierreoper) {
        this.idcierreoper = idcierreoper;
    }

    public CierreOperador getIdcierreopcancela() {
        return idcierreopcancela;
    }

    public void setIdcierreopcancela(CierreOperador idcierreopcancela) {
        this.idcierreopcancela = idcierreopcancela;
    }

    public Cuenta getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Cuenta idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Prestacion getIdprestacion() {
        return idprestacion;
    }

    public void setIdprestacion(Prestacion idprestacion) {
        this.idprestacion = idprestacion;
    }

    public TipoCompNumeracion getTipoCompNumeracion() {
        return tipoCompNumeracion;
    }

    public void setTipoCompNumeracion(TipoCompNumeracion tipoCompNumeracion) {
        this.tipoCompNumeracion = tipoCompNumeracion;
    }

    public TipoIva getIdtipoIVA() {
        return idtipoIVA;
    }

    public void setIdtipoIVA(TipoIva idtipoIVA) {
        this.idtipoIVA = idtipoIVA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomprobante != null ? idcomprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprobante)) {
            return false;
        }
        Comprobante other = (Comprobante) object;
        if ((this.idcomprobante == null && other.idcomprobante != null) || (this.idcomprobante != null && !this.idcomprobante.equals(other.idcomprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.cuenta.Comprobante[ idcomprobante=" + idcomprobante + " ]";
    }
    
}
