// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.genmymodel.petshop.domain;

import com.genmymodel.petshop.domain.Item;
import com.genmymodel.petshop.domain.Product;

privileged aspect Item_Roo_JavaBean {
    
    public double Item.getPrice() {
        return this.price;
    }
    
    public void Item.setPrice(double price) {
        this.price = price;
    }
    
    public String Item.getQuantity() {
        return this.quantity;
    }
    
    public void Item.setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public Product Item.getProduct() {
        return this.product;
    }
    
    public void Item.setProduct(Product product) {
        this.product = product;
    }
    
}
