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
 * @author jmrunge
 */
@Entity
@Table(name = "NUMERO_ABONADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumeroAbonado.findAll", query = "SELECT n FROM NumeroAbonado n"),
    @NamedQuery(name = "NumeroAbonado.findByPrefijo", query = "SELECT n FROM NumeroAbonado n WHERE n.numeroAbonadoPK.prefijo = :prefijo"),
    @NamedQuery(name = "NumeroAbonado.findByNrotelefono", query = "SELECT n FROM NumeroAbonado n WHERE n.numeroAbonadoPK.nrotelefono = :nrotelefono"),
    @NamedQuery(name = "NumeroAbonado.findByEspecial", query = "SELECT n FROM NumeroAbonado n WHERE n.especial = :especial"),
    @NamedQuery(name = "NumeroAbonado.findByReservado", query = "SELECT n FROM NumeroAbonado n WHERE n.reservado = :reservado")})
public class NumeroAbonado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NumeroAbonadoPK numeroAbonadoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Especial")
    private boolean especial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Reservado")
    private boolean reservado;
    @JoinColumn(name = "Prefijo", referencedColumnName = "Prefijo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrefijoTelefonico prefijoTelefonico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroAbonado")
    private Collection<ConexionTelefonica> conexionTelefonicaCollection;

    public NumeroAbonado() {
    }

    public NumeroAbonado(NumeroAbonadoPK numeroAbonadoPK) {
        this.numeroAbonadoPK = numeroAbonadoPK;
    }

    public NumeroAbonado(NumeroAbonadoPK numeroAbonadoPK, boolean especial, boolean reservado) {
        this.numeroAbonadoPK = numeroAbonadoPK;
        this.especial = especial;
        this.reservado = reservado;
    }

    public NumeroAbonado(String prefijo, int nrotelefono) {
        this.numeroAbonadoPK = new NumeroAbonadoPK(prefijo, nrotelefono);
    }

    public NumeroAbonadoPK getNumeroAbonadoPK() {
        return numeroAbonadoPK;
    }

    public void setNumeroAbonadoPK(NumeroAbonadoPK numeroAbonadoPK) {
        this.numeroAbonadoPK = numeroAbonadoPK;
    }

    public boolean getEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public boolean getReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public PrefijoTelefonico getPrefijoTelefonico() {
        return prefijoTelefonico;
    }

    public void setPrefijoTelefonico(PrefijoTelefonico prefijoTelefonico) {
        this.prefijoTelefonico = prefijoTelefonico;
    }

    @XmlTransient
    public Collection<ConexionTelefonica> getConexionTelefonicaCollection() {
        return conexionTelefonicaCollection;
    }

    public void setConexionTelefonicaCollection(Collection<ConexionTelefonica> conexionTelefonicaCollection) {
        this.conexionTelefonicaCollection = conexionTelefonicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroAbonadoPK != null ? numeroAbonadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumeroAbonado)) {
            return false;
        }
        NumeroAbonado other = (NumeroAbonado) object;
        if ((this.numeroAbonadoPK == null && other.numeroAbonadoPK != null) || (this.numeroAbonadoPK != null && !this.numeroAbonadoPK.equals(other.numeroAbonadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.NumeroAbonado[ numeroAbonadoPK=" + numeroAbonadoPK + " ]";
    }
    
}
