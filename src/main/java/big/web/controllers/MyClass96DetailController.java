package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass96;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass96Validator;
import big.services.MyClass96Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass96.class)
public class MyClass96DetailController
{

	
	@Autowired
	private MyClass96Service myClass96Service;
    

	@RequestMapping(value = "/myclass96/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass96/edit";	
	}

	@RequestMapping(value = "/myclass96/detail/{myClass96Id}")
	public String details (@PathVariable(value = "myClass96Id") Long myClass96Id, Model model) 
	{
		MyClass96 myClass96 = this.myClass96Service.findById(myClass96Id);
		model.addAttribute(myClass96);
		return "myclass96/detail";	
	}

	@RequestMapping(value = "/myclass96/edit/{myClass96Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass96Id") Long myClass96Id, Model model) 
	{
		MyClass96 myClass96 = this.myClass96Service.findById(myClass96Id);
		model.addAttribute(myClass96);
		return "myclass96/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass96Validator());	
	}

	@RequestMapping(value = "/myclass96/edit", method = RequestMethod.GET)
	public MyClass96 newMyClass96 (Model model) 
	{
		if(model != null && model.asMap().get("myclass96") == null)
		{
			return new MyClass96();	
		}
		return (MyClass96) model.asMap().get("myclass96");	
	}

	@RequestMapping(value = {"/myclass96/edit", "/myclass96/edit/{myclass96Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass96 MyClass96, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass96/edit";
		}
		
		
		
		this.myClass96Service.save(MyClass96);
		session.setComplete();
		return "redirect:/myclass96/list";	
	}


}
