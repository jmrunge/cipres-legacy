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
import javax.persistence.OneToOne;
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
@Table(name = "PREST_TELEFONIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrestTelefonia.findAll", query = "SELECT p FROM PrestTelefonia p"),
    @NamedQuery(name = "PrestTelefonia.findByIdprestacion", query = "SELECT p FROM PrestTelefonia p WHERE p.idprestacion = :idprestacion"),
    @NamedQuery(name = "PrestTelefonia.findByDirectorio", query = "SELECT p FROM PrestTelefonia p WHERE p.directorio = :directorio"),
    @NamedQuery(name = "PrestTelefonia.findByFantasia", query = "SELECT p FROM PrestTelefonia p WHERE p.fantasia = :fantasia")})
public class PrestTelefonia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_prestacion")
    private Integer idprestacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Directorio")
    private boolean directorio;
    @Size(max = 40)
    @Column(name = "Fantasia")
    private String fantasia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestTelefonia")
    private Collection<ConsTelefMovil> consTelefMovilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestTelefonia")
    private Collection<TarifaTelefHist> tarifaTelefHistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestTelefonia")
    private Collection<ConexionTelefonica> conexionTelefonicaCollection;
    @JoinColumn(name = "Id_grupo", referencedColumnName = "Id_grupo")
    @ManyToOne(optional = false)
    private GrupoFactuTelef idgrupo;
    @JoinColumn(name = "Id_prestacion", referencedColumnName = "Id_prestacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Prestacion prestacion;
    @JoinColumn(name = "Id_tarifa", referencedColumnName = "Id_tarifa")
    @ManyToOne(optional = false)
    private TarifaTelefonia idtarifa;

    public PrestTelefonia() {
    }

    public PrestTelefonia(Integer idprestacion) {
        this.idprestacion = idprestacion;
    }

    public PrestTelefonia(Integer idprestacion, boolean directorio) {
        this.idprestacion = idprestacion;
        this.directorio = directorio;
    }

    public Integer getIdprestacion() {
        return idprestacion;
    }

    public void setIdprestacion(Integer idprestacion) {
        this.idprestacion = idprestacion;
    }

    public boolean getDirectorio() {
        return directorio;
    }

    public void setDirectorio(boolean directorio) {
        this.directorio = directorio;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    @XmlTransient
    public Collection<ConsTelefMovil> getConsTelefMovilCollection() {
        return consTelefMovilCollection;
    }

    public void setConsTelefMovilCollection(Collection<ConsTelefMovil> consTelefMovilCollection) {
        this.consTelefMovilCollection = consTelefMovilCollection;
    }

    @XmlTransient
    public Collection<TarifaTelefHist> getTarifaTelefHistCollection() {
        return tarifaTelefHistCollection;
    }

    public void setTarifaTelefHistCollection(Collection<TarifaTelefHist> tarifaTelefHistCollection) {
        this.tarifaTelefHistCollection = tarifaTelefHistCollection;
    }

    @XmlTransient
    public Collection<ConexionTelefonica> getConexionTelefonicaCollection() {
        return conexionTelefonicaCollection;
    }

    public void setConexionTelefonicaCollection(Collection<ConexionTelefonica> conexionTelefonicaCollection) {
        this.conexionTelefonicaCollection = conexionTelefonicaCollection;
    }

    public GrupoFactuTelef getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(GrupoFactuTelef idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Prestacion getPrestacion() {
        return prestacion;
    }

    public void setPrestacion(Prestacion prestacion) {
        this.prestacion = prestacion;
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
        hash += (idprestacion != null ? idprestacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestTelefonia)) {
            return false;
        }
        PrestTelefonia other = (PrestTelefonia) object;
        if ((this.idprestacion == null && other.idprestacion != null) || (this.idprestacion != null && !this.idprestacion.equals(other.idprestacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.PrestTelefonia[ idprestacion=" + idprestacion + " ]";
    }
    
}
