// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.genmymodel.petshop.web;

import com.genmymodel.petshop.domain.Address;
import com.genmymodel.petshop.domain.Cart;
import com.genmymodel.petshop.domain.Customer;
import com.genmymodel.petshop.domain.Food;
import com.genmymodel.petshop.domain.Item;
import com.genmymodel.petshop.domain.MyClass;
import com.genmymodel.petshop.domain.Order_;
import com.genmymodel.petshop.domain.Product;
import com.genmymodel.petshop.domain.Toy;
import com.genmymodel.petshop.web.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<Address, String> ApplicationConversionServiceFactoryBean.getAddressToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.genmymodel.petshop.domain.Address, java.lang.String>() {
            public String convert(Address address) {
                return new StringBuilder().append(address.getLine1()).append(' ').append(address.getLine2()).append(' ').append(address.getCity()).append(' ').append(address.getCountry()).toString();
            }
        };
    }
    
    public Converter<Long, Address> ApplicationConversionServiceFactoryBean.getIdToAddressConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.genmymodel.petshop.domain.Address>() {
            public com.genmymodel.petshop.domain.Address convert(java.lang.Long id) {
                return Address.findAddress(id);
            }
        };
    }
    
    public Converter<String, Address> ApplicationConversionServiceFactoryBean.getStringToAddressConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.genmymodel.petshop.domain.Address>() {
            public com.genmymodel.petshop.domain.Address convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Address.class);
            }
        };
    }
    
    public Converter<Cart, String> ApplicationConversionServiceFactoryBean.getCartToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.genmymodel.petshop.domain.Cart, java.lang.String>() {
            public String convert(Cart cart) {
                return new StringBuilder().append(cart.getCreationDate()).toString();
            }
        };
    }
    
    public Converter<Long, Cart> ApplicationConversionServiceFactoryBean.getIdToCartConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.genmymodel.petshop.domain.Cart>() {
            public com.genmymodel.petshop.domain.Cart convert(java.lang.Long id) {
                return Cart.findCart(id);
            }
        };
    }
    
    public Converter<String, Cart> ApplicationConversionServiceFactoryBean.getStringToCartConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.genmymodel.petshop.domain.Cart>() {
            public com.genmymodel.petshop.domain.Cart convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Cart.class);
            }
        };
    }
    
    public Converter<Customer, String> ApplicationConversionServiceFactoryBean.getCustomerToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.genmymodel.petshop.domain.Customer, java.lang.String>() {
            public String convert(Customer customer) {
                return new StringBuilder().append(customer.getFirstName()).append(' ').append(customer.getLastName()).toString();
            }
        };
    }
    
    public Converter<Long, Customer> ApplicationConversionServiceFactoryBean.getIdToCustomerConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.genmymodel.petshop.domain.Customer>() {
            public com.genmymodel.petshop.domain.Customer convert(java.lang.Long id) {
                return Customer.findCustomer(id);
            }
        };
    }
    
    public Converter<String, Customer> ApplicationConversionServiceFactoryBean.getStringToCustomerConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.genmymodel.petshop.domain.Customer>() {
            public com.genmymodel.petshop.domain.Customer convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Customer.class);
            }
        };
    }
    
    public Converter<Food, String> ApplicationConversionServiceFactoryBean.getFoodToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.genmymodel.petshop.domain.Food, java.lang.String>() {
            public String convert(Food food) {
                return new StringBuilder().append(food.getName_()).append(' ').append(food.getDescription()).toString();
            }
        };
    }
    
    public Converter<Long, Food> ApplicationConversionServiceFactoryBean.getIdToFoodConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.genmymodel.petshop.domain.Food>() {
            public com.genmymodel.petshop.domain.Food convert(java.lang.Long id) {
                return Food.findFood(id);
            }
        };
    }
    
    public Converter<String, Food> ApplicationConversionServiceFactoryBean.getStringToFoodConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.genmymodel.petshop.domain.Food>() {
            public com.genmymodel.petshop.domain.Food convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Food.class);
            }
        };
    }
    
    public Converter<Item, String> ApplicationConversionServiceFactoryBean.getItemToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.genmymodel.petshop.domain.Item, java.lang.String>() {
            public String convert(Item item) {
                return new StringBuilder().append(item.getPrice()).append(' ').append(item.getQuantity()).toString();
            }
        };
    }
    
    public Converter<Long, Item> ApplicationConversionServiceFactoryBean.getIdToItemConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.genmymodel.petshop.domain.Item>() {
            public com.genmymodel.petshop.domain.Item convert(java.lang.Long id) {
                return Item.findItem(id);
            }
        };
    }
    
    public Converter<String, Item> ApplicationConversionServiceFactoryBean.getStringToItemConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.genmymodel.petshop.domain.Item>() {
            public com.genmymodel.petshop.domain.Item convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Item.class);
            }
        };
    }
    
    public Converter<MyClass, String> ApplicationConversionServiceFactoryBean.getMyClassToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.genmymodel.petshop.domain.MyClass, java.lang.String>() {
            public String convert(MyClass myClass) {
                return new StringBuilder().append(myClass.getAttribute_()).toString();
            }
        };
    }
    
    public Converter<Long, MyClass> ApplicationConversionServiceFactoryBean.getIdToMyClassConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.genmymodel.petshop.domain.MyClass>() {
            public com.genmymodel.petshop.domain.MyClass convert(java.lang.Long id) {
                return MyClass.findMyClass(id);
            }
        };
    }
    
    public Converter<String, MyClass> ApplicationConversionServiceFactoryBean.getStringToMyClassConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.genmymodel.petshop.domain.MyClass>() {
            public com.genmymodel.petshop.domain.MyClass convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), MyClass.class);
            }
        };
    }
    
    public Converter<Order_, String> ApplicationConversionServiceFactoryBean.getOrder_ToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.genmymodel.petshop.domain.Order_, java.lang.String>() {
            public String convert(Order_ order_) {
                return new StringBuilder().append(order_.getReference()).append(' ').append(order_.getDate_()).toString();
            }
        };
    }
    
    public Converter<Long, Order_> ApplicationConversionServiceFactoryBean.getIdToOrder_Converter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.genmymodel.petshop.domain.Order_>() {
            public com.genmymodel.petshop.domain.Order_ convert(java.lang.Long id) {
                return Order_.findOrder_(id);
            }
        };
    }
    
    public Converter<String, Order_> ApplicationConversionServiceFactoryBean.getStringToOrder_Converter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.genmymodel.petshop.domain.Order_>() {
            public com.genmymodel.petshop.domain.Order_ convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Order_.class);
            }
        };
    }
    
    public Converter<Product, String> ApplicationConversionServiceFactoryBean.getProductToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.genmymodel.petshop.domain.Product, java.lang.String>() {
            public String convert(Product product) {
                return new StringBuilder().append(product.getName_()).append(' ').append(product.getDescription()).toString();
            }
        };
    }
    
    public Converter<Long, Product> ApplicationConversionServiceFactoryBean.getIdToProductConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.genmymodel.petshop.domain.Product>() {
            public com.genmymodel.petshop.domain.Product convert(java.lang.Long id) {
                return Product.findProduct(id);
            }
        };
    }
    
    public Converter<String, Product> ApplicationConversionServiceFactoryBean.getStringToProductConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.genmymodel.petshop.domain.Product>() {
            public com.genmymodel.petshop.domain.Product convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Product.class);
            }
        };
    }
    
    public Converter<Toy, String> ApplicationConversionServiceFactoryBean.getToyToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.genmymodel.petshop.domain.Toy, java.lang.String>() {
            public String convert(Toy toy) {
                return new StringBuilder().append(toy.getName_()).append(' ').append(toy.getDescription()).toString();
            }
        };
    }
    
    public Converter<Long, Toy> ApplicationConversionServiceFactoryBean.getIdToToyConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.genmymodel.petshop.domain.Toy>() {
            public com.genmymodel.petshop.domain.Toy convert(java.lang.Long id) {
                return Toy.findToy(id);
            }
        };
    }
    
    public Converter<String, Toy> ApplicationConversionServiceFactoryBean.getStringToToyConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.genmymodel.petshop.domain.Toy>() {
            public com.genmymodel.petshop.domain.Toy convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Toy.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getAddressToStringConverter());
        registry.addConverter(getIdToAddressConverter());
        registry.addConverter(getStringToAddressConverter());
        registry.addConverter(getCartToStringConverter());
        registry.addConverter(getIdToCartConverter());
        registry.addConverter(getStringToCartConverter());
        registry.addConverter(getCustomerToStringConverter());
        registry.addConverter(getIdToCustomerConverter());
        registry.addConverter(getStringToCustomerConverter());
        registry.addConverter(getFoodToStringConverter());
        registry.addConverter(getIdToFoodConverter());
        registry.addConverter(getStringToFoodConverter());
        registry.addConverter(getItemToStringConverter());
        registry.addConverter(getIdToItemConverter());
        registry.addConverter(getStringToItemConverter());
        registry.addConverter(getMyClassToStringConverter());
        registry.addConverter(getIdToMyClassConverter());
        registry.addConverter(getStringToMyClassConverter());
        registry.addConverter(getOrder_ToStringConverter());
        registry.addConverter(getIdToOrder_Converter());
        registry.addConverter(getStringToOrder_Converter());
        registry.addConverter(getProductToStringConverter());
        registry.addConverter(getIdToProductConverter());
        registry.addConverter(getStringToProductConverter());
        registry.addConverter(getToyToStringConverter());
        registry.addConverter(getIdToToyConverter());
        registry.addConverter(getStringToToyConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
