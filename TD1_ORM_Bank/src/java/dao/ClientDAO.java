/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Client;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sothiya
 */
public class ClientDAO {
    
    public ClientDAO(){ 
    }
    public void create (Client c){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_ORM_BankPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }
    
    public void update (Client cNew){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_ORM_BankPU");
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       em.merge(cNew);
       em.getTransaction().commit();
       em.close();         
    }
    
    public Client findById(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_ORM_BankPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return  (Client) em.createQuery("SELECT * from Client c where c.numeroClient=:idClient")
                .setParameter("idClient", id)
                .getSingleResult();
    }
    
    public void delete(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_ORM_BankPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Client c = findById(id);
        em.remove(c);
        em.getTransaction().commit();
        em.close();
    }
    
}
