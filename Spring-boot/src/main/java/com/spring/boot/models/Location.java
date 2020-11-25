package com.spring.boot.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "locations")
@Access(AccessType.FIELD)
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    private double latitude;
    private double longitude;
    //private DateTi location_date;

    @ManyToMany(mappedBy = "locations")
    @JsonIgnore
    private List<User> users;

}
