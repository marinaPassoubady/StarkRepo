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
public class DAO {
    
    public EntityManager em;
    
    public DAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_Bank_SauvPU");
        this.em = emf.createEntityManager();
    }
    
    public void create (Object a){
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }
    
    public void update (Object a){
       em.getTransaction().begin();
       em.merge(a);
       em.getTransaction().commit();       
    }
    
    public void delete(Object o){
        em.getTransaction().begin();
        em.remove(o);
        em.getTransaction().commit();
    }
    
    public Object findById(Object o, String id){
        em.getTransaction().begin();

        Object c = em.find(o.getClass(), id);
        
        return c;
    }
    
    public List<Object> findAll(String className) {
        Query query = em.createQuery("Select a From " + className + " a");    
        List<Object> lObjects = query.getResultList();

        return lObjects;
    }
    
    
    public void close() {
        this.em.close();
    }
    
    
}
