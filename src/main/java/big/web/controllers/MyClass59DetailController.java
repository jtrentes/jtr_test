package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import big.services.MyClass59Service;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass59;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass59Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass59.class)
public class MyClass59DetailController
{

	
	@Autowired
	private MyClass59Service myClass59Service;
    

	@RequestMapping(value = "/myclass59/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass59/edit";	
	}

	@RequestMapping(value = "/myclass59/detail/{myClass59Id}")
	public String details (@PathVariable(value = "myClass59Id") Long myClass59Id, Model model) 
	{
		MyClass59 myClass59 = this.myClass59Service.findById(myClass59Id);
		model.addAttribute(myClass59);
		return "myclass59/detail";	
	}

	@RequestMapping(value = "/myclass59/edit/{myClass59Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass59Id") Long myClass59Id, Model model) 
	{
		MyClass59 myClass59 = this.myClass59Service.findById(myClass59Id);
		model.addAttribute(myClass59);
		return "myclass59/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass59Validator());	
	}

	@RequestMapping(value = "/myclass59/edit", method = RequestMethod.GET)
	public MyClass59 newMyClass59 (Model model) 
	{
		if(model != null && model.asMap().get("myclass59") == null)
		{
			return new MyClass59();	
		}
		return (MyClass59) model.asMap().get("myclass59");	
	}

	@RequestMapping(value = {"/myclass59/edit", "/myclass59/edit/{myclass59Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass59 MyClass59, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass59/edit";
		}
		
		
		
		this.myClass59Service.save(MyClass59);
		session.setComplete();
		return "redirect:/myclass59/list";	
	}


}
