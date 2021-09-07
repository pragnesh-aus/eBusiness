//Package Declaration
package model;
// import Statement
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author 12093185 & 12095728
 */
//List of named query
@Entity
@NamedQueries({
    @NamedQuery(name="Car.findAllCar",query="SELECT c FROM Car c"),
    @NamedQuery(name="Car.findCarByName",query="SELECT c FROM Car c WHERE c.carmodel = :carmodel"),
    @NamedQuery(name="Car.findCarByModel",query="SELECT c FROM Car c WHERE c.carmodel = :carmodel and c.id in (SELECT n.id FROM NewCar n)"),
}) 
//Inheritance type joined 
@Inheritance(strategy = InheritanceType.JOINED)
// Class Car that implement serializable interface
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //list of attributes
    @Id
    @Column(name = "REFERENCE_NUMBER") 
    protected String id; 
    @Column(name = "CAR_MAKE")
    protected String carMake;
    @Column(name = "CAR_MODEL")
    protected String carmodel;
    @Column(name = "DRIVE_TYPE")
    protected String driveType;
    @Column(name = "BODY_COLOUR") 
    protected String bodyColour;
    @Column(name = "TRANSMISSION") 
    protected String transmission;
    @Column(name = "CAR_ENGINE") 
    protected String carEngine;
    @Column(name = "FUAL_TYPE") 
    protected String fualType;
    @Column(name = "NUMBER_OF_DOORS") 
    protected Integer numberOfDoors;
    @Column(name = "NUMBER_OF_SEATS") 
    protected Integer numberofSeats;
    @Column(name="PRICE")
    protected Double carPrice;
    
    // default constructor of car
    public Car(){}

    
    //getters and setters methods of car class  
    
    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }
    
    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getBodyColour() {
        return bodyColour;
    }

    public void setBodyColour(String bodyColour) {
        this.bodyColour = bodyColour;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    public String getFualType() {
        return fualType;
    }

    public void setFualType(String fualType) {
        this.fualType = fualType;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Integer getNumberofSeats() {
        return numberofSeats;
    }

    public void setNumberofSeats(Integer numberofSeats) {
        this.numberofSeats = numberofSeats;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    // TODO: Warning - this method won't work in the case the id fields are not set
    public boolean equals(Object object) {
        
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    // toString method
    @Override
    public String toString() {
        return "persist.Cars[ id=" + id + " ]";
    }
    
}
