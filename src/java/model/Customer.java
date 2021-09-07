// Package Delcaration
package model;
// Import Statement
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author 12093185 & 12095728
 */
@Entity
//list of named query
@NamedQueries({
    @NamedQuery(name="Customer.findAllCustomer",query="SELECT c FROM Customer c"),
    @NamedQuery(name="Customer.findByName",query="SELECT c FROM Customer c WHERE c.customerName = :customerName"),
}) 
// class customer that implement serailizable interface
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //list of attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //primary key
    private Long id; 
    @Column(name = "Name")
    private String customerName;
    @Column(name = "Phone")
    private String phoneNumber;
    @Column(name = "Address")
    private String customerAddress;
    @Column(name = "Email")
    private String customerEmailAddress;

  
// Define relationship one to many
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST) 
   
    private List<Orders> orders=new ArrayList<>(); 

    //Default Constructors 
    public Customer(){}
   
    //Getter and Setter method of customer    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }
    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persist.Customer[ id=" + id + " ]";
    }
    
}
