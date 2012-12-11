package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass42Validator;
import big.services.MyClass42Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.domain.MyClass42;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass42.class)
public class MyClass42DetailController
{

	
	@Autowired
	private MyClass42Service myClass42Service;
    

	@RequestMapping(value = "/myclass42/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass42/edit";	
	}

	@RequestMapping(value = "/myclass42/detail/{myClass42Id}")
	public String details (@PathVariable(value = "myClass42Id") Long myClass42Id, Model model) 
	{
		MyClass42 myClass42 = this.myClass42Service.findById(myClass42Id);
		model.addAttribute(myClass42);
		return "myclass42/detail";	
	}

	@RequestMapping(value = "/myclass42/edit/{myClass42Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass42Id") Long myClass42Id, Model model) 
	{
		MyClass42 myClass42 = this.myClass42Service.findById(myClass42Id);
		model.addAttribute(myClass42);
		return "myclass42/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass42Validator());	
	}

	@RequestMapping(value = "/myclass42/edit", method = RequestMethod.GET)
	public MyClass42 newMyClass42 (Model model) 
	{
		if(model != null && model.asMap().get("myclass42") == null)
		{
			return new MyClass42();	
		}
		return (MyClass42) model.asMap().get("myclass42");	
	}

	@RequestMapping(value = {"/myclass42/edit", "/myclass42/edit/{myclass42Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass42 MyClass42, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass42/edit";
		}
		
		
		
		this.myClass42Service.save(MyClass42);
		session.setComplete();
		return "redirect:/myclass42/list";	
	}


}
