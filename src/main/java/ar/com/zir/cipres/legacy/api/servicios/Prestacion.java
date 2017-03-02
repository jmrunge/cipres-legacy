/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios;

import ar.com.zir.cipres.legacy.api.servicios.GrupoVto;
import ar.com.zir.cipres.legacy.api.servicios.Frecuencia;
import ar.com.zir.cipres.legacy.api.cuenta.Cuenta;
import ar.com.zir.cipres.legacy.api.cliente.Cliente;
import ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.PrestTelefonia;
import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmrunge
 */
@Entity
@Table(name = "PRESTACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestacion.findAll", query = "SELECT p FROM Prestacion p"),
    @NamedQuery(name = "Prestacion.findByIdprestacion", query = "SELECT p FROM Prestacion p WHERE p.idprestacion = :idprestacion"),
    @NamedQuery(name = "Prestacion.findByPrepago", query = "SELECT p FROM Prestacion p WHERE p.prepago = :prepago"),
    @NamedQuery(name = "Prestacion.findByNroplanilla", query = "SELECT p FROM Prestacion p WHERE p.nroplanilla = :nroplanilla"),
    @NamedQuery(name = "Prestacion.findByFechaactu", query = "SELECT p FROM Prestacion p WHERE p.fechaactu = :fechaactu"),
    @NamedQuery(name = "Prestacion.findByVinculosys", query = "SELECT p FROM Prestacion p WHERE p.vinculosys = :vinculosys")})
public class Prestacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_prestacion")
    private Integer idprestacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prepago")
    private boolean prepago;
    @Size(max = 15)
    @Column(name = "Nro_planilla")
    private String nroplanilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_actu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaactu;
    @Size(max = 15)
    @Column(name = "Vinculo_sys")
    private String vinculosys;
    @JoinColumn(name = "Id_cliente", referencedColumnName = "Id_cliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @JoinColumn(name = "Id_cuenta", referencedColumnName = "Id_cuenta")
    @ManyToOne(optional = false)
    private Cuenta idcuenta;
    @JoinColumn(name = "Id_frecuencia", referencedColumnName = "Id_frecuencia")
    @ManyToOne(optional = false)
    private Frecuencia idfrecuencia;
    @JoinColumn(name = "Id_grupo_vto", referencedColumnName = "Id_grupo_vto")
    @ManyToOne(optional = false)
    private GrupoVto idgrupovto;
    @JoinColumn(name = "Id_servicio", referencedColumnName = "Id_servicio")
    @ManyToOne(optional = false)
    private Servicio idservicio;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prestacion")
    private PrestTelefonia prestTelefonia;

    public Prestacion() {
    }

    public Prestacion(Integer idprestacion) {
        this.idprestacion = idprestacion;
    }

    public Prestacion(Integer idprestacion, boolean prepago, Date fechaactu) {
        this.idprestacion = idprestacion;
        this.prepago = prepago;
        this.fechaactu = fechaactu;
    }

    public Integer getIdprestacion() {
        return idprestacion;
    }

    public void setIdprestacion(Integer idprestacion) {
        this.idprestacion = idprestacion;
    }

    public boolean getPrepago() {
        return prepago;
    }

    public void setPrepago(boolean prepago) {
        this.prepago = prepago;
    }

    public String getNroplanilla() {
        return nroplanilla;
    }

    public void setNroplanilla(String nroplanilla) {
        this.nroplanilla = nroplanilla;
    }

    public Date getFechaactu() {
        return fechaactu;
    }

    public void setFechaactu(Date fechaactu) {
        this.fechaactu = fechaactu;
    }

    public String getVinculosys() {
        return vinculosys;
    }

    public void setVinculosys(String vinculosys) {
        this.vinculosys = vinculosys;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Cuenta getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Cuenta idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Frecuencia getIdfrecuencia() {
        return idfrecuencia;
    }

    public void setIdfrecuencia(Frecuencia idfrecuencia) {
        this.idfrecuencia = idfrecuencia;
    }

    public GrupoVto getIdgrupovto() {
        return idgrupovto;
    }

    public void setIdgrupovto(GrupoVto idgrupovto) {
        this.idgrupovto = idgrupovto;
    }

    public Servicio getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Servicio idservicio) {
        this.idservicio = idservicio;
    }

    public PrestTelefonia getPrestTelefonia() {
        return prestTelefonia;
    }

    public void setPrestTelefonia(PrestTelefonia prestTelefonia) {
        this.prestTelefonia = prestTelefonia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprestacion != null ? idprestacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestacion)) {
            return false;
        }
        Prestacion other = (Prestacion) object;
        if ((this.idprestacion == null && other.idprestacion != null) || (this.idprestacion != null && !this.idprestacion.equals(other.idprestacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Prestacion[ idprestacion=" + idprestacion + " ]";
    }
    
}
