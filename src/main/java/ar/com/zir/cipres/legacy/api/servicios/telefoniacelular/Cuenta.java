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
@Table(name = "CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByIdcuenta", query = "SELECT c FROM Cuenta c WHERE c.idcuenta = :idcuenta"),
    @NamedQuery(name = "Cuenta.findByCuitCuil", query = "SELECT c FROM Cuenta c WHERE c.cuitCuil = :cuitCuil"),
    @NamedQuery(name = "Cuenta.findByNumero", query = "SELECT c FROM Cuenta c WHERE c.numero = :numero"),
    @NamedQuery(name = "Cuenta.findByPisodpto", query = "SELECT c FROM Cuenta c WHERE c.pisodpto = :pisodpto"),
    @NamedQuery(name = "Cuenta.findByCp", query = "SELECT c FROM Cuenta c WHERE c.cp = :cp"),
    @NamedQuery(name = "Cuenta.findByObservCP", query = "SELECT c FROM Cuenta c WHERE c.observCP = :observCP"),
    @NamedQuery(name = "Cuenta.findByCantcopias", query = "SELECT c FROM Cuenta c WHERE c.cantcopias = :cantcopias"),
    @NamedQuery(name = "Cuenta.findByGranusuario", query = "SELECT c FROM Cuenta c WHERE c.granusuario = :granusuario"),
    @NamedQuery(name = "Cuenta.findByRepartpublica", query = "SELECT c FROM Cuenta c WHERE c.repartpublica = :repartpublica"),
    @NamedQuery(name = "Cuenta.findByPagatasa", query = "SELECT c FROM Cuenta c WHERE c.pagatasa = :pagatasa"),
    @NamedQuery(name = "Cuenta.findByUsuarioespecial", query = "SELECT c FROM Cuenta c WHERE c.usuarioespecial = :usuarioespecial"),
    @NamedQuery(name = "Cuenta.findByNroIIBB", query = "SELECT c FROM Cuenta c WHERE c.nroIIBB = :nroIIBB")})
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_cuenta")
    private Integer idcuenta;
    @Size(max = 15)
    @Column(name = "CUIT_CUIL")
    private String cuitCuil;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cant_copias")
    private short cantcopias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gran_usuario")
    private boolean granusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Repart_publica")
    private boolean repartpublica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Paga_tasa")
    private boolean pagatasa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_especial")
    private boolean usuarioespecial;
    @Size(max = 15)
    @Column(name = "Nro_IIBB")
    private String nroIIBB;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuenta")
    private Collection<Prestacion> prestacionCollection;
    @JoinColumns({
        @JoinColumn(name = "Id_provincia", referencedColumnName = "Id_provincia"),
        @JoinColumn(name = "Id_localidad", referencedColumnName = "Id_localidad"),
        @JoinColumn(name = "Id_calle", referencedColumnName = "Id_calle")})
    @ManyToOne(optional = false)
    private Calle calle;
    @JoinColumn(name = "Id_cliente", referencedColumnName = "Id_cliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @JoinColumn(name = "Id_ejido", referencedColumnName = "Id_ejido")
    @ManyToOne(optional = false)
    private Ejido idejido;
    @JoinColumn(name = "Familia", referencedColumnName = "Familia")
    @ManyToOne
    private Familias familia;
    @JoinColumn(name = "Id_tipo_IIBB", referencedColumnName = "Id_tipo_IIBB")
    @ManyToOne(optional = false)
    private TipoIibb idtipoIIBB;
    @JoinColumn(name = "Id_tipo_IVA", referencedColumnName = "Id_tipo_IVA")
    @ManyToOne(optional = false)
    private TipoIva idtipoIVA;

    public Cuenta() {
    }

    public Cuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Cuenta(Integer idcuenta, short cantcopias, boolean granusuario, boolean repartpublica, boolean pagatasa, boolean usuarioespecial) {
        this.idcuenta = idcuenta;
        this.cantcopias = cantcopias;
        this.granusuario = granusuario;
        this.repartpublica = repartpublica;
        this.pagatasa = pagatasa;
        this.usuarioespecial = usuarioespecial;
    }

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getCuitCuil() {
        return cuitCuil;
    }

    public void setCuitCuil(String cuitCuil) {
        this.cuitCuil = cuitCuil;
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

    public short getCantcopias() {
        return cantcopias;
    }

    public void setCantcopias(short cantcopias) {
        this.cantcopias = cantcopias;
    }

    public boolean getGranusuario() {
        return granusuario;
    }

    public void setGranusuario(boolean granusuario) {
        this.granusuario = granusuario;
    }

    public boolean getRepartpublica() {
        return repartpublica;
    }

    public void setRepartpublica(boolean repartpublica) {
        this.repartpublica = repartpublica;
    }

    public boolean getPagatasa() {
        return pagatasa;
    }

    public void setPagatasa(boolean pagatasa) {
        this.pagatasa = pagatasa;
    }

    public boolean getUsuarioespecial() {
        return usuarioespecial;
    }

    public void setUsuarioespecial(boolean usuarioespecial) {
        this.usuarioespecial = usuarioespecial;
    }

    public String getNroIIBB() {
        return nroIIBB;
    }

    public void setNroIIBB(String nroIIBB) {
        this.nroIIBB = nroIIBB;
    }

    @XmlTransient
    public Collection<Prestacion> getPrestacionCollection() {
        return prestacionCollection;
    }

    public void setPrestacionCollection(Collection<Prestacion> prestacionCollection) {
        this.prestacionCollection = prestacionCollection;
    }

    public Calle getCalle() {
        return calle;
    }

    public void setCalle(Calle calle) {
        this.calle = calle;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Ejido getIdejido() {
        return idejido;
    }

    public void setIdejido(Ejido idejido) {
        this.idejido = idejido;
    }

    public Familias getFamilia() {
        return familia;
    }

    public void setFamilia(Familias familia) {
        this.familia = familia;
    }

    public TipoIibb getIdtipoIIBB() {
        return idtipoIIBB;
    }

    public void setIdtipoIIBB(TipoIibb idtipoIIBB) {
        this.idtipoIIBB = idtipoIIBB;
    }

    public TipoIva getIdtipoIVA() {
        return idtipoIVA;
    }

    public void setIdtipoIVA(TipoIva idtipoIVA) {
        this.idtipoIVA = idtipoIVA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuenta != null ? idcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idcuenta == null && other.idcuenta != null) || (this.idcuenta != null && !this.idcuenta.equals(other.idcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.zir.cipres.legacy.api.servicios.telefoniacelular.Cuenta[ idcuenta=" + idcuenta + " ]";
    }
    
}
