/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import databaseChecker.UserChecker;
import entity.User;
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
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author kelto
 */
@WebServlet(name = "ConnectionServlet", urlPatterns = {"/ConnectionServlet"})
public class ConnectionServlet extends HttpServlet {

    public static final String ATT_SESSION_USER = "user";
    public static final String ACCESS_CONNECTION = "/ConnectionServlet";

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
            out.println("<title>Servlet ConnectionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConnectionServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        HttpSession session;
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
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
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try 
        {
            em = emf.createEntityManager();
            String userPath = request.getServletPath();
            //query for all the persons in database
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            UserChecker checker = new UserChecker();
            User user = null;
            HttpSession session = request.getSession();
            if(checker.loadUser(request,em,login,password))
            {
                user = checker.getUser();
                session.setAttribute(ATT_SESSION_USER, user);
                request.getRequestDispatcher("WEB-INF/printUser.jsp").forward(request, response);
            }
            request.setAttribute("error", checker.error());
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
              
        } catch (ServletException | IOException ex) {
                throw new ServletException(ex);
            } finally {
                //close the em to release any resources held up by the persistebce provider
                if (em != null) {
                    em.close();
                }
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
}
