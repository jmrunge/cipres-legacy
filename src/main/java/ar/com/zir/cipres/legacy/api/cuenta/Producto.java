/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.api.cuenta;

import ar.com.zir.cipres.legacy.api.cuenta.ItemsAVender;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdproducto", query = "SELECT p FROM Producto p WHERE p.idproducto = :idproducto"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByIditemanticipo", query = "SELECT p FROM Producto p WHERE p.iditemanticipo = :iditemanticipo"),
    @NamedQuery(name = "Producto.findByIditemcancela", query = "SELECT p FROM Producto p WHERE p.iditemcancela = :iditemcancela")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_producto")
    private Short idproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Id_item_anticipo")
    private Short iditemanticipo;
    @Column(name = "Id_item_cancela")
    private Short iditemcancela;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproducto")
    private Collection<ItemsAVender> itemsAVenderCollection;

    public Producto() {
    }

    public Producto(Short idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(Short idproducto, String descripcion) {
        this.idproducto = idproducto;
        this.descripcion = descripcion;
    }

    public Short getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Short idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getIditemanticipo() {
        return iditemanticipo;
    }

    public void setIditemanticipo(Short iditemanticipo) {
        this.iditemanticipo = iditemanticipo;
    }

    public Short getIditemcancela() {
        return iditemcancela;
    }

    public void setIditemcancela(Short iditemcancela) {
        this.iditemcancela = iditemcancela;
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
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
