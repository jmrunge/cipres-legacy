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
@Table(name = "TIPO_PREFIJO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPrefijo.findAll", query = "SELECT t FROM TipoPrefijo t"),
    @NamedQuery(name = "TipoPrefijo.findByTipoprefijo", query = "SELECT t FROM TipoPrefijo t WHERE t.tipoprefijo = :tipoprefijo"),
    @NamedQuery(name = "TipoPrefijo.findByDescripcion", query = "SELECT t FROM TipoPrefijo t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoPrefijo.findByPeriodotasacion", query = "SELECT t FROM TipoPrefijo t WHERE t.periodotasacion = :periodotasacion"),
    @NamedQuery(name = "TipoPrefijo.findByPagatitular", query = "SELECT t FROM TipoPrefijo t WHERE t.pagatitular = :pagatitular"),
    @NamedQuery(name = "TipoPrefijo.findByHorario", query = "SELECT t FROM TipoPrefijo t WHERE t.horario = :horario")})
public class TipoPrefijo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tipo_prefijo")
    private Short tipoprefijo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Periodo_tasacion")
    private Short periodotasacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Paga_titular")
    private boolean pagatitular;
    @Column(name = "Horario")
    private Short horario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoprefijo")
    private Collection<PrefijoTelefonico> prefijoTelefonicoCollection;
    @JoinColumn(name = "Id_clave", referencedColumnName = "Id_clave")
    @ManyToOne
    private Clave idclave;
    @JoinColumn(name = "Id_tipo_dia", referencedColumnName = "Id_tipo_dia")
    @ManyToOne
    private TipoDia idtipodia;

    public TipoPrefijo() {
    }

    public TipoPrefijo(Short tipoprefijo) {
        this.tipoprefijo = tipoprefijo;
    }

    public TipoPrefijo(Short tipoprefijo, String descripcion, boolean pagatitular) {
        this.tipoprefijo = tipoprefijo;
        this.descripcion = descripcion;
        this.pagatitular = pagatitular;
    }

    public Short getTipoprefijo() {
        return tipoprefijo;
    }

    public void setTipoprefijo(Short tipoprefijo) {
        this.tipoprefijo = tipoprefijo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getPeriodotasacion() {
        return periodotasacion;
    }

    public void setPeriodotasacion(Short periodotasacion) {
        this.periodotasacion = periodotasacion;
    }

    public boolean getPagatitular() {
        return pagatitular;
    }

    public void setPagatitular(boolean pagatitular) {
        this.pagatitular = pagatitular;
    }

    public Short getHorario() {
        return horario;
    }

    public void setHorario(Short horario) {
        this.horario = horario;
    }

    @XmlTransient
    public Collection<PrefijoTelefonico> getPrefijoTelefonicoCollection() {
        return prefijoTelefonicoCollection;
    }

    public void setPrefijoTelefonicoCollection(Collection<PrefijoTelefonico> prefijoTelefonicoCollection) {
        this.prefijoTelefonicoCollection = prefijoTelefonicoCollection;
    }

    public Clave getIdclave() {
        return idclave;
    }

    public void setIdclave(Clave idclave) {
        this.idclave = idclave;
    }

    public TipoDia getIdtipodia() {
        return idtipodia;
    }

    public void setIdtipodia(TipoDia idtipodia) {
        this.idtipodia = idtipodia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoprefijo != null ? tipoprefijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPrefijo)) {
            return false;
        }
        TipoPrefijo other = (TipoPrefijo) object;
        if ((this.tipoprefijo == null && other.tipoprefijo != null) || (this.tipoprefijo != null && !this.tipoprefijo.equals(other.tipoprefijo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.TipoPrefijo[ tipoprefijo=" + tipoprefijo + " ]";
    }
    
}
