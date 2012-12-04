package com.genmymodel.petshop.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "CUSTOMER_SEQ")
public class Customer {

    private String firstName;

    private String lastName;

    @OneToOne
    private Address address;

    @OneToOne
    private Cart carts;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Order_> orders = new HashSet<Order_>();
}
