package com.genmymodel.petshop.domain;

import com.genmymodel.petshop.reference.OrderStatus;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "ORDER__SEQ")
public class Order_ {

    private String reference;

    private String date_;

    @Enumerated
    private OrderStatus status;

    @OneToOne
    private Cart cart;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<Item>();

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Address deliveryAddress;

    @ManyToOne
    private Address paymentAddress;
}
