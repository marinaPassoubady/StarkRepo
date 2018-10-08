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
import model.Account;

/**
 *
 * @author Ilangovane
 */
public class AccountDAO {
    
    //public EntityManager em;
    
    public AccountDAO(EntityManager em) {
        //this.em = em;
    }
    
    public AccountDAO() {
        
    }
    
    public void create (Account a){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_ORM_BankPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }
    
    public void update (Account a){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_ORM_BankPU");
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       em.merge(a);
       em.getTransaction().commit();
       em.close();         
    }
    
    public Account findById(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_ORM_BankPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Account c = em.find(Account.class, id);
        /*TypedQuery<Client> query = em.createQuery("Select c From Client c Where c.numeroClient = :idClient",Client.class)
            .setParameter("idClient",id);      
        Client c= query.getSingleResult();*/
        em.close();
        
        return c;
    }
    
    public List<Account> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_ORM_BankPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("Select a From Account a");
       
        List<Account> lAccounts = query.getResultList();
        em.close();
        
        return lAccounts;
    }
    
    public void delete(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_ORM_BankPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Account a = findById(id);
        em.remove(a);
        em.getTransaction().commit();
        em.close();
    }
    
}
