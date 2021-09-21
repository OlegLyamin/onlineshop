package com.oleglmn.onlineshop.domain.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_sequence_generator")
    @SequenceGenerator(name = "cart_sequence_generator")
    private Long id;

    @ManyToMany(
        cascade = {
            CascadeType.ALL},
        targetEntity = Product.class)
    private List<Product> products = new ArrayList<>();

}
