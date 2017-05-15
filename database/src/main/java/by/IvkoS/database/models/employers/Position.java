package by.IvkoS.database.models.employers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position{

    public static final Position EMPTY_POSITION = new Position();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idposition", unique = true, nullable = false)
    private int positionID;

    @Column(name = "positionName", unique = true, nullable = false)
    private String positionName;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "positions")
    private transient Set<Employer> employers = new HashSet<>();

    public Position() {
    }

    public Position(int positionID) {
        this.positionID = positionID;
    }

    public Position(String positionName) {
        this.positionName = positionName;
    }

    public Position(int positionID, String positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }

    public void addEmployer(Employer employer) {
        this.employers.add(employer);
    }

    public void setEmployees(Set<Employer> employers) {
        this.employers = employers;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public Set<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(Set<Employer> employers) {
        this.employers = employers;
    }
}
