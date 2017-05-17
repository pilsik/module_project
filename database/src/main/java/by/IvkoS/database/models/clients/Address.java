package by.IvkoS.database.models.clients;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address  implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaddress")
    private int id;

    @Column
    private int houseNumber;

    @Column
    private String streetAddress;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zipCode;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "addressSet")
    private Set<User> clients = new HashSet<>(0);

    public Address() {
    }

    public Address(int houseNumber, String streetAddress, String city, String state, String zipCode) {
        this.houseNumber = houseNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(int houseNumber, String streetAddress, String city, String state, String zipCode, Set<User> clients) {
        this.houseNumber = houseNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.clients = clients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Set<User> getClients() {
        return clients;
    }

    public void setClients(Set<User> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", houseNumber=" + houseNumber +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", clients=" + clients +
                '}';
    }
}
