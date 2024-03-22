package com.example.trade.model;

import jakarta.persistence.*;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Long price;

    //todo replace with enum
    @Column
    private String quality;

    @ManyToMany(mappedBy = "sendersItems")
    private Set<Offer> sendInOffers = new HashSet<>();


    @ManyToMany(mappedBy = "receiversItems")
    private Set<Offer> receivedInOffers = new HashSet<>();

    //todo maybe...
/*
    @Column
    private Long quantity = 0L;
*/


    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private AuthorizedUser user;


    public Item(String name, String description, Long price, String quality, AuthorizedUser user) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quality = quality;
        this.user = user;
    }

    public Item() {
    }


}
