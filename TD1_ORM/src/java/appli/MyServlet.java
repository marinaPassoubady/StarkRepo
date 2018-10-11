/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import dao.AccountJpaDAO;
import dao.JpaDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.BankBranch;
import model.Client;
import model.Adresse;
/**
 *
 * @author Ilangovane
 */
public class MyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
//        
//        
//        
//        //TEST CREATE
//        Date d = new Date();
//        Client c1 = new Client("85698569","jon.s","sothix",d);
//        Client c2 = new Client("77777777","pass","marina",d);
//        
//        Adresse ad = new Adresse("10","rue des etoiles","Trappes","78190");
//        
//        //BankBranch bb = new BankBranch(10002,ad);
//        Adresse a = new Adresse();
//        Account a1 = new Account("10000000001","compteCourantSotix","41257896354ADFGSD784ZE2300Q",10,bb);
//        Account a2 = new Account("10000000002","compteCourantMarina","41257896354ADFGSD999FGVDS56",150,bb);
//        
//        JpaDAOImpl dao = new JpaDAOImpl();
//        
//        //PURGE DES TABLES
//        dao.deleteAll();
//        
//        dao.create(c1);
//        dao.create(c2);
//        //dao.create(bb);
//        dao.create(a1);
//        dao.create(a2);
//        
//        //TEST UPDATE
//        c1.setNom("kingNorth");
//        dao.update(c1);
//        
//        a1.setLibelle("compteCourantUpdatedSotix");
//        a2.setLibelle("compteCourantKhal");
//        dao.update(a1);
//        dao.update(a2);
//        
//        //TEST FINDALL
//        System.out.println(dao.findAll("Account").size());
//        
//        //TEST DELETE
//        dao.delete(c2);
//        
//        //TEST FINDMYID
//        Account a3 = new Account();
//        a3 = (Account) dao.findById(a3,"10000000001");
//        System.out.println(a3.getLibelle());
//        
//        AccountJpaDAO aDAO = new AccountJpaDAO();       
//        aDAO.ajouterClient(c2, "10000000001");
//        
//        dao.close();
//        
//        
    }
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
