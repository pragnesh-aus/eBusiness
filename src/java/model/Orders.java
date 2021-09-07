// Package Delcaration
package model;
// Import Statement
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 12093185 & 12095728
 */
@Entity
//list of named query
@NamedQueries({
    @NamedQuery(name="Orders.findAllorder",query="SELECT o FROM Orders o"),
    @NamedQuery(name="Orders.findById",query="SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name="Orders.findOrderCountByCustomer",query="SELECT COUNT(o) FROM Orders o WHERE o.customer = :customer"),
    @NamedQuery(name="Orders.findOrdersByCustomer",query="SELECT o FROM Orders o WHERE o.customer = :customer"),
}) 
// class order that implement serailizable interface
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    //list of attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //primary key
    @Column(name = "Customer")
    private String customer;
    @Column(name = "Car")
    private String car;
    @Column(name="PRICE")
    private double carPrice;    
    @Column(name = "Quantity")
    private int Qty;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    //Default constructor
    public Orders(){
        //get current order date
       this.creationDate = new Date(); 
    }

    
    //getters and setters method of order
    
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }
    
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persist.Orders[ id=" + id + " ]";
    }
    
}
