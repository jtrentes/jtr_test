package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass75;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass75Validator;
import org.springframework.validation.BindingResult;
import big.services.MyClass75Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass75.class)
public class MyClass75DetailController
{

	
	@Autowired
	private MyClass75Service myClass75Service;
    

	@RequestMapping(value = "/myclass75/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass75/edit";	
	}

	@RequestMapping(value = "/myclass75/detail/{myClass75Id}")
	public String details (@PathVariable(value = "myClass75Id") Long myClass75Id, Model model) 
	{
		MyClass75 myClass75 = this.myClass75Service.findById(myClass75Id);
		model.addAttribute(myClass75);
		return "myclass75/detail";	
	}

	@RequestMapping(value = "/myclass75/edit/{myClass75Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass75Id") Long myClass75Id, Model model) 
	{
		MyClass75 myClass75 = this.myClass75Service.findById(myClass75Id);
		model.addAttribute(myClass75);
		return "myclass75/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass75Validator());	
	}

	@RequestMapping(value = "/myclass75/edit", method = RequestMethod.GET)
	public MyClass75 newMyClass75 (Model model) 
	{
		if(model != null && model.asMap().get("myclass75") == null)
		{
			return new MyClass75();	
		}
		return (MyClass75) model.asMap().get("myclass75");	
	}

	@RequestMapping(value = {"/myclass75/edit", "/myclass75/edit/{myclass75Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass75 MyClass75, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass75/edit";
		}
		
		
		
		this.myClass75Service.save(MyClass75);
		session.setComplete();
		return "redirect:/myclass75/list";	
	}


}
