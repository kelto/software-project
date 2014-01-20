/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import entity.User;
import form.FormUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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

/**
 *
 * @author kelto
 */
@WebServlet(name = "CreateUserServlet", urlPatterns = {"/CreateUser"})
public class CreateUserServlet extends HttpServlet {

    @PersistenceUnit
    //The emf corresponding to 
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    public static final String USER = "user",
            FORM = "form";

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
            out.println("<title>Servlet CreateUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateUserServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        FormUser form = new FormUser();
        User user = form.create(request);
        request.setAttribute(USER, user);
        request.setAttribute(FORM, form);
        if(!form.hasError())
        {
            try
            {

                //begin a transaction
                utx.begin();
                //create an em. 
                //Since the em is created inside a transaction, it is associsated with 
                //the transaction
                em = emf.createEntityManager();
                //persist the person entity
                em.persist(user);
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
