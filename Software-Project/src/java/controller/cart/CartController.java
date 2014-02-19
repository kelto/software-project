/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cart;

import cart.ShoppingCart;
import entity.Product;
import form.FormCartUpdate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.ProductFacade;

/**
 *
 * @author kelto
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart", "/add", "/update"})
public class CartController extends HttpServlet {
    @EJB
    private FormCartUpdate formCartUpdate;

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
    
    @EJB
    private ProductFacade productFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartController at " + request.getContextPath() + "</h1>");
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
        // We assume that the GET method will be /view. If /add or /update is called in GET,
        // it's a good thing that it's redirect here.
        HttpSession session = request.getSession();
        String clear = request.getParameter("clear");
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        createCart(session, cart);

        if ((clear != null) && clear.equals("true")) {

            cart.clear();
        }

        request.getRequestDispatcher("/WEB-INF/view/cart.jsp").forward(request, response);
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

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        createCart(session, cart);
        if (path.equals("/add")) {

            String productId = request.getParameter("productId");
            if (!productId.isEmpty()) {
                Product product = productFacade.find(Integer.parseInt(productId));
                if(product != null)
                    cart.addItem(product);
            }
            request.getRequestDispatcher("/WEB-INF/view/category.jsp").forward(request, response);

        } else if (path.equals("/update")) {
            boolean result = formCartUpdate.create(request);
            
        } 
        request.getRequestDispatcher("/WEB-INF/view/cart.jsp").forward(request, response);
        
    }

    private void createCart(HttpSession session, ShoppingCart cart) {

        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
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
