package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass90Validator;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass90;
import org.springframework.ui.Model;
import big.services.MyClass90Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass90.class)
public class MyClass90DetailController
{

	
	@Autowired
	private MyClass90Service myClass90Service;
    

	@RequestMapping(value = "/myclass90/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass90/edit";	
	}

	@RequestMapping(value = "/myclass90/detail/{myClass90Id}")
	public String details (@PathVariable(value = "myClass90Id") Long myClass90Id, Model model) 
	{
		MyClass90 myClass90 = this.myClass90Service.findById(myClass90Id);
		model.addAttribute(myClass90);
		return "myclass90/detail";	
	}

	@RequestMapping(value = "/myclass90/edit/{myClass90Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass90Id") Long myClass90Id, Model model) 
	{
		MyClass90 myClass90 = this.myClass90Service.findById(myClass90Id);
		model.addAttribute(myClass90);
		return "myclass90/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass90Validator());	
	}

	@RequestMapping(value = "/myclass90/edit", method = RequestMethod.GET)
	public MyClass90 newMyClass90 (Model model) 
	{
		if(model != null && model.asMap().get("myclass90") == null)
		{
			return new MyClass90();	
		}
		return (MyClass90) model.asMap().get("myclass90");	
	}

	@RequestMapping(value = {"/myclass90/edit", "/myclass90/edit/{myclass90Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass90 MyClass90, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass90/edit";
		}
		
		
		
		this.myClass90Service.save(MyClass90);
		session.setComplete();
		return "redirect:/myclass90/list";	
	}


}
