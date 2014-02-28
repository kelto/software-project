/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.UserFacade;

/**
 *
 * @author kelto
 */
@WebServlet(name = "ManageUserController", urlPatterns = {"/admin/users","/admin/users/delete"})
public class ManageUserController extends HttpServlet {

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
    private final static int range = 20;
    @EJB
    private UserFacade userFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteUserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteUserController at " + request.getContextPath() + "</h1>");
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

        setUsers(request,0);

        request.getRequestDispatcher("/WEB-INF/view/admin/users.jsp").forward(request, response);

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
        String path = request.getServletPath();

        if (path.equals("/admin/users/delete")) {
            String query = request.getParameter("user_id");
            try {
                userFacade.remove(userFacade.find(Integer.parseInt(query)));
            } catch (Exception ex) {
                Logger.getLogger(ManageUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } else if (path.equals("/update")) {
        }
        setUsers(request);
        request.getRequestDispatcher("/WEB-INF/view/admin/users.jsp").forward(request, response);
    }

    private void setUsers(HttpServletRequest request) {
        
        request.setAttribute("users", userFacade.findAll());
        request.setAttribute("nbPages", userFacade.count()/range);
        request.setAttribute("currentPage", 0);
    }
    private void setUsers(HttpServletRequest request,int page) {
        
        request.setAttribute("users", userFacade.findRange(page*range, range));
        request.setAttribute("nbPages", userFacade.count()/range);
        request.setAttribute("currentPage", page);
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
