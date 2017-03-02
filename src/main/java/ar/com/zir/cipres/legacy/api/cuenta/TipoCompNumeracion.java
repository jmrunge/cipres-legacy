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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Martin Runge {@literal <jmrunge@gmail.com>}
 */
@Entity
@Table(name = "TIPO_COMP_NUMERACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCompNumeracion.findAll", query = "SELECT t FROM TipoCompNumeracion t"),
    @NamedQuery(name = "TipoCompNumeracion.findByIdtipocomp", query = "SELECT t FROM TipoCompNumeracion t WHERE t.tipoCompNumeracionPK.idtipocomp = :idtipocomp"),
    @NamedQuery(name = "TipoCompNumeracion.findByIdpuntovta", query = "SELECT t FROM TipoCompNumeracion t WHERE t.tipoCompNumeracionPK.idpuntovta = :idpuntovta"),
    @NamedQuery(name = "TipoCompNumeracion.findByUltimooficial", query = "SELECT t FROM TipoCompNumeracion t WHERE t.ultimooficial = :ultimooficial")})
public class TipoCompNumeracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoCompNumeracionPK tipoCompNumeracionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ultimo_oficial")
    private int ultimooficial;
    @JoinColumn(name = "Id_punto_vta", referencedColumnName = "Id_punto_vta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PuntoVta puntoVta;
    @JoinColumn(name = "Id_tipo_comp", referencedColumnName = "Id_tipo_comp", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoComprobanteLegacy tipoComprobante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCompNumeracion")
    private Collection<Comprobante> comprobanteCollection;

    public TipoCompNumeracion() {
    }

    public TipoCompNumeracion(TipoCompNumeracionPK tipoCompNumeracionPK) {
        this.tipoCompNumeracionPK = tipoCompNumeracionPK;
    }

    public TipoCompNumeracion(TipoCompNumeracionPK tipoCompNumeracionPK, int ultimooficial) {
        this.tipoCompNumeracionPK = tipoCompNumeracionPK;
        this.ultimooficial = ultimooficial;
    }

    public TipoCompNumeracion(short idtipocomp, short idpuntovta) {
        this.tipoCompNumeracionPK = new TipoCompNumeracionPK(idtipocomp, idpuntovta);
    }

    public TipoCompNumeracionPK getTipoCompNumeracionPK() {
        return tipoCompNumeracionPK;
    }

    public void setTipoCompNumeracionPK(TipoCompNumeracionPK tipoCompNumeracionPK) {
        this.tipoCompNumeracionPK = tipoCompNumeracionPK;
    }

    public int getUltimooficial() {
        return ultimooficial;
    }

    public void setUltimooficial(int ultimooficial) {
        this.ultimooficial = ultimooficial;
    }

    public PuntoVta getPuntoVta() {
        return puntoVta;
    }

    public void setPuntoVta(PuntoVta puntoVta) {
        this.puntoVta = puntoVta;
    }

    public TipoComprobanteLegacy getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobanteLegacy tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    @XmlTransient
    public Collection<Comprobante> getComprobanteCollection() {
        return comprobanteCollection;
    }

    public void setComprobanteCollection(Collection<Comprobante> comprobanteCollection) {
        this.comprobanteCollection = comprobanteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCompNumeracionPK != null ? tipoCompNumeracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCompNumeracion)) {
            return false;
        }
        TipoCompNumeracion other = (TipoCompNumeracion) object;
        if ((this.tipoCompNumeracionPK == null && other.tipoCompNumeracionPK != null) || (this.tipoCompNumeracionPK != null && !this.tipoCompNumeracionPK.equals(other.tipoCompNumeracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.cuenta.TipoCompNumeracion[ tipoCompNumeracionPK=" + tipoCompNumeracionPK + " ]";
    }
    
}
