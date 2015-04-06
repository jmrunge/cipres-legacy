/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByNumero", query = "SELECT c FROM Cliente c WHERE c.numero = :numero"),
    @NamedQuery(name = "Cliente.findByPisodpto", query = "SELECT c FROM Cliente c WHERE c.pisodpto = :pisodpto"),
    @NamedQuery(name = "Cliente.findByCp", query = "SELECT c FROM Cliente c WHERE c.cp = :cp"),
    @NamedQuery(name = "Cliente.findByObservCP", query = "SELECT c FROM Cliente c WHERE c.observCP = :observCP"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cliente.findByFechaalta", query = "SELECT c FROM Cliente c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Cliente.findByFechabaja", query = "SELECT c FROM Cliente c WHERE c.fechabaja = :fechabaja"),
    @NamedQuery(name = "Cliente.findByObservaciones", query = "SELECT c FROM Cliente c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "Cliente.findByFechaactu", query = "SELECT c FROM Cliente c WHERE c.fechaactu = :fechaactu"),
    @NamedQuery(name = "Cliente.findByVinculosys", query = "SELECT c FROM Cliente c WHERE c.vinculosys = :vinculosys"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
    @NamedQuery(name = "Cliente.findByDtype", query = "SELECT c FROM Cliente c WHERE c.dtype = :dtype")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_cliente")
    private Integer idcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Numero")
    private String numero;
    @Size(max = 10)
    @Column(name = "Piso_dpto")
    private String pisodpto;
    @Size(max = 8)
    @Column(name = "CP")
    private String cp;
    @Size(max = 255)
    @Column(name = "Observ_CP")
    private String observCP;
    @Size(max = 40)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaalta;
    @Column(name = "Fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechabaja;
    @Size(max = 255)
    @Column(name = "Observaciones")
    private String observaciones;
    @Column(name = "Fecha_actu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaactu;
    @Size(max = 15)
    @Column(name = "Vinculo_sys")
    private String vinculosys;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "email")
    private String email;
    @Size(max = 30)
    @Column(name = "DTYPE")
    private String dtype;
    @JoinColumns({
        @JoinColumn(name = "Id_provincia", referencedColumnName = "Id_provincia"),
        @JoinColumn(name = "Id_localidad", referencedColumnName = "Id_localidad"),
        @JoinColumn(name = "Id_calle", referencedColumnName = "Id_calle")})
    @ManyToOne(optional = false)
    private Calle calle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private Collection<Prestacion> prestacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private Collection<Cuenta> cuentaCollection;

    public Cliente() {
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(Integer idcliente, String nombre, String numero, Date fechaalta) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.numero = numero;
        this.fechaalta = fechaalta;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPisodpto() {
        return pisodpto;
    }

    public void setPisodpto(String pisodpto) {
        this.pisodpto = pisodpto;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getObservCP() {
        return observCP;
    }

    public void setObservCP(String observCP) {
        this.observCP = observCP;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public Calle getCalle() {
        return calle;
    }

    public void setCalle(Calle calle) {
        this.calle = calle;
    }

    @XmlTransient
    public Collection<Prestacion> getPrestacionCollection() {
        return prestacionCollection;
    }

    public void setPrestacionCollection(Collection<Prestacion> prestacionCollection) {
        this.prestacionCollection = prestacionCollection;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
