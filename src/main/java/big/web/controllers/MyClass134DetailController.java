package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass134Service;
import org.springframework.validation.BindingResult;
import big.domain.MyClass134;
import big.web.controllers.validator.MyClass134Validator;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass134.class)
public class MyClass134DetailController
{

	
	@Autowired
	private MyClass134Service myClass134Service;
    

	@RequestMapping(value = "/myclass134/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass134/edit";	
	}

	@RequestMapping(value = "/myclass134/detail/{myClass134Id}")
	public String details (@PathVariable(value = "myClass134Id") Long myClass134Id, Model model) 
	{
		MyClass134 myClass134 = this.myClass134Service.findById(myClass134Id);
		model.addAttribute(myClass134);
		return "myclass134/detail";	
	}

	@RequestMapping(value = "/myclass134/edit/{myClass134Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass134Id") Long myClass134Id, Model model) 
	{
		MyClass134 myClass134 = this.myClass134Service.findById(myClass134Id);
		model.addAttribute(myClass134);
		return "myclass134/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass134Validator());	
	}

	@RequestMapping(value = "/myclass134/edit", method = RequestMethod.GET)
	public MyClass134 newMyClass134 (Model model) 
	{
		if(model != null && model.asMap().get("myclass134") == null)
		{
			return new MyClass134();	
		}
		return (MyClass134) model.asMap().get("myclass134");	
	}

	@RequestMapping(value = {"/myclass134/edit", "/myclass134/edit/{myclass134Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass134 MyClass134, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass134/edit";
		}
		
		
		
		this.myClass134Service.save(MyClass134);
		session.setComplete();
		return "redirect:/myclass134/list";	
	}


}
