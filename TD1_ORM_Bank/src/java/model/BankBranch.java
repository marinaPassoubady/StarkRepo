/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Sothiya
 */
@Entity
public class BankBranch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(length=5)
    private int codeAgence;
    
    @Embedded
    private Adresse adresseAgence;
    
    @OneToMany(mappedBy = "banque")
    private Collection<Account> comptes;
    
    public BankBranch() {
        
    }
    
    public BankBranch (int code, Adresse ad) {
        this.codeAgence = code;
        this.adresseAgence = ad;
    }

    public int getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(int codeAgence) {
        this.codeAgence = codeAgence;
    }

    public Adresse getAdresseAgence() {
        return adresseAgence;
    }

    public void setAdresseAgence(Adresse adresseAgence) {
        this.adresseAgence = adresseAgence;
    }

    public int getId() {
        return codeAgence;
    }

    public void setId(int id) {
        this.codeAgence = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
       // hash += (codeAgence != null ? codeAgence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the codeAgence fields are not set
        if (!(object instanceof BankBranch)) {
            return false;
        }
        BankBranch other = (BankBranch) object;
//        if ((this.codeAgence == null && other.codeAgence != null) || (this.codeAgence != null && !this.codeAgence.equals(other.codeAgence))) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.BankBranch[ id=" + codeAgence + " ]";
    }
    
}
