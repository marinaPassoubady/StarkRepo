/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sothiya
 */
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(length=11)
    private String numeroCompte;
    
    @Column
    private String libelle;
    
        
    @Column(length=27)
    private String IBAN;
    
    @Column
    private double solde;
    
    @ManyToOne
    @JoinColumn(name="agence_fk")
    private BankBranch banque;
    
    @ManyToMany
    @JoinTable(name="clients",
            joinColumns= @JoinColumn (name="a_id", referencedColumnName="numeroCompte"),
            inverseJoinColumns=@JoinColumn(name="c_id", referencedColumnName="numeroClient"))
    private Collection<Client> clients;
    
    public Account() {
        
    }
    
    public Account(String numero, String lib, String IBAN, double solde, BankBranch bq) {
        this.numeroCompte = numero;
        this.libelle = lib;
        this.IBAN = IBAN; 
        this.solde = solde;
        this.banque = bq;
    }

    public BankBranch getBanque() {
        return banque;
    }

    public void setBanque(BankBranch banque) {
        this.banque = banque;
    }
    
    
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }


    public void setNumeroCompte(String id) {
        this.numeroCompte = id;
    }
    
    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCompte != null ? numeroCompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.numeroCompte == null && other.numeroCompte != null) || (this.numeroCompte != null && !this.numeroCompte.equals(other.numeroCompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Account[ id=" + numeroCompte + " ]";
    }
    
}
