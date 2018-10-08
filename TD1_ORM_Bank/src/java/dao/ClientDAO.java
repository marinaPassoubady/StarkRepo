/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Client;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Sothiya
 */
public class ClientDAO {
    
    public EntityManager emf;
    public ClientDAO(EntityManager em){ 
        this.emf = em;
    }
    
    public ClientDAO() {
        
    }
    
    public void create (Client c){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_Bank_SauvPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }
    
    public void update (Client cNew){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_Bank_SauvPU");
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       em.merge(cNew);
       em.getTransaction().commit();
       em.close();         
    }
    
    public Client findById(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_Bank_SauvPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Client c = em.find(Client.class, id);
        /*TypedQuery<Client> query = em.createQuery("Select c From Client c Where c.numeroClient = :idClient",Client.class)
            .setParameter("idClient",id);
       
        Client c= query.getSingleResult();*/
        em.close();
        
        return c;
    }
    
    public List<Client> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_Bank_SauvPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("Select c From Client c");
       
        List<Client> lClients = query.getResultList();
        em.close();
        
        return lClients;
    }
    
    public void delete(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_Bank_SauvPU");
        EntityManager em = emf.createEntityManager();
        Client c = findById(id);
        em.getTransaction().begin(); 
        c = em.merge(c);
        em.remove(c);
        em.getTransaction().commit();
        em.close();
    }
    
}
