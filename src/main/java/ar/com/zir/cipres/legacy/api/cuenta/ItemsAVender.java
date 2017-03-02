/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.cuenta;

import ar.com.zir.cipres.legacy.api.impresion.GrupoImpresion;
import ar.com.zir.cipres.legacy.api.impresion.ConceptoImpresion;
import ar.com.zir.cipres.legacy.api.servicios.Servicio;
import ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.TarifaTelefMovil;
import ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.TarifaTelefonia;
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
@Table(name = "ITEMS_A_VENDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemsAVender.findAll", query = "SELECT i FROM ItemsAVender i"),
    @NamedQuery(name = "ItemsAVender.findByIditem", query = "SELECT i FROM ItemsAVender i WHERE i.iditem = :iditem"),
    @NamedQuery(name = "ItemsAVender.findByDescripcion", query = "SELECT i FROM ItemsAVender i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "ItemsAVender.findByAbreviatura", query = "SELECT i FROM ItemsAVender i WHERE i.abreviatura = :abreviatura"),
    @NamedQuery(name = "ItemsAVender.findByImporte", query = "SELECT i FROM ItemsAVender i WHERE i.importe = :importe"),
    @NamedQuery(name = "ItemsAVender.findByOrdenimp", query = "SELECT i FROM ItemsAVender i WHERE i.ordenimp = :ordenimp"),
    @NamedQuery(name = "ItemsAVender.findByUnidadmedida", query = "SELECT i FROM ItemsAVender i WHERE i.unidadmedida = :unidadmedida"),
    @NamedQuery(name = "ItemsAVender.findByFijo", query = "SELECT i FROM ItemsAVender i WHERE i.fijo = :fijo"),
    @NamedQuery(name = "ItemsAVender.findByGravado", query = "SELECT i FROM ItemsAVender i WHERE i.gravado = :gravado"),
    @NamedQuery(name = "ItemsAVender.findByCuotassoc", query = "SELECT i FROM ItemsAVender i WHERE i.cuotassoc = :cuotassoc"),
    @NamedQuery(name = "ItemsAVender.findByDevuelvecuot", query = "SELECT i FROM ItemsAVender i WHERE i.devuelvecuot = :devuelvecuot"),
    @NamedQuery(name = "ItemsAVender.findByTransferible", query = "SELECT i FROM ItemsAVender i WHERE i.transferible = :transferible"),
    @NamedQuery(name = "ItemsAVender.findByImportemanual", query = "SELECT i FROM ItemsAVender i WHERE i.importemanual = :importemanual"),
    @NamedQuery(name = "ItemsAVender.findByDescripmanual", query = "SELECT i FROM ItemsAVender i WHERE i.descripmanual = :descripmanual"),
    @NamedQuery(name = "ItemsAVender.findByIditemfinanc", query = "SELECT i FROM ItemsAVender i WHERE i.iditemfinanc = :iditemfinanc"),
    @NamedQuery(name = "ItemsAVender.findByItemajuste", query = "SELECT i FROM ItemsAVender i WHERE i.itemajuste = :itemajuste"),
    @NamedQuery(name = "ItemsAVender.findByItemajusteRRPP", query = "SELECT i FROM ItemsAVender i WHERE i.itemajusteRRPP = :itemajusteRRPP"),
    @NamedQuery(name = "ItemsAVender.findByIditeminteres", query = "SELECT i FROM ItemsAVender i WHERE i.iditeminteres = :iditeminteres")})
