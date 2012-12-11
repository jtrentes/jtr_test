package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass53;
import big.web.controllers.validator.MyClass53Validator;
import org.springframework.ui.Model;
import big.services.MyClass53Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass53.class)
public class MyClass53DetailController
{

	
	@Autowired
	private MyClass53Service myClass53Service;
    

	@RequestMapping(value = "/myclass53/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass53/edit";	
	}

	@RequestMapping(value = "/myclass53/detail/{myClass53Id}")
	public String details (@PathVariable(value = "myClass53Id") Long myClass53Id, Model model) 
	{
		MyClass53 myClass53 = this.myClass53Service.findById(myClass53Id);
		model.addAttribute(myClass53);
		return "myclass53/detail";	
	}

	@RequestMapping(value = "/myclass53/edit/{myClass53Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass53Id") Long myClass53Id, Model model) 
	{
		MyClass53 myClass53 = this.myClass53Service.findById(myClass53Id);
		model.addAttribute(myClass53);
		return "myclass53/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass53Validator());	
	}

	@RequestMapping(value = "/myclass53/edit", method = RequestMethod.GET)
	public MyClass53 newMyClass53 (Model model) 
	{
		if(model != null && model.asMap().get("myclass53") == null)
		{
			return new MyClass53();	
		}
		return (MyClass53) model.asMap().get("myclass53");	
	}

	@RequestMapping(value = {"/myclass53/edit", "/myclass53/edit/{myclass53Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass53 MyClass53, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass53/edit";
		}
		
		
		
		this.myClass53Service.save(MyClass53);
		session.setComplete();
		return "redirect:/myclass53/list";	
	}


}
