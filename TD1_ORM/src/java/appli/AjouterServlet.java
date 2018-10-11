/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import dao.DAO;
import dao.JpaDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Adresse;
import model.BankBranch;
import model.Client;

/**
 *
 * @author Ilangovane
 */
@WebServlet(name = "AjouterServlet", urlPatterns = {"/ajouter"})
public class AjouterServlet extends HttpServlet {

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
            out.println("<title>Servlet AjouterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjouterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        System.out.println("je suis entré dans le get");
        DAO dao = new JpaDAOImpl();
        
        //A RETIRER 
        /**** ajout d'une liste de client ****/
        Client c1 = new Client("83398789","jon.s","sothix",Date.valueOf("1997-02-14"));
        Client c2 = new Client("14788526","passou","ilan",Date.valueOf("1907-03-17"));
        
        dao.create(c1);
        dao.create(c2);
        
        List<Client> lClients = (List<Client>)(Object) dao.findAll("Client");
        System.out.println("liste clients " + lClients.get(0)); 
        
        /**** ajout d'une liste de banque ****/
        Adresse ad = new Adresse("10","rue des etoiles","Trappes","78190");
        Adresse ad1 = new Adresse("10","rue des etoiles","Sevran","78370");
        
        BankBranch bank1 = new BankBranch("10002",ad);
        BankBranch bank2 = new BankBranch("10003",ad1);
        
        dao.create(bank1);
        dao.create(bank2);
        
        List<BankBranch> lBankBranchs = (List<BankBranch>)(Object) dao.findAll("BankBranch");
        
        request.setAttribute("listeClients", lClients);
        request.setAttribute("listeBanque", lBankBranchs);
        
        request.getRequestDispatcher("AjouterCompte.jsp").forward(request,response);
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
        String btn = request.getParameter("btnAjout");
        DAO dao = new JpaDAOImpl();
        System.out.println("je suis entré dans le post");
        
        if(btn.equals("ajoutCli")) {
            String numeroClient = request.getParameter("numeroCli");
            String nomC = request.getParameter("nom");
            String prenomC = request.getParameter("prenom");
            String dateNaiss = request.getParameter("dateNaiss");
            
            System.out.println("bonjour");
            
            Client c = new Client(numeroClient,nomC,prenomC,Date.valueOf(dateNaiss));
            
            dao.create(c);
            
            System.out.println("j'ai passe le create");
            
            request.getRequestDispatcher("Accueil.jsp").forward(request,response);
        }
        if(btn.equals("ajoutCpt")) {
            String numeroCpt = request.getParameter("numeroCompte");
            String libelle = request.getParameter("libelle");
            String IBAN = request.getParameter("IBAN");
            String solde = request.getParameter("solde");
            String codeAgence = request.getParameter("Agence");
            
            Account acc = new Account(numeroCpt,libelle,IBAN,Double.valueOf(solde),
                    (BankBranch) dao.findById(new BankBranch(), codeAgence));
            
            dao.create(acc);
            
            String[] numeroClients = request.getParameterValues("checkClient");
            for(int i =0; i < numeroClients.length; ++i) {
                Client client = (Client) dao.findById(new Client(), numeroClients[i]);
                acc.getClients().add(client);
            }
            
            dao.update(acc);
            
            request.getRequestDispatcher("Accueil.jsp").forward(request,response);
            
        }
        
        dao.close();
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
