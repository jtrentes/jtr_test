package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass113Validator;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass113Service;
import org.springframework.validation.BindingResult;
import big.domain.MyClass113;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass113.class)
public class MyClass113DetailController
{

	
	@Autowired
	private MyClass113Service myClass113Service;
    

	@RequestMapping(value = "/myclass113/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass113/edit";	
	}

	@RequestMapping(value = "/myclass113/detail/{myClass113Id}")
	public String details (@PathVariable(value = "myClass113Id") Long myClass113Id, Model model) 
	{
		MyClass113 myClass113 = this.myClass113Service.findById(myClass113Id);
		model.addAttribute(myClass113);
		return "myclass113/detail";	
	}

	@RequestMapping(value = "/myclass113/edit/{myClass113Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass113Id") Long myClass113Id, Model model) 
	{
		MyClass113 myClass113 = this.myClass113Service.findById(myClass113Id);
		model.addAttribute(myClass113);
		return "myclass113/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass113Validator());	
	}

	@RequestMapping(value = "/myclass113/edit", method = RequestMethod.GET)
	public MyClass113 newMyClass113 (Model model) 
	{
		if(model != null && model.asMap().get("myclass113") == null)
		{
			return new MyClass113();	
		}
		return (MyClass113) model.asMap().get("myclass113");	
	}

	@RequestMapping(value = {"/myclass113/edit", "/myclass113/edit/{myclass113Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass113 MyClass113, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass113/edit";
		}
		
		
		
		this.myClass113Service.save(MyClass113);
		session.setComplete();
		return "redirect:/myclass113/list";	
	}


}
