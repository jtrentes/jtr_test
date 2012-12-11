package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass41Service;
import big.domain.MyClass41;
import big.web.controllers.validator.MyClass41Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass41.class)
public class MyClass41DetailController
{

	
	@Autowired
	private MyClass41Service myClass41Service;
    

	@RequestMapping(value = "/myclass41/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass41/edit";	
	}

	@RequestMapping(value = "/myclass41/detail/{myClass41Id}")
	public String details (@PathVariable(value = "myClass41Id") Long myClass41Id, Model model) 
	{
		MyClass41 myClass41 = this.myClass41Service.findById(myClass41Id);
		model.addAttribute(myClass41);
		return "myclass41/detail";	
	}

	@RequestMapping(value = "/myclass41/edit/{myClass41Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass41Id") Long myClass41Id, Model model) 
	{
		MyClass41 myClass41 = this.myClass41Service.findById(myClass41Id);
		model.addAttribute(myClass41);
		return "myclass41/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass41Validator());	
	}

	@RequestMapping(value = "/myclass41/edit", method = RequestMethod.GET)
	public MyClass41 newMyClass41 (Model model) 
	{
		if(model != null && model.asMap().get("myclass41") == null)
		{
			return new MyClass41();	
		}
		return (MyClass41) model.asMap().get("myclass41");	
	}

	@RequestMapping(value = {"/myclass41/edit", "/myclass41/edit/{myclass41Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass41 MyClass41, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass41/edit";
		}
		
		
		
		this.myClass41Service.save(MyClass41);
		session.setComplete();
		return "redirect:/myclass41/list";	
	}


}
