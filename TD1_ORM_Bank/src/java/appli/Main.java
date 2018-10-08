/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import dao.ClientDAO;
import dao.AccountDAO;
import dao.BankBranchDAO;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Client;

/**
 *
 * @author Sothiya
 */
public class Main {
    
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TD1_ORM_BankPU");
        EntityManager em = emf.createEntityManager();
        
        ClientDAO cDAO = new ClientDAO(em);
        AccountDAO aDAO = new AccountDAO(em);
        BankBranchDAO bDAO = new BankBranchDAO(em);
        
        //TEST CLIENT DAO
        Date d = new Date();
        Client c1 = new Client("12345698","jon.s","sothix",d);
        Client c2 = new Client("12345671","pass","marina",d);
        
        //test du create
        cDAO.create(c1);
        cDAO.create(c2);

        //test findAll
        System.out.println(cDAO.findAll().size()); //2
        
        //test update c1 + findById
        c1.setNom("kingNorth");
        cDAO.update(c1);
        Client c3 = cDAO.findById(c1.getId());
        System.out.println(c3.getNom() + " " + c3.getPrenom());
        
        //test delete
        cDAO.delete(c2.getId());
        System.out.println(cDAO.findAll().size()); //1
        
        
        
        //TEST BANK BRANCH DAO
        
        //TEST ACCOUNT DAO
    }
}
