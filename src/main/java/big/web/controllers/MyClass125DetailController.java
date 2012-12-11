package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass125Service;
import big.domain.MyClass125;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass125Validator;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass125.class)
public class MyClass125DetailController
{

	
	@Autowired
	private MyClass125Service myClass125Service;
    

	@RequestMapping(value = "/myclass125/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass125/edit";	
	}

	@RequestMapping(value = "/myclass125/detail/{myClass125Id}")
	public String details (@PathVariable(value = "myClass125Id") Long myClass125Id, Model model) 
	{
		MyClass125 myClass125 = this.myClass125Service.findById(myClass125Id);
		model.addAttribute(myClass125);
		return "myclass125/detail";	
	}

	@RequestMapping(value = "/myclass125/edit/{myClass125Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass125Id") Long myClass125Id, Model model) 
	{
		MyClass125 myClass125 = this.myClass125Service.findById(myClass125Id);
		model.addAttribute(myClass125);
		return "myclass125/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass125Validator());	
	}

	@RequestMapping(value = "/myclass125/edit", method = RequestMethod.GET)
	public MyClass125 newMyClass125 (Model model) 
	{
		if(model != null && model.asMap().get("myclass125") == null)
		{
			return new MyClass125();	
		}
		return (MyClass125) model.asMap().get("myclass125");	
	}

	@RequestMapping(value = {"/myclass125/edit", "/myclass125/edit/{myclass125Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass125 MyClass125, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass125/edit";
		}
		
		
		
		this.myClass125Service.save(MyClass125);
		session.setComplete();
		return "redirect:/myclass125/list";	
	}


}
