package by.IvkoS.database.models.employers;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.HashSet;

import java.util.Set;

/**
 * Класс реализующий харнение данных для клиентов (xls файл)
 */
@Entity
@Table(name = "employer")
public class Employer  implements java.io.Serializable{
    public static final Employer EMPTY_EMPLOYER = new Employer();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemployer", unique = true, nullable = false)
    private int idEmployer;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "prone_number")
    private int numberPhone;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, targetEntity = Position.class)
    @JoinTable(name = "employer_position", joinColumns = {
            @JoinColumn(name = "idemployer", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "idposition", insertable = false, nullable = false, updatable = false)})
    @XmlTransient
    private Set<Position> positions = new HashSet<Position>();

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public Employer() {
    }

    public Employer(int idEmployer, String lastName, String firstName, int numberPhone) {
        this(lastName, firstName, numberPhone);
        this.idEmployer = idEmployer;

    }

    public void addPosition(Position position) {
        this.positions.add(position);
    }

    public Employer(String lastName, String firstName, int numberPhone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.numberPhone = numberPhone;
    }

    public int getIdEmployer() {
        return idEmployer;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setIdEmployer(int idEmployer) {
        this.idEmployer = idEmployer;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String showPositions() {
        String delim = "";
        StringBuilder sb = new StringBuilder();
        for (Position position : positions) {
            sb.append(delim).append(position.getPositionName());
            delim = ",";
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.lastName + " " + this.firstName + " " + this.numberPhone;
    }

    public Employer(String lastName, String firstName, int numberPhone, Set<Position> positions) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.numberPhone = numberPhone;
        this.positions = positions;
    }


}