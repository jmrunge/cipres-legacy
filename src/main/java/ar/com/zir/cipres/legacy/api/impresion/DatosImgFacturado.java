/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.impresion;

import ar.com.zir.cipres.legacy.api.security.Usuario;
import ar.com.zir.cipres.legacy.api.facturacion.Facturacion;
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
@Table(name = "DATOS_IMG_FACTURADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosImgFacturado.findAll", query = "SELECT d FROM DatosImgFacturado d"),
    @NamedQuery(name = "DatosImgFacturado.findByFechaimgdesde", query = "SELECT d FROM DatosImgFacturado d WHERE d.fechaimgdesde = :fechaimgdesde"),
    @NamedQuery(name = "DatosImgFacturado.findByDatabasename", query = "SELECT d FROM DatosImgFacturado d WHERE d.databasename = :databasename"),
    @NamedQuery(name = "DatosImgFacturado.findByConnectstring", query = "SELECT d FROM DatosImgFacturado d WHERE d.connectstring = :connectstring"),
    @NamedQuery(name = "DatosImgFacturado.findByFechaimghasta", query = "SELECT d FROM DatosImgFacturado d WHERE d.fechaimghasta = :fechaimghasta"),
    @NamedQuery(name = "DatosImgFacturado.findByObservaciones", query = "SELECT d FROM DatosImgFacturado d WHERE d.observaciones = :observaciones")})
public class DatosImgFacturado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_img_desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaimgdesde;
    @Size(max = 255)
    @Column(name = "Database_name")
    private String databasename;
    @Size(max = 255)
    @Column(name = "Connect_string")
    private String connectstring;
    @Column(name = "Fecha_img_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaimghasta;
    @Size(max = 255)
    @Column(name = "Observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "fechaimgdesde")
    private Collection<Facturacion> facturacionCollection;
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public DatosImgFacturado() {
    }

    public DatosImgFacturado(Date fechaimgdesde) {
        this.fechaimgdesde = fechaimgdesde;
    }

    public Date getFechaimgdesde() {
        return fechaimgdesde;
    }

    public void setFechaimgdesde(Date fechaimgdesde) {
        this.fechaimgdesde = fechaimgdesde;
    }

    public String getDatabasename() {
        return databasename;
    }

    public void setDatabasename(String databasename) {
        this.databasename = databasename;
    }

    public String getConnectstring() {
        return connectstring;
    }

    public void setConnectstring(String connectstring) {
        this.connectstring = connectstring;
    }

    public Date getFechaimghasta() {
        return fechaimghasta;
    }

    public void setFechaimghasta(Date fechaimghasta) {
        this.fechaimghasta = fechaimghasta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<Facturacion> getFacturacionCollection() {
        return facturacionCollection;
    }

    public void setFacturacionCollection(Collection<Facturacion> facturacionCollection) {
        this.facturacionCollection = facturacionCollection;
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
        hash += (fechaimgdesde != null ? fechaimgdesde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosImgFacturado)) {
            return false;
        }
        DatosImgFacturado other = (DatosImgFacturado) object;
        if ((this.fechaimgdesde == null && other.fechaimgdesde != null) || (this.fechaimgdesde != null && !this.fechaimgdesde.equals(other.fechaimgdesde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.DatosImgFacturado[ fechaimgdesde=" + fechaimgdesde + " ]";
    }
    
}
