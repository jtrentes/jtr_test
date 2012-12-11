package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass122Service;
import big.domain.MyClass122;
import big.web.controllers.validator.MyClass122Validator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass122.class)
public class MyClass122DetailController
{

	
	@Autowired
	private MyClass122Service myClass122Service;
    

	@RequestMapping(value = "/myclass122/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass122/edit";	
	}

	@RequestMapping(value = "/myclass122/detail/{myClass122Id}")
	public String details (@PathVariable(value = "myClass122Id") Long myClass122Id, Model model) 
	{
		MyClass122 myClass122 = this.myClass122Service.findById(myClass122Id);
		model.addAttribute(myClass122);
		return "myclass122/detail";	
	}

	@RequestMapping(value = "/myclass122/edit/{myClass122Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass122Id") Long myClass122Id, Model model) 
	{
		MyClass122 myClass122 = this.myClass122Service.findById(myClass122Id);
		model.addAttribute(myClass122);
		return "myclass122/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass122Validator());	
	}

	@RequestMapping(value = "/myclass122/edit", method = RequestMethod.GET)
	public MyClass122 newMyClass122 (Model model) 
	{
		if(model != null && model.asMap().get("myclass122") == null)
		{
			return new MyClass122();	
		}
		return (MyClass122) model.asMap().get("myclass122");	
	}

	@RequestMapping(value = {"/myclass122/edit", "/myclass122/edit/{myclass122Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass122 MyClass122, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass122/edit";
		}
		
		
		
		this.myClass122Service.save(MyClass122);
		session.setComplete();
		return "redirect:/myclass122/list";	
	}


}
