package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass108;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass108Validator;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass108Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass108.class)
public class MyClass108DetailController
{

	
	@Autowired
	private MyClass108Service myClass108Service;
    

	@RequestMapping(value = "/myclass108/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass108/edit";	
	}

	@RequestMapping(value = "/myclass108/detail/{myClass108Id}")
	public String details (@PathVariable(value = "myClass108Id") Long myClass108Id, Model model) 
	{
		MyClass108 myClass108 = this.myClass108Service.findById(myClass108Id);
		model.addAttribute(myClass108);
		return "myclass108/detail";	
	}

	@RequestMapping(value = "/myclass108/edit/{myClass108Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass108Id") Long myClass108Id, Model model) 
	{
		MyClass108 myClass108 = this.myClass108Service.findById(myClass108Id);
		model.addAttribute(myClass108);
		return "myclass108/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass108Validator());	
	}

	@RequestMapping(value = "/myclass108/edit", method = RequestMethod.GET)
	public MyClass108 newMyClass108 (Model model) 
	{
		if(model != null && model.asMap().get("myclass108") == null)
		{
			return new MyClass108();	
		}
		return (MyClass108) model.asMap().get("myclass108");	
	}

	@RequestMapping(value = {"/myclass108/edit", "/myclass108/edit/{myclass108Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass108 MyClass108, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass108/edit";
		}
		
		
		
		this.myClass108Service.save(MyClass108);
		session.setComplete();
		return "redirect:/myclass108/list";	
	}


}
