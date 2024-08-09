package vn.vpm.deluxe.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String roomNumber;
    private String type;
    private String description;
    private double pricePerNight;
    private String availabilityStatus;
    private String image;
    private int maxPerson;
    private int size;
    private String view;
    private int bed;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomImage> imagesDetail;

    public Room() {
    }

    public Room(long id, String roomNumber, String type, String description, double pricePerNight, String availabilityStatus, String image) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.availabilityStatus = availabilityStatus;
        this.image = image;
    }

    public Room(long id, String roomNumber, String type, String description, Double pricePerNight, String availabilityStatus) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.availabilityStatus = availabilityStatus;
    }

    // Getters and Setters


    public List<RoomImage> getImagesDetail() {
        return imagesDetail;
    }

    public void setImagesDetail(List<RoomImage> imagesDetail) {
        this.imagesDetail = imagesDetail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }
}
