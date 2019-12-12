/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leen
 */
@Entity
@Table(name = "DOCENTEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docenten.findAll", query = "SELECT d FROM Docenten d"),
    @NamedQuery(name = "Docenten.findByDnr", query = "SELECT d FROM Docenten d WHERE d.dnr = :dnr"),
    @NamedQuery(name = "Docenten.findByNaam", query = "SELECT d FROM Docenten d WHERE d.naam = :naam")})
public class Docenten implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DNR")
    private BigDecimal dnr;
    @Size(max = 20)
    @Column(name = "NAAM")
    private String naam;
    @JoinColumn(name = "OPLEIDING", referencedColumnName = "NAAM")
    @ManyToOne
    private Opleiding opleiding;
    @JoinColumn(name = "DNR", referencedColumnName = "GEBRUIKERSNAAM", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Secgebruikers secgebruikers;

    public Docenten() {
    }

    public Docenten(BigDecimal dnr) {
        this.dnr = dnr;
    }

    public BigDecimal getDnr() {
        return dnr;
    }

    public void setDnr(BigDecimal dnr) {
        this.dnr = dnr;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }

    public Secgebruikers getSecgebruikers() {
        return secgebruikers;
    }

    public void setSecgebruikers(Secgebruikers secgebruikers) {
        this.secgebruikers = secgebruikers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dnr != null ? dnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docenten)) {
            return false;
        }
        Docenten other = (Docenten) object;
        if ((this.dnr == null && other.dnr != null) || (this.dnr != null && !this.dnr.equals(other.dnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Docenten[ dnr=" + dnr + " ]";
    }
    
}
