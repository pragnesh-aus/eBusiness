//Package delcaration
package Controller;

// Import Statement
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

/**
 *
 * @author 12093185  & 12095728
 */
@Named(value = "usedController")
@SessionScoped
public class UsedCarController implements Serializable {
    // List of variables and object
    @EJB
    private CarEJB carEJB;
 
    private UsedCar usedCar=new UsedCar();
    private Car car=new Car(); 
    private List<UsedCar> usedCarList=new ArrayList<>();
    private int usedCarCount=0; 
    private UsedCar finalResultUsedCar=new UsedCar(); 
    private Car resultCarList=new Car(); 
    
    
    //Default constructor
    public UsedCarController() {
        
    }

    //getters and setters methods of used car
    
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


    public UsedCar getResultUsedCar() {
        return finalResultUsedCar;
    }

    public void setResultUsedCar(UsedCar resultUsedCar) {
        this.finalResultUsedCar = resultUsedCar;
    }

    public int getUsedCarCount() {
        return usedCarCount;
    }

    public void setUsedCarCount(int usedCarCount) {
        this.usedCarCount = usedCarCount;
    }

    
  
    public List<UsedCar> getUsedCarList() {
        return usedCarList;
    }

    public void setUsedCarList(List<UsedCar> usedCarList) {
        this.usedCarList = usedCarList;
    }

    
    
    public UsedCar getUsedCar() {
        return usedCar;
    }

    public void setUsedCar(UsedCar usedCar) {
        this.usedCar = usedCar;
    }
    
    
   

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    
    //Create a used car
    public String InsertUsedCar() {
    
    String ErrorreturnResult=""; 
        //check input field 
      if(!usedCar.getId().equals("")){ if(!usedCar.getCarMake().equals("")){ if(!usedCar.getCarmodel().equals("")){  if(!usedCar.getDriveType().equals("")){ if(!usedCar.getBodyColour().equals("")){  if(!usedCar.getTransmission().equals("")){ if(!usedCar.getCarEngine().equals("")){if(!usedCar.getFualType().equals("")){                               if(usedCar.getNumberOfDoors()!=0){                                  if(usedCar.getNumberofSeats() !=0){                                      if(usedCar.getCarPrice()!=0){                                        if(usedCar.getOdometer()!=0){                                           if(!usedCar.getRegoNo().equals("")){                                              if(usedCar.getRegoExpiry()!=0){                                                 if(!usedCar.getServiceHistory().equals("")){ if(!usedCar.getVehicalIdentificationNumber().equals("")){ if(!usedCar.getCarHistory().equals("")){
                                                        // Execute if data is correct
                                                        carEJB.addUsedCar(usedCar);  
                                                        finalResultUsedCar=usedCar;  
                                                        usedCar=new UsedCar();       
                                                        ErrorreturnResult="";        
                                                        return "createUsedCarResult.xhtml";                                                     
                                                       }else{  ErrorreturnResult="Car History cannot be empty! "; 
                                                       }
                                                    }else{  ErrorreturnResult="Identification number cannot be empty! "; 
                                                    }
                                                }else{ ErrorreturnResult="Service history cannot be empty! ";  
                                               }
                                              }else{ ErrorreturnResult="Rego expiry cannot be empty! ";  
                                              }
                                           }else{  ErrorreturnResult="Rego number cannot be empty! ";  
                                           }
                                        }else{  ErrorreturnResult="Odometer cannot be empty! ";  
                                        }
                                     }else{   ErrorreturnResult="Car price cannot be empty! ";  
                                     }
                                  }else{ ErrorreturnResult="Number of seats cannot be empty! ";  
                                  }
                               }else{ ErrorreturnResult="Number of doors cannot be empty! ";  
                               }
                            }else{  ErrorreturnResult="Car fuel type cannot be empty! ";  
                            }
                         }else{  ErrorreturnResult="Car engine cannot be empty! ";  
                         }
                     }else{  ErrorreturnResult="Transmission cannot be empty! ";  
                     }
                  }else{  ErrorreturnResult="Body color cannot be empty! ";  
                  }
                }else{ ErrorreturnResult="Drive type cannot be empty! ";  
                }
            }else{ ErrorreturnResult="Car model cannot be empty! ";
            }
        }else{ ErrorreturnResult="Car make cannot be empty! ";
        }
     }else{ ErrorreturnResult="Reference ID cannot be empty! ";
     }  
         FacesContext con = FacesContext.getCurrentInstance(); 
         con.addMessage(null, new FacesMessage(ErrorreturnResult)); 
         return "createUsedCar.xhtml";        
    }
    
    //Get list of used cars
    public List<UsedCar> getAllUsedCars(){ 
        usedCarList=carEJB.findAllUsedCars();
        return usedCarList;
    } 
    
    //Get used car count
    public int UsedCarCount(){        
        return usedCarCount=usedCarList.size();
    }   
    
    //this method used to find used car by reference number
    public String getUsedCarByID(String referenceID){
    
    String resultMessage=""; 
    String ErrMessage=""; 
    if(!referenceID.equals("")){
    finalResultUsedCar=carEJB.findUsedCarById(referenceID);
    if(finalResultUsedCar ==null){
    resultMessage="Total Used Car : 0"; 
    }else{
    resultMessage="Total Used Car : 1";
    } 
      FacesContext mes = FacesContext.getCurrentInstance();
      mes.addMessage(null, new FacesMessage(resultMessage));
      return "searchUsedCarList.xhtml";
       }else{
     ErrMessage="Please enter reference number";
     }
        FacesContext con = FacesContext.getCurrentInstance();
        con.addMessage(null, new FacesMessage(ErrMessage)); 
        return "searchUsedCar.xhtml"; 
       
    }     
}
