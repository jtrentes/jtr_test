package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass55;
import big.web.controllers.validator.MyClass55Validator;
import big.services.MyClass55Service;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass55.class)
public class MyClass55DetailController
{

	
	@Autowired
	private MyClass55Service myClass55Service;
    

	@RequestMapping(value = "/myclass55/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass55/edit";	
	}

	@RequestMapping(value = "/myclass55/detail/{myClass55Id}")
	public String details (@PathVariable(value = "myClass55Id") Long myClass55Id, Model model) 
	{
		MyClass55 myClass55 = this.myClass55Service.findById(myClass55Id);
		model.addAttribute(myClass55);
		return "myclass55/detail";	
	}

	@RequestMapping(value = "/myclass55/edit/{myClass55Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass55Id") Long myClass55Id, Model model) 
	{
		MyClass55 myClass55 = this.myClass55Service.findById(myClass55Id);
		model.addAttribute(myClass55);
		return "myclass55/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass55Validator());	
	}

	@RequestMapping(value = "/myclass55/edit", method = RequestMethod.GET)
	public MyClass55 newMyClass55 (Model model) 
	{
		if(model != null && model.asMap().get("myclass55") == null)
		{
			return new MyClass55();	
		}
		return (MyClass55) model.asMap().get("myclass55");	
	}

	@RequestMapping(value = {"/myclass55/edit", "/myclass55/edit/{myclass55Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass55 MyClass55, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass55/edit";
		}
		
		
		
		this.myClass55Service.save(MyClass55);
		session.setComplete();
		return "redirect:/myclass55/list";	
	}


}
