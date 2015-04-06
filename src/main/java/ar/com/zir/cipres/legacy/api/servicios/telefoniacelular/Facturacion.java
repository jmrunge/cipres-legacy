/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import ar.com.zir.cipres.legacy.api.security.Usuario;
import java.io.Serializable;
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
 * @author jmrunge
 */
@Entity
@Table(name = "FACTURACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturacion.findAll", query = "SELECT f FROM Facturacion f"),
    @NamedQuery(name = "Facturacion.findByIdfacturacion", query = "SELECT f FROM Facturacion f WHERE f.idfacturacion = :idfacturacion"),
    @NamedQuery(name = "Facturacion.findByPeriodo", query = "SELECT f FROM Facturacion f WHERE f.periodo = :periodo"),
    @NamedQuery(name = "Facturacion.findByFecproceso", query = "SELECT f FROM Facturacion f WHERE f.fecproceso = :fecproceso"),
    @NamedQuery(name = "Facturacion.findByFecemision", query = "SELECT f FROM Facturacion f WHERE f.fecemision = :fecemision"),
    @NamedQuery(name = "Facturacion.findByFecPRFs", query = "SELECT f FROM Facturacion f WHERE f.fecPRFs = :fecPRFs"),
    @NamedQuery(name = "Facturacion.findByFechacorte", query = "SELECT f FROM Facturacion f WHERE f.fechacorte = :fechacorte"),
    @NamedQuery(name = "Facturacion.findByMensaje", query = "SELECT f FROM Facturacion f WHERE f.mensaje = :mensaje"),
    @NamedQuery(name = "Facturacion.findByObservaciones", query = "SELECT f FROM Facturacion f WHERE f.observaciones = :observaciones"),
    @NamedQuery(name = "Facturacion.findByFinalizado", query = "SELECT f FROM Facturacion f WHERE f.finalizado = :finalizado"),
    @NamedQuery(name = "Facturacion.findByIdcomprobantedesde", query = "SELECT f FROM Facturacion f WHERE f.idcomprobantedesde = :idcomprobantedesde"),
    @NamedQuery(name = "Facturacion.findByIdcomprobantehasta", query = "SELECT f FROM Facturacion f WHERE f.idcomprobantehasta = :idcomprobantehasta"),
    @NamedQuery(name = "Facturacion.findByProxvto", query = "SELECT f FROM Facturacion f WHERE f.proxvto = :proxvto"),
    @NamedQuery(name = "Facturacion.findByUtilizaCESP", query = "SELECT f FROM Facturacion f WHERE f.utilizaCESP = :utilizaCESP")})
public class Facturacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_facturacion")
    private Integer idfacturacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Periodo")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fec_proceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecproceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fec_emision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecemision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fec_PRFs")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecPRFs;
    @Column(name = "Fecha_corte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacorte;
    @Size(max = 1073741823)
    @Column(name = "Mensaje")
    private String mensaje;
    @Size(max = 255)
    @Column(name = "Observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Finalizado")
    private short finalizado;
    @Column(name = "Id_comprobante_desde")
    private Integer idcomprobantedesde;
    @Column(name = "Id_comprobante_hasta")
    private Integer idcomprobantehasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prox_vto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proxvto;
    @Column(name = "UtilizaCESP")
    private Boolean utilizaCESP;
    @OneToMany(mappedBy = "idfacturacion")
    private Collection<ConsTelefMovil> consTelefMovilCollection;
    @JoinColumn(name = "Fecha_img_desde", referencedColumnName = "Fecha_img_desde")
    @ManyToOne
    private DatosImgFacturado fechaimgdesde;
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Facturacion() {
    }

    public Facturacion(Integer idfacturacion) {
        this.idfacturacion = idfacturacion;
    }

    public Facturacion(Integer idfacturacion, String periodo, Date fecproceso, Date fecemision, Date fecPRFs, short finalizado, Date proxvto) {
        this.idfacturacion = idfacturacion;
        this.periodo = periodo;
        this.fecproceso = fecproceso;
        this.fecemision = fecemision;
        this.fecPRFs = fecPRFs;
        this.finalizado = finalizado;
        this.proxvto = proxvto;
    }

    public Integer getIdfacturacion() {
        return idfacturacion;
    }

    public void setIdfacturacion(Integer idfacturacion) {
        this.idfacturacion = idfacturacion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getFecproceso() {
        return fecproceso;
    }

    public void setFecproceso(Date fecproceso) {
        this.fecproceso = fecproceso;
    }

    public Date getFecemision() {
        return fecemision;
    }

    public void setFecemision(Date fecemision) {
        this.fecemision = fecemision;
    }

    public Date getFecPRFs() {
        return fecPRFs;
    }

    public void setFecPRFs(Date fecPRFs) {
        this.fecPRFs = fecPRFs;
    }

    public Date getFechacorte() {
        return fechacorte;
    }

    public void setFechacorte(Date fechacorte) {
        this.fechacorte = fechacorte;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public short getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(short finalizado) {
        this.finalizado = finalizado;
    }

    public Integer getIdcomprobantedesde() {
        return idcomprobantedesde;
    }

    public void setIdcomprobantedesde(Integer idcomprobantedesde) {
        this.idcomprobantedesde = idcomprobantedesde;
    }

    public Integer getIdcomprobantehasta() {
        return idcomprobantehasta;
    }

    public void setIdcomprobantehasta(Integer idcomprobantehasta) {
        this.idcomprobantehasta = idcomprobantehasta;
    }

    public Date getProxvto() {
        return proxvto;
    }

    public void setProxvto(Date proxvto) {
        this.proxvto = proxvto;
    }

    public Boolean getUtilizaCESP() {
        return utilizaCESP;
    }

    public void setUtilizaCESP(Boolean utilizaCESP) {
        this.utilizaCESP = utilizaCESP;
    }

    @XmlTransient
    public Collection<ConsTelefMovil> getConsTelefMovilCollection() {
        return consTelefMovilCollection;
    }

    public void setConsTelefMovilCollection(Collection<ConsTelefMovil> consTelefMovilCollection) {
        this.consTelefMovilCollection = consTelefMovilCollection;
    }

    public DatosImgFacturado getFechaimgdesde() {
        return fechaimgdesde;
    }

    public void setFechaimgdesde(DatosImgFacturado fechaimgdesde) {
        this.fechaimgdesde = fechaimgdesde;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacturacion != null ? idfacturacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturacion)) {
            return false;
        }
        Facturacion other = (Facturacion) object;
        if ((this.idfacturacion == null && other.idfacturacion != null) || (this.idfacturacion != null && !this.idfacturacion.equals(other.idfacturacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Facturacion[ idfacturacion=" + idfacturacion + " ]";
    }
    
}
