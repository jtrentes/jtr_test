package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass123;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass123Validator;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass123Service;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass123.class)
public class MyClass123DetailController
{

	
	@Autowired
	private MyClass123Service myClass123Service;
    

	@RequestMapping(value = "/myclass123/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass123/edit";	
	}

	@RequestMapping(value = "/myclass123/detail/{myClass123Id}")
	public String details (@PathVariable(value = "myClass123Id") Long myClass123Id, Model model) 
	{
		MyClass123 myClass123 = this.myClass123Service.findById(myClass123Id);
		model.addAttribute(myClass123);
		return "myclass123/detail";	
	}

	@RequestMapping(value = "/myclass123/edit/{myClass123Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass123Id") Long myClass123Id, Model model) 
	{
		MyClass123 myClass123 = this.myClass123Service.findById(myClass123Id);
		model.addAttribute(myClass123);
		return "myclass123/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass123Validator());	
	}

	@RequestMapping(value = "/myclass123/edit", method = RequestMethod.GET)
	public MyClass123 newMyClass123 (Model model) 
	{
		if(model != null && model.asMap().get("myclass123") == null)
		{
			return new MyClass123();	
		}
		return (MyClass123) model.asMap().get("myclass123");	
	}

	@RequestMapping(value = {"/myclass123/edit", "/myclass123/edit/{myclass123Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass123 MyClass123, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass123/edit";
		}
		
		
		
		this.myClass123Service.save(MyClass123);
		session.setComplete();
		return "redirect:/myclass123/list";	
	}


}
