package com.genmymodel.petshop.domain;

import java.util.Date;
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
@RooJpaActiveRecord(sequenceName = "CART_SEQ")
public class Cart {

    private Date creationDate;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<Item>();

    @OneToOne
    private Customer customer;

    @OneToOne
    private Order_ order_;
}
