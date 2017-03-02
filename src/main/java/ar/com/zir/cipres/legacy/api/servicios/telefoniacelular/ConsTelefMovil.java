/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import ar.com.zir.cipres.legacy.api.facturacion.Facturacion;
import ar.com.zir.cipres.legacy.api.security.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmrunge
 */
@Entity
@Table(name = "CONS_TELEF_MOVIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsTelefMovil.findAll", query = "SELECT c FROM ConsTelefMovil c"),
    @NamedQuery(name = "ConsTelefMovil.findByIdprestacion", query = "SELECT c FROM ConsTelefMovil c WHERE c.consTelefMovilPK.idprestacion = :idprestacion"),
    @NamedQuery(name = "ConsTelefMovil.findByFecha", query = "SELECT c FROM ConsTelefMovil c WHERE c.consTelefMovilPK.fecha = :fecha"),
    @NamedQuery(name = "ConsTelefMovil.findByCantminaire", query = "SELECT c FROM ConsTelefMovil c WHERE c.cantminaire = :cantminaire"),
    @NamedQuery(name = "ConsTelefMovil.findByImpminaire", query = "SELECT c FROM ConsTelefMovil c WHERE c.impminaire = :impminaire"),
    @NamedQuery(name = "ConsTelefMovil.findByImpminairead", query = "SELECT c FROM ConsTelefMovil c WHERE c.impminairead = :impminairead"),
    @NamedQuery(name = "ConsTelefMovil.findByCantminfixloc", query = "SELECT c FROM ConsTelefMovil c WHERE c.cantminfixloc = :cantminfixloc"),
    @NamedQuery(name = "ConsTelefMovil.findByImpminfixloc", query = "SELECT c FROM ConsTelefMovil c WHERE c.impminfixloc = :impminfixloc"),
    @NamedQuery(name = "ConsTelefMovil.findByCantminfixint", query = "SELECT c FROM ConsTelefMovil c WHERE c.cantminfixint = :cantminfixint"),
    @NamedQuery(name = "ConsTelefMovil.findByImpminfixint", query = "SELECT c FROM ConsTelefMovil c WHERE c.impminfixint = :impminfixint"),
    @NamedQuery(name = "ConsTelefMovil.findByCantmsg", query = "SELECT c FROM ConsTelefMovil c WHERE c.cantmsg = :cantmsg"),
    @NamedQuery(name = "ConsTelefMovil.findByCantkb", query = "SELECT c FROM ConsTelefMovil c WHERE c.cantkb = :cantkb"),
    @NamedQuery(name = "ConsTelefMovil.findByImpdatos", query = "SELECT c FROM ConsTelefMovil c WHERE c.impdatos = :impdatos"),
    @NamedQuery(name = "ConsTelefMovil.findByImpotros", query = "SELECT c FROM ConsTelefMovil c WHERE c.impotros = :impotros")})
