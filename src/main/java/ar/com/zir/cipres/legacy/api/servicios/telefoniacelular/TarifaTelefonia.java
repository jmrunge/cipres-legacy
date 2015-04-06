/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.persistence.OneToOne;
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
@Table(name = "TARIFA_TELEFONIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaTelefonia.findAll", query = "SELECT t FROM TarifaTelefonia t"),
    @NamedQuery(name = "TarifaTelefonia.findByIdtarifa", query = "SELECT t FROM TarifaTelefonia t WHERE t.idtarifa = :idtarifa"),
    @NamedQuery(name = "TarifaTelefonia.findByDescripcion", query = "SELECT t FROM TarifaTelefonia t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TarifaTelefonia.findByImpabono", query = "SELECT t FROM TarifaTelefonia t WHERE t.impabono = :impabono"),
    @NamedQuery(name = "TarifaTelefonia.findByDiscriminabonif", query = "SELECT t FROM TarifaTelefonia t WHERE t.discriminabonif = :discriminabonif"),
    @NamedQuery(name = "TarifaTelefonia.findByImpabonoad", query = "SELECT t FROM TarifaTelefonia t WHERE t.impabonoad = :impabonoad")})
public class TarifaTelefonia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tarifa")
    private Short idtarifa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_abono")
    private BigDecimal impabono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Discrimina_bonif")
    private boolean discriminabonif;
    @Column(name = "Imp_abono_ad")
    private BigDecimal impabonoad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtarifa")
    private Collection<TarifaTelefHist> tarifaTelefHistCollection;
    @JoinColumn(name = "Id_item", referencedColumnName = "Id_item")
    @ManyToOne
    private ItemsAVender iditem;
    @JoinColumn(name = "Id_item_ad", referencedColumnName = "Id_item")
    @ManyToOne
    private ItemsAVender iditemad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtarifa")
    private Collection<PrestTelefonia> prestTelefoniaCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tarifaTelefonia")
    private TarifaTelefMovil tarifaTelefMovil;

    public TarifaTelefonia() {
    }

    public TarifaTelefonia(Short idtarifa) {
        this.idtarifa = idtarifa;
    }

    public TarifaTelefonia(Short idtarifa, String descripcion, BigDecimal impabono, boolean discriminabonif) {
        this.idtarifa = idtarifa;
        this.descripcion = descripcion;
        this.impabono = impabono;
        this.discriminabonif = discriminabonif;
    }

    public Short getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(Short idtarifa) {
        this.idtarifa = idtarifa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getImpabono() {
        return impabono;
    }

    public void setImpabono(BigDecimal impabono) {
        this.impabono = impabono;
    }

    public boolean getDiscriminabonif() {
        return discriminabonif;
    }

    public void setDiscriminabonif(boolean discriminabonif) {
        this.discriminabonif = discriminabonif;
    }

    public BigDecimal getImpabonoad() {
        return impabonoad;
    }

    public void setImpabonoad(BigDecimal impabonoad) {
        this.impabonoad = impabonoad;
    }

    @XmlTransient
    public Collection<TarifaTelefHist> getTarifaTelefHistCollection() {
        return tarifaTelefHistCollection;
    }

    public void setTarifaTelefHistCollection(Collection<TarifaTelefHist> tarifaTelefHistCollection) {
        this.tarifaTelefHistCollection = tarifaTelefHistCollection;
    }

    public ItemsAVender getIditem() {
        return iditem;
    }

    public void setIditem(ItemsAVender iditem) {
        this.iditem = iditem;
    }

    public ItemsAVender getIditemad() {
        return iditemad;
    }

    public void setIditemad(ItemsAVender iditemad) {
        this.iditemad = iditemad;
    }

    @XmlTransient
    public Collection<PrestTelefonia> getPrestTelefoniaCollection() {
        return prestTelefoniaCollection;
    }

    public void setPrestTelefoniaCollection(Collection<PrestTelefonia> prestTelefoniaCollection) {
        this.prestTelefoniaCollection = prestTelefoniaCollection;
    }

    public TarifaTelefMovil getTarifaTelefMovil() {
        return tarifaTelefMovil;
    }

    public void setTarifaTelefMovil(TarifaTelefMovil tarifaTelefMovil) {
        this.tarifaTelefMovil = tarifaTelefMovil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtarifa != null ? idtarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaTelefonia)) {
            return false;
        }
        TarifaTelefonia other = (TarifaTelefonia) object;
        if ((this.idtarifa == null && other.idtarifa != null) || (this.idtarifa != null && !this.idtarifa.equals(other.idtarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.TarifaTelefonia[ idtarifa=" + idtarifa + " ]";
    }
    
}
