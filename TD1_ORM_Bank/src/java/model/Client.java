/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sothiya
 */
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(length = 8)
    private String numeroClient;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;

    public Client(String numeroClient, String nom, String prenom, Date dateNaiss) {
        this.numeroClient = numeroClient;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
    }
    
    public Client(){
        
    }

    public String getId() {
        return numeroClient;
    }

    public void setId(String id) {
        this.numeroClient = id;
    }

    public String getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(String numeroClient) {
        this.numeroClient = numeroClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroClient != null ? numeroClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the numeroClient fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.numeroClient == null && other.numeroClient != null) || (this.numeroClient != null && !this.numeroClient.equals(other.numeroClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Client[ id=" + numeroClient + " ]";
    }

}
