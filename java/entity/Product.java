/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Product.findByNumberSold", query = "SELECT p FROM Product p WHERE p.numberSold = :numberSold")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
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
    @Column(name = "selling_price")
    private Integer sellingPrice;
    @Column(name = "number_sold")
    private Integer numberSold;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
    private Collection<CommandProduct> commandProductCollection;
    @JoinColumn(name = "tag", referencedColumnName = "idTag")
    @ManyToOne
    private Tag tag;
    @JoinColumn(name = "brand", referencedColumnName = "idBrand")
    @ManyToOne
    private Brand brand;
    @OneToMany(mappedBy = "product")
    private Collection<Comment> commentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
    private Collection<Basket> basketCollection;

    public Product() {
    }

    public Product(Integer idProduct) {
        this.idProduct = idProduct;
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

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(Integer numberSold) {
        this.numberSold = numberSold;
    }

    @XmlTransient
    public Collection<CommandProduct> getCommandProductCollection() {
        return commandProductCollection;
    }

    public void setCommandProductCollection(Collection<CommandProduct> commandProductCollection) {
        this.commandProductCollection = commandProductCollection;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<Basket> getBasketCollection() {
        return basketCollection;
    }

    public void setBasketCollection(Collection<Basket> basketCollection) {
        this.basketCollection = basketCollection;
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
