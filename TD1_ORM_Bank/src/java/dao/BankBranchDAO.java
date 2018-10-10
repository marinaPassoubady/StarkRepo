/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.BankBranch;

/**
 *
 * @author Ilangovane
 */
public class BankBranchDAO {
    
    public EntityManager em;
    
    public BankBranchDAO(EntityManager em) {
        this.em = em;
    }

    public BankBranchDAO() {
        
    }

    public void create (BankBranch b){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_Bank_SauvPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
        em.close();
    }
    
    public void update (BankBranch bNew){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_Bank_SauvPU");
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       em.merge(bNew);
       em.getTransaction().commit();
       em.close();         
    }
    
    public BankBranch findById(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_Bank_SauvPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        BankBranch c = em.find(BankBranch.class, id);
        /*TypedQuery<Client> query = em.createQuery("Select c From Client c Where c.numeroClient = :idClient",Client.class)
            .setParameter("idClient",id);
       
        Client c= query.getSingleResult();*/
        em.close();
        
        return c;
    }
    
    public List<BankBranch> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_Bank_SauvPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("Select b From BankBranch b");
       
        List<BankBranch> lBanks = query.getResultList();
        em.close();
        
        return lBanks;
    }
    
    public void delete(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_Bank_SauvPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        BankBranch b = findById(id);
        em.remove(b);
        em.getTransaction().commit();
        em.close();
    }
    
    
}
