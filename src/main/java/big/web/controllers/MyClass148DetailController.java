package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass148;
import big.web.controllers.validator.MyClass148Validator;
import org.springframework.ui.Model;
import big.services.MyClass148Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass148.class)
public class MyClass148DetailController
{

	
	@Autowired
	private MyClass148Service myClass148Service;
    

	@RequestMapping(value = "/myclass148/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass148/edit";	
	}

	@RequestMapping(value = "/myclass148/detail/{myClass148Id}")
	public String details (@PathVariable(value = "myClass148Id") Long myClass148Id, Model model) 
	{
		MyClass148 myClass148 = this.myClass148Service.findById(myClass148Id);
		model.addAttribute(myClass148);
		return "myclass148/detail";	
	}

	@RequestMapping(value = "/myclass148/edit/{myClass148Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass148Id") Long myClass148Id, Model model) 
	{
		MyClass148 myClass148 = this.myClass148Service.findById(myClass148Id);
		model.addAttribute(myClass148);
		return "myclass148/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass148Validator());	
	}

	@RequestMapping(value = "/myclass148/edit", method = RequestMethod.GET)
	public MyClass148 newMyClass148 (Model model) 
	{
		if(model != null && model.asMap().get("myclass148") == null)
		{
			return new MyClass148();	
		}
		return (MyClass148) model.asMap().get("myclass148");	
	}

	@RequestMapping(value = {"/myclass148/edit", "/myclass148/edit/{myclass148Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass148 MyClass148, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass148/edit";
		}
		
		
		
		this.myClass148Service.save(MyClass148);
		session.setComplete();
		return "redirect:/myclass148/list";	
	}


}
