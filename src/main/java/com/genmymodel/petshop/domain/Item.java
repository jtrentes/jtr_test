package com.genmymodel.petshop.domain;

import javax.persistence.ManyToOne;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "ITEM_SEQ")
public class Item {

    private double price;

    private String quantity;

    @ManyToOne
    private Product product;
}
