package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import big.domain.MyClass112;
import org.springframework.ui.Model;
import big.services.MyClass112Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass112Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
@SessionAttributes(types = MyClass112.class)
public class MyClass112DetailController
{

	
	@Autowired
	private MyClass112Service myClass112Service;
    

	@RequestMapping(value = "/myclass112/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass112/edit";	
	}

	@RequestMapping(value = "/myclass112/detail/{myClass112Id}")
	public String details (@PathVariable(value = "myClass112Id") Long myClass112Id, Model model) 
	{
		MyClass112 myClass112 = this.myClass112Service.findById(myClass112Id);
		model.addAttribute(myClass112);
		return "myclass112/detail";	
	}

	@RequestMapping(value = "/myclass112/edit/{myClass112Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass112Id") Long myClass112Id, Model model) 
	{
		MyClass112 myClass112 = this.myClass112Service.findById(myClass112Id);
		model.addAttribute(myClass112);
		return "myclass112/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass112Validator());	
	}

	@RequestMapping(value = "/myclass112/edit", method = RequestMethod.GET)
	public MyClass112 newMyClass112 (Model model) 
	{
		if(model != null && model.asMap().get("myclass112") == null)
		{
			return new MyClass112();	
		}
		return (MyClass112) model.asMap().get("myclass112");	
	}

	@RequestMapping(value = {"/myclass112/edit", "/myclass112/edit/{myclass112Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass112 MyClass112, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass112/edit";
		}
		
		
		
		this.myClass112Service.save(MyClass112);
		session.setComplete();
		return "redirect:/myclass112/list";	
	}


}
