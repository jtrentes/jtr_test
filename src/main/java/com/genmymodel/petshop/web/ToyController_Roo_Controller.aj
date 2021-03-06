// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.genmymodel.petshop.web;

import com.genmymodel.petshop.domain.Toy;
import com.genmymodel.petshop.web.ToyController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect ToyController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String ToyController.create(@Valid Toy toy, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, toy);
            return "toys/create";
        }
        uiModel.asMap().clear();
        toy.persist();
        return "redirect:/toys/" + encodeUrlPathSegment(toy.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String ToyController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Toy());
        return "toys/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String ToyController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("toy", Toy.findToy(id));
        uiModel.addAttribute("itemId", id);
        return "toys/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String ToyController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("toys", Toy.findToyEntries(firstResult, sizeNo));
            float nrOfPages = (float) Toy.countToys() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("toys", Toy.findAllToys());
        }
        return "toys/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String ToyController.update(@Valid Toy toy, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, toy);
            return "toys/update";
        }
        uiModel.asMap().clear();
        toy.merge();
        return "redirect:/toys/" + encodeUrlPathSegment(toy.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ToyController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Toy.findToy(id));
        return "toys/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ToyController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Toy toy = Toy.findToy(id);
        toy.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/toys";
    }
    
    void ToyController.populateEditForm(Model uiModel, Toy toy) {
        uiModel.addAttribute("toy", toy);
    }
    
    String ToyController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
