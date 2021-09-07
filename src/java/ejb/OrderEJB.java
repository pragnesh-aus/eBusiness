// Package Declaration
package ejb;
// Import Statement
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Orders;
/**
 *
 * @author 12093185 & 12095728
 */

// annonotaion
@Stateless
@LocalBean
// EJB class for Order
public class OrderEJB{
    //add persistance unit name
    @PersistenceContext(unitName = "eBusinessPU")
    //create entity manager variable 
    private EntityManager em; 
    
   
    //find the all orders
    public List<Orders> findAllOrders() {
        //create named query for find all orders
        TypedQuery<Orders> allOrderList = em.createNamedQuery("Orders.findAllorder", Orders.class); 
        //return orderlist of order
        return allOrderList.getResultList(); 
    }

    // This mehtod used to find order by order ID
    public Orders findOrderById(Long id) {      
        // return order
        return em.find(Orders.class, id);         
    }
    
    //This methid used to find how many order created by particular customer
    public int findOrderCountByCustomerName(String name){
    //create named query for get order based of customer name
       Query query=em.createNamedQuery("Orders.findOrderCountByCustomer",Orders.class);
       //set the customer name into query
       query.setParameter("customer",name); 
        //return number of orders
       return ((Number)query.getSingleResult()).intValue(); 
    }
    
    //This method used to find oder list by customer name
    public List<Orders> findOrdersByCustomerName(String name){
       Query query=em.createNamedQuery("Orders.findOrdersByCustomer",Orders.class);
       //set the customer name 
       query.setParameter("customer",name); 
       //return list of order
       return query.getResultList(); 
    }

    //This method create a new order
    public Orders createOrder(Orders order) {
      // Persist order object to table
        em.persist(order);
        return order;
    }

    //This method delete order
    public void deleteOrder(Orders order) {
        em.remove(em.merge(order));
    }

    //This methof update order
    public Orders updateOrder(Orders order) {
        return em.merge(order);
    }
}
