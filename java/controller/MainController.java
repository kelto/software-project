/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.CategoryFacade;
import manager.OrderManager;
import session.ProductFacade;
import cart.ShoppingCart;
import entity.Category;

/**
 *
 * @author kelto
 */
@WebServlet(name = "MainController", loadOnStartup = 1, urlPatterns = {"/viewCart", "/category", "/addToCart","/view"})
public class MainController extends HttpServlet {

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
    private CategoryFacade categoryFacade;
    @EJB
    private OrderManager orderManager;
    @EJB
    private ProductFacade productFacade;
    
    
    /**
     *
     * @throws ServletException
     */
    @Override   
    public void init() throws ServletException
    {
        //Store category list in servlet context
        //Should use a singleton session bean
        getServletContext().setAttribute("categories",categoryFacade.findAll());
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MainController at " + request.getContextPath() + "</h1>");
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
         String userPath = request.getServletPath();
         HttpSession session = request.getSession();
         
        // if category page is requested
        if (userPath.equals("/category")) {
            String categoryId = request.getQueryString();
            if(categoryId != null)
            {
                Category category = categoryFacade.find(Short.parseShort(categoryId));
                //storing in the session : in case of some post request with the same layout ...
                session.setAttribute("selectedCategory",category);
                session.setAttribute("listProducts", category.getProductList());
                
                
            }
                        
        // if cart page is requested
        } else if (userPath.equals("/viewCart")) {
            // TODO: Implement cart page request
            
            userPath = "/cart";

        // if checkout page is requested
        } else if (userPath.equals("/checkout")) {
            // TODO: Implement checkout page request

        // if user switches language
        } else if (userPath.equals("/chooseLanguage")) {
            // TODO: Implement language request

        }
        else if(userPath.equals("/view"))
        {
            userPath = "/index";
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
        
        
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        // if addToCart action is called
        if (userPath.equals("/addToCart")) {
            // TODO: Implement add product to cart action
            if(cart== null)
            {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }
            String productId = request.getParameter("productId");
            if(! productId.isEmpty())
            {
                Product product = productFacade.find(Integer.parseInt(productId));
                cart.addItem(product);
                cart.calcule();
            }
            userPath = "/category";

        // if updateCart action is called
        } else if (userPath.equals("/updateCart")) {
            // TODO: Implement update cart action

        // if purchase action is called
        } else if (userPath.equals("/purchase")) {
            
            if (cart != null) {

        // extract user data from request
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String ccNumber = request.getParameter("creditcard");
      
                
        int orderId = orderManager.placeOrder(name,email,address,ccNumber,cart);
    }

    userPath = "/confirmation";
            
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
}
