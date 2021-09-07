// Package Declaration
package ejb;
// Import Statement
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
// EJB Class of Car
public class CarEJB{
    // Persistence unit name 
    @PersistenceContext(unitName = "eBusinessPU")
     //create entity manager variable 
    private EntityManager em;
    
    //This method used to get all used and new cars 
    public List<Car> dofindAllCars() {
        Query sql = em.createNamedQuery("Car.findAllCar",Car.class);   
        //return all cars used and new
        return sql.getResultList();   
    }
    
    
    //find all used cars 
    public List<UsedCar> findAllUsedCars() {
        TypedQuery<UsedCar> allUsedCars = em.createNamedQuery("UsedCar.findAllUsedCars", UsedCar.class);  //create named query    
        return allUsedCars.getResultList();
    }
    
    
    //This method used to find all new cars  
     public List<NewCar> findALLNewCars() {
        //create named query 
        TypedQuery<NewCar> allNewCars = em.createNamedQuery("NewCar.findAllNewCar", NewCar.class); 
        //return all new cars list
        return allNewCars.getResultList(); 
    }
    
   
    //This method find the newcar by reference number
    public NewCar findNewCarById(String rID) {
      try{
       //create named query
       Query sql=em.createNamedQuery("NewCar.findNewCarById",NewCar.class); 
       //set refference ID parameter
       sql.setParameter("id",rID); 
       //get the single result from list
       return (NewCar)sql.getSingleResult(); 
      }catch(NoResultException ex){
        return null;
      }
    }
    // This method used to find car by using car name
      public NewCar findNewCarByName(String carmodel) {
        try{
        //create named query 
       Query sql=em.createNamedQuery("NewCar.findNewCarByName",NewCar.class);
       //set reference number
       sql.setParameter("carmodel",carmodel); 
       //get the result 
       return (NewCar) sql.getSingleResult();     
      }catch(NoResultException ex){
        System.out.println("ex");
        return null;
      }
       
    }
  
    
    //This method used to find car by using Reference Number
    public UsedCar findUsedCarById(String rID) {
        
      try{  
       Query sql=em.createNamedQuery("UsedCar.findUsedCarById",UsedCar.class);
       //set reference number
       sql.setParameter("id",rID); 
       //return single result
       return (UsedCar)sql.getSingleResult();    
      }catch(NoResultException ex){
       return null; 
      }
    }
    // This method returen list od car by its car model
    public List<NewCar> findCarByModel(String model){    
       Query sql=em.createNamedQuery("Car.findCarByModel",Car.class);
       sql.setParameter("carmodel",model);      
       return sql.getResultList();
       
    }
    
     // This method add used car object values to table and return added used car
     public UsedCar addUsedCar(UsedCar usedcar) {
        em.persist(usedcar);
        return usedcar;     
    }
     
    //This method add new car object values to table and return added new car
     public NewCar addNewCar(NewCar newcar) {
        em.persist(newcar); 
        return newcar;     
    }
    // This method Delete car
    public void deleteCar(Car car) {
        em.remove(em.merge(car));
    }
    // This method Delete used car
    public void deleteUsedCar(UsedCar usedcar) {
        em.remove(em.merge(usedcar));
    }
    // This method delete new car
     public void deleteNewCar(NewCar newcar) {
        em.remove(em.merge(newcar));
    }
     
    // This method update car 
    public Car updateCar(Car car) {
        return em.merge(car);
    } 
   // This method update used car
    public UsedCar updateUsedCar(UsedCar usedcar) {
        return em.merge(usedcar);
    } 
    
    //This method update new car
     public NewCar updateNewCar(NewCar newcar) {
        return em.merge(newcar);
    }
    // This method create car
    public Car createCar(Car car) {
        em.persist(car);
        return car;
    }
}
