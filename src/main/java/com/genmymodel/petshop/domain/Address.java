package com.genmymodel.petshop.domain;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "ADDRESS_SEQ")
public class Address {

    private String line1;

    private String line2;

    private String city;

    private String country;
}
