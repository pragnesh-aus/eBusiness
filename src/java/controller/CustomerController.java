//Package Delcaration
package Controller;
// Import Statement
import ejb.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.*;

/**
 *
 * @author 12093185 & 12095728
 */

@ManagedBean
@SessionScoped
//Customer controller class
public class CustomerController {

    @EJB
    //Create variable to manage customerEJB
    private CustomerEJB customerEJB; 

    @EJB
    //crete variable to manage orderEJB
    private OrderEJB orderEJB;    
    //Declare variable to store customer name
    private String customerName; 
    //create customer name list type array 
    private List<String> customerNameList=new ArrayList<>(); 
    //create cusomer object list type array
    private List<Customer> customerList=new ArrayList<>();   
    //create customer object
    private Customer customer=new Customer();       
    //create resultcustomer object
    private Customer resultCustomer=new Customer(); 
     //create variable to order count
    private int orderCount=0;

    //Default constructor
    public CustomerController() {
    }
   
    //getters and setters methods
       
    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }
    
   
    
    public List<Customer> getCustomerlist() {
        return customerList;
    }

    public void setCustomerlist(List<Customer> customerList) {
        this.customerList = customerList;
    }
    

    public Customer getCustomer() {
        return customer;
    }

    public void setName(String name) {
        this.customerName = name;
    }

    public void setCustomer(Customer obj) {
        this.customer = obj;
    }

    public Customer getResultCustomer() {
        return resultCustomer;
    }

    public void setResultCustomer(Customer resultCustomer) {
        this.resultCustomer = resultCustomer;
    }
    
     
    
    //add new customer 
     public String InsertCustomer() {
        //Error message variable
        String ErrorreturnResult="";  
        // Checking in any field is empty then it gives error
        if(!customer.getCustomerName().equals("")){
          if(!customer.getCustomerAddress().equals("")){
              if(!customer.getPhoneNumber().equals("")){
                 if(customer.getPhoneNumber().length() ==10){
                    if(!customer.getCustomerEmailAddress().equals("")){
                      
                     //if data is correct then further processed
                     //passing customer object to CustomerEJB model
                     customerEJB.createCustomer(customer);
                     //Assign customer model into result customer object
                     resultCustomer=customer; 
                      //Reset thes customer object
                     customer=new Customer(); 
                     //Reset error message
                     ErrorreturnResult="";
                     //Redirect result to xhtml pages
                     return "createCustomerResult.xhtml";                         
                    }else{
                    ErrorreturnResult="Email address connot be Empty! ";
                    }
                 }else{
                   ErrorreturnResult="Phone Number must be a 10 digits Long! ";
                 }
              }else{
              ErrorreturnResult="Phone number cannot be Empty! ";
              }
          }else{
           ErrorreturnResult="Customer address cannot be Empty!";
          }
        }else{        
            ErrorreturnResult="Customer Name cannot be Empty! ";
        }
        //Get facecontext for currunt instance and store into con
        FacesContext con = FacesContext.getCurrentInstance(); 
         //Return Error message 
        con.addMessage(null, new FacesMessage(ErrorreturnResult));
        return "createCustomer.xhtml"; 
    }
       
    //Get list of customer name
    public List<String> getCustomerList(){
        //crear customer list
        customerNameList.clear(); 
        //Get customer list from CustomerEJB 
        List<Customer> allCustomers=customerEJB.findAllCustomers(); 
        // looping
        for(Customer customer:allCustomers){           
            //add one by one to list
            customerNameList.add(customer.getCustomerName()); 
        }
        // return customer list
        return customerNameList; 
    }
    
   
    //Get customer based on customer name
    public String getCustomersByName(){
    String ErrMsg="";
    //getting customer name 
    customerName= customer.getCustomerName(); 
    // check if empty or not
    if(!customer.getCustomerName().equals("")){
     // get customer list by customer name
     customerList=customerEJB.findCustomerByName(customer.getCustomerName()); 
     ErrMsg=""; 
     //redirect to result page
     return "searchCutomerList.xhtml";      
    }else{      
        ErrMsg="Please enter customer name you want to search";    
    }
    //Get facecontext currunt instance and store into con
        FacesContext con = FacesContext.getCurrentInstance(); 
        //return error message 
        con.addMessage(null, new FacesMessage(ErrMsg)); 
        return "searchCustomer.xhtml";
    }
    
    //Get all customer list
    public List<Customer> getAllCustomers(){
        customerList=customerEJB.findAllCustomers();
        return customerList;
    }
    
    //Get order count
    public int orderCount(){    
    return customer.getOrders().size();
    }
    
    //Get cusotmer count
    public int customerCount(){
    return customerList.size();
    }
    
    //Get order by customer name
    public int orderCountByCustomerName(String customerName){
    return orderEJB.findOrderCountByCustomerName(customerName);     
    }
}
