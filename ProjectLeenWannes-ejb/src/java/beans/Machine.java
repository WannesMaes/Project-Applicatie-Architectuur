/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Leen
 */
@Entity
@Table(name = "MACHINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machine.findAll", query = "SELECT m FROM Machine m"),
    @NamedQuery(name = "Machine.findByNaam", query = "SELECT m FROM Machine m WHERE m.naam = :naam"),
    @NamedQuery(name = "Machine.findByBeschrijving", query = "SELECT m FROM Machine m WHERE m.beschrijving = :beschrijving"),
    @NamedQuery(name = "Machine.findByLokaal", query = "SELECT m FROM Machine m WHERE m.lokaal = :lokaal"),
    @NamedQuery(name = "Machine.findBySerienr", query = "SELECT m FROM Machine m WHERE m.serienr = :serienr"),
    @NamedQuery(name = "Machine.findByAankoopprijs", query = "SELECT m FROM Machine m WHERE m.aankoopprijs = :aankoopprijs"),
    @NamedQuery(name = "Machine.findByUurprijs", query = "SELECT m FROM Machine m WHERE m.uurprijs = :uurprijs")})
public class Machine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "NAAM")
    private String naam;
    @Size(max = 40)
    @Column(name = "BESCHRIJVING")
    private String beschrijving;
    @Size(max = 5)
    @Column(name = "LOKAAL")
    private String lokaal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERIENR")
    private BigDecimal serienr;
    @Column(name = "AANKOOPPRIJS")
    private BigInteger aankoopprijs;
    @Column(name = "UURPRIJS")
    private BigInteger uurprijs;
    @OneToMany(mappedBy = "serienr")
    private Collection<Reservatie> reservatieCollection;
    @JoinColumn(name = "OPLEIDING", referencedColumnName = "NAAM")
    @ManyToOne
    private Opleiding opleiding;

    public Machine() {
    }

    public Machine(BigDecimal serienr) {
        this.serienr = serienr;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getLokaal() {
        return lokaal;
    }

    public void setLokaal(String lokaal) {
        this.lokaal = lokaal;
    }

    public BigDecimal getSerienr() {
        return serienr;
    }

    public void setSerienr(BigDecimal serienr) {
        this.serienr = serienr;
    }

    public BigInteger getAankoopprijs() {
        return aankoopprijs;
    }

    public void setAankoopprijs(BigInteger aankoopprijs) {
        this.aankoopprijs = aankoopprijs;
    }

    public BigInteger getUurprijs() {
        return uurprijs;
    }

    public void setUurprijs(BigInteger uurprijs) {
        this.uurprijs = uurprijs;
    }

    @XmlTransient
    public Collection<Reservatie> getReservatieCollection() {
        return reservatieCollection;
    }

    public void setReservatieCollection(Collection<Reservatie> reservatieCollection) {
        this.reservatieCollection = reservatieCollection;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serienr != null ? serienr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Machine)) {
            return false;
        }
        Machine other = (Machine) object;
        if ((this.serienr == null && other.serienr != null) || (this.serienr != null && !this.serienr.equals(other.serienr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Machine[ serienr=" + serienr + " ]";
    }
    
}
