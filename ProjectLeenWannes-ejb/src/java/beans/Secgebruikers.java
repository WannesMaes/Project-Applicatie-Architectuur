/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Leen
 */
@Entity
@Table(name = "SECGEBRUIKERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secgebruikers.findAll", query = "SELECT s FROM Secgebruikers s"),
    @NamedQuery(name = "Secgebruikers.findByGebruikersnaam", query = "SELECT s FROM Secgebruikers s WHERE s.gebruikersnaam = :gebruikersnaam"),
    @NamedQuery(name = "Secgebruikers.findByPaswoord", query = "SELECT s FROM Secgebruikers s WHERE s.paswoord = :paswoord")})
public class Secgebruikers implements Serializable {
    @OneToMany(mappedBy = "huurder")
    private Collection<Reservatie> reservatieCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GEBRUIKERSNAAM")
    private BigDecimal gebruikersnaam;
    @Size(max = 20)
    @Column(name = "PASWOORD")
    private String paswoord;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "secgebruikers")
    private Secgroepen secgroepen;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "secgebruikers")
    private Studenten studenten;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "secgebruikers")
    private Docenten docenten;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "secgebruikers")
    private Extern extern;

    public Secgebruikers() {
    }

    public Secgebruikers(BigDecimal gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public BigDecimal getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(BigDecimal gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    public Secgroepen getSecgroepen() {
        return secgroepen;
    }

    public void setSecgroepen(Secgroepen secgroepen) {
        this.secgroepen = secgroepen;
    }

    public Studenten getStudenten() {
        return studenten;
    }

    public void setStudenten(Studenten studenten) {
        this.studenten = studenten;
    }

    public Docenten getDocenten() {
        return docenten;
    }

    public void setDocenten(Docenten docenten) {
        this.docenten = docenten;
    }

    public Extern getExtern() {
        return extern;
    }

    public void setExtern(Extern extern) {
        this.extern = extern;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gebruikersnaam != null ? gebruikersnaam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secgebruikers)) {
            return false;
        }
        Secgebruikers other = (Secgebruikers) object;
        if ((this.gebruikersnaam == null && other.gebruikersnaam != null) || (this.gebruikersnaam != null && !this.gebruikersnaam.equals(other.gebruikersnaam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Secgebruikers[ gebruikersnaam=" + gebruikersnaam + " ]";
    }

    @XmlTransient
    public Collection<Reservatie> getReservatieCollection() {
        return reservatieCollection;
    }

    public void setReservatieCollection(Collection<Reservatie> reservatieCollection) {
        this.reservatieCollection = reservatieCollection;
    }
    
}
