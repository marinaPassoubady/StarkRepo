/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import DAO.ClientDAO;
import java.util.Date;
import model.Client;

/**
 *
 * @author Sothiya
 */
public class Main {
    
    public static void main(String args[]) {
        
        ClientDAO cDAO = new ClientDAO();
        Date d = new Date();
        Client c = new Client("12345678","jeya","sothix",d);
        cDAO.create(c);
        System.out.println("ah");
    }
}
