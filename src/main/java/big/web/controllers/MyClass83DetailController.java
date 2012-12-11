package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.services.MyClass83Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass83Validator;
import big.domain.MyClass83;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass83.class)
public class MyClass83DetailController
{

	
	@Autowired
	private MyClass83Service myClass83Service;
    

	@RequestMapping(value = "/myclass83/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass83/edit";	
	}

	@RequestMapping(value = "/myclass83/detail/{myClass83Id}")
	public String details (@PathVariable(value = "myClass83Id") Long myClass83Id, Model model) 
	{
		MyClass83 myClass83 = this.myClass83Service.findById(myClass83Id);
		model.addAttribute(myClass83);
		return "myclass83/detail";	
	}

	@RequestMapping(value = "/myclass83/edit/{myClass83Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass83Id") Long myClass83Id, Model model) 
	{
		MyClass83 myClass83 = this.myClass83Service.findById(myClass83Id);
		model.addAttribute(myClass83);
		return "myclass83/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass83Validator());	
	}

	@RequestMapping(value = "/myclass83/edit", method = RequestMethod.GET)
	public MyClass83 newMyClass83 (Model model) 
	{
		if(model != null && model.asMap().get("myclass83") == null)
		{
			return new MyClass83();	
		}
		return (MyClass83) model.asMap().get("myclass83");	
	}

	@RequestMapping(value = {"/myclass83/edit", "/myclass83/edit/{myclass83Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass83 MyClass83, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass83/edit";
		}
		
		
		
		this.myClass83Service.save(MyClass83);
		session.setComplete();
		return "redirect:/myclass83/list";	
	}


}
