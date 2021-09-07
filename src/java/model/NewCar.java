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
@NamedQuery(name = "NewCar.findAllNewCar", query = "SELECT n FROM NewCar n"),
@NamedQuery(name="NewCar.findNewCarById",query="SELECT n FROM NewCar n WHERE n.id = :id"), 
@NamedQuery(name="NewCar.findNewCarByName",query="SELECT n FROM NewCar n WHERE n.carmodel = :carmodel"), 
}) 
// class NewCar that implement serailizable interface and extend base class car
public class NewCar extends Car implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //list of child attribute of car class
    @Column(name = "WARRANTY")
    private Integer warranty;
    @Column(name = "EXTENDING_WARRANTY")
    private Integer extendingWarranty;
    @Column(name = "ROAD_ASSISTANCE_PACKAGE")
    private String roadAssistancePackege;
    @Column(name = "NUMBER_OF_CARS")
    private Integer numberOfCars;

    
    
     //Getter and Setter method of NewCar    
    
    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    public Integer getExtendingWarranty() {
        return extendingWarranty;
    }

    public void setExtendingWarranty(Integer extendingWarranty) {
        this.extendingWarranty = extendingWarranty;
    }

    public String getRoadAssistancePackege() {
        return roadAssistancePackege;
    }

    public void setRoadAssistancePackege(String roadAssistancePackege) {
        this.roadAssistancePackege = roadAssistancePackege;
    }

    public Integer getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(Integer numberOfCars) {
        this.numberOfCars = numberOfCars;
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
        if (!(object instanceof NewCar)) {
            return false;
        }
        NewCar other = (NewCar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persist.NewCars[ id=" + id + " ]";
    }
    
}
