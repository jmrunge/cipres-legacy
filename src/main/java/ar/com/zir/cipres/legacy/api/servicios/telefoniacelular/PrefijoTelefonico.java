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
@Table(name = "PREFIJO_TELEFONICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrefijoTelefonico.findAll", query = "SELECT p FROM PrefijoTelefonico p"),
    @NamedQuery(name = "PrefijoTelefonico.findByPrefijo", query = "SELECT p FROM PrefijoTelefonico p WHERE p.prefijo = :prefijo"),
    @NamedQuery(name = "PrefijoTelefonico.findByActivo", query = "SELECT p FROM PrefijoTelefonico p WHERE p.activo = :activo")})
public class PrefijoTelefonico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Prefijo")
    private String prefijo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefijoTelefonico")
    private Collection<NumeroAbonado> numeroAbonadoCollection;
    @JoinColumn(name = "Tipo_prefijo", referencedColumnName = "Tipo_prefijo")
    @ManyToOne(optional = false)
    private TipoPrefijo tipoprefijo;

    public PrefijoTelefonico() {
    }

    public PrefijoTelefonico(String prefijo) {
        this.prefijo = prefijo;
    }

    public PrefijoTelefonico(String prefijo, boolean activo) {
        this.prefijo = prefijo;
        this.activo = activo;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<NumeroAbonado> getNumeroAbonadoCollection() {
        return numeroAbonadoCollection;
    }

    public void setNumeroAbonadoCollection(Collection<NumeroAbonado> numeroAbonadoCollection) {
        this.numeroAbonadoCollection = numeroAbonadoCollection;
    }

    public TipoPrefijo getTipoprefijo() {
        return tipoprefijo;
    }

    public void setTipoprefijo(TipoPrefijo tipoprefijo) {
        this.tipoprefijo = tipoprefijo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prefijo != null ? prefijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrefijoTelefonico)) {
            return false;
        }
        PrefijoTelefonico other = (PrefijoTelefonico) object;
        if ((this.prefijo == null && other.prefijo != null) || (this.prefijo != null && !this.prefijo.equals(other.prefijo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.PrefijoTelefonico[ prefijo=" + prefijo + " ]";
    }
    
}
