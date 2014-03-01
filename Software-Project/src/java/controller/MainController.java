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
import entity.Comment;
import entity.User;
import form.FormCategory;
import java.util.ArrayList;
import java.util.List;
import manager.CategoryManager;
import session.CategoryPool;
import session.ProductPool;
import session.UserFacade;

/**
 *
 * @author kelto
 */
@WebServlet(name = "MainController", loadOnStartup = 1, urlPatterns = {"/viewProduct","/index","/viewCart", "/addToCart","/view","/addCategory","/purchase"})
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
    private UserFacade userFacade;
    @EJB
    private CategoryFacade categoryFacade;
    @EJB
    private OrderManager orderManager;
    @EJB
    private ProductFacade productFacade;
    @EJB
    private CategoryPool categoryPool;
    @EJB
    private FormCategory formCategory;
    @EJB
    private CategoryManager categoryManager;
    @EJB
    private ProductPool productsPool;
    
    
    /**
     *
     * @throws ServletException
     */
    @Override   
    public void init() throws ServletException
    {
        //Store category list in servlet context
        //Should use a singleton session bean
        categoryPool.setCategories(categoryFacade.findAll());
        getServletContext().setAttribute("categoriesPool",categoryPool);
        getServletContext().setAttribute("productsPool",productsPool);
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
         
        if (userPath.equals("/viewCart")) {
            // TODO: Implement cart page request
            String clear = request.getParameter("clear");

            if ((clear != null) && clear.equals("true")) {

                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                cart.clear();
            }
            userPath = "/cart";

        // if checkout page is requested
        } else if (userPath.equals("/checkout")) {
            // TODO: Implement checkout page request

        // if user switches language
        } else if (userPath.equals("/chooseLanguage")) {
            // TODO: Implement language request

        }
        else if(userPath.equals("/"))
        {
            userPath = "/index";
        }
        else if(userPath.equals("/index"))
        {
            userPath = "/index";
        }
        else if(userPath.equals("/view"))
        {
            userPath = "/index";
        }else if(userPath.equals("/addCategory"))
        {
            
        }else if (userPath.equals("/viewProduct")) {
            Product product = new Product();
            List<Comment> comments = new ArrayList<Comment>();
            for(int i = 0;i<5;i++)
            {
                Comment comment = new Comment();
                comments.add(comment);
            }
            request.setAttribute("product", product);
            request.setAttribute("comments", comments);
            request.getRequestDispatcher("/WEB-INF/view/product.jsp").forward(request, response);
        }else if (userPath.equals("/purchase")) {
            ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
            
            if (cart != null) {
                
        
            //int orderId = orderManager.placeOrder(name,email,address,ccNumber,cart);
            User user = (User) session.getAttribute("user");
            int orderId = orderManager.placeOrder(user, cart);
        
            request.setAttribute("orderId", orderId);
            session.setAttribute("orderId", orderId);
            String purchaseError = orderId == -1 ? "failed" : "success";
            session.setAttribute("purchaseError", purchaseError);
            request.getRequestDispatcher("/WEB-INF/view/done.jsp").forward(request, response);
    }

    userPath = "/category";
            
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
      
        
        //int orderId = orderManager.placeOrder(name,email,address,ccNumber,cart);
        User user = (User) session.getAttribute("user");
        int orderId = orderManager.placeOrder(user, cart);
    }

    userPath = "/category";
            
        }else if(userPath.equals("/addCategory"))
        {
            formCategory.create(request);
            if(formCategory.hasError())
            {
                //do something here ... error page ?
            }
        } else if(userPath.equals("/removeCategory"))
        {       
            //Need to add controll if category contains products. They will be removed.
            short id = Short.parseShort(request.getParameter("categoryID"));
            categoryManager.remove(id);
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
