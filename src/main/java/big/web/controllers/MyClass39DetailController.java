package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass39Service;
import big.domain.MyClass39;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass39Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass39.class)
public class MyClass39DetailController
{

	
	@Autowired
	private MyClass39Service myClass39Service;
    

	@RequestMapping(value = "/myclass39/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass39/edit";	
	}

	@RequestMapping(value = "/myclass39/detail/{myClass39Id}")
	public String details (@PathVariable(value = "myClass39Id") Long myClass39Id, Model model) 
	{
		MyClass39 myClass39 = this.myClass39Service.findById(myClass39Id);
		model.addAttribute(myClass39);
		return "myclass39/detail";	
	}

	@RequestMapping(value = "/myclass39/edit/{myClass39Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass39Id") Long myClass39Id, Model model) 
	{
		MyClass39 myClass39 = this.myClass39Service.findById(myClass39Id);
		model.addAttribute(myClass39);
		return "myclass39/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass39Validator());	
	}

	@RequestMapping(value = "/myclass39/edit", method = RequestMethod.GET)
	public MyClass39 newMyClass39 (Model model) 
	{
		if(model != null && model.asMap().get("myclass39") == null)
		{
			return new MyClass39();	
		}
		return (MyClass39) model.asMap().get("myclass39");	
	}

	@RequestMapping(value = {"/myclass39/edit", "/myclass39/edit/{myclass39Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass39 MyClass39, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass39/edit";
		}
		
		
		
		this.myClass39Service.save(MyClass39);
		session.setComplete();
		return "redirect:/myclass39/list";	
	}


}
