//Package Declaration 
package ejb;
// Import Statement
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.*;
/**
 *
 * @author 12093185 & 12095728
 */
@Stateless
@LocalBean
//EJB Class Customer
public class CustomerEJB{
    //Adding persistance unit name
    @PersistenceContext(unitName = "eBusinessPU") 
    //create entity manager variable 
    private EntityManager em; 
    
    // This method used to find all custoemrs 
    public List<Customer> findAllCustomers() {
       //create named query for excute query statement
        TypedQuery<Customer> allCustomers = em.createNamedQuery("Customer.findAllCustomer", Customer.class);
       //return all the customers
        return allCustomers.getResultList();
    }

    //Find the customers by Name
    public List<Customer> findCustomerByName(String customerName) {
       //create named query to excute query statement
       Query sql=em.createNamedQuery("Customer.findByName",Customer.class);
       //set customer name
       sql.setParameter("customerName",customerName); 
       //retrun customer name if match found
       return sql.getResultList(); 
    }
       
    // This method is used to create new customer
    public Customer createCustomer(Customer customer) {
        //persist customer object to table
        em.persist(customer); 
        return customer;
    }

    // This method is delete customer object
    public void deleteCustomer(Customer customer) {
        em.remove(em.merge(customer));
    }

    //update customer  object
    public Customer updateCustomer(Customer customer) {
        return em.merge(customer);
    }
}
