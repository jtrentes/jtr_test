package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass82;
import big.web.controllers.validator.MyClass82Validator;
import big.services.MyClass82Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass82.class)
public class MyClass82DetailController
{

	
	@Autowired
	private MyClass82Service myClass82Service;
    

	@RequestMapping(value = "/myclass82/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass82/edit";	
	}

	@RequestMapping(value = "/myclass82/detail/{myClass82Id}")
	public String details (@PathVariable(value = "myClass82Id") Long myClass82Id, Model model) 
	{
		MyClass82 myClass82 = this.myClass82Service.findById(myClass82Id);
		model.addAttribute(myClass82);
		return "myclass82/detail";	
	}

	@RequestMapping(value = "/myclass82/edit/{myClass82Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass82Id") Long myClass82Id, Model model) 
	{
		MyClass82 myClass82 = this.myClass82Service.findById(myClass82Id);
		model.addAttribute(myClass82);
		return "myclass82/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass82Validator());	
	}

	@RequestMapping(value = "/myclass82/edit", method = RequestMethod.GET)
	public MyClass82 newMyClass82 (Model model) 
	{
		if(model != null && model.asMap().get("myclass82") == null)
		{
			return new MyClass82();	
		}
		return (MyClass82) model.asMap().get("myclass82");	
	}

	@RequestMapping(value = {"/myclass82/edit", "/myclass82/edit/{myclass82Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass82 MyClass82, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass82/edit";
		}
		
		
		
		this.myClass82Service.save(MyClass82);
		session.setComplete();
		return "redirect:/myclass82/list";	
	}


}
