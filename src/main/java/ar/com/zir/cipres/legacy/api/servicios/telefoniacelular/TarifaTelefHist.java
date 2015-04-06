/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmrunge
 */
@Entity
@Table(name = "TARIFA_TELEF_HIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaTelefHist.findAll", query = "SELECT t FROM TarifaTelefHist t"),
    @NamedQuery(name = "TarifaTelefHist.findByIdprestacion", query = "SELECT t FROM TarifaTelefHist t WHERE t.tarifaTelefHistPK.idprestacion = :idprestacion"),
    @NamedQuery(name = "TarifaTelefHist.findByFechadesde", query = "SELECT t FROM TarifaTelefHist t WHERE t.tarifaTelefHistPK.fechadesde = :fechadesde"),
    @NamedQuery(name = "TarifaTelefHist.findByFechahasta", query = "SELECT t FROM TarifaTelefHist t WHERE t.fechahasta = :fechahasta")})
public class TarifaTelefHist implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TarifaTelefHistPK tarifaTelefHistPK;
    @Column(name = "Fecha_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahasta;
    @JoinColumn(name = "Id_prestacion", referencedColumnName = "Id_prestacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PrestTelefonia prestTelefonia;
    @JoinColumn(name = "Id_tarifa", referencedColumnName = "Id_tarifa")
    @ManyToOne(optional = false)
    private TarifaTelefonia idtarifa;

    public TarifaTelefHist() {
    }

    public TarifaTelefHist(TarifaTelefHistPK tarifaTelefHistPK) {
        this.tarifaTelefHistPK = tarifaTelefHistPK;
    }

    public TarifaTelefHist(int idprestacion, Date fechadesde) {
        this.tarifaTelefHistPK = new TarifaTelefHistPK(idprestacion, fechadesde);
    }

    public TarifaTelefHistPK getTarifaTelefHistPK() {
        return tarifaTelefHistPK;
    }

    public void setTarifaTelefHistPK(TarifaTelefHistPK tarifaTelefHistPK) {
        this.tarifaTelefHistPK = tarifaTelefHistPK;
    }

    public Date getFechahasta() {
        return fechahasta;
    }

    public void setFechahasta(Date fechahasta) {
        this.fechahasta = fechahasta;
    }

    public PrestTelefonia getPrestTelefonia() {
        return prestTelefonia;
    }

    public void setPrestTelefonia(PrestTelefonia prestTelefonia) {
        this.prestTelefonia = prestTelefonia;
    }

    public TarifaTelefonia getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(TarifaTelefonia idtarifa) {
        this.idtarifa = idtarifa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarifaTelefHistPK != null ? tarifaTelefHistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaTelefHist)) {
            return false;
        }
        TarifaTelefHist other = (TarifaTelefHist) object;
        if ((this.tarifaTelefHistPK == null && other.tarifaTelefHistPK != null) || (this.tarifaTelefHistPK != null && !this.tarifaTelefHistPK.equals(other.tarifaTelefHistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.TarifaTelefHist[ tarifaTelefHistPK=" + tarifaTelefHistPK + " ]";
    }
    
}
