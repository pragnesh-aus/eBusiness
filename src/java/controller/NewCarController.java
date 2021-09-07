// Package declaration
package Controller;
// Import statement
import ejb.*;
import model.*;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author 12093185 & 12095728
 */

@Named(value = "newcontroller")
@SessionScoped
public class NewCarController implements Serializable {
    
     @EJB
     //create carEJB variable for Managed beans
    private CarEJB carEJB;  
     //create object of new car
    private NewCar newCar = new NewCar(); 
    //create object of car
    private Car car = new Car(); 
    //List to store car list
    private List<NewCar> newCarList = new ArrayList<>();    
    //counter for new car
    private int newCarCount = 0; 
    private NewCar finalResultNewCar = new NewCar();  
    private Car resultCarList = new Car(); 

    //Default constructor
    public NewCarController() {

    }

    //getters and setters methods of newcar controller
    public Car getResultCarList() {
        return resultCarList;
    }

    public void setResultCarList(Car resultCarList) {
        this.resultCarList = resultCarList;
    }

    public CarEJB getCarEJB() {
        return carEJB;
    }

    public void setCarEJB(CarEJB carEJB) {
        this.carEJB = carEJB;
    }

    public NewCar getResultNewCar() {
        return finalResultNewCar;
    }

    public void setResultNewCar(NewCar resultNewCar) {
        this.finalResultNewCar = resultNewCar;
    }

    public int getNewCarCount() {
        return newCarCount;
    }

    public void setNewCarCount(int newCarCount) {
        this.newCarCount = newCarCount;
    }
   
    public List<NewCar> getNewCarList() {
        return newCarList;
    }

    public void setNewCarList(List<NewCar> newCarList) {
        this.newCarList = newCarList;
    }
   
    public NewCar getNewCar() {
        return newCar;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setNewCar(NewCar newCar) {
        this.newCar = newCar;
    }
    
    //add new car
    public String InsertNewCar() {
    //Error message variable
        String ValidationMsg = "";  
        //check if any field is empty or not
        if (!newCar.getId().equals("")) { if (!newCar.getCarMake().equals("")) {if (!newCar.getCarmodel().equals("")) {if (!newCar.getDriveType().equals("")) {if (!newCar.getBodyColour().equals("")) {if (!newCar.getTransmission().equals("")) {if (!newCar.getCarEngine().equals("")) {if (!newCar.getFualType().equals("")) {if (newCar.getNumberOfDoors() != 0) {if (newCar.getNumberofSeats() != 0) {if (newCar.getCarPrice() != 0) {if (newCar.getWarranty() != 0) {if (newCar.getExtendingWarranty() != 0) {if (!newCar.getRoadAssistancePackege().equals("")) {if (newCar.getNumberOfCars() != 0) {
                                                                    //passing new car object to carEJB model
                                                                    carEJB.addNewCar(newCar);  
                                                                    //Assign newcar object to final result varibale
                                                                    finalResultNewCar = newCar;          
                                                                    newCar = new NewCar();                
                                                                    ValidationMsg = "";         
                                                                      //redirect to xhtml page
                                                                    return "createNewCarResult.xhtml"; 
        } 
        else {ValidationMsg = "Number of cars cannot be empty! ";}  } else {ValidationMsg = "Assistance package cannot be empty! ";}} else {ValidationMsg = "Extending warranty cannot be empty! ";}} else {ValidationMsg = "Warranty cannot be empty cannot be empty! ! ";}} else {ValidationMsg = "Car price cannot be empty! ";}} else {ValidationMsg = "Number of seats cannot be empty! ";}} else {ValidationMsg = "Number of Doors cannot be empty! ";}} else {ValidationMsg = "Car fual type cannot be empty! ";}} else {ValidationMsg = "Car engine cannot be empty! ";}} else {ValidationMsg = "Transmission cannot be empty! ";}} else {ValidationMsg ="Body color cannot be empty! ";}} else {ValidationMsg = "Drive type cannot be empty! ";}} else {ValidationMsg = "Car model cannot be empty! ";}} else {ValidationMsg = "Car make cannot be empty! ";}} else {ValidationMsg = "Reference Number cannot be empty! ";}
        //Get facecontext currunt instance and store into 
        FacesContext con = FacesContext.getCurrentInstance(); 
        con.addMessage(null, new FacesMessage(ValidationMsg)); 
        return "createNewCar.xhtml"; 
    }

    //Get a list of new cars
    public List<NewCar> getAllNewCars() {
        newCarList = carEJB.findALLNewCars();
        return newCarList;
    }

    //Counting for new cars
    public int NewCarCount() {
        return newCarCount = newCarList.size();
    }

    //Get price and new car list
    public List<String> getNewCarModelAndPriceList() {
        //create list to store result 
        List<String> resultallNewCars = new ArrayList(); 
        //Get all new cars from CarEJB  
        List<Car> allNewCars = carEJB.dofindAllCars();
        for (Car car : allNewCars) {
            resultallNewCars.add(car.getCarmodel() + "-$" + car.getCarPrice()); 
        }
        return resultallNewCars;
    }

    //This method find car by reference number
    public String getNewCarByID(String referenceID) {
        String resultMessage = "";
        String ErrMessage = "";
        if (!referenceID.equals("")) {
            // Invoke method of carEJB
            finalResultNewCar = carEJB.findNewCarById(referenceID);        
            if (finalResultNewCar == null) {
                resultMessage = "Total brand new cars : 0"; 
            } else {
                resultMessage = "Total brand new cars : 1"; 
            }

            FacesContext mes = FacesContext.getCurrentInstance(); 
            mes.addMessage(null, new FacesMessage(resultMessage)); 
            return "searchNewCarList.xhtml"; 
        } else {
            ErrMessage = "Please Enter reference number";
        }
        FacesContext con = FacesContext.getCurrentInstance();
        con.addMessage(null, new FacesMessage(ErrMessage)); 
        return "searchNewCar.xhtml"; 
    }

     //This method find new car by reference number
    public String getNewCarByName(String name) {
        String resultMessage = "";        
        // Invoke method of carEJB
            finalResultNewCar = carEJB.findNewCarByName(name); 
            if (finalResultNewCar == null) {
                resultMessage = "Total brand new cars : 0"; 
            } else {
                resultMessage = "Total brand new cars : 1"; 
            }
            FacesContext mes = FacesContext.getCurrentInstance(); 
            mes.addMessage(null, new FacesMessage(resultMessage)); 
            return "searchNewCarList.xhtml";
    }    
}
