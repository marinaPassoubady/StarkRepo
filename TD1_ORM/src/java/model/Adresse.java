/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Sothiya
 */
@Embeddable
public class Adresse implements Serializable {
    
   @Column
   private String numero;
   
   @Column
   private String rue;
   
   @Column
   private String ville;
   
   @Column(length=5)
   private String codePostal;
   
   public Adresse() {
       
   }
   
   public Adresse(String numero,String rue,String ville, String codePostal) {
       this.numero = numero;
       this.rue = rue;
       this.ville = ville;
       this.codePostal = codePostal;
   }
  
   public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
