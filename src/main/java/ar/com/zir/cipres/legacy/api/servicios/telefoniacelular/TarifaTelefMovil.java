/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmrunge
 */
@Entity
@Table(name = "TARIFA_TELEF_MOVIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaTelefMovil.findAll", query = "SELECT t FROM TarifaTelefMovil t"),
    @NamedQuery(name = "TarifaTelefMovil.findByIdtarifa", query = "SELECT t FROM TarifaTelefMovil t WHERE t.idtarifa = :idtarifa"),
    @NamedQuery(name = "TarifaTelefMovil.findByMinutoslibres", query = "SELECT t FROM TarifaTelefMovil t WHERE t.minutoslibres = :minutoslibres"),
    @NamedQuery(name = "TarifaTelefMovil.findByImpminex", query = "SELECT t FROM TarifaTelefMovil t WHERE t.impminex = :impminex"),
    @NamedQuery(name = "TarifaTelefMovil.findByImpminexad", query = "SELECT t FROM TarifaTelefMovil t WHERE t.impminexad = :impminexad"),
    @NamedQuery(name = "TarifaTelefMovil.findByIditemexad", query = "SELECT t FROM TarifaTelefMovil t WHERE t.iditemexad = :iditemexad"),
    @NamedQuery(name = "TarifaTelefMovil.findByImpredfixloc", query = "SELECT t FROM TarifaTelefMovil t WHERE t.impredfixloc = :impredfixloc"),
    @NamedQuery(name = "TarifaTelefMovil.findByImpredfixint", query = "SELECT t FROM TarifaTelefMovil t WHERE t.impredfixint = :impredfixint"),
    @NamedQuery(name = "TarifaTelefMovil.findByImpmsg", query = "SELECT t FROM TarifaTelefMovil t WHERE t.impmsg = :impmsg"),
    @NamedQuery(name = "TarifaTelefMovil.findByCantmsglibres", query = "SELECT t FROM TarifaTelefMovil t WHERE t.cantmsglibres = :cantmsglibres"),
    @NamedQuery(name = "TarifaTelefMovil.findByImpkb", query = "SELECT t FROM TarifaTelefMovil t WHERE t.impkb = :impkb"),
    @NamedQuery(name = "TarifaTelefMovil.findByCantkblibres", query = "SELECT t FROM TarifaTelefMovil t WHERE t.cantkblibres = :cantkblibres")})
