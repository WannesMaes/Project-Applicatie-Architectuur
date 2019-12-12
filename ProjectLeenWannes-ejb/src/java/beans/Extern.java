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
@Table(name = "EXTERN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extern.findAll", query = "SELECT e FROM Extern e"),
    @NamedQuery(name = "Extern.findByEnr", query = "SELECT e FROM Extern e WHERE e.enr = :enr"),
    @NamedQuery(name = "Extern.findByNaam", query = "SELECT e FROM Extern e WHERE e.naam = :naam")})
public class Extern implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENR")
    private BigDecimal enr;
    @Size(max = 20)
    @Column(name = "NAAM")
    private String naam;
    @JoinColumn(name = "ENR", referencedColumnName = "GEBRUIKERSNAAM", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Secgebruikers secgebruikers;

    public Extern() {
    }

    public Extern(BigDecimal enr) {
        this.enr = enr;
    }

    public BigDecimal getEnr() {
        return enr;
    }

    public void setEnr(BigDecimal enr) {
        this.enr = enr;
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
        hash += (enr != null ? enr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extern)) {
            return false;
        }
        Extern other = (Extern) object;
        if ((this.enr == null && other.enr != null) || (this.enr != null && !this.enr.equals(other.enr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Extern[ enr=" + enr + " ]";
    }
    
}
