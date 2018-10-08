/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import dao.ClientDAO;
import dao.AccountDAO;
import dao.BankBranchDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Client;

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
        
        ClientDAO cDAO = new ClientDAO();
        AccountDAO aDAO = new AccountDAO();
        BankBranchDAO bDAO = new BankBranchDAO();
        
        //TEST CLIENT DAO
        Date d = new Date();
        Client c1 = new Client("99999999","jon.s","sothix",d);
        Client c2 = new Client("77777777","pass","marina",d);
        
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
        System.out.println(cDAO.findAll().size()); //3
        
        //TEST ACCOUNT DAO
        Account a1 = new Account();
        
        Account a2 = new Account();
        //aDAO.create();
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
