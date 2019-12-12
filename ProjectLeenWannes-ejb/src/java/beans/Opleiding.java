/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author Leen
 */
@Entity
@Table(name = "OPLEIDING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opleiding.findAll", query = "SELECT o FROM Opleiding o"),
    @NamedQuery(name = "Opleiding.findByNaam", query = "SELECT o FROM Opleiding o WHERE o.naam = :naam")})
public class Opleiding implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NAAM")
    private String naam;
    @OneToMany(mappedBy = "opleiding")
    private Collection<Machine> machineCollection;
    @OneToMany(mappedBy = "opleiding")
    private Collection<Docenten> docentenCollection;

    public Opleiding() {
    }

    public Opleiding(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @XmlTransient
    public Collection<Machine> getMachineCollection() {
        return machineCollection;
    }

    public void setMachineCollection(Collection<Machine> machineCollection) {
        this.machineCollection = machineCollection;
    }

    @XmlTransient
    public Collection<Docenten> getDocentenCollection() {
        return docentenCollection;
    }

    public void setDocentenCollection(Collection<Docenten> docentenCollection) {
        this.docentenCollection = docentenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (naam != null ? naam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opleiding)) {
            return false;
        }
        Opleiding other = (Opleiding) object;
        if ((this.naam == null && other.naam != null) || (this.naam != null && !this.naam.equals(other.naam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Opleiding[ naam=" + naam + " ]";
    }
    
}
