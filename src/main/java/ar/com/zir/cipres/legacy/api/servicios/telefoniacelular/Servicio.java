/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jmrunge
 */
@Entity
@Table(name = "SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findByIdservicio", query = "SELECT s FROM Servicio s WHERE s.idservicio = :idservicio"),
    @NamedQuery(name = "Servicio.findByDescripcion", query = "SELECT s FROM Servicio s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Servicio.findByActivo", query = "SELECT s FROM Servicio s WHERE s.activo = :activo"),
    @NamedQuery(name = "Servicio.findByCuotassociales", query = "SELECT s FROM Servicio s WHERE s.cuotassociales = :cuotassociales"),
    @NamedQuery(name = "Servicio.findByRequiereasociacion", query = "SELECT s FROM Servicio s WHERE s.requiereasociacion = :requiereasociacion"),
    @NamedQuery(name = "Servicio.findByMultipleafiliacion", query = "SELECT s FROM Servicio s WHERE s.multipleafiliacion = :multipleafiliacion"),
    @NamedQuery(name = "Servicio.findByAceptaadherentes", query = "SELECT s FROM Servicio s WHERE s.aceptaadherentes = :aceptaadherentes"),
    @NamedQuery(name = "Servicio.findByCantadherentes", query = "SELECT s FROM Servicio s WHERE s.cantadherentes = :cantadherentes"),
    @NamedQuery(name = "Servicio.findByTieneacometida", query = "SELECT s FROM Servicio s WHERE s.tieneacometida = :tieneacometida"),
    @NamedQuery(name = "Servicio.findByRealizamedicion", query = "SELECT s FROM Servicio s WHERE s.realizamedicion = :realizamedicion"),
    @NamedQuery(name = "Servicio.findByTrasladable", query = "SELECT s FROM Servicio s WHERE s.trasladable = :trasladable"),
    @NamedQuery(name = "Servicio.findByTransferible", query = "SELECT s FROM Servicio s WHERE s.transferible = :transferible"),
    @NamedQuery(name = "Servicio.findByFacturable", query = "SELECT s FROM Servicio s WHERE s.facturable = :facturable"),
    @NamedQuery(name = "Servicio.findByIcono", query = "SELECT s FROM Servicio s WHERE s.icono = :icono"),
    @NamedQuery(name = "Servicio.findByEsmandatario", query = "SELECT s FROM Servicio s WHERE s.esmandatario = :esmandatario"),
    @NamedQuery(name = "Servicio.findByTablafacturacion", query = "SELECT s FROM Servicio s WHERE s.tablafacturacion = :tablafacturacion"),
    @NamedQuery(name = "Servicio.findByVtapaquete", query = "SELECT s FROM Servicio s WHERE s.vtapaquete = :vtapaquete"),
    @NamedQuery(name = "Servicio.findByColector", query = "SELECT s FROM Servicio s WHERE s.colector = :colector"),
    @NamedQuery(name = "Servicio.findByRequieregarante", query = "SELECT s FROM Servicio s WHERE s.requieregarante = :requieregarante"),
    @NamedQuery(name = "Servicio.findByMultiplesprestaciones", query = "SELECT s FROM Servicio s WHERE s.multiplesprestaciones = :multiplesprestaciones")})