public class ItemsAVender implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_item")
    private Short iditem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 5)
    @Column(name = "Abreviatura")
    private String abreviatura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Importe")
    private BigDecimal importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Orden_imp")
    private short ordenimp;
    @Size(max = 5)
    @Column(name = "Unidad_medida")
    private String unidadmedida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fijo")
    private boolean fijo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gravado")
    private boolean gravado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cuotas_soc")
    private boolean cuotassoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Devuelve_cuot")
    private boolean devuelvecuot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Transferible")
    private boolean transferible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Importe_manual")
    private boolean importemanual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Descrip_manual")
    private boolean descripmanual;
    @Column(name = "Id_item_financ")
    private Short iditemfinanc;
    @Column(name = "Item_ajuste")
    private Short itemajuste;
    @Column(name = "Item_ajuste_RRPP")
    private Short itemajusteRRPP;
    @Column(name = "Id_item_interes")
    private Short iditeminteres;
    @OneToMany(mappedBy = "iditem")
    private Collection<TipoIibb> tipoIibbCollection;
    @JoinColumn(name = "Id_concepto", referencedColumnName = "Id_concepto")
    @ManyToOne
    private ConceptoImpresion idconcepto;
    @Column(name = "Id_grupo_direc_adm")
    private Short idgrupodirecadm;
    @JoinColumn(name = "Id_grupo_imp", referencedColumnName = "Id_grupo_imp")
    @ManyToOne(optional = false)
    private GrupoImpresion idgrupoimp;
    @JoinColumn(name = "Id_grupo", referencedColumnName = "Id_grupo")
    @ManyToOne(optional = false)
    private GrupoVenta idgrupo;
    @JoinColumn(name = "Id_cuenta_origen", referencedColumnName = "Id_cuenta")
    @ManyToOne
    private PlanCuentas idcuentaorigen;
    @JoinColumn(name = "Id_cuenta_destino", referencedColumnName = "Id_cuenta")
    @ManyToOne
    private PlanCuentas idcuentadestino;
    @JoinColumn(name = "Id_cuenta_puente", referencedColumnName = "Id_cuenta")
    @ManyToOne
    private PlanCuentas idcuentapuente;
    @JoinColumn(name = "Id_producto", referencedColumnName = "Id_producto")
    @ManyToOne(optional = false)
    private Producto idproducto;
    @JoinColumn(name = "Id_servicio", referencedColumnName = "Id_servicio")
    @ManyToOne(optional = false)
    private Servicio idservicio;
    @OneToMany(mappedBy = "iditem")
    private Collection<TarifaTelefonia> tarifaTelefoniaCollection;
    @OneToMany(mappedBy = "iditemad")
    private Collection<TarifaTelefonia> tarifaTelefoniaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iditemex")
    private Collection<TarifaTelefMovil> tarifaTelefMovilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iditemfixloc")
    private Collection<TarifaTelefMovil> tarifaTelefMovilCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iditemfixint")
    private Collection<TarifaTelefMovil> tarifaTelefMovilCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iditemdatos")
    private Collection<TarifaTelefMovil> tarifaTelefMovilCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iditemotros")
    private Collection<TarifaTelefMovil> tarifaTelefMovilCollection4;

    public ItemsAVender() {
    }

    public ItemsAVender(Short iditem) {
        this.iditem = iditem;
    }

    public ItemsAVender(Short iditem, String descripcion, BigDecimal importe, short ordenimp, boolean fijo, boolean gravado, boolean cuotassoc, boolean devuelvecuot, boolean transferible, boolean importemanual, boolean descripmanual) {
        this.iditem = iditem;
        this.descripcion = descripcion;
        this.importe = importe;
        this.ordenimp = ordenimp;
        this.fijo = fijo;
        this.gravado = gravado;
        this.cuotassoc = cuotassoc;
        this.devuelvecuot = devuelvecuot;
        this.transferible = transferible;
        this.importemanual = importemanual;
        this.descripmanual = descripmanual;
    }

    public Short getIditem() {
        return iditem;
    }

    public void setIditem(Short iditem) {
        this.iditem = iditem;
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

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public short getOrdenimp() {
        return ordenimp;
    }

    public void setOrdenimp(short ordenimp) {
        this.ordenimp = ordenimp;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public boolean getFijo() {
        return fijo;
    }

    public void setFijo(boolean fijo) {
        this.fijo = fijo;
    }

    public boolean getGravado() {
        return gravado;
    }

    public void setGravado(boolean gravado) {
        this.gravado = gravado;
    }

    public boolean getCuotassoc() {
        return cuotassoc;
    }

    public void setCuotassoc(boolean cuotassoc) {
        this.cuotassoc = cuotassoc;
    }

    public boolean getDevuelvecuot() {
        return devuelvecuot;
    }

    public void setDevuelvecuot(boolean devuelvecuot) {
        this.devuelvecuot = devuelvecuot;
    }

    public boolean getTransferible() {
        return transferible;
    }

    public void setTransferible(boolean transferible) {
        this.transferible = transferible;
    }

    public boolean getImportemanual() {
        return importemanual;
    }

    public void setImportemanual(boolean importemanual) {
        this.importemanual = importemanual;
    }

    public boolean getDescripmanual() {
        return descripmanual;
    }

    public void setDescripmanual(boolean descripmanual) {
        this.descripmanual = descripmanual;
    }

    public Short getIditemfinanc() {
        return iditemfinanc;
    }

    public void setIditemfinanc(Short iditemfinanc) {
        this.iditemfinanc = iditemfinanc;
    }

    public Short getItemajuste() {
        return itemajuste;
    }

    public void setItemajuste(Short itemajuste) {
        this.itemajuste = itemajuste;
    }

    public Short getItemajusteRRPP() {
        return itemajusteRRPP;
    }

    public void setItemajusteRRPP(Short itemajusteRRPP) {
        this.itemajusteRRPP = itemajusteRRPP;
    }

    public Short getIditeminteres() {
        return iditeminteres;
    }

    public void setIditeminteres(Short iditeminteres) {
        this.iditeminteres = iditeminteres;
    }

    @XmlTransient
    public Collection<TipoIibb> getTipoIibbCollection() {
        return tipoIibbCollection;
    }

    public void setTipoIibbCollection(Collection<TipoIibb> tipoIibbCollection) {
        this.tipoIibbCollection = tipoIibbCollection;
    }

    public ConceptoImpresion getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(ConceptoImpresion idconcepto) {
        this.idconcepto = idconcepto;
    }

    public Short getIdgrupodirecadm() {
        return idgrupodirecadm;
    }

    public void setIdgrupodirecadm(Short idgrupodirecadm) {
        this.idgrupodirecadm = idgrupodirecadm;
    }

    public GrupoImpresion getIdgrupoimp() {
        return idgrupoimp;
    }

    public void setIdgrupoimp(GrupoImpresion idgrupoimp) {
        this.idgrupoimp = idgrupoimp;
    }

    public GrupoVenta getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(GrupoVenta idgrupo) {
        this.idgrupo = idgrupo;
    }

    public PlanCuentas getIdcuentaorigen() {
        return idcuentaorigen;
    }

    public void setIdcuentaorigen(PlanCuentas idcuentaorigen) {
        this.idcuentaorigen = idcuentaorigen;
    }

    public PlanCuentas getIdcuentadestino() {
        return idcuentadestino;
    }

    public void setIdcuentadestino(PlanCuentas idcuentadestino) {
        this.idcuentadestino = idcuentadestino;
    }

    public PlanCuentas getIdcuentapuente() {
        return idcuentapuente;
    }

    public void setIdcuentapuente(PlanCuentas idcuentapuente) {
        this.idcuentapuente = idcuentapuente;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public Servicio getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Servicio idservicio) {
        this.idservicio = idservicio;
    }

    @XmlTransient
    public Collection<TarifaTelefonia> getTarifaTelefoniaCollection() {
        return tarifaTelefoniaCollection;
    }

    public void setTarifaTelefoniaCollection(Collection<TarifaTelefonia> tarifaTelefoniaCollection) {
        this.tarifaTelefoniaCollection = tarifaTelefoniaCollection;
    }

    @XmlTransient
    public Collection<TarifaTelefonia> getTarifaTelefoniaCollection1() {
        return tarifaTelefoniaCollection1;
    }

    public void setTarifaTelefoniaCollection1(Collection<TarifaTelefonia> tarifaTelefoniaCollection1) {
        this.tarifaTelefoniaCollection1 = tarifaTelefoniaCollection1;
    }

    @XmlTransient
    public Collection<TarifaTelefMovil> getTarifaTelefMovilCollection() {
        return tarifaTelefMovilCollection;
    }

    public void setTarifaTelefMovilCollection(Collection<TarifaTelefMovil> tarifaTelefMovilCollection) {
        this.tarifaTelefMovilCollection = tarifaTelefMovilCollection;
    }

    @XmlTransient
    public Collection<TarifaTelefMovil> getTarifaTelefMovilCollection1() {
        return tarifaTelefMovilCollection1;
    }

    public void setTarifaTelefMovilCollection1(Collection<TarifaTelefMovil> tarifaTelefMovilCollection1) {
        this.tarifaTelefMovilCollection1 = tarifaTelefMovilCollection1;
    }

    @XmlTransient
    public Collection<TarifaTelefMovil> getTarifaTelefMovilCollection2() {
        return tarifaTelefMovilCollection2;
    }

    public void setTarifaTelefMovilCollection2(Collection<TarifaTelefMovil> tarifaTelefMovilCollection2) {
        this.tarifaTelefMovilCollection2 = tarifaTelefMovilCollection2;
    }

    @XmlTransient
    public Collection<TarifaTelefMovil> getTarifaTelefMovilCollection3() {
        return tarifaTelefMovilCollection3;
    }

    public void setTarifaTelefMovilCollection3(Collection<TarifaTelefMovil> tarifaTelefMovilCollection3) {
        this.tarifaTelefMovilCollection3 = tarifaTelefMovilCollection3;
    }

    @XmlTransient
    public Collection<TarifaTelefMovil> getTarifaTelefMovilCollection4() {
        return tarifaTelefMovilCollection4;
    }

    public void setTarifaTelefMovilCollection4(Collection<TarifaTelefMovil> tarifaTelefMovilCollection4) {
        this.tarifaTelefMovilCollection4 = tarifaTelefMovilCollection4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditem != null ? iditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsAVender)) {
            return false;
        }
        ItemsAVender other = (ItemsAVender) object;
        if ((this.iditem == null && other.iditem != null) || (this.iditem != null && !this.iditem.equals(other.iditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.ItemsAVender[ iditem=" + iditem + " ]";
    }
    
}
