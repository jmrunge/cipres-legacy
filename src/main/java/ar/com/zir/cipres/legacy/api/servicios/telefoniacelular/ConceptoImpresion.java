/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.servicios.telefoniacelular;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CONCEPTO_IMPRESION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConceptoImpresion.findAll", query = "SELECT c FROM ConceptoImpresion c"),
    @NamedQuery(name = "ConceptoImpresion.findByIdconcepto", query = "SELECT c FROM ConceptoImpresion c WHERE c.idconcepto = :idconcepto"),
    @NamedQuery(name = "ConceptoImpresion.findByDescripcion", query = "SELECT c FROM ConceptoImpresion c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "ConceptoImpresion.findByOrdenimp", query = "SELECT c FROM ConceptoImpresion c WHERE c.ordenimp = :ordenimp")})
public class ConceptoImpresion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_concepto")
    private Integer idconcepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Orden_imp")
    private short ordenimp;
    @OneToMany(mappedBy = "idconcepto")
    private Collection<ItemsAVender> itemsAVenderCollection;

    public ConceptoImpresion() {
    }

    public ConceptoImpresion(Integer idconcepto) {
        this.idconcepto = idconcepto;
    }

    public ConceptoImpresion(Integer idconcepto, String descripcion, short ordenimp) {
        this.idconcepto = idconcepto;
        this.descripcion = descripcion;
        this.ordenimp = ordenimp;
    }

    public Integer getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Integer idconcepto) {
        this.idconcepto = idconcepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getOrdenimp() {
        return ordenimp;
    }

    public void setOrdenimp(short ordenimp) {
        this.ordenimp = ordenimp;
    }

    @XmlTransient
    public Collection<ItemsAVender> getItemsAVenderCollection() {
        return itemsAVenderCollection;
    }

    public void setItemsAVenderCollection(Collection<ItemsAVender> itemsAVenderCollection) {
        this.itemsAVenderCollection = itemsAVenderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconcepto != null ? idconcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConceptoImpresion)) {
            return false;
        }
        ConceptoImpresion other = (ConceptoImpresion) object;
        if ((this.idconcepto == null && other.idconcepto != null) || (this.idconcepto != null && !this.idconcepto.equals(other.idconcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.ConceptoImpresion[ idconcepto=" + idconcepto + " ]";
    }
    
}
