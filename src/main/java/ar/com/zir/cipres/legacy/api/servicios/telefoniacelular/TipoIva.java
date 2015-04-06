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
@Table(name = "TIPO_IVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIva.findAll", query = "SELECT t FROM TipoIva t"),
    @NamedQuery(name = "TipoIva.findByIdtipoIVA", query = "SELECT t FROM TipoIva t WHERE t.idtipoIVA = :idtipoIVA"),
    @NamedQuery(name = "TipoIva.findByDescripcion", query = "SELECT t FROM TipoIva t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoIva.findByAbreviatura", query = "SELECT t FROM TipoIva t WHERE t.abreviatura = :abreviatura"),
    @NamedQuery(name = "TipoIva.findByDiscrimina", query = "SELECT t FROM TipoIva t WHERE t.discrimina = :discrimina"),
    @NamedQuery(name = "TipoIva.findBySobretasa", query = "SELECT t FROM TipoIva t WHERE t.sobretasa = :sobretasa"),
    @NamedQuery(name = "TipoIva.findByRg3337", query = "SELECT t FROM TipoIva t WHERE t.rg3337 = :rg3337"),
    @NamedQuery(name = "TipoIva.findByCategorizado", query = "SELECT t FROM TipoIva t WHERE t.categorizado = :categorizado"),
    @NamedQuery(name = "TipoIva.findByIdafip", query = "SELECT t FROM TipoIva t WHERE t.idafip = :idafip"),
    @NamedQuery(name = "TipoIva.findByIdafip2", query = "SELECT t FROM TipoIva t WHERE t.idafip2 = :idafip2")})
public class TipoIva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_IVA")
    private Short idtipoIVA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Abreviatura")
    private String abreviatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Discrimina")
    private boolean discrimina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sobretasa")
    private boolean sobretasa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RG3337")
    private boolean rg3337;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Categorizado")
    private boolean categorizado;
    @Column(name = "Id_afip")
    private Short idafip;
    @Column(name = "Id_afip_2")
    private Short idafip2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoIVA")
    private Collection<Cuenta> cuentaCollection;

    public TipoIva() {
    }

    public TipoIva(Short idtipoIVA) {
        this.idtipoIVA = idtipoIVA;
    }

    public TipoIva(Short idtipoIVA, String descripcion, String abreviatura, boolean discrimina, boolean sobretasa, boolean rg3337, boolean categorizado) {
        this.idtipoIVA = idtipoIVA;
        this.descripcion = descripcion;
        this.abreviatura = abreviatura;
        this.discrimina = discrimina;
        this.sobretasa = sobretasa;
        this.rg3337 = rg3337;
        this.categorizado = categorizado;
    }

    public Short getIdtipoIVA() {
        return idtipoIVA;
    }

    public void setIdtipoIVA(Short idtipoIVA) {
        this.idtipoIVA = idtipoIVA;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public boolean getDiscrimina() {
        return discrimina;
    }

    public void setDiscrimina(boolean discrimina) {
        this.discrimina = discrimina;
    }

    public boolean getSobretasa() {
        return sobretasa;
    }

    public void setSobretasa(boolean sobretasa) {
        this.sobretasa = sobretasa;
    }

    public boolean getRg3337() {
        return rg3337;
    }

    public void setRg3337(boolean rg3337) {
        this.rg3337 = rg3337;
    }

    public boolean getCategorizado() {
        return categorizado;
    }

    public void setCategorizado(boolean categorizado) {
        this.categorizado = categorizado;
    }

    public Short getIdafip() {
        return idafip;
    }

    public void setIdafip(Short idafip) {
        this.idafip = idafip;
    }

    public Short getIdafip2() {
        return idafip2;
    }

    public void setIdafip2(Short idafip2) {
        this.idafip2 = idafip2;
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
        hash += (idtipoIVA != null ? idtipoIVA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIva)) {
            return false;
        }
        TipoIva other = (TipoIva) object;
        if ((this.idtipoIVA == null && other.idtipoIVA != null) || (this.idtipoIVA != null && !this.idtipoIVA.equals(other.idtipoIVA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.TipoIva[ idtipoIVA=" + idtipoIVA + " ]";
    }
    
}
