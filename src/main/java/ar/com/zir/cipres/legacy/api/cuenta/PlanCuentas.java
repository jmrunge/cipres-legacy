/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.cuenta;

import ar.com.zir.cipres.legacy.api.cuenta.ItemsAVender;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "PLAN_CUENTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanCuentas.findAll", query = "SELECT p FROM PlanCuentas p"),
    @NamedQuery(name = "PlanCuentas.findByIdcuenta", query = "SELECT p FROM PlanCuentas p WHERE p.idcuenta = :idcuenta"),
    @NamedQuery(name = "PlanCuentas.findByDescripcion", query = "SELECT p FROM PlanCuentas p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PlanCuentas.findByNroplancta", query = "SELECT p FROM PlanCuentas p WHERE p.nroplancta = :nroplancta")})
public class PlanCuentas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_cuenta")
    private Integer idcuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Nro_plan_cta")
    private String nroplancta;
    @OneToMany(mappedBy = "idcuentaorigen")
    private Collection<ItemsAVender> itemsAVenderCollection;
    @OneToMany(mappedBy = "idcuentadestino")
    private Collection<ItemsAVender> itemsAVenderCollection1;
    @OneToMany(mappedBy = "idcuentapuente")
    private Collection<ItemsAVender> itemsAVenderCollection2;

    public PlanCuentas() {
    }

    public PlanCuentas(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public PlanCuentas(Integer idcuenta, String descripcion, String nroplancta) {
        this.idcuenta = idcuenta;
        this.descripcion = descripcion;
        this.nroplancta = nroplancta;
    }

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNroplancta() {
        return nroplancta;
    }

    public void setNroplancta(String nroplancta) {
        this.nroplancta = nroplancta;
    }

    @XmlTransient
    public Collection<ItemsAVender> getItemsAVenderCollection() {
        return itemsAVenderCollection;
    }

    public void setItemsAVenderCollection(Collection<ItemsAVender> itemsAVenderCollection) {
        this.itemsAVenderCollection = itemsAVenderCollection;
    }

    @XmlTransient
    public Collection<ItemsAVender> getItemsAVenderCollection1() {
        return itemsAVenderCollection1;
    }

    public void setItemsAVenderCollection1(Collection<ItemsAVender> itemsAVenderCollection1) {
        this.itemsAVenderCollection1 = itemsAVenderCollection1;
    }

    @XmlTransient
    public Collection<ItemsAVender> getItemsAVenderCollection2() {
        return itemsAVenderCollection2;
    }

    public void setItemsAVenderCollection2(Collection<ItemsAVender> itemsAVenderCollection2) {
        this.itemsAVenderCollection2 = itemsAVenderCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuenta != null ? idcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanCuentas)) {
            return false;
        }
        PlanCuentas other = (PlanCuentas) object;
        if ((this.idcuenta == null && other.idcuenta != null) || (this.idcuenta != null && !this.idcuenta.equals(other.idcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.PlanCuentas[ idcuenta=" + idcuenta + " ]";
    }
    
}
