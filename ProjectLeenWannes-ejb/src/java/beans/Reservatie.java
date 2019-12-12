/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leen
 */
@Entity
@Table(name = "RESERVATIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservatie.findAll", query = "SELECT r FROM Reservatie r"),
    @NamedQuery(name = "Reservatie.findByRnr", query = "SELECT r FROM Reservatie r WHERE r.rnr = :rnr"),
    @NamedQuery(name = "Reservatie.findByDatum", query = "SELECT r FROM Reservatie r WHERE r.datum = :datum"),
    @NamedQuery(name = "Reservatie.findByStartuur", query = "SELECT r FROM Reservatie r WHERE r.startuur = :startuur"),
    @NamedQuery(name = "Reservatie.findByEinduur", query = "SELECT r FROM Reservatie r WHERE r.einduur = :einduur"),
    @NamedQuery(name = "Reservatie.findByBeschikbaar", query = "SELECT r FROM Reservatie r WHERE r.beschikbaar = :beschikbaar")})
public class Reservatie implements Serializable {
    @JoinColumn(name = "HUURDER", referencedColumnName = "GEBRUIKERSNAAM")
    @ManyToOne
    private Secgebruikers huurder;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RNR")
    private BigDecimal rnr;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Column(name = "STARTUUR")
    private BigInteger startuur;
    @Column(name = "EINDUUR")
    private BigInteger einduur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "BESCHIKBAAR")
    private String beschikbaar;
    @JoinColumn(name = "SERIENR", referencedColumnName = "SERIENR")
    @ManyToOne
    private Machine serienr;

    public Reservatie() {
    }

    public Reservatie(BigDecimal rnr) {
        this.rnr = rnr;
    }

    public Reservatie(BigDecimal rnr, String beschikbaar) {
        this.rnr = rnr;
        this.beschikbaar = beschikbaar;
    }

    public BigDecimal getRnr() {
        return rnr;
    }

    public void setRnr(BigDecimal rnr) {
        this.rnr = rnr;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public BigInteger getStartuur() {
        return startuur;
    }

    public void setStartuur(BigInteger startuur) {
        this.startuur = startuur;
    }

    public BigInteger getEinduur() {
        return einduur;
    }

    public void setEinduur(BigInteger einduur) {
        this.einduur = einduur;
    }

    public String getBeschikbaar() {
        return beschikbaar;
    }

    public void setBeschikbaar(String beschikbaar) {
        this.beschikbaar = beschikbaar;
    }

    public Machine getSerienr() {
        return serienr;
    }

    public void setSerienr(Machine serienr) {
        this.serienr = serienr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rnr != null ? rnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservatie)) {
            return false;
        }
        Reservatie other = (Reservatie) object;
        if ((this.rnr == null && other.rnr != null) || (this.rnr != null && !this.rnr.equals(other.rnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Reservatie[ rnr=" + rnr + " ]";
    }

    public Secgebruikers getHuurder() {
        return huurder;
    }

    public void setHuurder(Secgebruikers huurder) {
        this.huurder = huurder;
    }
    
}
