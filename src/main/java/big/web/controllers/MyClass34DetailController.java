package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass34;
import big.web.controllers.validator.MyClass34Validator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass34Service;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass34.class)
public class MyClass34DetailController
{

	
	@Autowired
	private MyClass34Service myClass34Service;
    

	@RequestMapping(value = "/myclass34/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass34/edit";	
	}

	@RequestMapping(value = "/myclass34/detail/{myClass34Id}")
	public String details (@PathVariable(value = "myClass34Id") Long myClass34Id, Model model) 
	{
		MyClass34 myClass34 = this.myClass34Service.findById(myClass34Id);
		model.addAttribute(myClass34);
		return "myclass34/detail";	
	}

	@RequestMapping(value = "/myclass34/edit/{myClass34Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass34Id") Long myClass34Id, Model model) 
	{
		MyClass34 myClass34 = this.myClass34Service.findById(myClass34Id);
		model.addAttribute(myClass34);
		return "myclass34/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass34Validator());	
	}

	@RequestMapping(value = "/myclass34/edit", method = RequestMethod.GET)
	public MyClass34 newMyClass34 (Model model) 
	{
		if(model != null && model.asMap().get("myclass34") == null)
		{
			return new MyClass34();	
		}
		return (MyClass34) model.asMap().get("myclass34");	
	}

	@RequestMapping(value = {"/myclass34/edit", "/myclass34/edit/{myclass34Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass34 MyClass34, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass34/edit";
		}
		
		
		
		this.myClass34Service.save(MyClass34);
		session.setComplete();
		return "redirect:/myclass34/list";	
	}


}
