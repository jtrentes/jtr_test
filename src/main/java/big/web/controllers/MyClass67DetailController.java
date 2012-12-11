package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass67Validator;
import big.domain.MyClass67;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass67Service;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass67.class)
public class MyClass67DetailController
{

	
	@Autowired
	private MyClass67Service myClass67Service;
    

	@RequestMapping(value = "/myclass67/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass67/edit";	
	}

	@RequestMapping(value = "/myclass67/detail/{myClass67Id}")
	public String details (@PathVariable(value = "myClass67Id") Long myClass67Id, Model model) 
	{
		MyClass67 myClass67 = this.myClass67Service.findById(myClass67Id);
		model.addAttribute(myClass67);
		return "myclass67/detail";	
	}

	@RequestMapping(value = "/myclass67/edit/{myClass67Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass67Id") Long myClass67Id, Model model) 
	{
		MyClass67 myClass67 = this.myClass67Service.findById(myClass67Id);
		model.addAttribute(myClass67);
		return "myclass67/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass67Validator());	
	}

	@RequestMapping(value = "/myclass67/edit", method = RequestMethod.GET)
	public MyClass67 newMyClass67 (Model model) 
	{
		if(model != null && model.asMap().get("myclass67") == null)
		{
			return new MyClass67();	
		}
		return (MyClass67) model.asMap().get("myclass67");	
	}

	@RequestMapping(value = {"/myclass67/edit", "/myclass67/edit/{myclass67Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass67 MyClass67, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass67/edit";
		}
		
		
		
		this.myClass67Service.save(MyClass67);
		session.setComplete();
		return "redirect:/myclass67/list";	
	}


}
