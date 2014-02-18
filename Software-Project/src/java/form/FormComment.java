/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

import entity.Comment;
import entity.Product;
import entity.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import session.CommentFacade;
import session.ProductFacade;

/**
 *
 * @author Daniel
 */
@Stateless
public class FormComment extends Form<Comment>{
    
    @EJB
    private CommentFacade commentFacade;
    @EJB
    private ProductFacade productFacade;

    @Override
    public Comment create(HttpServletRequest request) {
        String commentText = getValue(request, "comment");
        Short score = Short.parseShort(getValue(request, "score"));
        try {
            commentTextValidation(commentText, score);
        } catch (Exception ex) {
            addErrors("comment", ex.getMessage());
        }
        Integer productId = Integer.parseInt(getValue(request, "productId"));
        Product product = null;
        try {
            product =productValidation(productId);
        } catch (Exception ex) {
            addErrors("productId", ex.getMessage());
        }
        
        Comment comment = null;
        
        if(!hasError()) {
            comment = new Comment();
            comment.setProductid(product);
            comment.setScore(score);
            comment.setComment(commentText);
            User user = (User) request.getSession().getAttribute("user");
            comment.setUserid(user);
            commentFacade.create(comment);
            result = "Comment created";
        }
            
        if(hasError())
            result= "Failed to create comment";
            
            
        return comment;
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private void commentTextValidation(String commentText, Short score) throws Exception {
        
        if(commentText==null && score == null)
            throw new Exception("Comment is empty");
        if(commentText != null && commentText.length()>254)
            throw new Exception("Comment is to big");
        if(score != null && (score>5||score<0))
            throw new Exception("Invalid score");
        
                   
            
    }

    private Product productValidation(Integer productId) throws Exception {
        Product product = productFacade.find(productId);
        if(product==null){
            throw new Exception("Product doesn't exist ");
        }
        return product;
    }
}
