/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "ALUMBRADO_PUBLICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumbradoPublico.findAll", query = "SELECT a FROM AlumbradoPublico a"),
    @NamedQuery(name = "AlumbradoPublico.findByIdalumbradopub", query = "SELECT a FROM AlumbradoPublico a WHERE a.idalumbradopub = :idalumbradopub"),
    @NamedQuery(name = "AlumbradoPublico.findByDescripcion", query = "SELECT a FROM AlumbradoPublico a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "AlumbradoPublico.findByValorbase", query = "SELECT a FROM AlumbradoPublico a WHERE a.valorbase = :valorbase"),
    @NamedQuery(name = "AlumbradoPublico.findByFuncion", query = "SELECT a FROM AlumbradoPublico a WHERE a.funcion = :funcion")})
public class AlumbradoPublico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_alumbrado_pub")
    private Short idalumbradopub;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor_base")
    private BigDecimal valorbase;
    @Size(max = 255)
    @Column(name = "Funcion")
    private String funcion;
    @JoinColumn(name = "Id_item", referencedColumnName = "Id_item")
    @ManyToOne(optional = false)
    private ItemsAVender iditem;
    @JoinColumns({
        @JoinColumn(name = "Id_tipo_modulo", referencedColumnName = "Id_tipo_modulo"),
        @JoinColumn(name = "Id_modulo", referencedColumnName = "Id_modulo")})
    @ManyToOne
    private Modulocodigo modulocodigo;
    @OneToMany(mappedBy = "idalumbradopub")
    private Collection<Catastro> catastroCollection;

    public AlumbradoPublico() {
    }

    public AlumbradoPublico(Short idalumbradopub) {
        this.idalumbradopub = idalumbradopub;
    }

    public AlumbradoPublico(Short idalumbradopub, String descripcion) {
        this.idalumbradopub = idalumbradopub;
        this.descripcion = descripcion;
    }

    public Short getIdalumbradopub() {
        return idalumbradopub;
    }

    public void setIdalumbradopub(Short idalumbradopub) {
        this.idalumbradopub = idalumbradopub;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValorbase() {
        return valorbase;
    }

    public void setValorbase(BigDecimal valorbase) {
        this.valorbase = valorbase;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public ItemsAVender getIditem() {
        return iditem;
    }

    public void setIditem(ItemsAVender iditem) {
        this.iditem = iditem;
    }

    public Modulocodigo getModulocodigo() {
        return modulocodigo;
    }

    public void setModulocodigo(Modulocodigo modulocodigo) {
        this.modulocodigo = modulocodigo;
    }

    @XmlTransient
    public Collection<Catastro> getCatastroCollection() {
        return catastroCollection;
    }

    public void setCatastroCollection(Collection<Catastro> catastroCollection) {
        this.catastroCollection = catastroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalumbradopub != null ? idalumbradopub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumbradoPublico)) {
            return false;
        }
        AlumbradoPublico other = (AlumbradoPublico) object;
        if ((this.idalumbradopub == null && other.idalumbradopub != null) || (this.idalumbradopub != null && !this.idalumbradopub.equals(other.idalumbradopub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.AlumbradoPublico[ idalumbradopub=" + idalumbradopub + " ]";
    }
    
}
