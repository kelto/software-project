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
import manager.ProductManager;
import session.CategoryPool;
import session.ProductPool;
import session.UserFacade;

/**
 *
 * @author kelto
 */
@WebServlet(name = "MainController", loadOnStartup = 1, urlPatterns = {"/viewProduct","/index", "/product","/view","/search"})
public class MainController extends HttpServlet {
    @EJB
    private ProductManager productManager;

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
         
       if (userPath.equals("/search")) {
            String search = request.getParameter("search");
            if(search!=null && !search.isEmpty())
            {
                List<Product> searchResult = productManager.search(search);
                request.setAttribute("listProducts", searchResult);
                userPath="/category";
            }

        }
        
        else if(userPath.equals("/product"))
        {
            String param = request.getParameter("productId");
            Product product = null;
            if(param != null && ! param.isEmpty())
            {
                int id = -1;
                try {
                    id = Integer.parseInt(param);
                    product = productFacade.find(id);
                    request.setAttribute("product", product);
                } catch (Exception e) {
                    id = -1;
                    product = null;
                    e.printStackTrace();
                }
                
                
            }
            if(product != null)
                request.getRequestDispatcher("/WEB-INF/view/product.jsp").forward(request, response);
            else
            {
                request.setAttribute("error", "This product doesn't exist. Can't show the product page of an empty product.");
                request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
            }
                
        }
        else if(userPath.equals("/view"))
        {
            userPath = "/index";
        }else if (userPath.equals("/viewProduct")) {
            Product product = new Product();
            List<Comment> comments = new ArrayList<Comment>();
            User user = userFacade.findAll().get(0);
            for(int i = 0;i<5;i++)
            {
                Comment comment = new Comment();
                comment.setId(i);
                comment.setUserid(user);
                comment.setComment("This a comment !! let's rate this product.");
                comment.setScore((short)4);
                comments.add(comment);
            }
            product.setCommentList(comments);
            request.setAttribute("product", product);
            request.getRequestDispatcher("/WEB-INF/view/product.jsp").forward(request, response);
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
         if (userPath.equals("/purchase")) {
            
            if (cart != null) {

        // extract user data from request
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String ccNumber = request.getParameter("creditcard");
      
        
        //int orderId = orderManager.placeOrder(name,email,address,ccNumber,cart);
        User user = (User) session.getAttribute("user");
        //int orderId = orderManager.placeOrder(user, cart);
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
