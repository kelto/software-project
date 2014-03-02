/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.category;

import form.FormCategory;
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
import session.CategoryFacade;

/**
 *
 * @author kelto
 */
@WebServlet(name = "AddCategoryController", urlPatterns = {"/admin/category/add"})
public class AddCategoryController extends HttpServlet {
    @EJB
    private FormCategory formCategory;
    @EJB
    private CategoryFacade categoryFacade;

    private static final String VIEW = "/WEB-INF/view/admin/categories.jsp";

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
            out.println("<title>Servlet AddCategoryController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCategoryController at " + request.getContextPath() + "</h1>");
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
        String query = request.getPathInfo();
        int page = 0;
        if (query != null && !query.isEmpty()) {
            try {
                page = Integer.parseInt(query);
            } catch (Exception ex) {
                Logger.getLogger(AddCategoryController.class.getName()).log(Level.SEVERE, null, ex);
                page = 0;
            }
        }
        categoryFacade.listInSession(request, page);
        request.getRequestDispatcher(VIEW).forward(request, response);
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
        if (request.getServletPath().equals("/admin/category/add")) {
            formCategory.create(request);
            request.setAttribute("form", formCategory);
        }

        categoryFacade.listInSession(request, 0);
        request.getRequestDispatcher("/WEB-INF/view/admin/create.jsp").forward(request, response);
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
