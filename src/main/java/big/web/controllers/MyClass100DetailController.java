package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import big.domain.MyClass100;
import big.web.controllers.validator.MyClass100Validator;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass100Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass100.class)
public class MyClass100DetailController
{

	
	@Autowired
	private MyClass100Service myClass100Service;
    

	@RequestMapping(value = "/myclass100/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass100/edit";	
	}

	@RequestMapping(value = "/myclass100/detail/{myClass100Id}")
	public String details (@PathVariable(value = "myClass100Id") Long myClass100Id, Model model) 
	{
		MyClass100 myClass100 = this.myClass100Service.findById(myClass100Id);
		model.addAttribute(myClass100);
		return "myclass100/detail";	
	}

	@RequestMapping(value = "/myclass100/edit/{myClass100Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass100Id") Long myClass100Id, Model model) 
	{
		MyClass100 myClass100 = this.myClass100Service.findById(myClass100Id);
		model.addAttribute(myClass100);
		return "myclass100/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass100Validator());	
	}

	@RequestMapping(value = "/myclass100/edit", method = RequestMethod.GET)
	public MyClass100 newMyClass100 (Model model) 
	{
		if(model != null && model.asMap().get("myclass100") == null)
		{
			return new MyClass100();	
		}
		return (MyClass100) model.asMap().get("myclass100");	
	}

	@RequestMapping(value = {"/myclass100/edit", "/myclass100/edit/{myclass100Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass100 MyClass100, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass100/edit";
		}
		
		
		
		this.myClass100Service.save(MyClass100);
		session.setComplete();
		return "redirect:/myclass100/list";	
	}


}
