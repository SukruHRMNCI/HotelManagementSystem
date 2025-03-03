package com.tpe.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_room")
public class Room {

    @Id
    private Long id;//PK

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Integer capacity;


    @ManyToOne//room ile hotel arasında ilişki kurulmasını sağlar:room tablosuna FK(hotel_id) ekler
    @JoinColumn(name = "hotel_id",nullable = false)//opsiyonel
    private Hotel hotel;


    @OneToMany(mappedBy = "room",orphanRemoval = true)
    private List<Reservation> reservations=new ArrayList<>();

    public Room() {
    }

    public Room(Long id, String number, Integer capacity, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.hotel = hotel;
    }

    //getter-setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    //toString

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
