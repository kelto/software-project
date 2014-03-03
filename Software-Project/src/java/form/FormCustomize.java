/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import entity.Category;
import entity.Customize;
import entity.Product;
import entity.User;
import entity.UserOrder;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import manager.OrderManager;
import session.CategoryPool;
import session.ProductFacade;

/**
 *
 * @author kelto
 */
@Stateless
public class FormCustomize extends Form<Customize> {
    @EJB
    private OrderManager orderManager;
    @EJB
    private ProductFacade productFacade;

    @EJB
    private CategoryPool categoryPool;
    // Since we need all the categories to create a pc, we can use
    // the categoryPool, but might be that we need to use this one
    // in the future.
    private static final String[] CATEGORY_CUSTOM = null;

    @Override
    public Customize create(HttpServletRequest request) {
        List<Category> listCategories = categoryPool.getCategories();
        List<Product> products = new ArrayList<Product>();
        try {
            for (Category cat : listCategories) {
                String productId = getValue(request, cat.getName());

                products.add(productValidation(productId, cat));


            }
        } catch (Exception e) {
            addErrors("products", e.getMessage());
            products.clear();
        }

        Customize customize = null;
        result = "Creation of the order failed.";
        if(!hasError())
        {
            User user = (User)request.getSession().getAttribute("user");
            assert user!=null;
            customize = new Customize(products);
            result =  "You've succeed to create a customize PC" ;
        }
        return customize;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Product productValidation(String productId, Category cat) throws Exception {
        Product product = null;
        int id = -1;
        try {
            id = Integer.parseInt(productId);
        } catch (Exception e) {
            throw new Exception("The id given is not a number !");
        }
        try {
            product = productFacade.find(id);
        } catch (Exception e) {
            throw new Exception("This product does not exist.");
        }
        if(!product.getCategoryid().equals(cat))
            throw new Exception("This product category does not match the category assigned to this field");
        return product;
    }
}
