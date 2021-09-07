// Package Delcaration
package model;
// Import Statement
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author 12093185 & 12095728
 */
@Entity
//list of named query
@NamedQueries({
@NamedQuery(name = "UsedCar.findAllUsedCars", query = "SELECT u FROM UsedCar u"),
@NamedQuery(name="UsedCar.findUsedCarById",query="SELECT u FROM UsedCar u WHERE u.id = :id"),
}) 
// class UsedCar that implement serailizable interface and extend base class car
public class UsedCar extends Car implements Serializable {
    private static final long serialVersionUID = 1L;
   
    //list of child arrtibutes 
    @Column(name = "ODOMETER")
    private Long Odometer;
    @Column(name = "REGO_NO")
    private String regoNo;
    @Column(name = "REGO_EXPIRY")
    private Integer regoExpiry;
    @Column(name = "SERVICE_HISTORY")
    private String serviceHistory;
    @Column(name = "VIN")
    private String vehicalIdentificationNumber;
    @Column(name = "CAR_HISTORY")
    private String carHistory;
    @Column(name = "NO_OF_CARS")
    private Integer noOfCars = 1;

    //default constructor
    public UsedCar(){}
    
    //getters and setters method of Used car
    
    public Long getOdometer() {
        return Odometer;
    }

    public void setOdometer(Long Odometer) {
        this.Odometer = Odometer;
    }

    public String getRegoNo() {
        return regoNo;
    }

    public void setRegoNo(String regoNo) {
        this.regoNo = regoNo;
    }

    public Integer getRegoExpiry() {
        return regoExpiry;
    }

    public void setRegoExpiry(Integer regoExpiry) {
        this.regoExpiry = regoExpiry;
    }

    public String getServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(String serviceHistory) {
        this.serviceHistory = serviceHistory;
    }

    public String getVehicalIdentificationNumber() {
        return vehicalIdentificationNumber;
    }

    public void setVehicalIdentificationNumber(String vehicalIdentificationNumber) {
        this.vehicalIdentificationNumber = vehicalIdentificationNumber;
    }

    public String getCarHistory() {
        return carHistory;
    }

    public void setCarHistory(String carHistory) {
        this.carHistory = carHistory;
    }

    public Integer getNoOfCars() {
        return noOfCars;
    }

    public void setNoOfCars(Integer noOfCars) {
        this.noOfCars = noOfCars;
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
        if (!(object instanceof UsedCar)) {
            return false;
        }
        UsedCar other = (UsedCar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persist.UsedCars[ id=" + id + " ]";
    }
    
    
    
}
