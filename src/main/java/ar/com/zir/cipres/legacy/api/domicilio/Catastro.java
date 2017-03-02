/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.domicilio;

import ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.CajaTelefonica;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "CATASTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catastro.findAll", query = "SELECT c FROM Catastro c"),
    @NamedQuery(name = "Catastro.findByIdcatastro", query = "SELECT c FROM Catastro c WHERE c.idcatastro = :idcatastro"),
    @NamedQuery(name = "Catastro.findByNumero", query = "SELECT c FROM Catastro c WHERE c.numero = :numero"),
    @NamedQuery(name = "Catastro.findByPisodpto", query = "SELECT c FROM Catastro c WHERE c.pisodpto = :pisodpto"),
    @NamedQuery(name = "Catastro.findByCp", query = "SELECT c FROM Catastro c WHERE c.cp = :cp"),
    @NamedQuery(name = "Catastro.findByObservCP", query = "SELECT c FROM Catastro c WHERE c.observCP = :observCP"),
    @NamedQuery(name = "Catastro.findByMapa", query = "SELECT c FROM Catastro c WHERE c.mapa = :mapa"),
    @NamedQuery(name = "Catastro.findByCoordXY", query = "SELECT c FROM Catastro c WHERE c.coordXY = :coordXY"),
    @NamedQuery(name = "Catastro.findBySuplote", query = "SELECT c FROM Catastro c WHERE c.suplote = :suplote"),
    @NamedQuery(name = "Catastro.findByNrocatastral", query = "SELECT c FROM Catastro c WHERE c.nrocatastral = :nrocatastral")})
public class Catastro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_catastro")
    private Integer idcatastro;
    @Size(max = 5)
    @Column(name = "Numero")
    private String numero;
    @Size(max = 10)
    @Column(name = "Piso_dpto")
    private String pisodpto;
    @Size(max = 8)
    @Column(name = "CP")
    private String cp;
    @Size(max = 255)
    @Column(name = "Observ_CP")
    private String observCP;
    @Size(max = 5)
    @Column(name = "Mapa")
    private String mapa;
    @Size(max = 3)
    @Column(name = "Coord_X_Y")
    private String coordXY;
    @Column(name = "Sup_lote")
    private Integer suplote;
    @Size(max = 20)
    @Column(name = "Nro_catastral")
    private String nrocatastral;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcatastro")
    private Collection<CajaTelefonica> cajaTelefonicaCollection;
    @Column(name = "Id_alumnbrado_pub")
    private Short idalumbradopub;
    @JoinColumn(name = "Id_barrio", referencedColumnName = "Id_barrio")
    @ManyToOne(optional = false)
    private Barrio idbarrio;
    @JoinColumns({
        @JoinColumn(name = "Id_provincia", referencedColumnName = "Id_provincia"),
        @JoinColumn(name = "Id_localidad", referencedColumnName = "Id_localidad"),
        @JoinColumn(name = "Id_calle", referencedColumnName = "Id_calle")})
    @ManyToOne(optional = false)
    private Calle calle;
    @Column(name = "Id_distrito")
    private Short iddistrito;

    public Catastro() {
    }

    public Catastro(Integer idcatastro) {
        this.idcatastro = idcatastro;
    }

    public Integer getIdcatastro() {
        return idcatastro;
    }

    public void setIdcatastro(Integer idcatastro) {
        this.idcatastro = idcatastro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPisodpto() {
        return pisodpto;
    }

    public void setPisodpto(String pisodpto) {
        this.pisodpto = pisodpto;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getObservCP() {
        return observCP;
    }

    public void setObservCP(String observCP) {
        this.observCP = observCP;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getCoordXY() {
        return coordXY;
    }

    public void setCoordXY(String coordXY) {
        this.coordXY = coordXY;
    }

    public Integer getSuplote() {
        return suplote;
    }

    public void setSuplote(Integer suplote) {
        this.suplote = suplote;
    }

    public String getNrocatastral() {
        return nrocatastral;
    }

    public void setNrocatastral(String nrocatastral) {
        this.nrocatastral = nrocatastral;
    }

    @XmlTransient
    public Collection<CajaTelefonica> getCajaTelefonicaCollection() {
        return cajaTelefonicaCollection;
    }

    public void setCajaTelefonicaCollection(Collection<CajaTelefonica> cajaTelefonicaCollection) {
        this.cajaTelefonicaCollection = cajaTelefonicaCollection;
    }

    public Short getIdalumbradopub() {
        return idalumbradopub;
    }

    public void setIdalumbradopub(Short idalumbradopub) {
        this.idalumbradopub = idalumbradopub;
    }

    public Barrio getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(Barrio idbarrio) {
        this.idbarrio = idbarrio;
    }

    public Calle getCalle() {
        return calle;
    }

    public void setCalle(Calle calle) {
        this.calle = calle;
    }

    public Short getIddistrito() {
        return iddistrito;
    }

    public void setIddistrito(Short iddistrito) {
        this.iddistrito = iddistrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcatastro != null ? idcatastro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catastro)) {
            return false;
        }
        Catastro other = (Catastro) object;
        if ((this.idcatastro == null && other.idcatastro != null) || (this.idcatastro != null && !this.idcatastro.equals(other.idcatastro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Catastro[ idcatastro=" + idcatastro + " ]";
    }
    
}
