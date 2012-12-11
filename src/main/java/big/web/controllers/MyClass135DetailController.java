package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass135Service;
import big.web.controllers.validator.MyClass135Validator;
import big.domain.MyClass135;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass135.class)
public class MyClass135DetailController
{

	
	@Autowired
	private MyClass135Service myClass135Service;
    

	@RequestMapping(value = "/myclass135/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass135/edit";	
	}

	@RequestMapping(value = "/myclass135/detail/{myClass135Id}")
	public String details (@PathVariable(value = "myClass135Id") Long myClass135Id, Model model) 
	{
		MyClass135 myClass135 = this.myClass135Service.findById(myClass135Id);
		model.addAttribute(myClass135);
		return "myclass135/detail";	
	}

	@RequestMapping(value = "/myclass135/edit/{myClass135Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass135Id") Long myClass135Id, Model model) 
	{
		MyClass135 myClass135 = this.myClass135Service.findById(myClass135Id);
		model.addAttribute(myClass135);
		return "myclass135/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass135Validator());	
	}

	@RequestMapping(value = "/myclass135/edit", method = RequestMethod.GET)
	public MyClass135 newMyClass135 (Model model) 
	{
		if(model != null && model.asMap().get("myclass135") == null)
		{
			return new MyClass135();	
		}
		return (MyClass135) model.asMap().get("myclass135");	
	}

	@RequestMapping(value = {"/myclass135/edit", "/myclass135/edit/{myclass135Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass135 MyClass135, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass135/edit";
		}
		
		
		
		this.myClass135Service.save(MyClass135);
		session.setComplete();
		return "redirect:/myclass135/list";	
	}


}