public class TarifaTelefMovil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tarifa")
    private Short idtarifa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Minutos_libres")
    private int minutoslibres;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_min_ex")
    private BigDecimal impminex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_min_ex_ad")
    private BigDecimal impminexad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_item_ex_ad")
    private short iditemexad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_red_fix_loc")
    private BigDecimal impredfixloc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_red_fix_int")
    private BigDecimal impredfixint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_msg")
    private BigDecimal impmsg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cant_msg_libres")
    private short cantmsglibres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_kb")
    private BigDecimal impkb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cant_kb_libres")
    private int cantkblibres;
    @JoinColumn(name = "Id_item_ex", referencedColumnName = "Id_item")
    @ManyToOne(optional = false)
    private ItemsAVender iditemex;
    @JoinColumn(name = "Id_item_fix_loc", referencedColumnName = "Id_item")
    @ManyToOne(optional = false)
    private ItemsAVender iditemfixloc;
    @JoinColumn(name = "Id_item_fix_int", referencedColumnName = "Id_item")
    @ManyToOne(optional = false)
    private ItemsAVender iditemfixint;
    @JoinColumn(name = "Id_item_datos", referencedColumnName = "Id_item")
    @ManyToOne(optional = false)
    private ItemsAVender iditemdatos;
    @JoinColumn(name = "Id_item_otros", referencedColumnName = "Id_item")
    @ManyToOne(optional = false)
    private ItemsAVender iditemotros;
    @JoinColumn(name = "Id_tarifa", referencedColumnName = "Id_tarifa", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TarifaTelefonia tarifaTelefonia;

    public TarifaTelefMovil() {
    }

    public TarifaTelefMovil(Short idtarifa) {
        this.idtarifa = idtarifa;
    }

    public TarifaTelefMovil(Short idtarifa, int minutoslibres, BigDecimal impminex, BigDecimal impminexad, short iditemexad, BigDecimal impredfixloc, BigDecimal impredfixint, BigDecimal impmsg, short cantmsglibres, BigDecimal impkb, int cantkblibres) {
        this.idtarifa = idtarifa;
        this.minutoslibres = minutoslibres;
        this.impminex = impminex;
        this.impminexad = impminexad;
        this.iditemexad = iditemexad;
        this.impredfixloc = impredfixloc;
        this.impredfixint = impredfixint;
        this.impmsg = impmsg;
        this.cantmsglibres = cantmsglibres;
        this.impkb = impkb;
        this.cantkblibres = cantkblibres;
    }

    public Short getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(Short idtarifa) {
        this.idtarifa = idtarifa;
    }

    public int getMinutoslibres() {
        return minutoslibres;
    }

    public void setMinutoslibres(int minutoslibres) {
        this.minutoslibres = minutoslibres;
    }

    public BigDecimal getImpminex() {
        return impminex;
    }

    public void setImpminex(BigDecimal impminex) {
        this.impminex = impminex;
    }

    public BigDecimal getImpminexad() {
        return impminexad;
    }

    public void setImpminexad(BigDecimal impminexad) {
        this.impminexad = impminexad;
    }

    public short getIditemexad() {
        return iditemexad;
    }

    public void setIditemexad(short iditemexad) {
        this.iditemexad = iditemexad;
    }

    public BigDecimal getImpredfixloc() {
        return impredfixloc;
    }

    public void setImpredfixloc(BigDecimal impredfixloc) {
        this.impredfixloc = impredfixloc;
    }

    public BigDecimal getImpredfixint() {
        return impredfixint;
    }

    public void setImpredfixint(BigDecimal impredfixint) {
        this.impredfixint = impredfixint;
    }

    public BigDecimal getImpmsg() {
        return impmsg;
    }

    public void setImpmsg(BigDecimal impmsg) {
        this.impmsg = impmsg;
    }

    public short getCantmsglibres() {
        return cantmsglibres;
    }

    public void setCantmsglibres(short cantmsglibres) {
        this.cantmsglibres = cantmsglibres;
    }

    public BigDecimal getImpkb() {
        return impkb;
    }

    public void setImpkb(BigDecimal impkb) {
        this.impkb = impkb;
    }

    public int getCantkblibres() {
        return cantkblibres;
    }

    public void setCantkblibres(int cantkblibres) {
        this.cantkblibres = cantkblibres;
    }

    public ItemsAVender getIditemex() {
        return iditemex;
    }

    public void setIditemex(ItemsAVender iditemex) {
        this.iditemex = iditemex;
    }

    public ItemsAVender getIditemfixloc() {
        return iditemfixloc;
    }

    public void setIditemfixloc(ItemsAVender iditemfixloc) {
        this.iditemfixloc = iditemfixloc;
    }

    public ItemsAVender getIditemfixint() {
        return iditemfixint;
    }

    public void setIditemfixint(ItemsAVender iditemfixint) {
        this.iditemfixint = iditemfixint;
    }

    public ItemsAVender getIditemdatos() {
        return iditemdatos;
    }

    public void setIditemdatos(ItemsAVender iditemdatos) {
        this.iditemdatos = iditemdatos;
    }

    public ItemsAVender getIditemotros() {
        return iditemotros;
    }

    public void setIditemotros(ItemsAVender iditemotros) {
        this.iditemotros = iditemotros;
    }

    public TarifaTelefonia getTarifaTelefonia() {
        return tarifaTelefonia;
    }

    public void setTarifaTelefonia(TarifaTelefonia tarifaTelefonia) {
        this.tarifaTelefonia = tarifaTelefonia;
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
        if (!(object instanceof TarifaTelefMovil)) {
            return false;
        }
        TarifaTelefMovil other = (TarifaTelefMovil) object;
        if ((this.idtarifa == null && other.idtarifa != null) || (this.idtarifa != null && !this.idtarifa.equals(other.idtarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.TarifaTelefMovil[ idtarifa=" + idtarifa + " ]";
    }
    
}
