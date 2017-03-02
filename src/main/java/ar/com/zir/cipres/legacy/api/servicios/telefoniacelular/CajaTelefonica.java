/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import ar.com.zir.cipres.legacy.api.domicilio.Catastro;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jmrunge
 */
@Entity
@Table(name = "CAJA_TELEFONICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CajaTelefonica.findAll", query = "SELECT c FROM CajaTelefonica c"),
    @NamedQuery(name = "CajaTelefonica.findByIdcable", query = "SELECT c FROM CajaTelefonica c WHERE c.cajaTelefonicaPK.idcable = :idcable"),
    @NamedQuery(name = "CajaTelefonica.findByIdcaja", query = "SELECT c FROM CajaTelefonica c WHERE c.cajaTelefonicaPK.idcaja = :idcaja"),
    @NamedQuery(name = "CajaTelefonica.findByDescripcion", query = "SELECT c FROM CajaTelefonica c WHERE c.descripcion = :descripcion")})
public class CajaTelefonica implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CajaTelefonicaPK cajaTelefonicaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "Id_cable", referencedColumnName = "Id_cable", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CableTelefonico cableTelefonico;
    @JoinColumn(name = "Id_catastro", referencedColumnName = "Id_catastro")
    @ManyToOne(optional = false)
    private Catastro idcatastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajaTelefonica")
    private Collection<ParTelefonico> parTelefonicoCollection;

    public CajaTelefonica() {
    }

    public CajaTelefonica(CajaTelefonicaPK cajaTelefonicaPK) {
        this.cajaTelefonicaPK = cajaTelefonicaPK;
    }

    public CajaTelefonica(CajaTelefonicaPK cajaTelefonicaPK, String descripcion) {
        this.cajaTelefonicaPK = cajaTelefonicaPK;
        this.descripcion = descripcion;
    }

    public CajaTelefonica(short idcable, short idcaja) {
        this.cajaTelefonicaPK = new CajaTelefonicaPK(idcable, idcaja);
    }

    public CajaTelefonicaPK getCajaTelefonicaPK() {
        return cajaTelefonicaPK;
    }

    public void setCajaTelefonicaPK(CajaTelefonicaPK cajaTelefonicaPK) {
        this.cajaTelefonicaPK = cajaTelefonicaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CableTelefonico getCableTelefonico() {
        return cableTelefonico;
    }

    public void setCableTelefonico(CableTelefonico cableTelefonico) {
        this.cableTelefonico = cableTelefonico;
    }

    public Catastro getIdcatastro() {
        return idcatastro;
    }

    public void setIdcatastro(Catastro idcatastro) {
        this.idcatastro = idcatastro;
    }

    @XmlTransient
    public Collection<ParTelefonico> getParTelefonicoCollection() {
        return parTelefonicoCollection;
    }

    public void setParTelefonicoCollection(Collection<ParTelefonico> parTelefonicoCollection) {
        this.parTelefonicoCollection = parTelefonicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajaTelefonicaPK != null ? cajaTelefonicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CajaTelefonica)) {
            return false;
        }
        CajaTelefonica other = (CajaTelefonica) object;
        if ((this.cajaTelefonicaPK == null && other.cajaTelefonicaPK != null) || (this.cajaTelefonicaPK != null && !this.cajaTelefonicaPK.equals(other.cajaTelefonicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.CajaTelefonica[ cajaTelefonicaPK=" + cajaTelefonicaPK + " ]";
    }
    
}
