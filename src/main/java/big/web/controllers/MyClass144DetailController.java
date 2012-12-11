package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.domain.MyClass144;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass144Validator;
import big.services.MyClass144Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass144.class)
public class MyClass144DetailController
{

	
	@Autowired
	private MyClass144Service myClass144Service;
    

	@RequestMapping(value = "/myclass144/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass144/edit";	
	}

	@RequestMapping(value = "/myclass144/detail/{myClass144Id}")
	public String details (@PathVariable(value = "myClass144Id") Long myClass144Id, Model model) 
	{
		MyClass144 myClass144 = this.myClass144Service.findById(myClass144Id);
		model.addAttribute(myClass144);
		return "myclass144/detail";	
	}

	@RequestMapping(value = "/myclass144/edit/{myClass144Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass144Id") Long myClass144Id, Model model) 
	{
		MyClass144 myClass144 = this.myClass144Service.findById(myClass144Id);
		model.addAttribute(myClass144);
		return "myclass144/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass144Validator());	
	}

	@RequestMapping(value = "/myclass144/edit", method = RequestMethod.GET)
	public MyClass144 newMyClass144 (Model model) 
	{
		if(model != null && model.asMap().get("myclass144") == null)
		{
			return new MyClass144();	
		}
		return (MyClass144) model.asMap().get("myclass144");	
	}

	@RequestMapping(value = {"/myclass144/edit", "/myclass144/edit/{myclass144Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass144 MyClass144, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass144/edit";
		}
		
		
		
		this.myClass144Service.save(MyClass144);
		session.setComplete();
		return "redirect:/myclass144/list";	
	}


}
