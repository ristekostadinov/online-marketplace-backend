package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "sale_ads", name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @Column(name = "sale_price")
    private int salePrice;

    @Column(name = "old_price")
    private int oldPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
