/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import entity.Category;
import entity.Product;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import manager.ProductManager;
import session.CategoryFacade;

/**
 *
 * @author kelto
 */
@Stateless
public class FormProduct extends Form<Product> {
    @EJB
    private ProductManager productManager;
    @EJB
    private CategoryFacade categoryFacade;

    private static final String NAME = "name",
            DESCRIPTION = "description",
            BUYING = "buying_price",
            SELLING = "selling_price",
            CATEGORY = "category";
    
    @Override
    public Product create(HttpServletRequest request) {
        clear();
        String name = getValue(request, NAME);
        try {
            nameValidation(name);
        } catch (Exception e) {
            addErrors(NAME, e.getMessage());
        }
        String description = getValue(request, DESCRIPTION);
        try {
            descriptionValidation(description);
        } catch (Exception e) {
            addErrors(DESCRIPTION, e.getMessage());
        }
        double[] prices = {0.0,0.0};
        try {
            prices = priceValidation(getValue(request, BUYING),getValue(request,SELLING));
        } catch (Exception e) {
            addErrors("prices", e.getMessage());
        }
        Category category = null;
        try {
            category = categoryValidation(getValue(request,CATEGORY));
        } catch (Exception e) {
            addErrors(CATEGORY, e.getMessage());
        }
        
        Product product = null;
        result = "Failed to create Product.";
        if(!hasError())
        {
            product = new Product();
            product.setBuyingPrice(new BigDecimal(prices[0]));
            product.setDescription(description);
            product.setName(name);
            product.setCategoryid(category);
            try {
                productManager.addProduct(product);
                result = "Product created.";
            } catch (Exception e) {
                Logger.getLogger(FormProduct.class.getName()).log(Level.SEVERE, null, e);
                product = null;
                result = "Failed to create Product.";
            }
            
        }
        
        return product;
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private void nameValidation(String name) throws Exception {
        if(name == null)
            throw new Exception("The name of the product can't be null");
        if(name.length()<3)
            throw new Exception("The name of the product should be at least 3 characters.");
    }

    private void descriptionValidation(String description) throws Exception {
        if(description == null)
            throw new Exception("The description of the product can't be null");
        if(description.length()<10)
            throw new Exception("The description of the product should be at least 10 characters.");
    }

    private double[] priceValidation(String buying, String selling) throws Exception {
        double b_price,s_price;
        try {
            b_price = Double.parseDouble(buying);
            s_price = Double.parseDouble(selling);
        } catch (Exception e) {
            throw new Exception("You must enter a number for the price");
        }
        if(b_price>s_price)
            throw new Exception("The buying price can't be superior to the selling price.");
        double[] prices = {b_price,s_price};
        return prices;
    }

    private Category categoryValidation(String categoryId) throws Exception {
        int id = -1;
        Category category = null;
        try {
            id = Integer.parseInt(categoryId);
        } catch (Exception e) {
            throw new Exception("Wrong input for category !");
        }
        try {
            category = categoryFacade.find(id);
        } catch (Exception e) {
            throw new Exception("This category doesn't exist.");
        }
        
        return category;
    }

}
