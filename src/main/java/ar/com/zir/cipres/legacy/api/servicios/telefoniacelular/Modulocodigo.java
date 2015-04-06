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
@Table(name = "Modulo_codigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulocodigo.findAll", query = "SELECT m FROM Modulocodigo m"),
    @NamedQuery(name = "Modulocodigo.findByIdtipomodulo", query = "SELECT m FROM Modulocodigo m WHERE m.modulocodigoPK.idtipomodulo = :idtipomodulo"),
    @NamedQuery(name = "Modulocodigo.findByIdmodulo", query = "SELECT m FROM Modulocodigo m WHERE m.modulocodigoPK.idmodulo = :idmodulo"),
    @NamedQuery(name = "Modulocodigo.findByDescripcion", query = "SELECT m FROM Modulocodigo m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Modulocodigo.findByLenguaje", query = "SELECT m FROM Modulocodigo m WHERE m.lenguaje = :lenguaje"),
    @NamedQuery(name = "Modulocodigo.findByCodigo", query = "SELECT m FROM Modulocodigo m WHERE m.codigo = :codigo")})
public class Modulocodigo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModulocodigoPK modulocodigoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Lenguaje")
    private String lenguaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "Codigo")
    private String codigo;
    @OneToMany(mappedBy = "modulocodigo")
    private Collection<AlumbradoPublico> alumbradoPublicoCollection;
    @JoinColumn(name = "Id_tipo_modulo", referencedColumnName = "Id_tipo_modulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipomodulocodigo tipomodulocodigo;

    public Modulocodigo() {
    }

    public Modulocodigo(ModulocodigoPK modulocodigoPK) {
        this.modulocodigoPK = modulocodigoPK;
    }

    public Modulocodigo(ModulocodigoPK modulocodigoPK, String descripcion, String lenguaje, String codigo) {
        this.modulocodigoPK = modulocodigoPK;
        this.descripcion = descripcion;
        this.lenguaje = lenguaje;
        this.codigo = codigo;
    }

    public Modulocodigo(short idtipomodulo, short idmodulo) {
        this.modulocodigoPK = new ModulocodigoPK(idtipomodulo, idmodulo);
    }

    public ModulocodigoPK getModulocodigoPK() {
        return modulocodigoPK;
    }

    public void setModulocodigoPK(ModulocodigoPK modulocodigoPK) {
        this.modulocodigoPK = modulocodigoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public Collection<AlumbradoPublico> getAlumbradoPublicoCollection() {
        return alumbradoPublicoCollection;
    }

    public void setAlumbradoPublicoCollection(Collection<AlumbradoPublico> alumbradoPublicoCollection) {
        this.alumbradoPublicoCollection = alumbradoPublicoCollection;
    }

    public Tipomodulocodigo getTipomodulocodigo() {
        return tipomodulocodigo;
    }

    public void setTipomodulocodigo(Tipomodulocodigo tipomodulocodigo) {
        this.tipomodulocodigo = tipomodulocodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modulocodigoPK != null ? modulocodigoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulocodigo)) {
            return false;
        }
        Modulocodigo other = (Modulocodigo) object;
        if ((this.modulocodigoPK == null && other.modulocodigoPK != null) || (this.modulocodigoPK != null && !this.modulocodigoPK.equals(other.modulocodigoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Modulocodigo[ modulocodigoPK=" + modulocodigoPK + " ]";
    }

}
