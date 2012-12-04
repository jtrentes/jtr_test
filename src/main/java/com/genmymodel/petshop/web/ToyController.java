package com.genmymodel.petshop.web;

import com.genmymodel.petshop.domain.Toy;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/toys")
@Controller
@RooWebScaffold(path = "toys", formBackingObject = Toy.class)
public class ToyController {
}
