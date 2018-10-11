/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Account;
import model.Client;

/**
 *
 * @author Ilangovane
 */
public class AccountJpaDAO extends JpaDAOImpl {
    
    public AccountJpaDAO() {
        super();
    }
    
    public void ajouterClient(Client c, String idCompte) {
        Account a = this.em.find(Account.class, idCompte);
        a.getClients().add(c);
        this.update(a);        
    }
    
    
    
    
}
