// Package declaration
package Controller;
// Import statement
import ejb.*;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.*;

@Named(value = "orderController")
@SessionScoped
public class OrderController implements Serializable {
// list of variables and objects
    @EJB
    private CarEJB carEJB; 
    @EJB
    private OrderEJB orderEJB; 
    private Orders order = new Orders(); 
    private Orders resultOrder = new Orders(); 
    private List<Orders> orderList = new ArrayList<>(); 
    private List<NewCar> resultCar = new ArrayList<>();
    private List<UsedCar> resultCar1 = new ArrayList<>();
    private Customer resultCustomer = new Customer(); 

    //Default contructor 
    public OrderController() {
    }

    //getters and setter methods of order controller
    public Customer getResultCustomer() {
        return resultCustomer;
    }

    public void setResultCustomer(Customer resultCustomer) {
        this.resultCustomer = resultCustomer;
    }

    public List<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }

    public Orders getResultOrder() {
        return resultOrder;
    }

    public void setResultOrder(Orders resultOrder) {
        this.resultOrder = resultOrder;
    }

    public OrderEJB getOrderEJB() {
        return orderEJB;
    }

    public void setOrderEJB(OrderEJB orderEJB) {
        this.orderEJB = orderEJB;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }


    //create a new order
    public String addOrder() {
        // variables
        int numberOfCars = 0;  
        NewCar newcar = new NewCar();
        String ErrMsg = "";
        //create array that holds car name and price
        String carDetailsArray[] = carDetailsArray = order.getCar().split("-"); 
        order.setCar(carDetailsArray[0]);
        carDetailsArray[1] = carDetailsArray[1].replaceAll("[^\\d\\.]", "");
        order.setCarPrice(Double.parseDouble(carDetailsArray[1]));
        // Check input is correct or not
        if (order.getQty() != 0) {       
            resultCar = carEJB.findCarByModel(order.getCar()); 
            for (NewCar car : resultCar) {
                numberOfCars = car.getNumberOfCars(); 
                newcar = car;
            }
            //check stock is  available or not
            if ((numberOfCars - order.getQty()) >= 0) { 
                orderEJB.createOrder(order);
                newcar.setNumberOfCars(numberOfCars - order.getQty());
                carEJB.updateNewCar(newcar);
                resultOrder = order;
                order = new Orders();
                return "createOrderResult.xhtml";
            } else {
                ErrMsg = "Opps !! Your Requested Car May Be Running out of Stock";
            }
        } else {
            ErrMsg = "Order Quantity must be greater than Zero !!";
        }

        FacesContext mes = FacesContext.getCurrentInstance(); 
        mes.addMessage(null, new FacesMessage(ErrMsg)); 
        return "createOrder.xhtml";

    }
    
// Get all orders
    public List<Orders> getAllOrders() {
        //invoke method into OrderEJB
        orderList = orderEJB.findAllOrders(); 
        //return order list
        return orderList; 
    }

    //Get order count
    public int orderCount() {
        // return how many records is there
        return orderList.size();
    }

    //Get orders by order id
    public String getOrdersByID() {
        String ErrMsg = "";
        String resultMsg = "";
        if (order.getId() != null) {
            resultOrder = orderEJB.findOrderById(order.getId()); 
            if (resultOrder == null) {
                resultMsg = "Total order : 0";
            } else {
                resultMsg = "Total order : 1";
            }
            FacesContext mes = FacesContext.getCurrentInstance(); 
            mes.addMessage(null, new FacesMessage(resultMsg)); 
            return "searchOrderList.xhtml"; 

        } else {
            ErrMsg = "Please Enter order id";
        }
        FacesContext mes = FacesContext.getCurrentInstance(); 
        mes.addMessage(null, new FacesMessage(ErrMsg));
        return "searchOrder.xhtml";
    }

    //This method delete order
    public void deleteOrder(Orders order) {
        int numberOfCars = 0; 
        NewCar newcar = new NewCar();  
        resultCar = carEJB.findCarByModel(order.getCar());
        for (NewCar car : resultCar) {
            numberOfCars = car.getNumberOfCars(); 
            newcar = car;
        }
        newcar.setNumberOfCars(numberOfCars + order.getQty()); 
        // update car qty after delete car order
        carEJB.updateNewCar(newcar);
        //Delete car order
        orderEJB.deleteOrder(order); 
    }

    //Get customer order details
    public String getCustomerOrderDetails(Customer customer) {
        resultCustomer = customer;
        orderList = orderEJB.findOrdersByCustomerName(customer.getCustomerName());
        return "customerOrderList.xhtml";
    }
}
