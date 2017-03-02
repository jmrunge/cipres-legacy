/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.cuenta;

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
 * @author Juan Martin Runge {@literal <jmrunge@gmail.com>}
 */
@Entity
@Table(name = "TIPO_COMPROBANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoComprobanteLegacy.findAll", query = "SELECT t FROM TipoComprobanteLegacy t"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByIdtipocomp", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.idtipocomp = :idtipocomp"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByDescripcion", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByAbreviatura", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.abreviatura = :abreviatura"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByNumeracionmanual", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.numeracionmanual = :numeracionmanual"),
    @NamedQuery(name = "TipoComprobanteLegacy.findBySigno", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.signo = :signo"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByGeneracabecera", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.generacabecera = :generacabecera"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByCobrablecaja", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.cobrablecaja = :cobrablecaja"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByCobrador", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.cobrador = :cobrador"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByGeneraasiento", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.generaasiento = :generaasiento"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByIVAventa", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.iVAventa = :iVAventa"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByPagocontado", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.pagocontado = :pagocontado"),
    @NamedQuery(name = "TipoComprobanteLegacy.findBySologestion", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.sologestion = :sologestion"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByBloqueado", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.bloqueado = :bloqueado"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByDiscriminaIVA", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.discriminaIVA = :discriminaIVA"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByPuerto", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.puerto = :puerto"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByColornormal", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.colornormal = :colornormal"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByColordocucartera", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.colordocucartera = :colordocucartera"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByColoracuerdo", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.coloracuerdo = :coloracuerdo"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByIdtipocompdebitoA", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.idtipocompdebitoA = :idtipocompdebitoA"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByIdtipocompdebitoB", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.idtipocompdebitoB = :idtipocompdebitoB"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByIdtipocompcreditoA", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.idtipocompcreditoA = :idtipocompcreditoA"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByIdtipocompcreditoB", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.idtipocompcreditoB = :idtipocompcreditoB"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByPuedecancelarimp", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.puedecancelarimp = :puedecancelarimp"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByPermiteanular", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.permiteanular = :permiteanular"),
    @NamedQuery(name = "TipoComprobanteLegacy.findByIdafip", query = "SELECT t FROM TipoComprobanteLegacy t WHERE t.idafip = :idafip")})
public class TipoComprobanteLegacy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_comp")
    private Short idtipocomp;
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
    @Column(name = "Numeracion_manual")
    private boolean numeracionmanual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Signo")
    private short signo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Genera_cabecera")
    private boolean generacabecera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cobrable_caja")
    private boolean cobrablecaja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cobrador")
    private boolean cobrador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Genera_asiento")
    private boolean generaasiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IVA_venta")
    private boolean iVAventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pago_contado")
    private boolean pagocontado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Solo_gestion")
    private boolean sologestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Bloqueado")
    private boolean bloqueado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Discrimina_IVA")
    private boolean discriminaIVA;
    @Size(max = 40)
    @Column(name = "Puerto")
    private String puerto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Color_normal")
    private int colornormal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Color_docu_cartera")
    private int colordocucartera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Color_acuerdo")
    private int coloracuerdo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_comp_debito_A")
    private short idtipocompdebitoA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_comp_debito_B")
    private short idtipocompdebitoB;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_comp_credito_A")
    private short idtipocompcreditoA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_tipo_comp_credito_B")
    private short idtipocompcreditoB;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Puede_cancelar_imp")
    private boolean puedecancelarimp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Permite_anular")
    private boolean permiteanular;
    @Column(name = "Id_afip")
    private Short idafip;
    @JoinTable(name = "TIPO_COMP_ITEMS", joinColumns = {
        @JoinColumn(name = "Id_tipo_comp", referencedColumnName = "Id_tipo_comp")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_item", referencedColumnName = "Id_item")})
    @ManyToMany
    private Collection<ItemsAVender> itemsAVenderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoComprobante")
    private Collection<TipoCompNumeracion> tipoCompNumeracionCollection;

    public TipoComprobanteLegacy() {
    }

    public TipoComprobanteLegacy(Short idtipocomp) {
        this.idtipocomp = idtipocomp;
    }

    public TipoComprobanteLegacy(Short idtipocomp, String descripcion, String abreviatura, boolean numeracionmanual, short signo, boolean generacabecera, boolean cobrablecaja, boolean cobrador, boolean generaasiento, boolean iVAventa, boolean pagocontado, boolean sologestion, boolean bloqueado, boolean discriminaIVA, int colornormal, int colordocucartera, int coloracuerdo, short idtipocompdebitoA, short idtipocompdebitoB, short idtipocompcreditoA, short idtipocompcreditoB, boolean puedecancelarimp, boolean permiteanular) {
        this.idtipocomp = idtipocomp;
        this.descripcion = descripcion;
        this.abreviatura = abreviatura;
        this.numeracionmanual = numeracionmanual;
        this.signo = signo;
        this.generacabecera = generacabecera;
        this.cobrablecaja = cobrablecaja;
        this.cobrador = cobrador;
        this.generaasiento = generaasiento;
        this.iVAventa = iVAventa;
        this.pagocontado = pagocontado;
        this.sologestion = sologestion;
        this.bloqueado = bloqueado;
        this.discriminaIVA = discriminaIVA;
        this.colornormal = colornormal;
        this.colordocucartera = colordocucartera;
        this.coloracuerdo = coloracuerdo;
        this.idtipocompdebitoA = idtipocompdebitoA;
        this.idtipocompdebitoB = idtipocompdebitoB;
        this.idtipocompcreditoA = idtipocompcreditoA;
        this.idtipocompcreditoB = idtipocompcreditoB;
        this.puedecancelarimp = puedecancelarimp;
        this.permiteanular = permiteanular;
    }

    public Short getIdtipocomp() {
        return idtipocomp;
    }

    public void setIdtipocomp(Short idtipocomp) {
        this.idtipocomp = idtipocomp;
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

    public boolean getNumeracionmanual() {
        return numeracionmanual;
    }

    public void setNumeracionmanual(boolean numeracionmanual) {
        this.numeracionmanual = numeracionmanual;
    }

    public short getSigno() {
        return signo;
    }

    public void setSigno(short signo) {
        this.signo = signo;
    }

    public boolean getGeneracabecera() {
        return generacabecera;
    }

    public void setGeneracabecera(boolean generacabecera) {
        this.generacabecera = generacabecera;
    }

    public boolean getCobrablecaja() {
        return cobrablecaja;
    }

    public void setCobrablecaja(boolean cobrablecaja) {
        this.cobrablecaja = cobrablecaja;
    }

    public boolean getCobrador() {
        return cobrador;
    }

    public void setCobrador(boolean cobrador) {
        this.cobrador = cobrador;
    }

    public boolean getGeneraasiento() {
        return generaasiento;
    }

    public void setGeneraasiento(boolean generaasiento) {
        this.generaasiento = generaasiento;
    }

    public boolean getIVAventa() {
        return iVAventa;
    }

    public void setIVAventa(boolean iVAventa) {
        this.iVAventa = iVAventa;
    }

    public boolean getPagocontado() {
        return pagocontado;
    }

    public void setPagocontado(boolean pagocontado) {
        this.pagocontado = pagocontado;
    }

    public boolean getSologestion() {
        return sologestion;
    }

    public void setSologestion(boolean sologestion) {
        this.sologestion = sologestion;
    }

    public boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public boolean getDiscriminaIVA() {
        return discriminaIVA;
    }

    public void setDiscriminaIVA(boolean discriminaIVA) {
        this.discriminaIVA = discriminaIVA;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public int getColornormal() {
        return colornormal;
    }

    public void setColornormal(int colornormal) {
        this.colornormal = colornormal;
    }

    public int getColordocucartera() {
        return colordocucartera;
    }

    public void setColordocucartera(int colordocucartera) {
        this.colordocucartera = colordocucartera;
    }

    public int getColoracuerdo() {
        return coloracuerdo;
    }

    public void setColoracuerdo(int coloracuerdo) {
        this.coloracuerdo = coloracuerdo;
    }

    public short getIdtipocompdebitoA() {
        return idtipocompdebitoA;
    }

    public void setIdtipocompdebitoA(short idtipocompdebitoA) {
        this.idtipocompdebitoA = idtipocompdebitoA;
    }

    public short getIdtipocompdebitoB() {
        return idtipocompdebitoB;
    }

    public void setIdtipocompdebitoB(short idtipocompdebitoB) {
        this.idtipocompdebitoB = idtipocompdebitoB;
    }

    public short getIdtipocompcreditoA() {
        return idtipocompcreditoA;
    }

    public void setIdtipocompcreditoA(short idtipocompcreditoA) {
        this.idtipocompcreditoA = idtipocompcreditoA;
    }

    public short getIdtipocompcreditoB() {
        return idtipocompcreditoB;
    }

    public void setIdtipocompcreditoB(short idtipocompcreditoB) {
        this.idtipocompcreditoB = idtipocompcreditoB;
    }

    public boolean getPuedecancelarimp() {
        return puedecancelarimp;
    }

    public void setPuedecancelarimp(boolean puedecancelarimp) {
        this.puedecancelarimp = puedecancelarimp;
    }

    public boolean getPermiteanular() {
        return permiteanular;
    }

    public void setPermiteanular(boolean permiteanular) {
        this.permiteanular = permiteanular;
    }

    public Short getIdafip() {
        return idafip;
    }

    public void setIdafip(Short idafip) {
        this.idafip = idafip;
    }

    @XmlTransient
    public Collection<ItemsAVender> getItemsAVenderCollection() {
        return itemsAVenderCollection;
    }

    public void setItemsAVenderCollection(Collection<ItemsAVender> itemsAVenderCollection) {
        this.itemsAVenderCollection = itemsAVenderCollection;
    }

    @XmlTransient
    public Collection<TipoCompNumeracion> getTipoCompNumeracionCollection() {
        return tipoCompNumeracionCollection;
    }

    public void setTipoCompNumeracionCollection(Collection<TipoCompNumeracion> tipoCompNumeracionCollection) {
        this.tipoCompNumeracionCollection = tipoCompNumeracionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipocomp != null ? idtipocomp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoComprobanteLegacy)) {
            return false;
        }
        TipoComprobanteLegacy other = (TipoComprobanteLegacy) object;
        if ((this.idtipocomp == null && other.idtipocomp != null) || (this.idtipocomp != null && !this.idtipocomp.equals(other.idtipocomp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.cuenta.TipoComprobante[ idtipocomp=" + idtipocomp + " ]";
    }
    
}
