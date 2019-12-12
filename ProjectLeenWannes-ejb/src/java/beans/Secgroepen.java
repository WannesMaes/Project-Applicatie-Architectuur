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
@Table(name = "SECGROEPEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secgroepen.findAll", query = "SELECT s FROM Secgroepen s"),
    @NamedQuery(name = "Secgroepen.findByGebruikersnaam", query = "SELECT s FROM Secgroepen s WHERE s.gebruikersnaam = :gebruikersnaam"),
    @NamedQuery(name = "Secgroepen.findByGroep", query = "SELECT s FROM Secgroepen s WHERE s.groep = :groep")})
public class Secgroepen implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GEBRUIKERSNAAM")
    private BigDecimal gebruikersnaam;
    @Size(max = 20)
    @Column(name = "GROEP")
    private String groep;
    @JoinColumn(name = "GEBRUIKERSNAAM", referencedColumnName = "GEBRUIKERSNAAM", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Secgebruikers secgebruikers;

    public Secgroepen() {
    }

    public Secgroepen(BigDecimal gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public BigDecimal getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(BigDecimal gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getGroep() {
        return groep;
    }

    public void setGroep(String groep) {
        this.groep = groep;
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
        hash += (gebruikersnaam != null ? gebruikersnaam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secgroepen)) {
            return false;
        }
        Secgroepen other = (Secgroepen) object;
        if ((this.gebruikersnaam == null && other.gebruikersnaam != null) || (this.gebruikersnaam != null && !this.gebruikersnaam.equals(other.gebruikersnaam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Secgroepen[ gebruikersnaam=" + gebruikersnaam + " ]";
    }
    
}
