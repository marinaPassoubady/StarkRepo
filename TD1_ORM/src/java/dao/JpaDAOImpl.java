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

/**
 *
 * @author Ilangovane
 */
public class JpaDAOImpl implements DAO {
    
    public EntityManager em;
    
    public JpaDAOImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_ORMPU");
        this.em = emf.createEntityManager();
    }
    
    @Override
    public void create (Object a){
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }
    
    @Override
    public void update (Object a){
       em.getTransaction().begin();
       em.merge(a);
       em.getTransaction().commit();       
    }
    
    @Override
    public void delete(Object o){
        em.getTransaction().begin();
        em.remove(o);
        em.getTransaction().commit();
    }
    
    @Override
    public Object findById(Object o, String id){ 
        
        Object c = em.find(o.getClass(), id);
        
        return c;
    }
    
    @Override
    public List<Object> findAll(String className) {
        Query query = em.createQuery("Select a From " + className + " a");    
        List<Object> lObjects = query.getResultList();

        return lObjects;
    }
    
    public void deleteAll() {
        em.getTransaction().begin();
        
        Query query = em.createQuery("Delete From Account");
        Query query1 = em.createQuery("Delete From Client");  
        Query query2 = em.createQuery("Delete From BankBranch");           
        
        query.executeUpdate();
        query1.executeUpdate();
        query2.executeUpdate();
        
        em.getTransaction().commit();
   
    }
    
    @Override
    public void close() {
        this.em.close();
    }
    
    
}
