package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass99;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass99Validator;
import org.springframework.ui.Model;
import big.services.MyClass99Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
@SessionAttributes(types = MyClass99.class)
public class MyClass99DetailController
{

	
	@Autowired
	private MyClass99Service myClass99Service;
    

	@RequestMapping(value = "/myclass99/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass99/edit";	
	}

	@RequestMapping(value = "/myclass99/detail/{myClass99Id}")
	public String details (@PathVariable(value = "myClass99Id") Long myClass99Id, Model model) 
	{
		MyClass99 myClass99 = this.myClass99Service.findById(myClass99Id);
		model.addAttribute(myClass99);
		return "myclass99/detail";	
	}

	@RequestMapping(value = "/myclass99/edit/{myClass99Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass99Id") Long myClass99Id, Model model) 
	{
		MyClass99 myClass99 = this.myClass99Service.findById(myClass99Id);
		model.addAttribute(myClass99);
		return "myclass99/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass99Validator());	
	}

	@RequestMapping(value = "/myclass99/edit", method = RequestMethod.GET)
	public MyClass99 newMyClass99 (Model model) 
	{
		if(model != null && model.asMap().get("myclass99") == null)
		{
			return new MyClass99();	
		}
		return (MyClass99) model.asMap().get("myclass99");	
	}

	@RequestMapping(value = {"/myclass99/edit", "/myclass99/edit/{myclass99Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass99 MyClass99, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass99/edit";
		}
		
		
		
		this.myClass99Service.save(MyClass99);
		session.setComplete();
		return "redirect:/myclass99/list";	
	}


}
