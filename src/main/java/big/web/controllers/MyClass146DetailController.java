package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass146Validator;
import org.springframework.ui.Model;
import big.domain.MyClass146;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass146Service;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass146.class)
public class MyClass146DetailController
{

	
	@Autowired
	private MyClass146Service myClass146Service;
    

	@RequestMapping(value = "/myclass146/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass146/edit";	
	}

	@RequestMapping(value = "/myclass146/detail/{myClass146Id}")
	public String details (@PathVariable(value = "myClass146Id") Long myClass146Id, Model model) 
	{
		MyClass146 myClass146 = this.myClass146Service.findById(myClass146Id);
		model.addAttribute(myClass146);
		return "myclass146/detail";	
	}

	@RequestMapping(value = "/myclass146/edit/{myClass146Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass146Id") Long myClass146Id, Model model) 
	{
		MyClass146 myClass146 = this.myClass146Service.findById(myClass146Id);
		model.addAttribute(myClass146);
		return "myclass146/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass146Validator());	
	}

	@RequestMapping(value = "/myclass146/edit", method = RequestMethod.GET)
	public MyClass146 newMyClass146 (Model model) 
	{
		if(model != null && model.asMap().get("myclass146") == null)
		{
			return new MyClass146();	
		}
		return (MyClass146) model.asMap().get("myclass146");	
	}

	@RequestMapping(value = {"/myclass146/edit", "/myclass146/edit/{myclass146Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass146 MyClass146, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass146/edit";
		}
		
		
		
		this.myClass146Service.save(MyClass146);
		session.setComplete();
		return "redirect:/myclass146/list";	
	}


}
