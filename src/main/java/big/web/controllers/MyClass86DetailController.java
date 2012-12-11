package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass86Validator;
import org.springframework.ui.Model;
import big.domain.MyClass86;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass86Service;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass86.class)
public class MyClass86DetailController
{

	
	@Autowired
	private MyClass86Service myClass86Service;
    

	@RequestMapping(value = "/myclass86/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass86/edit";	
	}

	@RequestMapping(value = "/myclass86/detail/{myClass86Id}")
	public String details (@PathVariable(value = "myClass86Id") Long myClass86Id, Model model) 
	{
		MyClass86 myClass86 = this.myClass86Service.findById(myClass86Id);
		model.addAttribute(myClass86);
		return "myclass86/detail";	
	}

	@RequestMapping(value = "/myclass86/edit/{myClass86Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass86Id") Long myClass86Id, Model model) 
	{
		MyClass86 myClass86 = this.myClass86Service.findById(myClass86Id);
		model.addAttribute(myClass86);
		return "myclass86/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass86Validator());	
	}

	@RequestMapping(value = "/myclass86/edit", method = RequestMethod.GET)
	public MyClass86 newMyClass86 (Model model) 
	{
		if(model != null && model.asMap().get("myclass86") == null)
		{
			return new MyClass86();	
		}
		return (MyClass86) model.asMap().get("myclass86");	
	}

	@RequestMapping(value = {"/myclass86/edit", "/myclass86/edit/{myclass86Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass86 MyClass86, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass86/edit";
		}
		
		
		
		this.myClass86Service.save(MyClass86);
		session.setComplete();
		return "redirect:/myclass86/list";	
	}


}