public class ConsTelefMovil implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsTelefMovilPK consTelefMovilPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cant_min_aire")
    private int cantminaire;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_min_aire")
    private BigDecimal impminaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_min_aire_ad")
    private BigDecimal impminairead;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cant_min_fix_loc")
    private int cantminfixloc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_min_fix_loc")
    private BigDecimal impminfixloc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cant_min_fix_int")
    private int cantminfixint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_min_fix_int")
    private BigDecimal impminfixint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cant_msg")
    private int cantmsg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cant_kb")
    private int cantkb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_datos")
    private BigDecimal impdatos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Imp_otros")
    private BigDecimal impotros;
    @JoinColumn(name = "Id_facturacion", referencedColumnName = "Id_facturacion")
    @ManyToOne
    private Facturacion idfacturacion;
    @JoinColumn(name = "Id_prestacion", referencedColumnName = "Id_prestacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrestTelefonia prestTelefonia;
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public ConsTelefMovil() {
    }

    public ConsTelefMovil(ConsTelefMovilPK consTelefMovilPK) {
        this.consTelefMovilPK = consTelefMovilPK;
    }

    public ConsTelefMovil(ConsTelefMovilPK consTelefMovilPK, int cantminaire, BigDecimal impminaire, BigDecimal impminairead, int cantminfixloc, BigDecimal impminfixloc, int cantminfixint, BigDecimal impminfixint, int cantmsg, int cantkb, BigDecimal impdatos, BigDecimal impotros) {
        this.consTelefMovilPK = consTelefMovilPK;
        this.cantminaire = cantminaire;
        this.impminaire = impminaire;
        this.impminairead = impminairead;
        this.cantminfixloc = cantminfixloc;
        this.impminfixloc = impminfixloc;
        this.cantminfixint = cantminfixint;
        this.impminfixint = impminfixint;
        this.cantmsg = cantmsg;
        this.cantkb = cantkb;
        this.impdatos = impdatos;
        this.impotros = impotros;
    }

    public ConsTelefMovil(int idprestacion, Date fecha) {
        this.consTelefMovilPK = new ConsTelefMovilPK(idprestacion, fecha);
    }

    public ConsTelefMovilPK getConsTelefMovilPK() {
        return consTelefMovilPK;
    }

    public void setConsTelefMovilPK(ConsTelefMovilPK consTelefMovilPK) {
        this.consTelefMovilPK = consTelefMovilPK;
    }

    public int getCantminaire() {
        return cantminaire;
    }

    public void setCantminaire(int cantminaire) {
        this.cantminaire = cantminaire;
    }

    public BigDecimal getImpminaire() {
        return impminaire;
    }

    public void setImpminaire(BigDecimal impminaire) {
        this.impminaire = impminaire;
    }

    public BigDecimal getImpminairead() {
        return impminairead;
    }

    public void setImpminairead(BigDecimal impminairead) {
        this.impminairead = impminairead;
    }

    public int getCantminfixloc() {
        return cantminfixloc;
    }

    public void setCantminfixloc(int cantminfixloc) {
        this.cantminfixloc = cantminfixloc;
    }

    public BigDecimal getImpminfixloc() {
        return impminfixloc;
    }

    public void setImpminfixloc(BigDecimal impminfixloc) {
        this.impminfixloc = impminfixloc;
    }

    public int getCantminfixint() {
        return cantminfixint;
    }

    public void setCantminfixint(int cantminfixint) {
        this.cantminfixint = cantminfixint;
    }

    public BigDecimal getImpminfixint() {
        return impminfixint;
    }

    public void setImpminfixint(BigDecimal impminfixint) {
        this.impminfixint = impminfixint;
    }

    public int getCantmsg() {
        return cantmsg;
    }

    public void setCantmsg(int cantmsg) {
        this.cantmsg = cantmsg;
    }

    public int getCantkb() {
        return cantkb;
    }

    public void setCantkb(int cantkb) {
        this.cantkb = cantkb;
    }

    public BigDecimal getImpdatos() {
        return impdatos;
    }

    public void setImpdatos(BigDecimal impdatos) {
        this.impdatos = impdatos;
    }

    public BigDecimal getImpotros() {
        return impotros;
    }

    public void setImpotros(BigDecimal impotros) {
        this.impotros = impotros;
    }

    public Facturacion getIdfacturacion() {
        return idfacturacion;
    }

    public void setIdfacturacion(Facturacion idfacturacion) {
        this.idfacturacion = idfacturacion;
    }

    public PrestTelefonia getPrestTelefonia() {
        return prestTelefonia;
    }

    public void setPrestTelefonia(PrestTelefonia prestTelefonia) {
        this.prestTelefonia = prestTelefonia;
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
        hash += (consTelefMovilPK != null ? consTelefMovilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsTelefMovil)) {
            return false;
        }
        ConsTelefMovil other = (ConsTelefMovil) object;
        if ((this.consTelefMovilPK == null && other.consTelefMovilPK != null) || (this.consTelefMovilPK != null && !this.consTelefMovilPK.equals(other.consTelefMovilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.ConsTelefMovil[ consTelefMovilPK=" + consTelefMovilPK + " ]";
    }
    
}
