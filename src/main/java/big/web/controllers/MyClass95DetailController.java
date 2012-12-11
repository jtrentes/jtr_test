package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass95Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass95;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass95Validator;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass95.class)
public class MyClass95DetailController
{

	
	@Autowired
	private MyClass95Service myClass95Service;
    

	@RequestMapping(value = "/myclass95/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass95/edit";	
	}

	@RequestMapping(value = "/myclass95/detail/{myClass95Id}")
	public String details (@PathVariable(value = "myClass95Id") Long myClass95Id, Model model) 
	{
		MyClass95 myClass95 = this.myClass95Service.findById(myClass95Id);
		model.addAttribute(myClass95);
		return "myclass95/detail";	
	}

	@RequestMapping(value = "/myclass95/edit/{myClass95Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass95Id") Long myClass95Id, Model model) 
	{
		MyClass95 myClass95 = this.myClass95Service.findById(myClass95Id);
		model.addAttribute(myClass95);
		return "myclass95/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass95Validator());	
	}

	@RequestMapping(value = "/myclass95/edit", method = RequestMethod.GET)
	public MyClass95 newMyClass95 (Model model) 
	{
		if(model != null && model.asMap().get("myclass95") == null)
		{
			return new MyClass95();	
		}
		return (MyClass95) model.asMap().get("myclass95");	
	}

	@RequestMapping(value = {"/myclass95/edit", "/myclass95/edit/{myclass95Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass95 MyClass95, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass95/edit";
		}
		
		
		
		this.myClass95Service.save(MyClass95);
		session.setComplete();
		return "redirect:/myclass95/list";	
	}


}
