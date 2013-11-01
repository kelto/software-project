/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kelto
 */
@Entity
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByIdProduct", query = "SELECT p FROM Product p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "Product.findByBuyingPrice", query = "SELECT p FROM Product p WHERE p.buyingPrice = :buyingPrice"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByProductStock", query = "SELECT p FROM Product p WHERE p.productStock = :productStock"),
    @NamedQuery(name = "Product.findBySellingPrice", query = "SELECT p FROM Product p WHERE p.sellingPrice = :sellingPrice"),
    @NamedQuery(name = "Product.findByDate", query = "SELECT p FROM Product p WHERE p.date = :date"),
    @NamedQuery(name = "Product.findByNumberSell", query = "SELECT p FROM Product p WHERE p.numberSell = :numberSell")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduct")
    private Integer idProduct;
    @Lob
    @Size(max = 65535)
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "buying_price")
    private Long buyingPrice;
    @Size(max = 45)
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_stock")
    private Integer productStock;
    @Size(max = 45)
    @Column(name = "selling_price")
    private String sellingPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number_sell")
    private int numberSell;
    @JoinColumn(name = "brand", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Brand brand;
    @JoinColumn(name = "tag", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tag tag;
    @OneToMany(mappedBy = "product")
    private Collection<Comment> commentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
    private Collection<OrderProduct> orderProductCollection;
    @OneToMany(mappedBy = "product")
    private Collection<BasketProduct> basketProductCollection;

    public Product() {
    }

    public Product(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Product(Integer idProduct, Date date, int numberSell) {
        this.idProduct = idProduct;
        this.date = date;
        this.numberSell = numberSell;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Long getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Long buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberSell() {
        return numberSell;
    }

    public void setNumberSell(int numberSell) {
        this.numberSell = numberSell;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<OrderProduct> getOrderProductCollection() {
        return orderProductCollection;
    }

    public void setOrderProductCollection(Collection<OrderProduct> orderProductCollection) {
        this.orderProductCollection = orderProductCollection;
    }

    @XmlTransient
    public Collection<BasketProduct> getBasketProductCollection() {
        return basketProductCollection;
    }

    public void setBasketProductCollection(Collection<BasketProduct> basketProductCollection) {
        this.basketProductCollection = basketProductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ idProduct=" + idProduct + " ]";
    }
    
}
