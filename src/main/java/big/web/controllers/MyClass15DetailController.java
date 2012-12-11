package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass15;
import big.services.MyClass15Service;
import big.web.controllers.validator.MyClass15Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass15.class)
public class MyClass15DetailController
{

	
	@Autowired
	private MyClass15Service myClass15Service;
    

	@RequestMapping(value = "/myclass15/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass15/edit";	
	}

	@RequestMapping(value = "/myclass15/detail/{myClass15Id}")
	public String details (@PathVariable(value = "myClass15Id") Long myClass15Id, Model model) 
	{
		MyClass15 myClass15 = this.myClass15Service.findById(myClass15Id);
		model.addAttribute(myClass15);
		return "myclass15/detail";	
	}

	@RequestMapping(value = "/myclass15/edit/{myClass15Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass15Id") Long myClass15Id, Model model) 
	{
		MyClass15 myClass15 = this.myClass15Service.findById(myClass15Id);
		model.addAttribute(myClass15);
		return "myclass15/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass15Validator());	
	}

	@RequestMapping(value = "/myclass15/edit", method = RequestMethod.GET)
	public MyClass15 newMyClass15 (Model model) 
	{
		if(model != null && model.asMap().get("myclass15") == null)
		{
			return new MyClass15();	
		}
		return (MyClass15) model.asMap().get("myclass15");	
	}

	@RequestMapping(value = {"/myclass15/edit", "/myclass15/edit/{myclass15Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass15 MyClass15, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass15/edit";
		}
		
		
		
		this.myClass15Service.save(MyClass15);
		session.setComplete();
		return "redirect:/myclass15/list";	
	}


}
