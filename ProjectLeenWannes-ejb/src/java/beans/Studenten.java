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
@Table(name = "STUDENTEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studenten.findAll", query = "SELECT s FROM Studenten s"),
    @NamedQuery(name = "Studenten.findBySnr", query = "SELECT s FROM Studenten s WHERE s.snr = :snr"),
    @NamedQuery(name = "Studenten.findByNaam", query = "SELECT s FROM Studenten s WHERE s.naam = :naam")})
public class Studenten implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SNR")
    private BigDecimal snr;
    @Size(max = 20)
    @Column(name = "NAAM")
    private String naam;
    @JoinColumn(name = "SNR", referencedColumnName = "GEBRUIKERSNAAM", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Secgebruikers secgebruikers;

    public Studenten() {
    }

    public Studenten(BigDecimal snr) {
        this.snr = snr;
    }

    public BigDecimal getSnr() {
        return snr;
    }

    public void setSnr(BigDecimal snr) {
        this.snr = snr;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
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
        hash += (snr != null ? snr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studenten)) {
            return false;
        }
        Studenten other = (Studenten) object;
        if ((this.snr == null && other.snr != null) || (this.snr != null && !this.snr.equals(other.snr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Studenten[ snr=" + snr + " ]";
    }
    
}
