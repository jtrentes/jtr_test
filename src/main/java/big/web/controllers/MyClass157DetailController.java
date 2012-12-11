package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass157Service;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass157Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.domain.MyClass157;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass157.class)
public class MyClass157DetailController
{

	
	@Autowired
	private MyClass157Service myClass157Service;
    

	@RequestMapping(value = "/myclass157/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass157/edit";	
	}

	@RequestMapping(value = "/myclass157/detail/{myClass157Id}")
	public String details (@PathVariable(value = "myClass157Id") Long myClass157Id, Model model) 
	{
		MyClass157 myClass157 = this.myClass157Service.findById(myClass157Id);
		model.addAttribute(myClass157);
		return "myclass157/detail";	
	}

	@RequestMapping(value = "/myclass157/edit/{myClass157Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass157Id") Long myClass157Id, Model model) 
	{
		MyClass157 myClass157 = this.myClass157Service.findById(myClass157Id);
		model.addAttribute(myClass157);
		return "myclass157/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass157Validator());	
	}

	@RequestMapping(value = "/myclass157/edit", method = RequestMethod.GET)
	public MyClass157 newMyClass157 (Model model) 
	{
		if(model != null && model.asMap().get("myclass157") == null)
		{
			return new MyClass157();	
		}
		return (MyClass157) model.asMap().get("myclass157");	
	}

	@RequestMapping(value = {"/myclass157/edit", "/myclass157/edit/{myclass157Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass157 MyClass157, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass157/edit";
		}
		
		
		
		this.myClass157Service.save(MyClass157);
		session.setComplete();
		return "redirect:/myclass157/list";	
	}


}
