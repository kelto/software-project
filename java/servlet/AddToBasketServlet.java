/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Basket;
import entity.Product;
import entity.User;
import form.FormUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import static servlet.CreateUserServlet.FORM;
import static servlet.CreateUserServlet.USER;

/**
 *
 * @author kelto
 */
@WebServlet(name = "AddToBasketServlet", urlPatterns = {"/AddToBasketServlet"})
public class AddToBasketServlet extends HttpServlet {

     @PersistenceUnit
    //The emf corresponding to 
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToBasketServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToBasketServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
            try
            {
            
                //begin a transaction
                utx.begin();
                //create an em. 
                //Since the em is created inside a transaction, it is associsated with 
                //the transaction
                em = emf.createEntityManager();
                User user = em.find(User.class,0);
                    
                Product product = em.find(Product.class,1);
                
                    //persist the person entity
                Basket basket = user.getBasket();
                basket.addBasketProduct(product);
                em.persist(basket);
                //commit transaction which will trigger the em to 
                //commit newly created entity into database
                utx.commit();

            //Forward to ListUser servlet to list persons along with the newly
            //created user above
            //request.getRequestDispatcher("ListUser").forward(request, response);
            } catch (Exception ex) {
                throw new ServletException(ex);
            } finally {
                //close the em to release any resources held up by the persistebce provider
                if (em != null) {
                    em.close();
                }
            }
           
        
        //request.getRequestDispatcher("WEB-INF/CreateUser.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        
        
            try
            {

                //begin a transaction
                utx.begin();
                //create an em. 
                //Since the em is created inside a transaction, it is associsated with 
                //the transaction
                em = emf.createEntityManager();
                Product product = em.find(Product.class,0);
                //persist the person entity
                User user = em.find(User.class,0);
                Basket basket = user.getBasket();
                basket.addBasketProduct(product);
                em.persist(basket);
                //commit transaction which will trigger the em to 
                //commit newly created entity into database
                utx.commit();

            //Forward to ListUser servlet to list persons along with the newly
            //created user above
            //request.getRequestDispatcher("ListUser").forward(request, response);
            } catch (Exception ex) {
                throw new ServletException(ex);
            } finally {
                //close the em to release any resources held up by the persistebce provider
                if (em != null) {
                    em.close();
                }
            }
        
        
        request.getRequestDispatcher("WEB-INF/CreateUser.jsp").forward(request, response);
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