public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_servicio")
    private Short idservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cuotas_sociales")
    private boolean cuotassociales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Requiere_asociacion")
    private boolean requiereasociacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Multiple_afiliacion")
    private boolean multipleafiliacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Acepta_adherentes")
    private boolean aceptaadherentes;
    @Column(name = "Cant_adherentes")
    private Short cantadherentes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tiene_acometida")
    private boolean tieneacometida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Realiza_medicion")
    private boolean realizamedicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Trasladable")
    private boolean trasladable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Transferible")
    private boolean transferible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Facturable")
    private boolean facturable;
    @Size(max = 255)
    @Column(name = "Icono")
    private String icono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Es_mandatario")
    private boolean esmandatario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Tabla_facturacion")
    private String tablafacturacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vta_paquete")
    private boolean vtapaquete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Colector")
    private boolean colector;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Requiere_garante")
    private boolean requieregarante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Multiples_prestaciones")
    private boolean multiplesprestaciones;
    @JoinTable(name = "PUEDE_FACTURARSE_EN", joinColumns = {
        @JoinColumn(name = "Id_servicio", referencedColumnName = "Id_servicio")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_servicio_fact", referencedColumnName = "Id_servicio")})
    @ManyToMany
    private Collection<Servicio> servicioCollection;
    @ManyToMany(mappedBy = "servicioCollection")
    private Collection<Servicio> servicioCollection1;
    @JoinTable(name = "REQUIERE_DE", joinColumns = {
        @JoinColumn(name = "Id_servicio_req", referencedColumnName = "Id_servicio")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_servicio", referencedColumnName = "Id_servicio")})
    @ManyToMany
    private Collection<Servicio> servicioCollection2;
    @ManyToMany(mappedBy = "servicioCollection2")
    private Collection<Servicio> servicioCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicio")
    private Collection<Prestacion> prestacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicio")
    private Collection<ItemsAVender> itemsAVenderCollection;

    public Servicio() {
    }

    public Servicio(Short idservicio) {
        this.idservicio = idservicio;
    }

    public Servicio(Short idservicio, String descripcion, boolean activo, boolean cuotassociales, boolean requiereasociacion, boolean multipleafiliacion, boolean aceptaadherentes, boolean tieneacometida, boolean realizamedicion, boolean trasladable, boolean transferible, boolean facturable, boolean esmandatario, String tablafacturacion, boolean vtapaquete, boolean colector, boolean requieregarante, boolean multiplesprestaciones) {
        this.idservicio = idservicio;
        this.descripcion = descripcion;
        this.activo = activo;
        this.cuotassociales = cuotassociales;
        this.requiereasociacion = requiereasociacion;
        this.multipleafiliacion = multipleafiliacion;
        this.aceptaadherentes = aceptaadherentes;
        this.tieneacometida = tieneacometida;
        this.realizamedicion = realizamedicion;
        this.trasladable = trasladable;
        this.transferible = transferible;
        this.facturable = facturable;
        this.esmandatario = esmandatario;
        this.tablafacturacion = tablafacturacion;
        this.vtapaquete = vtapaquete;
        this.colector = colector;
        this.requieregarante = requieregarante;
        this.multiplesprestaciones = multiplesprestaciones;
    }

    public Short getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Short idservicio) {
        this.idservicio = idservicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getCuotassociales() {
        return cuotassociales;
    }

    public void setCuotassociales(boolean cuotassociales) {
        this.cuotassociales = cuotassociales;
    }

    public boolean getRequiereasociacion() {
        return requiereasociacion;
    }

    public void setRequiereasociacion(boolean requiereasociacion) {
        this.requiereasociacion = requiereasociacion;
    }

    public boolean getMultipleafiliacion() {
        return multipleafiliacion;
    }

    public void setMultipleafiliacion(boolean multipleafiliacion) {
        this.multipleafiliacion = multipleafiliacion;
    }

    public boolean getAceptaadherentes() {
        return aceptaadherentes;
    }

    public void setAceptaadherentes(boolean aceptaadherentes) {
        this.aceptaadherentes = aceptaadherentes;
    }

    public Short getCantadherentes() {
        return cantadherentes;
    }

    public void setCantadherentes(Short cantadherentes) {
        this.cantadherentes = cantadherentes;
    }

    public boolean getTieneacometida() {
        return tieneacometida;
    }

    public void setTieneacometida(boolean tieneacometida) {
        this.tieneacometida = tieneacometida;
    }

    public boolean getRealizamedicion() {
        return realizamedicion;
    }

    public void setRealizamedicion(boolean realizamedicion) {
        this.realizamedicion = realizamedicion;
    }

    public boolean getTrasladable() {
        return trasladable;
    }

    public void setTrasladable(boolean trasladable) {
        this.trasladable = trasladable;
    }

    public boolean getTransferible() {
        return transferible;
    }

    public void setTransferible(boolean transferible) {
        this.transferible = transferible;
    }

    public boolean getFacturable() {
        return facturable;
    }

    public void setFacturable(boolean facturable) {
        this.facturable = facturable;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public boolean getEsmandatario() {
        return esmandatario;
    }

    public void setEsmandatario(boolean esmandatario) {
        this.esmandatario = esmandatario;
    }

    public String getTablafacturacion() {
        return tablafacturacion;
    }

    public void setTablafacturacion(String tablafacturacion) {
        this.tablafacturacion = tablafacturacion;
    }

    public boolean getVtapaquete() {
        return vtapaquete;
    }

    public void setVtapaquete(boolean vtapaquete) {
        this.vtapaquete = vtapaquete;
    }

    public boolean getColector() {
        return colector;
    }

    public void setColector(boolean colector) {
        this.colector = colector;
    }

    public boolean getRequieregarante() {
        return requieregarante;
    }

    public void setRequieregarante(boolean requieregarante) {
        this.requieregarante = requieregarante;
    }

    public boolean getMultiplesprestaciones() {
        return multiplesprestaciones;
    }

    public void setMultiplesprestaciones(boolean multiplesprestaciones) {
        this.multiplesprestaciones = multiplesprestaciones;
    }

    @XmlTransient
    public Collection<Servicio> getServicioCollection() {
        return servicioCollection;
    }

    public void setServicioCollection(Collection<Servicio> servicioCollection) {
        this.servicioCollection = servicioCollection;
    }

    @XmlTransient
    public Collection<Servicio> getServicioCollection1() {
        return servicioCollection1;
    }

    public void setServicioCollection1(Collection<Servicio> servicioCollection1) {
        this.servicioCollection1 = servicioCollection1;
    }

    @XmlTransient
    public Collection<Servicio> getServicioCollection2() {
        return servicioCollection2;
    }

    public void setServicioCollection2(Collection<Servicio> servicioCollection2) {
        this.servicioCollection2 = servicioCollection2;
    }

    @XmlTransient
    public Collection<Servicio> getServicioCollection3() {
        return servicioCollection3;
    }

    public void setServicioCollection3(Collection<Servicio> servicioCollection3) {
        this.servicioCollection3 = servicioCollection3;
    }

    @XmlTransient
    public Collection<Prestacion> getPrestacionCollection() {
        return prestacionCollection;
    }

    public void setPrestacionCollection(Collection<Prestacion> prestacionCollection) {
        this.prestacionCollection = prestacionCollection;
    }

    @XmlTransient
    public Collection<ItemsAVender> getItemsAVenderCollection() {
        return itemsAVenderCollection;
    }

    public void setItemsAVenderCollection(Collection<ItemsAVender> itemsAVenderCollection) {
        this.itemsAVenderCollection = itemsAVenderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservicio != null ? idservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idservicio == null && other.idservicio != null) || (this.idservicio != null && !this.idservicio.equals(other.idservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Servicio[ idservicio=" + idservicio + " ]";
    }
    
}
