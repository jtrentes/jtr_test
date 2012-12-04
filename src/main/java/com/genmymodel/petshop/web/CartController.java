package com.genmymodel.petshop.web;

import com.genmymodel.petshop.domain.Cart;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/carts")
@Controller
@RooWebScaffold(path = "carts", formBackingObject = Cart.class)
public class CartController {
}
