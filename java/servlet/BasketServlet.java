/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package servlet;

import entity.*;
import databaseChecker.BasketChecker;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "BasketServlet",
        urlPatterns = {"/BasketServlet",
            "/addToBasket",
            "/removeFromBasket",
            "/viewBasket"})
public class BasketServlet extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    EntityManagerFactory emf=(EntityManagerFactory)getServletContext().getAttribute("emf");
    EntityManager em = emf.createEntityManager();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BasketServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BasketServlet at " + request.getContextPath() + "</h1>");
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
        //    processRequest(request, response);
        
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        // if category page is requested
        if (userPath.equals("/viewBasket")) {
            User user = (User) session.getAttribute(ConnectionServlet.ATT_SESSION_USER);
            assert user != null ;
        /*    Basket basket = user.getBasket();
            request.setAttribute("basket",basket);
            request.getRequestDispatcher("ShowBasket.jsp").forward(request, response);
        */
        }
        
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        //  processRequest(request, response);
        HttpSession session = request.getSession();
        
        String userPath = request.getServletPath();
        
        User user = (User)session.getAttribute(ConnectionServlet.ATT_SESSION_USER);
      //  Basket basket = user.getBasket();
     // Collection<Basket> basketCollection = user.getBasketCollection();
        assert(user!=null);
       // assert(basketCollection!=null);
       
        //We create a new basket for every product we want to add
        if (userPath.equals("/addToBasket")) {     
            BasketChecker basketChecker = new BasketChecker(request, em, user);
            int userId = user.getIdUser(); 
            int itemId = basketChecker.getItemId();
            int amount = basketChecker.getAmount();
            Basket basket = basketChecker.createBasket(userId, itemId, amount);                     
            em.persist(basket);
        }
       
        else if (userPath.equals("/removeFromBasket")) {
            int itemId = Integer.parseInt(request.getParameter("itemId"));
           //what it should do. No remove method though...
            Product product = em.find(Product.class, itemId);
            em.remove(product);
        }
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";
        
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
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
    
    public Basket addProduct(User user,Product product, int amount)
    {
        Basket basket = new Basket();
        basket.setUser1(user);
      
        
        return basket;
    }
}
