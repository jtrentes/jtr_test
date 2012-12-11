package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass60Validator;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass60Service;
import big.domain.MyClass60;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass60.class)
public class MyClass60DetailController
{

	
	@Autowired
	private MyClass60Service myClass60Service;
    

	@RequestMapping(value = "/myclass60/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass60/edit";	
	}

	@RequestMapping(value = "/myclass60/detail/{myClass60Id}")
	public String details (@PathVariable(value = "myClass60Id") Long myClass60Id, Model model) 
	{
		MyClass60 myClass60 = this.myClass60Service.findById(myClass60Id);
		model.addAttribute(myClass60);
		return "myclass60/detail";	
	}

	@RequestMapping(value = "/myclass60/edit/{myClass60Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass60Id") Long myClass60Id, Model model) 
	{
		MyClass60 myClass60 = this.myClass60Service.findById(myClass60Id);
		model.addAttribute(myClass60);
		return "myclass60/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass60Validator());	
	}

	@RequestMapping(value = "/myclass60/edit", method = RequestMethod.GET)
	public MyClass60 newMyClass60 (Model model) 
	{
		if(model != null && model.asMap().get("myclass60") == null)
		{
			return new MyClass60();	
		}
		return (MyClass60) model.asMap().get("myclass60");	
	}

	@RequestMapping(value = {"/myclass60/edit", "/myclass60/edit/{myclass60Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass60 MyClass60, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass60/edit";
		}
		
		
		
		this.myClass60Service.save(MyClass60);
		session.setComplete();
		return "redirect:/myclass60/list";	
	}


}
